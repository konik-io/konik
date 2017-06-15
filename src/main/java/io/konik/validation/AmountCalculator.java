/* Copyright (C) 2014 konik.io
 *
 * This file is part of the Konik library.
 *
 * The Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * The Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the Konik library. If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.validation;

import com.google.common.base.Function;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.util.Amounts;
import io.konik.util.Items;
import io.konik.util.MonetarySummations;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.*;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.Settlement;
import io.konik.zugferd.entity.trade.TradeTax;
import io.konik.zugferd.entity.trade.item.*;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unqualified.Amount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Calculate the missing amounts of the invoice.
 */
public final class AmountCalculator {

	protected static Logger log = LoggerFactory.getLogger(AmountCalculator.class);

	/**
	 * Calculates {@link MonetarySummation} for given {@link Invoice} basing on line {@link Item}s
	 * and global {@link io.konik.zugferd.entity.AllowanceCharge} and {@link LogisticsServiceCharge}
	 *
	 * @param invoice
	 * @return
	 */
	public static RecalculationResult recalculate(final Invoice invoice) {
		assertNotNull(invoice);

		CurrencyCode currency = getCurrency(invoice);
		List<Item> items = Items.purchasableItemsOnly(invoice.getTrade().getItems());
		Settlement settlement = invoice.getTrade().getSettlement();

		TaxAggregator taxAggregator = new TaxAggregator();

		// If there are no items that can be used to recalculate monetary summation, return the current one
		if (items.isEmpty()) {
			return new RecalculationResult(MonetarySummations.newMonetarySummation(settlement.getMonetarySummation()), taxAggregator);
		}

		MonetarySummation monetarySummation = MonetarySummations.newMonetarySummation(currency);
		monetarySummation.setAllowanceTotal(new InvoiceAllowanceTotalCalculator().apply(settlement));
		monetarySummation.setChargeTotal(new InvoiceChargeTotalCalculator().apply(settlement));

		log.debug("Starting recalculating line total from {} items...", items.size());
		int itemsCounter = 0;

		for (Item item : items) {
			log.debug("==> {}:", ++itemsCounter);
			log.debug("Recalculating item: [{}]", item.getProduct() != null ? item.getProduct().getName() : "N/A");

			Amount lineTotal = new ItemLineTotalCalculator().apply(item);
			ItemTax itemTax = new ItemTaxExtractor().apply(item);

			log.debug("Recalculated item line total = {}", lineTotal);
			log.debug("Recalculated item tax = {}%", itemTax.getPercentage());

			taxAggregator.add(itemTax, lineTotal != null ? lineTotal.getValue() : BigDecimal.ZERO);

			monetarySummation.setLineTotal(Amounts.add(
					monetarySummation.getLineTotal(),
					lineTotal
			));

			log.debug("Current monetarySummation.lineTotal = {} (the sum of all line totals)", monetarySummation.getLineTotal());
		}

		log.debug("==> DONE!");
		log.debug("Finished recalculating monetarySummation.lineTotal...");

		appendTaxFromInvoiceAllowanceCharge(settlement, taxAggregator);

		appendTaxFromInvoiceServiceCharge(settlement, taxAggregator);

		monetarySummation.setTaxBasisTotal(new Amount(taxAggregator.calculateTaxBasis(), currency));
		monetarySummation.setTaxTotal(new Amount(taxAggregator.calculateTaxTotal(), currency));

		monetarySummation.setGrandTotal(Amounts.add(
				monetarySummation.getTaxBasisTotal(),
				monetarySummation.getTaxTotal()
		));

		log.debug("Recalculated grand total = {} (tax basis total + tax total)", monetarySummation.getGrandTotal());

		if (settlement.getMonetarySummation() != null && settlement.getMonetarySummation().getTotalPrepaid() != null) {
			monetarySummation.setTotalPrepaid(
					settlement.getMonetarySummation().getTotalPrepaid()
			);
		}

		monetarySummation.setDuePayable(
				Amounts.add(monetarySummation.getGrandTotal(), Amounts.negate(monetarySummation.getTotalPrepaid()))
		);

		MonetarySummation result = MonetarySummations.precise(monetarySummation, 2, RoundingMode.HALF_UP);

		log.debug("Recalculating invoice monetary summation DONE!");
		log.debug(" ==> result: {}", result);
		log.debug("");

		return new RecalculationResult(result, taxAggregator);
	}

	/**
	 * Calculates {@link SpecifiedMonetarySummation} for given {@link Item}
	 *
	 * @param item
	 * @return
	 */
	public static SpecifiedMonetarySummation calculateSpecifiedMonetarySummation(final Item item) {
		log.debug("Recalculating specified monetary summation for [{}]", item.getProduct() != null ? item.getProduct().getName() : "N/A");

		CurrencyCode currencyCode = getCurrency(item);

		SpecifiedMonetarySummation monetarySummation = MonetarySummations.newSpecifiedMonetarySummation(currencyCode);
		monetarySummation.setLineTotal(Amounts.setPrecision(new ItemLineTotalCalculator().apply(item), 2, RoundingMode.HALF_UP));
		monetarySummation.setTotalAllowanceCharge(Amounts.setPrecision(new ItemTotalAllowanceChargeCalculator(currencyCode).apply(item), 2, RoundingMode.HALF_UP));

		log.debug("==> lineTotal = {}", monetarySummation.getLineTotal());
		log.debug("==> totalAllowanceCharge = {}", monetarySummation.getTotalAllowanceCharge());

		return monetarySummation;
	}

	private static void appendTaxFromInvoiceServiceCharge(Settlement settlement, TaxAggregator taxAggregator) {
		log.debug("Adding tax amounts from invoice service charge...");
		if (settlement.getServiceCharge() != null) {
			for (LogisticsServiceCharge charge : settlement.getServiceCharge()) {
				if (charge.getTradeTax() != null && charge.getAmount() != null) {
					for (AppliedTax tax : charge.getTradeTax()) {
						log.debug("==> added {} to {}%", charge.getAmount(), tax.getPercentage());

						taxAggregator.add(tax, charge.getAmount().getValue());
					}
				}
			}
		}
	}

	private static void appendTaxFromInvoiceAllowanceCharge(Settlement settlement, TaxAggregator taxAggregator) {
		log.debug("Adding tax amounts from invoice allowance charge...");
		if (settlement.getAllowanceCharge() != null) {
			for (SpecifiedAllowanceCharge charge : settlement.getAllowanceCharge()) {
				if (charge.getCategory() != null && charge.getActual() != null) {
					BigDecimal amount = charge.getActual().getValue();
					if (charge.isDiscount()) {
						amount = amount.negate();
					}

					log.debug("==> added {} to {}%", amount, charge.getCategory().getPercentage());

					taxAggregator.add(charge.getCategory(), amount);
				}
			}
		}
	}

	public static CurrencyCode getCurrency(final Invoice invoice) {
		assertNotNull(invoice);
		return invoice.getTrade().getSettlement().getCurrency();
	}

	/**
	 * Extracts {@link CurrencyCode} from {@link Item} object.
	 * @param item
	 * @return
	 */
	public static CurrencyCode getCurrency(final Item item) {
		assertNotNull(item);

		SpecifiedAgreement agreement = item.getAgreement();
		if (agreement != null && agreement.getGrossPrice() != null && agreement.getGrossPrice().getChargeAmount() != null) {
			return agreement.getGrossPrice().getChargeAmount().getCurrency();
		}

		if (agreement != null && agreement.getNetPrice() != null && agreement.getNetPrice().getChargeAmount() != null) {
			return agreement.getNetPrice().getChargeAmount().getCurrency();
		}

		SpecifiedSettlement settlement = item.getSettlement();
		if (settlement != null && settlement.getMonetarySummation() != null && settlement.getMonetarySummation().getLineTotal() != null) {
			return settlement.getMonetarySummation().getLineTotal().getCurrency();
		}

		return null;
	}


	private static void assertNotNull(final Invoice invoice) {
		if (invoice == null || invoice.getTrade() == null) {
			throw new IllegalArgumentException("Invoice and Trade objects cannot be null");
		}
	}

	private static void assertNotNull(final Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item cannot be null");
		}
	}


	/**
	 * Helper class for calculating {@link Item}'s line total.
	 */
	static final class ItemLineTotalCalculator implements Function<Item, Amount> {

		@Nullable
		@Override
		public Amount apply(@Nullable Item item) {
			Amount originLineTotal = null;

			if (item != null && item.getSettlement() != null && item.getSettlement().getMonetarySummation() != null) {
				originLineTotal = Amounts.copy(item.getSettlement().getMonetarySummation().getLineTotal());
			}

			if (item == null || item.getDelivery() == null || item.getAgreement() == null) {
				return originLineTotal;
			}

			if (item.getAgreement().getNetPrice() == null) {
				return originLineTotal;
			}

			BigDecimal quantity = item.getDelivery().getBilled() != null ? item.getDelivery().getBilled().getValue() : BigDecimal.ZERO;
			Amount amount = item.getAgreement().getNetPrice().getChargeAmount();

			log.debug("Line total formula: {} (net price) x {} (quantity)", amount, quantity);

			return Amounts.multiply(amount, quantity);
		}
	}

	/**
	 * Helper class for calculating {@link Item}'s tax total.
	 */
	static final class ItemTaxTotalCalculator implements Function<Item, Amount> {

		private final Amount lineTotal;

		public ItemTaxTotalCalculator(final Amount lineTotal) {
			this.lineTotal = lineTotal;
		}

		@Override
		public Amount apply(@Nullable Item item) {
			CurrencyCode currency = lineTotal.getCurrency();
			Amount taxTotal = Amounts.zero(currency);

			if (item != null && item.getSettlement() != null && item.getSettlement().getTradeTax() != null) {
				for (ItemTax tax : item.getSettlement().getTradeTax()) {
					BigDecimal taxRate = tax.getPercentage().divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP).setScale(2, RoundingMode.HALF_UP);
					BigDecimal taxValue = lineTotal.getValue().multiply(taxRate).setScale(2, RoundingMode.HALF_UP);

					taxTotal = Amounts.add(taxTotal, new Amount(taxValue, currency));
				}
			}
			return taxTotal;
		}
	}

	/**
	 * Calculates total {@link io.konik.zugferd.entity.AllowanceCharge} for given {@link Item}.
	 */
	public static final class ItemTotalAllowanceChargeCalculator implements Function<Item, Amount> {

		private final CurrencyCode currencyCode;

		public ItemTotalAllowanceChargeCalculator(CurrencyCode currencyCode) {
			this.currencyCode = currencyCode;
		}

		@Override
		public Amount apply(@Nullable Item item) {
			Amount totalAllowanceCharge = Amounts.zero(currencyCode);
			BigDecimal quantity = BigDecimal.ONE;

			if (item != null && item.getDelivery() != null && item.getDelivery().getBilled() != null) {
				quantity = item.getDelivery().getBilled().getValue();
			}

			if (item != null && item.getAgreement() != null && item.getAgreement().getGrossPrice() != null) {
				GrossPrice grossPrice = item.getAgreement().getGrossPrice();

				if (grossPrice.getAllowanceCharges() != null && !grossPrice.getAllowanceCharges().isEmpty()) {
					for (AllowanceCharge charge : grossPrice.getAllowanceCharges()) {
						BigDecimal chargeValue = charge.getActual().getValue();
						if (charge.isDiscount()) {
							chargeValue = chargeValue.negate();
						}
						Amount amount = new Amount(chargeValue.multiply(quantity), currencyCode);
						totalAllowanceCharge = Amounts.add(totalAllowanceCharge, amount);
					}

					totalAllowanceCharge = Amounts.setPrecision(totalAllowanceCharge, 2, RoundingMode.HALF_UP);
				}
			}

			return totalAllowanceCharge;
		}
	}

	public static final class InvoiceAllowanceTotalCalculator implements Function<Settlement, Amount> {
		@Nullable
		@Override
		public Amount apply(@Nullable Settlement settlement) {
			if (settlement == null || settlement.getAllowanceCharge() == null) {
				return null;
			}

			BigDecimal chargeValue = BigDecimal.ZERO;

			for (SpecifiedAllowanceCharge charge : settlement.getAllowanceCharge()) {
				if (charge.isDiscount()) {
					chargeValue = chargeValue.add(charge.getActual().getValue());
				}
			}
			Amount amount =  new Amount(chargeValue, settlement.getCurrency());

			log.debug("Invoice allowance total = {}", amount);

			return amount;
		}
	}

	public static final class InvoiceChargeTotalCalculator implements Function<Settlement, Amount> {
		@Nullable
		@Override
		public Amount apply(@Nullable Settlement settlement) {
			if (settlement == null || settlement.getAllowanceCharge() == null) {
				return null;
			}

			BigDecimal chargeValue = BigDecimal.ZERO;

			for (SpecifiedAllowanceCharge charge : settlement.getAllowanceCharge()) {
				if (charge.isSurcharge()) {
					chargeValue = chargeValue.add(charge.getActual().getValue());
				}
			}

			for (LogisticsServiceCharge charge : settlement.getServiceCharge()) {
				chargeValue = chargeValue.add(charge.getAmount().getValue());
			}

			Amount amount =  new Amount(chargeValue, settlement.getCurrency());

			log.debug("Invoice charge total = {}", amount);

			return amount;
		}
	}

	public static final class ItemTaxExtractor implements Function<Item, ItemTax> {
		@Nullable
		@Override
		public ItemTax apply(@Nullable Item item) {
			if (item == null || item.getSettlement() == null) {
				return null;
			}

			if (item.getSettlement().getTradeTax().isEmpty()) {
				return null;
			}

			return item.getSettlement().getTradeTax().get(0);
		}
	}

	/**
	 * Helper class for aggregating tax information and calculating
	 * tax basis and tax total values.
	 */
	public static final class TaxAggregator {

		private static final int PRECISION = 2;
		private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

		private final ConcurrentMap<Key, BigDecimal> map = new ConcurrentHashMap<Key, BigDecimal>();

		public void add(Tax tax, BigDecimal amount) {
			Key key = Key.create(tax);
			map.putIfAbsent(key, BigDecimal.ZERO);
			map.put(key, map.get(key).add(amount));
		}

		public BigDecimal getTaxBasisForTaxPercentage(final BigDecimal percentage) {
			BigDecimal value = BigDecimal.ZERO;
			for (Key key : map.keySet()) {
				if (percentage.equals(key.getPercentage())) {
					value = value.add(map.get(key));
				}
			}
			return value;
		}

		public BigDecimal calculateTaxBasis() {
			log.debug("Recalculating tax basis for tax percentages: {}", Arrays.toString(map.keySet().toArray()));
			BigDecimal taxBasis = BigDecimal.ZERO;
			for (BigDecimal amount : map.values()) {
				taxBasis = taxBasis.add(amount);
			}

			log.debug("Recalculated tax basis = {}", taxBasis);

			return taxBasis;
		}

		public BigDecimal calculateTaxTotal() {
			log.debug("Calculating tax total...");
			BigDecimal taxTotal = BigDecimal.ZERO;
			for (Map.Entry<Key, BigDecimal> entry : map.entrySet()) {
				BigDecimal percentage = entry.getKey().getPercentage();
				BigDecimal value = entry.getValue();
				BigDecimal taxAmount = calculateTaxAmount(percentage, value);

				log.debug("===> {} x {}% = {}", value, percentage, taxAmount);

				taxTotal = taxTotal.add(taxAmount);
			}

			log.debug("Recalculated tax total = {}", taxTotal);

			return taxTotal;
		}

		public List<TradeTax> generateTradeTaxList(final CurrencyCode currencyCode, final List<TradeTax> previousList) {
			List<TradeTax> taxes = new LinkedList<TradeTax>();

			for (Key key : map.keySet()) {
				TradeTax tradeTax = new TradeTax();
				tradeTax.setType(key.getCode());
				tradeTax.setCategory(key.getCategory());
				tradeTax.setPercentage(key.getPercentage());

				BigDecimal basis = map.get(key);
				BigDecimal calculated = calculateTaxAmount(key.getPercentage(), basis);

				tradeTax.setBasis(new Amount(basis, currencyCode));
				tradeTax.setCalculated(new Amount(calculated, currencyCode));

				TradeTax existing = null;
				if (previousList != null) {
					for (TradeTax current : previousList) {
						if (tradeTax.getType().equals(current.getType()) &&
								tradeTax.getCategory().equals(current.getCategory()) &&
								tradeTax.getPercentage().equals(current.getPercentage())) {
							existing = current;
							break;
						}
					}
				}

				if (existing != null) {
					tradeTax.setExemptionReason(existing.getExemptionReason());

					if (existing.getAllowanceCharge() != null) {
						tradeTax.setAllowanceCharge(new Amount(existing.getAllowanceCharge().getValue(), existing.getAllowanceCharge().getCurrency()));
					}

					if (existing.getLineTotal() != null) {
						tradeTax.setLineTotal(new Amount(existing.getLineTotal().getValue(), existing.getLineTotal().getCurrency()));
					}
				}

				taxes.add(tradeTax);
			}

			return taxes;
		}

		public static BigDecimal calculateTaxAmount(final BigDecimal percentage, final BigDecimal value) {
			return value.multiply(percentage.divide(BigDecimal.valueOf(100))).setScale(PRECISION, ROUNDING_MODE);
		}

		@Override
		public String toString() {
			return "TaxAggregator{" +
					"map=" + map +
					'}';
		}

		/**
		 * Helper key for {@link TaxAggregator}
		 */
		static final class Key {
			private final BigDecimal percentage;
			private final TaxCode code;
			private final TaxCategory category;

			private Key(final Tax tax) {
				this.percentage = tax.getPercentage();
				this.category = tax.getCategory();
				this.code = tax.getType();
			}

			public static Key create(final Tax tax) {
				return new Key(tax);
			}

			public BigDecimal getPercentage() {
				return percentage;
			}

			public TaxCode getCode() {
				return code;
			}

			public TaxCategory getCategory() {
				return category;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (!(o instanceof Key)) return false;

				Key key = (Key) o;

				if (!percentage.equals(key.percentage)) return false;
				if (code != key.code) return false;
				return category == key.category;

			}

			@Override
			public int hashCode() {
				int result = percentage.hashCode();
				result = 31 * result + (code != null ? code.hashCode() : 0);
				result = 31 * result + (category != null ? category.hashCode() : 0);
				return result;
			}

			@Override
			public String toString() {
				return "Key{" +
						"percentage=" + percentage +
						", code=" + code +
						", category=" + category +
						'}';
			}
		}
	}

	public static final class RecalculationResult {
		private final MonetarySummation monetarySummation;
		private final TaxAggregator taxAggregator;

		public RecalculationResult(MonetarySummation monetarySummation, TaxAggregator taxAggregator) {
			this.monetarySummation = monetarySummation;
			this.taxAggregator = taxAggregator;
		}

		public MonetarySummation getMonetarySummation() {
			return monetarySummation;
		}

		public TaxAggregator getTaxAggregator() {
			return taxAggregator;
		}
	}
}
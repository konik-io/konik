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
import io.konik.zugferd.entity.trade.item.*;
import io.konik.zugferd.unqualified.Amount;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Calculate the missing amounts of the invoice.
 */
public final class AmountCalculator {

	/**
	 * Calculates {@link MonetarySummation} for given {@link Invoice} basing on line {@link Item}s
	 * and global {@link io.konik.zugferd.entity.AllowanceCharge} and {@link LogisticsServiceCharge}
	 *
	 * @param invoice
	 * @return
	 */
	public static MonetarySummation calculateMonetarySummation(final Invoice invoice) {
		assertNotNull(invoice);

		CurrencyCode currency = getCurrency(invoice);
		List<Item> items = Items.purchasableItemsOnly(invoice.getTrade().getItems());
		Settlement settlement = invoice.getTrade().getSettlement();

		// If there are no items that can be used to recalculate monetary summation, return the current one
		if (items.isEmpty()) {
			return MonetarySummations.newMonetarySummation(settlement.getMonetarySummation());
		}

		MonetarySummation monetarySummation = MonetarySummations.newMonetarySummation(currency);
		monetarySummation.setAllowanceTotal(new InvoiceAllowanceTotalCalculator().apply(settlement));
		monetarySummation.setChargeTotal(new InvoiceChargeTotalCalculator().apply(settlement));

		TaxAggregator taxAggregator = new TaxAggregator();

		for (Item item : items) {
			Amount lineTotal = new ItemLineTotalCalculator().apply(item);
			ItemTax itemTax = new ItemTaxExtractor().apply(item);

			taxAggregator.add(itemTax, lineTotal != null ? lineTotal.getValue() : BigDecimal.ZERO);

			monetarySummation.setLineTotal(Amounts.add(
					monetarySummation.getLineTotal(),
					lineTotal
			));
		}

		appendTaxFromInvoiceAllowanceCharge(settlement, taxAggregator);

		appendTaxFromInvoiceServiceCharge(settlement, taxAggregator);

		monetarySummation.setTaxBasisTotal(new Amount(taxAggregator.calculateTaxBasis(), currency));
		monetarySummation.setTaxTotal(new Amount(taxAggregator.calculateTaxTotal(), currency));

		monetarySummation.setGrandTotal(Amounts.add(
				monetarySummation.getTaxBasisTotal(),
				monetarySummation.getTaxTotal()
		));

		if (settlement.getMonetarySummation() != null && settlement.getMonetarySummation().getTotalPrepaid() != null) {
			monetarySummation.setTotalPrepaid(
					settlement.getMonetarySummation().getTotalPrepaid()
			);
		}

		monetarySummation.setDuePayable(
				Amounts.add(monetarySummation.getGrandTotal(), Amounts.negate(monetarySummation.getTotalPrepaid()))
		);

		return MonetarySummations.precise(monetarySummation, 2, RoundingMode.HALF_UP);
	}

	/**
	 * Calculates {@link SpecifiedMonetarySummation} for given {@link Item}
	 *
	 * @param item
	 * @return
	 */
	public static SpecifiedMonetarySummation calculateSpecifiedMonetarySummation(final Item item) {
		CurrencyCode currencyCode = getCurrency(item);

		SpecifiedMonetarySummation monetarySummation = MonetarySummations.newSpecifiedMonetarySummation(currencyCode);
		monetarySummation.setLineTotal(Amounts.setPrecision(new ItemLineTotalCalculator().apply(item), 2, RoundingMode.HALF_UP));
		monetarySummation.setTotalAllowanceCharge(Amounts.setPrecision(new ItemTotalAllowanceChargeCalculator(currencyCode).apply(item), 2, RoundingMode.HALF_UP));
		return monetarySummation;
	}

	private static void appendTaxFromInvoiceServiceCharge(Settlement settlement, TaxAggregator taxAggregator) {
		if (settlement.getServiceCharge() != null) {
			for (LogisticsServiceCharge charge : settlement.getServiceCharge()) {
				if (charge.getTradeTax() != null && charge.getAmount() != null) {
					for (AppliedTax tax : charge.getTradeTax()) {
						taxAggregator.add(tax, charge.getAmount().getValue());
					}
				}
			}
		}
	}

	private static void appendTaxFromInvoiceAllowanceCharge(Settlement settlement, TaxAggregator taxAggregator) {
		if (settlement.getAllowanceCharge() != null) {
			for (SpecifiedAllowanceCharge charge : settlement.getAllowanceCharge()) {
				if (charge.getCategory() != null && charge.getActual() != null) {
					BigDecimal amount = charge.getActual().getValue();
					if (charge.isDiscount()) {
						amount = amount.negate();
					}

					if (taxAggregator.getTaxBasisForTaxPercentage(charge.getCategory().getPercentage()).signum() < 0) {
						amount = amount.negate();
					}

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

				if (grossPrice.getAllowanceCharges() != null) {
					for (AllowanceCharge charge : grossPrice.getAllowanceCharges()) {
						Amount amount = new Amount(charge.getActual().getValue().multiply(quantity), currencyCode);
						totalAllowanceCharge = Amounts.add(totalAllowanceCharge, amount);
					}
				}
			}

			return Amounts.setPrecision(totalAllowanceCharge, 2, RoundingMode.HALF_UP);
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
			return new Amount(chargeValue, settlement.getCurrency());
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

			return new Amount(chargeValue, settlement.getCurrency());
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
	static final class TaxAggregator {

		private static final int PRECISION = 2;
		private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

		private final ConcurrentMap<BigDecimal, BigDecimal> map = new ConcurrentHashMap<BigDecimal, BigDecimal>();

		public void add(Tax tax, BigDecimal amount) {
			BigDecimal key = tax.getPercentage().setScale(PRECISION, ROUNDING_MODE);
			map.putIfAbsent(key, BigDecimal.ZERO);
			map.put(key, map.get(key).add(amount));
		}

		public BigDecimal getTaxBasisForTaxPercentage(final BigDecimal percentage) {
			BigDecimal value = map.get(percentage);
			if (value == null) {
				return BigDecimal.ZERO;
			}
			return value;
		}

		public BigDecimal calculateTaxBasis() {
			BigDecimal taxBasis = BigDecimal.ZERO;
			for (BigDecimal amount : map.values()) {
				taxBasis = taxBasis.add(amount);
			}
			return taxBasis;
		}

		public BigDecimal calculateTaxTotal() {
			BigDecimal taxTotal = BigDecimal.ZERO;
			for (Map.Entry<BigDecimal, BigDecimal> entry : map.entrySet()) {
				BigDecimal taxAmount = entry.getValue().multiply(entry.getKey().divide(BigDecimal.valueOf(100))).setScale(PRECISION, ROUNDING_MODE);
				taxTotal = taxTotal.add(taxAmount);
			}
			return taxTotal;
		}
	}
}
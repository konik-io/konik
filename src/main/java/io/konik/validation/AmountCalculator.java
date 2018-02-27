/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of the Konik library.
 *
 * The Konik library is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * The Konik library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with the Konik
 * library. If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.validation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.util.Amounts;
import io.konik.util.Items;
import io.konik.util.MonetarySummations;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.AppliedTax;
import io.konik.zugferd.entity.LogisticsServiceCharge;
import io.konik.zugferd.entity.SpecifiedAllowanceCharge;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.Settlement;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.ItemTax;
import io.konik.zugferd.entity.trade.item.SpecifiedAgreement;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import io.konik.zugferd.entity.trade.item.SpecifiedSettlement;
import io.konik.zugferd.unqualified.Amount;

/**
 * Calculate the missing amounts of the invoice.
 */
public final class AmountCalculator {

  protected static final Logger LOG = LoggerFactory.getLogger(AmountCalculator.class);

  /**
   * Calculates {@link MonetarySummation} for given {@link Invoice} basing on line {@link Item}s and
   * global {@link io.konik.zugferd.entity.AllowanceCharge} and {@link LogisticsServiceCharge}
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

    // If there are no items that can be used to recalculate monetary summation, return the current
    // one
    if (items.isEmpty()) {
      return new RecalculationResult(
          MonetarySummations.newMonetarySummation(settlement.getMonetarySummation()),
          taxAggregator);
    }

    MonetarySummation monetarySummation = MonetarySummations.newMonetarySummation(currency);
    monetarySummation.setAllowanceTotal(new InvoiceAllowanceTotalCalculator().apply(settlement));
    monetarySummation.setChargeTotal(new InvoiceChargeTotalCalculator().apply(settlement));

    LOG.debug("Starting recalculating line total from {} items...", items.size());
    int itemsCounter = 0;

    for (Item item : items) {
      LOG.debug("==> {}:", ++itemsCounter);
      LOG.debug("Recalculating item: [{}]",
          item.getProduct() != null ? item.getProduct().getName() : "N/A");

      Amount lineTotal = new ItemLineTotalCalculator().apply(item);
      List<ItemTax> itemTaxes = item.getSettlement().getTradeTax();
      for (ItemTax tax : itemTaxes) {
        LOG.debug("Recalculated item line total = {}", lineTotal);
        LOG.debug("Recalculated item tax = {}%", tax.getPercentage());

        taxAggregator.add(tax, lineTotal != null ? lineTotal.getValue() : BigDecimal.ZERO);
      }

      monetarySummation.setLineTotal(Amounts.add(monetarySummation.getLineTotal(), lineTotal));

      LOG.debug("Current monetarySummation.lineTotal = {} (the sum of all line totals)",
          monetarySummation.getLineTotal());
    }

    LOG.debug("==> DONE!");
    LOG.debug("Finished recalculating monetarySummation.lineTotal...");

    appendTaxFromInvoiceAllowanceCharge(settlement, taxAggregator);

    appendTaxFromInvoiceServiceCharge(settlement, taxAggregator);

    monetarySummation
        .setTaxBasisTotal(new Amount(taxAggregator.calculateTaxBasis(items), currency));
    monetarySummation.setTaxTotal(new Amount(taxAggregator.calculateTaxTotal(), currency));

    monetarySummation.setGrandTotal(
        Amounts.add(monetarySummation.getTaxBasisTotal(), monetarySummation.getTaxTotal()));

    LOG.debug("Recalculated grand total = {} (tax basis total + tax total)",
        monetarySummation.getGrandTotal());

    if (settlement.getMonetarySummation() != null
        && settlement.getMonetarySummation().getTotalPrepaid() != null) {
      monetarySummation.setTotalPrepaid(settlement.getMonetarySummation().getTotalPrepaid());
    }

    monetarySummation.setDuePayable(Amounts.add(monetarySummation.getGrandTotal(),
        Amounts.negate(monetarySummation.getTotalPrepaid())));

    MonetarySummation result =
        MonetarySummations.precise(monetarySummation, 2, RoundingMode.HALF_UP);

    LOG.debug("Recalculating invoice monetary summation DONE!");
    LOG.debug(" ==> result: {}", result);
    LOG.debug("");

    return new RecalculationResult(result, taxAggregator);
  }

  /**
   * Calculates {@link SpecifiedMonetarySummation} for given {@link Item}
   *
   * @param item
   * @return
   */
  public static SpecifiedMonetarySummation calculateSpecifiedMonetarySummation(final Item item) {
    LOG.debug("Recalculating specified monetary summation for [{}]",
        item.getProduct() != null ? item.getProduct().getName() : "N/A");

    CurrencyCode currencyCode = getCurrency(item);

    SpecifiedMonetarySummation monetarySummation =
        MonetarySummations.newSpecifiedMonetarySummation(currencyCode);
    monetarySummation.setLineTotal(
        Amounts.setPrecision(new ItemLineTotalCalculator().apply(item), 2, RoundingMode.HALF_UP));
    monetarySummation.setTotalAllowanceCharge(Amounts.setPrecision(
        new ItemTotalAllowanceChargeCalculator(currencyCode).apply(item), 2, RoundingMode.HALF_UP));

    LOG.debug("==> lineTotal = {}", monetarySummation.getLineTotal());
    LOG.debug("==> totalAllowanceCharge = {}", monetarySummation.getTotalAllowanceCharge());

    return monetarySummation;
  }

  private static void appendTaxFromInvoiceServiceCharge(Settlement settlement,
      TaxAggregator taxAggregator) {
    LOG.debug("Adding tax amounts from invoice service charge...");
    if (settlement.getServiceCharge() != null) {
      for (LogisticsServiceCharge charge : settlement.getServiceCharge()) {
        if (charge.getTradeTax() != null && charge.getAmount() != null) {
          for (AppliedTax tax : charge.getTradeTax()) {
            LOG.debug("==> added {} to {}%", charge.getAmount(), tax.getPercentage());

            taxAggregator.add(tax, charge.getAmount().getValue());
          }
        }
      }
    }
  }

  private static void appendTaxFromInvoiceAllowanceCharge(Settlement settlement,
      TaxAggregator taxAggregator) {
    LOG.debug("Adding tax amounts from invoice allowance charge...");
    if (settlement.getAllowanceCharge() != null) {
      for (SpecifiedAllowanceCharge charge : settlement.getAllowanceCharge()) {
        if (charge.getCategory() != null && charge.getActual() != null) {
          BigDecimal amount = charge.getActual().getValue();
          if (charge.isDiscount()) {
            amount = amount.negate();
          }

          LOG.debug("==> added {} to {}%", amount, charge.getCategory().getPercentage());

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
   * 
   * @param item
   * @return
   */
  public static CurrencyCode getCurrency(final Item item) {
    assertNotNull(item);

    SpecifiedAgreement agreement = item.getAgreement();
    if (agreement != null && agreement.getGrossPrice() != null
        && agreement.getGrossPrice().getChargeAmount() != null) {
      return agreement.getGrossPrice().getChargeAmount().getCurrency();
    }

    if (agreement != null && agreement.getNetPrice() != null
        && agreement.getNetPrice().getChargeAmount() != null) {
      return agreement.getNetPrice().getChargeAmount().getCurrency();
    }

    SpecifiedSettlement settlement = item.getSettlement();
    if (settlement != null && settlement.getMonetarySummation() != null
        && settlement.getMonetarySummation().getLineTotal() != null) {
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
}

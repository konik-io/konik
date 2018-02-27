/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.annotation.Nullable;
import com.google.common.base.Function;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.util.Amounts;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.ItemTax;
import io.konik.zugferd.unqualified.Amount;

/**
 * Helper class for calculating {@link Item}'s tax total.
 */
final class ItemTaxTotalCalculator implements Function<Item, Amount> {

  private final Amount lineTotal;

  public ItemTaxTotalCalculator(final Amount lineTotal) {
    this.lineTotal = lineTotal;
  }

  @Override
  public Amount apply(@Nullable Item item) {
    CurrencyCode currency = lineTotal.getCurrency();
    Amount taxTotal = Amounts.zero(currency);

    if (item != null && item.getSettlement() != null
        && item.getSettlement().getTradeTax() != null) {
      for (ItemTax tax : item.getSettlement().getTradeTax()) {
        BigDecimal taxRate =
            tax.getPercentage().divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxValue =
            lineTotal.getValue().multiply(taxRate).setScale(2, RoundingMode.HALF_UP);

        taxTotal = Amounts.add(taxTotal, new Amount(taxValue, currency));
      }
    }
    return taxTotal;
  }
}

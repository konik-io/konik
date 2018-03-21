/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.annotation.Nullable;
import com.google.common.base.Function;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.util.Amounts;
import io.konik.zugferd.entity.AllowanceCharge;
import io.konik.zugferd.entity.GrossPrice;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.unqualified.Amount;

/**
 * Calculates total {@link io.konik.zugferd.entity.AllowanceCharge} for given {@link Item}.
 */
final class ItemTotalAllowanceChargeCalculator implements Function<Item, Amount> {

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

    if (item != null && item.getAgreement() != null
        && item.getAgreement().getGrossPrice() != null) {
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

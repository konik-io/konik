/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import java.math.BigDecimal;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Function;
import io.konik.util.Amounts;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.unqualified.Amount;

/**
 * Helper class for calculating {@link Item}'s line total.
 */
final class ItemLineTotalCalculator implements Function<Item, Amount> {

  protected static final Logger LOG = LoggerFactory.getLogger(ItemLineTotalCalculator.class);

  @Nullable
  @Override
  public Amount apply(@Nullable Item item) {
    Amount originLineTotal = null;

    if (item != null && item.getSettlement() != null
        && item.getSettlement().getMonetarySummation() != null) {
      originLineTotal = Amounts.copy(item.getSettlement().getMonetarySummation().getLineTotal());
    }

    if (item == null || item.getDelivery() == null || item.getAgreement() == null) {
      return originLineTotal;
    }

    if (item.getAgreement().getNetPrice() == null) {
      return originLineTotal;
    }

    BigDecimal quantity =
        item.getDelivery().getBilled() != null ? item.getDelivery().getBilled().getValue()
            : BigDecimal.ZERO;
    Amount amount = item.getAgreement().getNetPrice().getChargeAmount();

    LOG.debug("Line total formula: {} (net price) x {} (quantity)", amount, quantity);

    return Amounts.multiply(amount, quantity);
  }
}

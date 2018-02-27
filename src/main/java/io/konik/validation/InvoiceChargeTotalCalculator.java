/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import java.math.BigDecimal;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Function;
import io.konik.zugferd.entity.LogisticsServiceCharge;
import io.konik.zugferd.entity.SpecifiedAllowanceCharge;
import io.konik.zugferd.entity.trade.Settlement;
import io.konik.zugferd.unqualified.Amount;

final class InvoiceChargeTotalCalculator implements Function<Settlement, Amount> {

  protected static final Logger LOG = LoggerFactory.getLogger(InvoiceChargeTotalCalculator.class);

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

    Amount amount = new Amount(chargeValue, settlement.getCurrency());

    LOG.debug("Invoice charge total = {}", amount);

    return amount;
  }
}

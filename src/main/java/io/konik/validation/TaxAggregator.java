/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.zugferd.entity.Tax;
import io.konik.zugferd.entity.trade.TradeTax;
import io.konik.zugferd.unqualified.Amount;

/**
 * Helper class for aggregating tax information and calculating tax basis and tax total values.
 */
public class TaxAggregator {

  protected static final Logger LOG = LoggerFactory.getLogger(TaxAggregator.class);

  private static final int PRECISION = 2;
  private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

  private final ConcurrentMap<List<TaxKey>, BigDecimal> map =
      new ConcurrentHashMap<List<TaxKey>, BigDecimal>();

  public void add(final List<Tax> itemTaxes, BigDecimal amount) {
    List<TaxKey> taxKeys = new ArrayList<TaxKey>(itemTaxes.size());
    for (Tax tax : itemTaxes) {
      taxKeys.add(TaxKey.create(tax));
    }
    map.putIfAbsent(taxKeys, BigDecimal.ZERO);
    map.put(taxKeys, map.get(taxKeys).add(amount));
  }

  public BigDecimal getTaxBasisForTaxPercentage(final BigDecimal percentage) {
    BigDecimal value = BigDecimal.ZERO;
    for (List<TaxKey> keys : map.keySet()) {
      BigDecimal percentageSum = BigDecimal.ZERO;
      for (TaxKey taxKey : keys) {
        percentageSum = percentageSum.add(taxKey.getPercentage());
      }
      if (percentage.equals(percentageSum)) {
        value = value.add(map.get(keys));
      }
    }
    return value;
  }

  public BigDecimal calculateTaxBasis() {
    LOG.debug("Recalculating tax basis for tax percentages: {}",
        Arrays.toString(map.keySet().toArray()));
    BigDecimal taxBasis = BigDecimal.ZERO;

    for (Map.Entry<List<TaxKey>, BigDecimal> entry : map.entrySet()) {
      taxBasis = taxBasis.add(entry.getValue());
    }

    LOG.debug("Recalculated tax basis = {}", taxBasis);

    return taxBasis;
  }

  public BigDecimal calculateTaxTotal() {
    LOG.debug("Calculating tax total...");
    BigDecimal taxTotal = BigDecimal.ZERO;
    for (Map.Entry<List<TaxKey>, BigDecimal> entry : map.entrySet()) {
      BigDecimal percentage = BigDecimal.ZERO;
      for (TaxKey key : entry.getKey()) {
        percentage = percentage.add(key.getPercentage());
      }
      BigDecimal value = entry.getValue();
      BigDecimal taxAmount = calculateTaxAmount(percentage, value);

      LOG.debug("===> {} x {}% = {}", value, percentage, taxAmount);

      taxTotal = taxTotal.add(taxAmount);
    }

    LOG.debug("Recalculated tax total = {}", taxTotal);

    return taxTotal;
  }

  public List<TradeTax> generateTradeTaxList(final CurrencyCode currencyCode,
      final List<TradeTax> previousList) {
    List<TradeTax> taxes = new LinkedList<TradeTax>();

    for (List<TaxKey> keys : map.keySet()) {
      for (TaxKey key : keys) {
        TradeTax tradeTax = new TradeTax();
        tradeTax.setType(key.getCode());
        tradeTax.setCategory(key.getCategory());
        tradeTax.setPercentage(key.getPercentage());

        BigDecimal basis = map.get(keys);
        BigDecimal calculated = calculateTaxAmount(key.getPercentage(), basis);

        tradeTax.setBasis(new Amount(basis, currencyCode));
        tradeTax.setCalculated(new Amount(calculated, currencyCode));

        TradeTax existing = null;
        if (previousList != null) {
          for (TradeTax current : previousList) {
            if (tradeTax.getType().equals(current.getType())
                && tradeTax.getCategory().equals(current.getCategory())
                && tradeTax.getPercentage().equals(current.getPercentage())) {
              existing = current;
              break;
            }
          }
        }

        if (existing != null) {
          tradeTax.setExemptionReason(existing.getExemptionReason());

          if (existing.getAllowanceCharge() != null) {
            tradeTax.setAllowanceCharge(new Amount(existing.getAllowanceCharge().getValue(),
                existing.getAllowanceCharge().getCurrency()));
          }

          if (existing.getLineTotal() != null) {
            tradeTax.setLineTotal(new Amount(existing.getLineTotal().getValue(),
                existing.getLineTotal().getCurrency()));
          }
        }

        taxes.add(tradeTax);
      }
    }

    return taxes;
  }

  public static BigDecimal calculateTaxAmount(final BigDecimal percentage, final BigDecimal value) {
    return value.multiply(percentage.divide(BigDecimal.valueOf(100))).setScale(PRECISION,
        ROUNDING_MODE);
  }

  @Override
  public String toString() {
    return "TaxAggregator{" + "map=" + map + '}';
  }
}

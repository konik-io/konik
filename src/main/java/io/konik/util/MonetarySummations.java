package io.konik.util;

import java.math.RoundingMode;

import com.neovisionaries.i18n.CurrencyCode;

import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import io.konik.zugferd.unqualified.Amount;

/**
 * Helper functions for {@link io.konik.zugferd.entity.trade.MonetarySummation} class.
 */
public final class MonetarySummations {

   /**
    * Creates a new {@link MonetarySummation} with 0 (zero) {@link Amount} for every field.
    * @param currencyCode
    * @return
    */
   public static MonetarySummation newMonetarySummation(final CurrencyCode currencyCode) {
      Amount zeroAmount = Amounts.zero(currencyCode);

      MonetarySummation monetarySummation = new MonetarySummation();
      monetarySummation.setAllowanceTotal(zeroAmount);
      monetarySummation.setChargeTotal(zeroAmount);
      monetarySummation.setDuePayable(zeroAmount);
      monetarySummation.setGrandTotal(zeroAmount);
      monetarySummation.setLineTotal(zeroAmount);
      monetarySummation.setTaxBasisTotal(zeroAmount);
      monetarySummation.setTaxTotal(zeroAmount);
      monetarySummation.setTotalPrepaid(zeroAmount);

      return monetarySummation;
   }

   /**
    * Creates a new {@link SpecifiedMonetarySummation} with 0 (zero) {@link Amount} for every field.
    * @param currencyCode
    * @return
    */
   public static SpecifiedMonetarySummation newSpecifiedMonetarySummation(final CurrencyCode currencyCode) {
      Amount zeroAmount = Amounts.zero(currencyCode);

      SpecifiedMonetarySummation monetarySummation = new SpecifiedMonetarySummation();
      monetarySummation.setLineTotal(zeroAmount);
      monetarySummation.setTotalAllowanceCharge(zeroAmount);

      return monetarySummation;
   }

   public static MonetarySummation newMonetarySummation(final MonetarySummation monetarySummation) {
      MonetarySummation copy = new MonetarySummation();
      copy.setChargeTotal(Amounts.copy(monetarySummation.getChargeTotal()));
      copy.setDuePayable(Amounts.copy(monetarySummation.getDuePayable()));
      copy.setLineTotal(Amounts.copy(monetarySummation.getLineTotal()));
      copy.setTotalPrepaid(Amounts.copy(monetarySummation.getTotalPrepaid()));
      copy.setGrandTotal(Amounts.copy(monetarySummation.getGrandTotal()));
      copy.setAllowanceTotal(Amounts.copy(monetarySummation.getAllowanceTotal()));
      copy.setTaxBasisTotal(Amounts.copy(monetarySummation.getTaxBasisTotal()));
      copy.setTaxTotal(Amounts.copy(monetarySummation.getTaxTotal()));
      return copy;
   }

   public static MonetarySummation precise(final MonetarySummation monetarySummation, int precision,
         RoundingMode roundingMode) {
      MonetarySummation copy = newMonetarySummation(monetarySummation);
      copy.setChargeTotal(Amounts.setPrecision(copy.getChargeTotal(), precision, roundingMode));
      copy.setDuePayable(Amounts.setPrecision(copy.getDuePayable(), precision, roundingMode));
      copy.setLineTotal(Amounts.setPrecision(copy.getLineTotal(), precision, roundingMode));
      copy.setTotalPrepaid(Amounts.setPrecision(copy.getTotalPrepaid(), precision, roundingMode));
      copy.setGrandTotal(Amounts.setPrecision(copy.getGrandTotal(), precision, roundingMode));
      copy.setAllowanceTotal(Amounts.setPrecision(copy.getAllowanceTotal(), precision, roundingMode));
      copy.setTaxBasisTotal(Amounts.setPrecision(copy.getTaxBasisTotal(), precision, roundingMode));
      copy.setTaxTotal(Amounts.setPrecision(copy.getTaxTotal(), precision, roundingMode));
      return copy;
   }
}

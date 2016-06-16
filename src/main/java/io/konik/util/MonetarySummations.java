package io.konik.util;

import com.neovisionaries.i18n.CurrencyCode;
import io.konik.zugferd.entity.trade.MonetarySummation;
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
}

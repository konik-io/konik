package io.konik.util;


import com.neovisionaries.i18n.CurrencyCode;
import io.konik.zugferd.unqualified.Amount;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Helper functions for {@link Amount} class.
 */
public final class Amounts {

	/**
	 * Creates {@link Amount} object with 0 (zero) value and given {@link CurrencyCode}
	 * @param currencyCode
	 * @return
	 */
	public static Amount zero(CurrencyCode currencyCode) {
		return new Amount(BigDecimal.ZERO, currencyCode);
	}

	/**
	 * Sums two amounts with the same {@link CurrencyCode} and throws {@link IllegalArgumentException} if
	 * amounts don't have the same {@link CurrencyCode}
	 * @param first
	 * @param second
	 * @return
	 */
	public static Amount add(final Amount first, final Amount second) {
		if (first == null && second == null) {
			throw new IllegalArgumentException("First and second amount cannot be null");
		}

		if (first != null && second != null && !first.getCurrency().equals(second.getCurrency())) {
			throw new IllegalArgumentException("Cannot add two amounts with different currencies");
		}

		CurrencyCode currency = first != null ? first.getCurrency() : second.getCurrency();
		BigDecimal firstValue = first != null ? first.getValue() : BigDecimal.ZERO;
		BigDecimal secondValue = second != null ? second.getValue() : BigDecimal.ZERO;

		return new Amount(firstValue.add(secondValue), currency);
	}

	/**
	 * Multiplies given {@link Amount} specified number of times.
	 * @param amount
	 * @param times
	 * @return
	 */
	public static Amount multiply(Amount amount, BigDecimal times) {
		return new Amount(amount.getValue().multiply(times).setScale(2, RoundingMode.HALF_UP), amount.getCurrency());
	}

	public static Amount negate(Amount amount) {
		return new Amount(amount.getValue().negate(), amount.getCurrency());
	}
}

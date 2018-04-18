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
package io.konik.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.neovisionaries.i18n.CurrencyCode;

import io.konik.zugferd.unqualified.Amount;

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
      return new Amount(amount.getValue().multiply(times), amount.getCurrency());
   }

   /**
    * Negate Amount
    *
    * @param amount the amount
    * @return the amount
    */
   public static Amount negate(Amount amount) {
      return new Amount(amount.getValue().negate(), amount.getCurrency());
   }

   /**
    * Amount absolute value.
    * @param amount
    * @return
    */
   public static Amount abs(Amount amount) {
      return new Amount(amount.getValue().abs(), amount.getCurrency());
   }

   /**
    * Sets the precision for amount.
    *
    * @param amount the amount
    * @param precision the precision
    * @param roundingMode the rounding mode
    * @return the amount
    */
   public static Amount setPrecision(final Amount amount, int precision, RoundingMode roundingMode) {
      if (amount == null) {
         return null;
      }
      return new Amount(amount.getValue().setScale(precision, roundingMode), amount.getCurrency());
   }

   /**
    * Creates a copy of given {@link Amount} object.
    * @param amount
    * @return
    */
   public static Amount copy(final Amount amount) {
      if (amount == null) {
         return null;
      }
      return new Amount(amount.getValue(), amount.getCurrency());
   }
}

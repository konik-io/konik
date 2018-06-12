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
package io.konik.jaxb.adapter;

import static java.lang.Integer.parseInt;
import static java.math.RoundingMode.valueOf;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import io.konik.Configuration;
import io.konik.zugferd.unqualified.Amount;

/**
 * 
 * Adapter to round the amount during marshalling to two decimals after the period.
 * 
 * The scale and rounding mode can be overridden via the configuration.
 * 
 * Defaults::
 * 
 * ----
 * io.konik.jaxb.adapter.TwoDigitRoundingAdapter.scale=2
 * io.konik.jaxb.adapter.TwoDigitRoundingAdapter.roundingMode=HALF_UP
 * ----
 */
public class TwoDigitRoundingAdapter extends XmlAdapter<Amount, Amount> {

   private static final String DEFAULT_SCALE = "2";
   private static final String DEFAULT_ROUNDING_MODE = "HALF_UP";

   private final int scale;
   private final RoundingMode roundingMode;
   private boolean stripTrailingZeros;

   /**
    * Instantiates a new amount rounding adapter.
    */
   public TwoDigitRoundingAdapter() {
      String name = this.getClass().getName();
      scale = parseInt(Configuration.INSTANCE.getProperty(name + ".scale", getDefaultScale()));
      roundingMode = valueOf(Configuration.INSTANCE.getProperty(name + ".roundingMode", DEFAULT_ROUNDING_MODE));
      stripTrailingZeros = Configuration.INSTANCE.stripTrailingZeros();
   }

   protected String getDefaultScale() {
      return DEFAULT_SCALE;
   }

   @Override
   public Amount unmarshal(Amount amount) throws Exception {
      if (amount == null || amount.getValue() == null) {
         return amount;
      }
      return amount.setValue(round(amount));
   }

   @Override
   public Amount marshal(Amount amount) throws Exception {
      if (amount == null || amount.getValue() == null) {
         return amount;
      }
      return amount.setValue(round(amount));
   }

   private BigDecimal round(Amount amount) {
      BigDecimal rounded = amount.getValue().setScale(scale, roundingMode);
      if (stripTrailingZeros) {
         return rounded.stripTrailingZeros();
      }
      return rounded;
   }
}

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

/**
 * 
 * Adapter to round the BigDecimal for marshalling to four decimals after the period.
 * 
 * The scale and rounding mode can be overridden via the configuration.
 * 
 * Defaults::
 * 
 * ----
 * io.konik.jaxb.adapter.BigDecimalRoundingAdapter.scale=4
 * io.konik.jaxb.adapter.BigDecimalRoundingAdapter.roundingMode=HALF_UP
 * ----
 * 
 */
public class QuantityRoundingAdapter extends XmlAdapter<BigDecimal, BigDecimal> {

   private static final String DEFAULT_ROUNDING_MODE = "HALF_UP";
   private static final String DEFAULT_SCALE = "4";

   final int scale;
   final RoundingMode roundingMode;
   private final boolean stripTrailingZeros;

   /**
    * Instantiates a new amount rounding adapter.
    */
   public QuantityRoundingAdapter() {
      String name = this.getClass().getName();
      scale = parseInt(Configuration.INSTANCE.getProperty(name + ".scale", DEFAULT_SCALE));
      roundingMode = valueOf(Configuration.INSTANCE.getProperty(name + ".roundingMode", DEFAULT_ROUNDING_MODE));
      stripTrailingZeros = Configuration.INSTANCE.stripTrailingZeros();
   }

   @Override
   public BigDecimal unmarshal(BigDecimal amount) throws Exception {
      return amount;
   }

   @Override
   public BigDecimal marshal(BigDecimal amount) throws Exception {
      if (amount == null) {
         return null;
      }
      BigDecimal roundedValue = amount.setScale(scale, roundingMode);
      if (stripTrailingZeros) {
         return roundedValue.stripTrailingZeros();
      }
      return roundedValue;
   }
}

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
import static java.lang.System.getProperty;
import static java.math.RoundingMode.valueOf;
import io.konik.zugferd.unqualified.Amount;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * Adapter to round the amount during marshalling to two decimals after the period.
 * 
 * The scale and rounding mode can be overridden via the configuration. 
 * 
 * Defaults::
 * 
 * ----
 * io.konik.jaxb.adapter.AmountLowRoundingAdapter.scale=2
 * io.konik.jaxb.adapter.AmountLowRoundingAdapter.roundingMode=HALF_UP
 * ----
 * 
 */
public class AmountLowRoundingAdapter extends XmlAdapter<Amount, Amount> {

   private static final String DEFAULT_ROUNDING_MODE = "HALF_UP";
   private static final String DEFAULT_SCALE = "2";
   
   final int scale;
   final RoundingMode roundingMode;
   
   /**
    * Instantiates a new amount rounding adapter.
    */
   public AmountLowRoundingAdapter() {
      String name = this.getClass().getName();
      scale = parseInt(getProperty(name+".scale",getDefaultScale()));
      roundingMode = valueOf(getProperty(name+".roundingMode",getDefaultRoundingMode()));
   }
   
   @Override
   public Amount unmarshal(Amount amount) throws Exception {
      return amount;
   }

   @Override
   public Amount marshal(Amount amount) throws Exception {
      if (amount==null || amount.getValue()==null) {return amount;}
      BigDecimal roundedValue = amount.getValue().setScale(scale, roundingMode);//.stripTrailingZeros();
      return amount.setValue(roundedValue);
   }
   
   
   protected String getDefaultRoundingMode() {
      return DEFAULT_ROUNDING_MODE;
   }


   protected String getDefaultScale() {
      return DEFAULT_SCALE;
   }

}

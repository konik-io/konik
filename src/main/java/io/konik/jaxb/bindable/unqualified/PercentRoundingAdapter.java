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
package io.konik.jaxb.bindable.unqualified;

import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;
import static java.math.RoundingMode.valueOf;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * = Rounding Adapter for percentage.
 */
public class PercentRoundingAdapter extends XmlAdapter<BigDecimal, BigDecimal>{
  
   private static final String DEFAULT_ROUNDING_MODE = "HALF_UP";
   private static final String DEFAULT_SCALE = "2";
   
   final int scale;
   final RoundingMode roundingMode;
   
   /**
    * Instantiates a new percent rounding adapter.
    */
   public PercentRoundingAdapter() {
      String name = this.getClass().getName();
      scale = parseInt(getProperty(name+".scale",DEFAULT_SCALE));
      roundingMode = valueOf(getProperty(name+".roundingMode",DEFAULT_ROUNDING_MODE));
   }
   
   @Override
   public BigDecimal unmarshal(BigDecimal p) throws Exception {
      return p;
   }

   @Override
   public BigDecimal marshal(BigDecimal value) throws Exception {
      if (value== null) {return null;}
      return value.setScale(scale, roundingMode).stripTrailingZeros();
   }
}

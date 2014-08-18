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


/**
 * 
 * Adapter to round the amount during marshalling to four decimals after the period.
 * 
 * The scale and rounding mode can be overridden via the configuration.
 * 
 * Defaults::
 * 
 * ----
 * io.konik.jaxb.adapter.AmountHighRoundingAdapter.scale=4
 * io.konik.jaxb.adapter.AmountHighRoundingAdapter.roundingMode=HALF_UP
 * ----
 */
public class AmountHighRoundingAdapter extends AmountLowRoundingAdapter {

   private static final String DEFAULT_SCALE = "4";
   
   @Override
   protected String getDefaultScale() {
      return DEFAULT_SCALE;
   }
}

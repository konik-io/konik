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
package io.konik.zugferd.entity.trade.item;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.konik.jaxb.adapter.FourDigitRoundingAdapter;
import io.konik.jaxb.adapter.TwoDigitRoundingAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.CommonMonetarySummation;
import io.konik.zugferd.unqualified.Amount;

/**
 * 
 * The specified per monetary summation on item basis.
 */
@XmlType(propOrder = { "lineTotal", "totalAllowanceCharge" })
public class SpecifiedMonetarySummation implements CommonMonetarySummation {

   @XmlElement(name = "LineTotalAmount")
   @XmlJavaTypeAdapter(TwoDigitRoundingAdapter.class)
   private Amount lineTotal;

   @XmlElement(name = "TotalAllowanceChargeAmount")
   @XmlJavaTypeAdapter(FourDigitRoundingAdapter.class)
   private Amount totalAllowanceCharge;

   @Comfort
   @Override
   @Valid
   @NotNull(groups = Comfort.class)
   public Amount getLineTotal() {
      return lineTotal;
   }

   @Override
   public SpecifiedMonetarySummation setLineTotal(Amount lineTotal) {
      this.lineTotal = lineTotal;
      return this;
   }

   /**
    * Gets the total allowance charge.
    *
    * @return the total allowance charge
    */
   @Extended
   @Valid
   public Amount getTotalAllowanceCharge() {
      return totalAllowanceCharge;
   }

   /**
    * Sets the total allowance charge.
    *
    * @param totalAllowanceCharge the new total allowance charge
    * @return the specified monetary summation
    */
   public SpecifiedMonetarySummation setTotalAllowanceCharge(Amount totalAllowanceCharge) {
      this.totalAllowanceCharge = totalAllowanceCharge;
      return this;
   }
}

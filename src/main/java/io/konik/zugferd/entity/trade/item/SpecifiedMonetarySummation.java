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

import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.entity.CommonMonetarySummation;
import io.konik.zugferd.unqualified.Amount;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * The specified per item monetary summation.
 */
@XmlType(propOrder = { "lineTotal", "totalAllowanceCharge" })
public class SpecifiedMonetarySummation extends CommonMonetarySummation {

   @Valid
   @XmlElement(name = "TotalAllowanceChargeAmount")
   private Amount totalAllowanceCharge;

   @Override
   @NotNull(groups = Comfort.class)
   public Amount getLineTotal() {
      return super.getLineTotal();
   }

   @Override
   public SpecifiedMonetarySummation setLineTotal(Amount lineTotal) {
      super.setLineTotal(lineTotal);
      return this;
   }

   /**
    * Gets the total allowance charge.
    *
    * @return the total allowance charge
    */
   public Amount getTotalAllowanceCharge() {
      return totalAllowanceCharge;
   }

   /**
    * Sets the total allowance charge.
    *
    * @param totalAllowanceCharge the new total allowance charge
    * @return
    */
   public SpecifiedMonetarySummation setTotalAllowanceCharge(Amount totalAllowanceCharge) {
      this.totalAllowanceCharge = totalAllowanceCharge;
      return this;
   }
}

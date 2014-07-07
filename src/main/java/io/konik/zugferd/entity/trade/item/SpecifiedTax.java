/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.entity.trade.item;

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.entity.Tax;
import io.konik.zugferd.unqualified.Amount;

import javax.validation.constraints.NotNull;

/**
 * = The trade tax on an item basis.
 */
public class SpecifiedTax extends Tax {

   /**
    * Gets the calculated amount.
    * 
    * Profile:: BASIC
    * 
    * @return the calculated amount
    */
   @Basic 
   @NotNull 
   public Amount getCalculated() {
      return calculated;
   }

   /**
    * Sets the calculated amount.
    * 
    * Profile:: BASIC
    *
    * @param calculatedAmount the new calculated amount
    * @return the tax
    */
   public SpecifiedTax setCalculatedAmount(Amount calculatedAmount) {
      this.calculated = calculatedAmount;
      return this;
   }

   /**
    * Gets the tax exemption reason.
    * 
    * Profile:: COMFORT
    * 
    * @return the exemption reason
    */
   @Comfort
   public String getExemptionReason() {
      return exemptionReason;
   }

   /**
    * Sets the tax exemption reason.
    * 
    * Profile:: COMFORT
    *
    * @param exemptionReason the new exemption reason
    * @return the tax
    */
   public SpecifiedTax setExemptionReason(String exemptionReason) {
      this.exemptionReason = exemptionReason;
      return this;
   }

}

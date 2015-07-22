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
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.Tax;
import io.konik.zugferd.unqualified.Amount;

import javax.validation.Valid;

/**
 *  
 * The Interface ItemTax.
 */
public interface SpecifiedTax extends Tax{

   /**
    * Set the calculated amount.
    * @param calculatedAmount 
    * 
    * @return the tax
    */
   @Valid
   @Extended
   SpecifiedTax setCalculated(Amount calculatedAmount);

   /**
    * Sets the calculated amount.
    * 
    * @return the calculated amount
    */
   Amount getCalculated();
   
   /**
    * Sets the tax exemption reason.
    * 
    * @param exemptionReason the new exemption reason
    * @return the tax
    */
   SpecifiedTax setExemptionReason(String exemptionReason);

   
   /**
    * Gets the tax exemption reason.
    * 
    * @return the exemption reason
    */
   @Comfort
   String getExemptionReason();



}

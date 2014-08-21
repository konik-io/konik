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
package io.konik.zugferd.entity;

import io.konik.zugferd.unqualified.Amount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * The Class GrossPrice.
 */
public class GrossPrice extends Price {

   GrossPrice() {
      super();
   }

   /**
    * Instantiates a new gross price.
    *
    * @param chargeAmount the charge amount
    */
   public GrossPrice(Amount chargeAmount) {
      super(chargeAmount);
   }

   /**
    * Gets the applied trade allowance charge.
    * 
    * @return the applied trade allowance charge
    */
   public List<AllowanceCharge> getAllowanceCharges() {
      if (allowanceCharges == null) {
         allowanceCharges = new ArrayList<AllowanceCharge>();
      }
      return this.allowanceCharges;
   }
   
   /**
    * Adds additional allowance charges.
    *
    * @param additionalAllowanceCharges the additional allowance charges
    * @return the price
    */
   public Price addAllowanceCharge(AllowanceCharge... additionalAllowanceCharges) {
      Collections.addAll(getAllowanceCharges(),additionalAllowanceCharges);
      return this;
   }
}

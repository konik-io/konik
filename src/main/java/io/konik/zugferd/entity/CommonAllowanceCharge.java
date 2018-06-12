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

import java.io.Serializable;
import java.math.BigDecimal;

import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Quantity;

/**
 *  
 * The common interface for the Allowance Charges.
 * 
 */
public interface CommonAllowanceCharge extends Serializable {

   /**
    * Checks if is a surcharge.
    *
    * @return true if charge
    */
   public abstract boolean isSurcharge();

   /**
    * Checks if is discount.
    *
    * @return true if is discount
    */
   public abstract boolean isDiscount();

   /**
    * Sets amount to be a surcharge.
    *
    * @return the allowance charge to be true
    */
   public abstract CommonAllowanceCharge setSurcharge();

   /**
    * Sets the amount to be a discount.
    *
    * @return the allowance discount to be true
    */
   public abstract CommonAllowanceCharge setDiscount();

   /**
    * Gets the sequence number of the allowance charge
    *
    * @return the sequence
    */
   public abstract BigDecimal getSequence();

   /**
    * Sets the sequence number of the allowance charge.
    *
    * @param sequence the new sequence
    * @return the allowance charge
    */
   public abstract CommonAllowanceCharge setSequence(BigDecimal sequence);

   /**
    * Gets the calculation percent of the allowance charge
    *
    * @return the calculation percent
    */
   public abstract BigDecimal getCalculationPercent();

   /**
    * Sets the calculation percent of the allowance charge.
    *
    * @param calculationPercent the new calculation percent
    * @return the allowance charge
    */
   public abstract CommonAllowanceCharge setCalculationPercent(BigDecimal calculationPercent);

   /**
    * Gets the basis amount of the allowance charge.
    * 
    * @return the basis amount
    */
   public abstract Amount getBasis();

   /**
    * Sets the basis amount of the allowance charge.
    *
    * @param basisAmount the new basis amount
    * @return the allowance charge
    */
   public abstract CommonAllowanceCharge setBasis(Amount basisAmount);

   /**
    * Gets the basis quantity.
    *
    * @return the basis quantity
    */
   public abstract Quantity getBasisQuantity();

   /**
    * Sets the basis quantity.
    *
    * @param basisQuantity the new basis quantity
    * @return the allowance charge
    */
   public abstract CommonAllowanceCharge setBasisQuantity(Quantity basisQuantity);

   /**
    * Gets the actual amount.
    * 
    * @return the actual amount
    */
   public abstract Amount getActual();

   /**
    * Sets the actual amount.
    *
    * @param actualAmount the new actual amount
    * @return the allowance charge
    */
   public abstract CommonAllowanceCharge setActual(Amount actualAmount);

   /**
    * Gets the reason code for the reason content.
    *
    * @return the reason code
    */
   public abstract String getReasonCode();

   /**
    * Sets the reason code for the reason content.
    *
    * @param reasonCode the new reason code
    * @return the allowance charge
    */
   public abstract CommonAllowanceCharge setReasonCode(String reasonCode);

   /**
    * Gets the reason free text
    * 
    * @return the reason
    */
   public abstract String getReason();

   /**
    * Sets the reason free text
    *
    * @param reason the new reason
    * @return the allowance charge
    */
   public abstract CommonAllowanceCharge setReason(String reason);

}
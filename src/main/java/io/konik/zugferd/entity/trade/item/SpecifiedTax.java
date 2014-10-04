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

import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.CommonTax;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unqualified.Amount;

import java.math.BigDecimal;

/**
 * = The trade tax on an item basis.
 */
public class SpecifiedTax extends CommonTax {

   @Comfort
   @Override
   public TaxCode getType() {
      return super.getType();
   }

   @Override
   public void setType(TaxCode taxTypeCode) {
      super.setType(taxTypeCode);
   }

   @Comfort
   @Override
   public TaxCategory getCategory() {
      return super.getCategory();
   }

   @Override
   public void setCategory(TaxCategory value) {
      super.setCategory(value);
   }

   /**
    * Gets the calculated amount.
    * 
    * @return the calculated amount
    */
   @Extended
   public Amount getCalculated() {
      return calculated;
   }

   /**
    * Sets the calculated amount.
    * 
    * @param calculatedAmount the new calculated amount
    */
   public void setCalculated(Amount calculatedAmount) {
      this.calculated = calculatedAmount;
      
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
    */
   public void setExemptionReason(String exemptionReason) {
      this.exemptionReason = exemptionReason;
      
   }

   @Override
   public void setPercentage(BigDecimal applicablePercentage) {
      super.setPercentage(applicablePercentage);
   }

}

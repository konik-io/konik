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
package io.konik.zugferd.entity.trade;

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.trade.item.SpecifiedTax;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unqualified.Amount;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * = The tax applied to a trade.
 */
public class TradeTax extends SpecifiedTax {

   @Basic
   @NotNull
   @Override
   public Amount getCalculated() {
      return super.getCalculated();
   }

   @Basic
   @Override
   public TradeTax setCalculated(Amount calculatedAmount) {
      return (TradeTax) super.setCalculated(calculatedAmount);
   }

   @Basic
   @NotNull
   @Override
   public TaxCode getType() {
      return super.getType();
   }

   @Basic
   @Override
   public TradeTax setType(TaxCode taxTypeCode) {
      return (TradeTax) super.setType(taxTypeCode);
   }

   /**
    * Gets the basis amount for tax calculation.
    * 
    * Profile:: BASIC
    * 
    * @return the basis amount
    */
   @Basic
   @Valid
   @NotNull
   public Amount getBasis() {
      return basis;
   }

   /**
    * Sets the basis amount for tax calculation.
    * 
    * Profile:: BASIC
    *
    * @param basisAmount the new basis amount
    * @return the tax
    */
   public TradeTax setBasis(Amount basisAmount) {
      this.basis = basisAmount;
      return this;
   }

   /**
    * Gets the line total.
    *
    * @return the line total
    */
   @Extended
   public Amount getLineTotal() {
      return lineTotal;
   }

   /**
    * Sets the line total.
    *
    * @param lineTotal the new line total
    */
   public void setLineTotal(Amount lineTotal) {
      this.lineTotal = lineTotal;
   }

   /**
    * Gets the allowance charge.
    *
    * @return the allowance charge
    */
   @Valid
   @Extended
   public Amount getAllowanceCharge() {
      return allowanceCharge;
   }

   /**
    * Sets the allowance charge.
    *
    * @param allowanceCharge the new allowance charge
    */
   public void setAllowanceCharge(Amount allowanceCharge) {
      this.allowanceCharge = allowanceCharge;
   }

   @Comfort
   @Override
   public TaxCategory getCategory() {
      return super.getCategory();
   }

   @Override
   public TradeTax setCategory(TaxCategory value) {
      return (TradeTax) super.setCategory(value);
   }

   @NotNull
   @Basic
   @Override
   public BigDecimal getPercentage() {
      return super.getPercentage();
   }

   @Basic
   @Override
   public TradeTax setPercentage(BigDecimal applicablePercentage) {
      return (TradeTax) super.setPercentage(applicablePercentage);
   }

   @Override
   public String getExemptionReason() {
      return super.getExemptionReason();
   }

   @Override
   public TradeTax setExemptionReason(String exemptionReason) {
      super.setExemptionReason(exemptionReason);
      return this;
   }

}

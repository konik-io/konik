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

import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * = The trade tax
 * 
 */
public class AppliedTax extends CommonTax {

   /**
    * Gets the UNCL 5153 tax type code.
    * 
    * Profile:: COMFORT
    * 
    * @return the type code
    */
   @Override
   @Comfort
   @NotNull(groups = Comfort.class)
   public TaxCode getType() {
      return type;
   }

   /**
    * Sets the UNCL 5153 tax type code.
    * 
    * Profile:: BASIC
    *
    * @param taxTypeCode the tax type code
    * @return the tax
    * @see <a href="http://www.unece.org/trade/untdid/d98b/uncl/uncl5153.htm">UNCL 5153</a>
    */
   @Override
   public AppliedTax setType(TaxCode taxTypeCode) {
      super.setType(taxTypeCode);
      return this;
   }

   /**
    * Gets the tax category.
    * 
    * Profile:: COMFORT
    * 
    * @return the category code
    */
   @Override
   @Comfort
   @NotNull(groups = Comfort.class)
   public TaxCategory getCategory() {
      return category;
   }

   /**
    * Sets the tax category.
    * 
    * Profile:: COMFORT
    *
    * @param value the new category code
    * @return the tax
    */
   @Override
   public AppliedTax setCategory(TaxCategory value) {
      return (AppliedTax) super.setCategory(value);
   }

   /**
    * Gets the applicable tax percentage.
    * 
    * Profile:: COMFORT
    * 
    * @return the applicable tax percentage
    */
   @Override
   @Comfort
   public BigDecimal getPercentage() {
      return percentage;
   }

   /**
    * Sets the applicable tax percentage.
    * 
    * Profile:: BASIC
    *
    * @param applicablePercentage the new applicable tax percentage
    * @return the tax
    */
   @Override
   public AppliedTax setPercentage(BigDecimal applicablePercentage) {
      return (AppliedTax) super.setPercentage(applicablePercentage);
   }
}

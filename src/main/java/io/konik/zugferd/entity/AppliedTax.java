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

import io.konik.jaxb.bindable.unqualified.PercentRoundingAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The trade tax
 * 
 */
@Comfort
public class AppliedTax implements Tax {
   
   @XmlElement(name = "TypeCode")
   private TaxCode type;

   @XmlElement(name = "CategoryCode")
   private TaxCategory category;

   @XmlElement(name = "ApplicablePercent")
   @XmlJavaTypeAdapter(PercentRoundingAdapter.class)
   private BigDecimal percentage;   

   /**
    * Gets the UNCL 5153 tax type code.
    * 
    * @return the type code
    */
   @Override
   @NotNull(groups = Comfort.class)
   public TaxCode getType() {
      return type;
   }

   /**
    * Sets the UNCL 5153 tax type code.
    * 
    * @param taxTypeCode the tax type code
    * @return the tax
    * @see <a href="http://www.unece.org/trade/untdid/d98b/uncl/uncl5153.htm">UNCL 5153</a>
    */
   @Override
   public AppliedTax setType(TaxCode taxTypeCode) {
      this.type = taxTypeCode;
      return this;
   }

   /**
    * Gets the tax category.
    * 
    * @return the category code
    */
   @Override
   @NotNull(groups = Comfort.class)
   public TaxCategory getCategory() {
      return category;
   }

   /**
    * Sets the tax category.
    * 
    * @param taxCategory the new category code
    * @return the tax
    */
   @Override
   public AppliedTax setCategory(TaxCategory taxCategory) {
      this.category = taxCategory;
      return this; 
   }

   /**
    * Gets the applicable tax percentage.
    * 
    * @return the applicable tax percentage
    */
   @Override
   @NotNull(groups = Comfort.class)
   public BigDecimal getPercentage() {
      return percentage;
   }

   /**
    * Sets the applicable tax percentage.
    * 
    * @param applicablePercentage the new applicable tax percentage
    * @return the tax
    */
   @Override
   public AppliedTax setPercentage(BigDecimal applicablePercentage) {
      this.percentage = applicablePercentage;
      return this;
   }
}

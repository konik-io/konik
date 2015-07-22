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

import io.konik.jaxb.bindable.unqualified.PercentRoundingAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unqualified.Amount;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The trade tax on an item basis.
 */
public class ItemTax implements SpecifiedTax {

   @XmlElement(name = "CalculatedAmount")
   private Amount calculated;

   @XmlElement(name = "TypeCode")
   private TaxCode type;

   @XmlElement(name = "ExemptionReason")
   private String exemptionReason;

   @XmlElement(name = "CategoryCode")
   private TaxCategory category;

   @XmlElement(name = "ApplicablePercent")
   @XmlJavaTypeAdapter(PercentRoundingAdapter.class)
   private BigDecimal percentage;   

   
   @Override
   @Valid
   @Extended
   public Amount getCalculated() {
      return calculated;
   }

   @Override
   public SpecifiedTax setCalculated(Amount calculatedAmount) {
      this.calculated = calculatedAmount;
      return this;
   }
   
   @Comfort
   @Override
   public TaxCode getType() {
      return this.type;
   }

   @Override
   public ItemTax setType(TaxCode taxTypeCode) {
      this.type = taxTypeCode;
      return this;
   }

   @Override
   @Comfort
   public String getExemptionReason() {
      return exemptionReason;
   }

   @Override
   public SpecifiedTax setExemptionReason(String exemptionReason) {
      this.exemptionReason = exemptionReason;
      return this;
   }

   @Comfort
   @Override
   public TaxCategory getCategory() {
      return this.category;
   }

   @Override
   public SpecifiedTax setCategory(TaxCategory value) {
      this.category = value;
      return this;
   }

   @Override
   public BigDecimal getPercentage() {
      return this.percentage;
   }
   
   @Override
   public SpecifiedTax setPercentage(BigDecimal applicablePercentage) {
      this.percentage = applicablePercentage;
       return this;
   }
}

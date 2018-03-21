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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;

/**
 * = The trade tax
 * 
 * 
 * image::http://yuml.me/0d095a59[Tax Class diagram,link="http://yuml.me/edit/0d095a59"]
 * 
 * The complexity of this hierarchy is also result of the validation path, as we can not override constraints.
 */
@XmlTransient
@XmlType(name = "TradeTaxType", propOrder = { "calculated", "type", "exemptionReason", "basis", "lineTotal","allowanceCharge", "category", "percentage" })
/* 
HIRACHY TOP DOWN
as AppliedTradeTax|CategoryTradeTax       TypeCode, CategoryCode, ApplicablePercent
   as ApplicableTradeTax in ITEM             +CalculatedAmount, +ExemptionReason
      as ApplicableTradeTax in TRADE            +BasisAmount, +LineTotalBasisAmount, +AllowanceChargeBasisAmount
 */
public interface Tax extends Serializable {
   /**
    * Gets the UNCL 5153 tax type code.
    * 
    * @return the type code
    */
   TaxCode getType();

   /**
    * Sets the UNCL 5153 tax type code.
    * 
    * @param taxTypeCode the tax type code
    * @return the tax
    * @see <a href="http://www.unece.org/trade/untdid/d98b/uncl/uncl5153.htm">UNCL 5153</a>
    */
   Tax setType(TaxCode taxTypeCode);

   /**
    * Gets the tax category.
    * 
    * @return the category code
    */
   TaxCategory getCategory();

   /**
    * Sets the tax category.
    * 
    * @param taxCategory the new tax category code
    * @return the tax
    */
   Tax setCategory(TaxCategory taxCategory);

   /**
    * Gets the applicable tax percentage.
    * 
    * @return the applicable tax percentage
    */
   @NotNull(groups = Comfort.class)
   BigDecimal getPercentage();

   /**
    * Sets the applicable tax percentage.
    * 
    * @param taxPercentage the new applicable tax percentage
    * @return the tax
    */
   Tax setPercentage(BigDecimal taxPercentage);
}

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
import io.konik.zugferd.unqualified.Amount;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * = The common trade tax
 * 
 * 
 * image::http://yuml.me/0d095a59[Tax Class diagram,link="http://yuml.me/edit/0d095a59"]
 * 
 * The complexity of this hierarchy is also result of the validation path, we can not override constraints.
 */
@XmlTransient
@XmlType(name = "TradeTaxType", propOrder = { "calculated", "type", "exemptionReason","basis", "lineTotal", "allowanceCharge", "category", "percentage" })
/* 
HIRACHY TOP DOWN
as AppliedTradeTax|CategoryTradeTax only   TypeCode, CategoryCode, ApplicablePercent
   as ApplicableTradeTax in ITEM             +CalculatedAmount, +ExemptionReason
      as ApplicableTradeTax in TRADE            +BasisAmount, +LineTotalBasisAmount, +AllowanceChargeBasisAmount
 */
public abstract class CommonTax {

   @Valid
	@XmlElement(name = "CalculatedAmount")
	protected Amount calculated;

	@XmlElement(name = "TypeCode")
	protected TaxCode type;

	@XmlElement(name = "ExemptionReason")
	protected String exemptionReason;
	
	@Valid
	@XmlElement(name = "BasisAmount")
	protected Amount basis;
	
	@Valid
	@XmlElement(name = "LineTotalBasisAmount")
	protected Amount lineTotal;
	
	@Valid
	@XmlElement(name = "AllowanceChargeBasisAmount")
	protected Amount allowanceCharge;

	@XmlElement(name = "CategoryCode")
	protected TaxCategory category;

	@XmlElement(name = "ApplicablePercent")
	@XmlJavaTypeAdapter(PercentRoundingAdapter.class)
	protected BigDecimal percentage;


	/**
	 * Gets the UNCL 5153 tax type code.
	 * 
	 * @return the type code
	 */
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
	public CommonTax setType(TaxCode taxTypeCode) {
		this.type = taxTypeCode;
		return  this;
	}

	/**
	 * Gets the tax category.
	 * 
	 * @return the category code
	 */
	public TaxCategory getCategory() {
		return category;
	}

	/**
    * Sets the tax category.
    * 
    * @param value the new category code
    * @return the tax
    */
	public CommonTax setCategory(TaxCategory value) {
		this.category = value;
		return this;
	}

	/**
	 * Gets the applicable tax percentage.
	 * 
	 * @return the applicable tax percentage
	 */
	@NotNull(groups=Comfort.class)
	public BigDecimal getPercentage() {
		return percentage;
	}

	/**
    * Sets the applicable tax percentage.
    * 
    * @param applicablePercentage the new applicable tax percentage
    * @return the tax
    */
   public CommonTax setPercentage(BigDecimal applicablePercentage) {
		this.percentage = applicablePercentage;
		return this;
	}
}

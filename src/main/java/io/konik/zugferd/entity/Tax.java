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

import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unqualified.Amount;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The common trade tax
 * 
 * image::http://yuml.me/d4c0330a[Tax Class diagram,link="http://yuml.me/edit/d4c0330a"]
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeTaxType", propOrder = { "calculated", "type", "exemptionReason","basis", "lineTotal", "allowanceCharge", "category", "percentage" })
//TODO: Comment
/* 
HIRACHY TOP DOWN
as AppliedTradeTax|CategoryTradeTax only   TypeCode, CategoryCode, ApplicablePercent
   as ApplicableTradeTax in ITEM             +CalculatedAmount, +ExemptionReason
      as ApplicableTradeTax in TRADE            +BasisAmount, +LineTotalBasisAmount, +AllowanceChargeBasisAmount
 */
public class Tax {

	@XmlElement(name = "CalculatedAmount")
	protected Amount calculated;

   @Valid
	@XmlElement(name = "TypeCode")
	private TaxCode type;

	@XmlElement(name = "ExemptionReason")
	protected String exemptionReason;

	@XmlElement(name = "BasisAmount")
	protected Amount basis;
	
	@XmlElement(name = "LineTotalBasisAmount")
	protected Amount lineTotal;
	
	@XmlElement(name = "AllowanceChargeBasisAmount")
	protected Amount allowanceCharge;

	@XmlElement(name = "CategoryCode")
	private TaxCategory category;

	@NotNull
	@XmlElement(name = "ApplicablePercent")
	private BigDecimal percentage;


	/**
	 * Gets the UNCL 5153 tax type code.
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the type code
	 */
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
	public Tax setType(TaxCode taxTypeCode) {
		this.type = taxTypeCode;
		return this;
	}

	/**
	 * Gets the tax category.
	 * 
	 * Profile:: COMFORT
	 * 
	 * @return the category code
	 */
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
	public Tax setCategory(TaxCategory value) {
		this.category = value;
		return this;
	}

	/**
	 * Gets the applicable tax percentage.
	 * 
	 * Profile:: BASIC
	 * 
	 * 
	 * @return the applicable tax percentage
	 */
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
	public Tax setPercentage(BigDecimal applicablePercentage) {
		this.percentage = applicablePercentage;
		return this;
	}
}

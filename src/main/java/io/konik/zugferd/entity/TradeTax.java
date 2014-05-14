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

import io.konik.unece.codes.TaxType;
import io.konik.zugferd.qualified.TaxCategoryCode;
import io.konik.zugferd.unqualified.Amount;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Trade Tax.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeTaxType", propOrder = { "calculatedAmount", "typeCode", "exemptionReason","basisAmount", "categoryCode", "applicablePercentage" })
public class TradeTax {

   @Valid
	@XmlElement(name = "CalculatedAmount")
	private Amount calculatedAmount;

   @Valid
	@XmlElement(name = "TypeCode")
	private TaxType typeCode;

	@XmlElement(name = "ExemptionReason")
	private String exemptionReason;

	@Valid
	@XmlElement(name = "BasisAmount")
	private Amount basisAmount;

	@XmlElement(name = "CategoryCode")
	private TaxCategoryCode categoryCode;

	@XmlElement(name = "ApplicablePercent")
	private BigDecimal applicablePercentage;

	/**
	 * Gets the calculated amount.

	 * Profile: BASIC

	 * 
	 * @return the calculated amount
	 */
	public Amount getCalculatedAmount() {
		return calculatedAmount;
	}

	/**
	 * Sets the calculated amount.

	 * Profile: BASIC

	 * 
	 * @param calculatedAmount the new calculated amount
	 */
	public void setCalculatedAmount(Amount calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	/**
	 * Gets the UNCL 5153 tax type code.
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the type code
	 */
	public TaxType getTypeCode() {
		return typeCode;
	}

	/**
	 * Sets the UNCL 5153 tax type code.
	 * 
	 * Profile:: BASIC
	 * 
	 * @param typeCode the new type code
	 * @see <a href="http://www.unece.org/trade/untdid/d98b/uncl/uncl5153.htm">UNCL 5153</a>
	 */
	public void setTypeCode(TaxType typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * Gets the tax exemption reason.

	 * Profile: COMFORT

	 * 
	 * @return the exemption reason
	 */
	public String getExemptionReason() {
		return exemptionReason;
	}

	/**
	 * Sets the tax exemption reason.

	 * Profile: COMFORT

	 * 
	 * @param exemptionReason the new exemption reason
	 */
	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	/**
	 * Gets the basis amount for tax calculation.

	 * Profile: BASIC

	 * 
	 * @return the basis amount
	 */
	public Amount getBasisAmount() {
		return basisAmount;
	}

	/**
	 * Sets the basis amount for tax calculation.

	 * Profile: BASIC

	 * 
	 * @param basisAmount the new basis amount
	 */
	public void setBasisAmount(Amount basisAmount) {
		this.basisAmount = basisAmount;
	}

	/**
	 * Gets the tax category code.

	 * Profile: COMFORT

	 * 
	 * @return the category code
	 */
	public TaxCategoryCode getCategoryCode() {
		return categoryCode;
	}

	/**
	 * Sets the tax category code.

	 * Profile: COMFORT

	 * 
	 * @param value the new category code
	 */
	public void setCategoryCode(TaxCategoryCode value) {
		this.categoryCode = value;
	}

	/**
	 * Gets the applicable tax percentage.

	 * Profile: BASIC

	 * 
	 * @return the applicable tax percentage
	 */
	public BigDecimal getApplicablePercentage() {
		return applicablePercentage;
	}

	/**
	 * Sets the applicable tax percentage.

	 * Profile: BASIC

	 * 
	 * @param applicablePercentage the new applicable tax percentage
	 */
	public void setApplicablePercentage(BigDecimal applicablePercentage) {
		this.applicablePercentage = applicablePercentage;
	}

}

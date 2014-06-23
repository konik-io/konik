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
package io.konik.zugferd.entity;

import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
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
@XmlType(name = "TradeTaxType", propOrder = { "calculatedAmount", "code", "exemptionReason","basisAmount", "category", "applicablePercentage" })
public class Tax {

   @Valid
	@XmlElement(name = "CalculatedAmount")
	private Amount calculatedAmount;

   @Valid
	@XmlElement(name = "TypeCode")
	private TaxCode code;

	@XmlElement(name = "ExemptionReason")
	private String exemptionReason;

	@Valid
	@XmlElement(name = "BasisAmount")
	private Amount basisAmount;

	@XmlElement(name = "CategoryCode")
	private TaxCategory category;

	@XmlElement(name = "ApplicablePercent")
	private BigDecimal applicablePercentage;

	/**
	 * Gets the calculated amount.
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the calculated amount
	 */
	public Amount getCalculatedAmount() {
		return calculatedAmount;
	}

	/**
    * Sets the calculated amount.
    * 
    * Profile:: BASIC
    *
    * @param calculatedAmount the new calculated amount
    * @return the tax
    */
	public Tax setCalculatedAmount(Amount calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
		return this;
	}

	/**
	 * Gets the UNCL 5153 tax type code.
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the type code
	 */
	public TaxCode getCode() {
		return code;
	}

	/**
    * Sets the UNCL 5153 tax type code.
    * 
    * Profile:: BASIC
    *
    * @param taxCode the new type code
    * @return the tax
    * @see <a href="http://www.unece.org/trade/untdid/d98b/uncl/uncl5153.htm">UNCL 5153</a>
    */
	public Tax setCode(TaxCode taxCode) {
		this.code = taxCode;
		return this;
	}

	/**
	 * Gets the tax exemption reason.
	 * 
	 * Profile:: COMFORT
	 * 
	 * @return the exemption reason
	 */
	public String getExemptionReason() {
		return exemptionReason;
	}

	/**
    * Sets the tax exemption reason.
    * 
    * Profile:: COMFORT
    *
    * @param exemptionReason the new exemption reason
    * @return the tax
    */
	public Tax setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
		return this;
	}

	/**
	 * Gets the basis amount for tax calculation.
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the basis amount
	 */
	public Amount getBasisAmount() {
		return basisAmount;
	}

	/**
    * Sets the basis amount for tax calculation.
    * 
    * Profile:: BASIC
    *
    * @param basisAmount the new basis amount
    * @return the tax
    */
	public Tax setBasisAmount(Amount basisAmount) {
		this.basisAmount = basisAmount;
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
	public BigDecimal getApplicablePercentage() {
		return applicablePercentage;
	}

	/**
    * Sets the applicable tax percentage.
    * 
    * Profile:: BASIC
    *
    * @param applicablePercentage the new applicable tax percentage
    * @return the tax
    */
	public Tax setApplicablePercentage(BigDecimal applicablePercentage) {
		this.applicablePercentage = applicablePercentage;
		return this;
	}

}

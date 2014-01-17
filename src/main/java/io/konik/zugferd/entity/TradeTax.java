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

import io.konik.zugferd.datatype.qualified.TaxCategoryCode;
import io.konik.zugferd.datatype.qualified.TaxTypeCode;
import io.konik.zugferd.datatype.unqualified.Amount;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class TradeTax.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeTaxType", propOrder = { "calculatedAmount", "typeCode", "exemptionReason",
		"basisAmount", "categoryCode", "applicablePercentage" })
public class TradeTax {

	/** The calculated amount. */
   @Valid
	@XmlElement(name = "CalculatedAmount")
	private Amount calculatedAmount;

	/** The type code. */
   @Valid
	@XmlElement(name = "TypeCode")
	private TaxTypeCode typeCode;

	/** The exemption reason. */
	@XmlElement(name = "ExemptionReason")
	private String exemptionReason;

	/** The basis amount. */
	@Valid
	@XmlElement(name = "BasisAmount")
	private Amount basisAmount;

	/** The category code. */
	@XmlElement(name = "CategoryCode")
	private TaxCategoryCode categoryCode;

	/** The applicable percent. */
	@XmlElement(name = "ApplicablePercent")
	private BigDecimal applicablePercentage;

	/**
	 * Gets the calculated amount.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @return the calculated amount
	 */
	public Amount getCalculatedAmount() {
		return calculatedAmount;
	}

	/**
	 * Sets the calculated amount.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @param calculatedAmount the new calculated amount
	 */
	public void setCalculatedAmount(Amount calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	/**
	 * Gets the UNCL 5153 tax type code.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @return the type code
	 * @see <a href="http://www.unece.org/trade/untdid/d98b/uncl/uncl5153.htm">UNCL 5153</a>
	 */
	public TaxTypeCode getTypeCode() {
		return typeCode;
	}

	/**
	 * Sets tthe UNCL 5153 tax type code.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @param typeCode the new type code
	 * @see <a href="http://www.unece.org/trade/untdid/d98b/uncl/uncl5153.htm">UNCL 5153</a>
	 */
	public void setTypeCode(TaxTypeCode typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * Gets the tax exemption reason.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @return the exemption reason
	 */
	public String getExemptionReason() {
		return exemptionReason;
	}

	/**
	 * Sets the tax exemption reason.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @param exemptionReason the new exemption reason
	 */
	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	/**
	 * Gets the basis amount for tax calculation.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @return the basis amount
	 */
	public Amount getBasisAmount() {
		return basisAmount;
	}

	/**
	 * Sets the basis amount for tax calculation.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @param basisAmount the new basis amount
	 */
	public void setBasisAmount(Amount basisAmount) {
		this.basisAmount = basisAmount;
	}

	/**
	 * Gets the tax category code.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @return the category code
	 */
	public TaxCategoryCode getCategoryCode() {
		return categoryCode;
	}

	/**
	 * Sets the tax category code.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @param value the new category code
	 */
	public void setCategoryCode(TaxCategoryCode value) {
		this.categoryCode = value;
	}

	/**
	 * Gets the applicable tax percentage.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @return the applicable tax percentage
	 */
	public BigDecimal getApplicablePercentage() {
		return applicablePercentage;
	}

	/**
	 * Sets the applicable tax percentage.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @param applicablePercentage the new applicable tax percentage
	 */
	public void setApplicablePercentage(BigDecimal applicablePercentage) {
		this.applicablePercentage = applicablePercentage;
	}

}

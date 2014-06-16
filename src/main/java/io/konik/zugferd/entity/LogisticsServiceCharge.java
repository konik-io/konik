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

import io.konik.zugferd.unqualified.Amount;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Logistics Service Charge
 * 
 * Represents the transport and packaging costs.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogisticsServiceChargeType", propOrder = { "description", "amount", "tradeTax" })
public class LogisticsServiceCharge {

	@XmlElement(name = "Description")
	private String description;
	
	@Valid
	@XmlElement(name = "AppliedAmount")
	private Amount amount;

	@Valid
	@XmlElement(name = "AppliedTradeTax")
	private List<Tax> tradeTax;

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description the new description
	 * @return the logistics service charge
	 */
	public LogisticsServiceCharge setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Gets the applied amount.
	 * 
	 * @return the applied amount
	 */
	public Amount getAmount() {
		return amount;
	}

	/**
    * Sets the applied amount.
    *
    * @param amount the new applied amount
    * @return the logistics service charge
    */
	public LogisticsServiceCharge setAmount(Amount amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * Gets the applied trade tax.
	 * 
	 * @return the applied trade tax
	 */
	public List<Tax> getTradeTax() {
		if (tradeTax == null) {
			tradeTax = new ArrayList<Tax>();
		}
		return this.tradeTax;
	}


	/**
    * Adds a trade tax.
    *
    * @param additionalTradeTax the additional trade tax
    * @return the logistics service charge
    */
	public LogisticsServiceCharge addTradeTax(Tax additionalTradeTax) {
		getTradeTax().add(additionalTradeTax);
		return this;
	}

}

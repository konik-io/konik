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

import io.konik.zugferd.qualified.DateTime;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Payment Term
 * Payment Term for the trade.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePaymentTermsType", propOrder = { "description", "due" })
public class PaymentTerm {

	@XmlElement(name = "Description")
	private String description;

	@Valid
	@XmlElement(name = "DueDateDateTime")
	private DateTime due;

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
    * @return the payment term
    */
	public PaymentTerm setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Gets the due date time.
	 * 
	 * @return the due date time
	 */
	public DateTime getDue() {
		return due;
	}

	/**
    * Sets the due date time.
    *
    * @param due the new due date time
    * @return the payment term
    */
	public PaymentTerm setDue(DateTime due) {
		this.due = due;
		return this;
	}

}

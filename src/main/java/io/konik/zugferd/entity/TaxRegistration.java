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

import io.konik.zugferd.unece.codes.Reference;
import io.konik.zugferd.unqualified.ID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Tax Registration
 * 
 * Represents the tax number and its type. 
 * The {@link ID#getValue()} is value added tax identification number
 * The {@link ID#getSchemeId()} is the Tax payer's number or VAT number according to (UNCL 1153) eg. FC or VA
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxRegistrationType", propOrder = { "id" })
public class TaxRegistration {

	/** The id. */
	@XmlElement(name = "ID")
	private final ID id;

	/** Instantiates a new tax registration. */
	public TaxRegistration() {
	   this.id = new ID();
	}

	/**
	 * Instantiates a new tax registration without a type.
	 * 
	 * @param taxNumber the id
	 */
	public TaxRegistration(String taxNumber) {
		this.id = new ID(taxNumber);
	}

	/**
	 * Instantiates a new tax registration.
	 * 
	 * @param taxNumber the tax id
	 * @param typeOfTax the scheme id
	 */
	public TaxRegistration(String taxNumber, Reference typeOfTax) {
		this.id = new ID(taxNumber, typeOfTax.code);
	}

	/**
	 * Gets the tax number.
	 * 
	 * Profile: BASIC
	 * Example: {@code DE234567891}
	 * 
	 * @return the number
	 */
	public String getNumber() {
		return id.getValue();
	}

	/**
    * Sets the tax number.
    * 
    * Profile: BASIC
    * Example: {@code DE234567891}
    *
    * @param taxNumber the new value
    * @return the tax registration
    */
	public TaxRegistration setNumber(String taxNumber) {
		this.id.setValue(taxNumber);
		return this;
	}

	/**
    * Gets the tax type. The UNCL 1153 tax type.
    * 
    * Profile: BASIC
    * Example: {@code VA}
    *
    * @return the type
    */
	public Reference getType() {
		return Reference.getByCode(id.getSchemeId());
	}

	/**
    * Sets the UNCL 1153 tax type.
    * 
    * Profile: BASIC
    * Example: {@code VA}
    *
    * @param taxType the new type
    * @return the tax registration
    */
	public TaxRegistration setType(Reference taxType) {
		this.id.setValue(taxType.code);
		return this;
	}

}

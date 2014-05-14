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

import io.konik.zugferd.unqualified.ID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class CreditorFinancialInstitution.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorFinancialInstitutionType", propOrder = { "bic", "germanBankleitzahl", "name" })
public class CreditorFinancialInstitution {

	/** The bicid. */
	@XmlElement(name = "BICID")
	private ID bic;

	/** The german bankleitzahl id. */
	@XmlElement(name = "GermanBankleitzahlID")
	private ID germanBankleitzahl;

	/** The name. */
	@XmlElement(name = "Name")
	private String name;

	/**
	 * Gets the bicid.
	 * 
	 * @return the bicid
	 */
	public ID getBic() {
		return bic;
	}

	/**
	 * Sets the bicid.
	 * 
	 * @param bic the new bicid
	 */
	public void setBic(ID bic) {
		this.bic = bic;
	}

	/**
	 * Gets the german bankleitzahl id.
	 * 
	 * @return the german bankleitzahl id
	 */
	public ID getGermanBankleitzahl() {
		return germanBankleitzahl;
	}

	/**
	 * Sets the german bankleitzahl id.
	 * 
	 * @param germanBankleitzahl the new german bankleitzahl id
	 */
	public void setGermanBankleitzahl(ID germanBankleitzahl) {
		this.germanBankleitzahl = germanBankleitzahl;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}

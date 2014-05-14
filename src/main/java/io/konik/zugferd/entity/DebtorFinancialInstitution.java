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
 * The Class DebtorFinancialInstitution.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebtorFinancialInstitutionType", propOrder = { "bic", "germanBankleitzahl", "name" })
public class DebtorFinancialInstitution {

	/** The bicid. */
	@XmlElement(name = "BICID")
	private ID bic;

	/** The german bankleitzahl id. */
	@XmlElement(name = "GermanBankleitzahlID")
	private ID germanBankleitzahl;

	/** The name. */
	@XmlElement(name = "Name")
	private String name;

	/** Instantiates a new debtor financial institution. */
	public DebtorFinancialInstitution() {
	}

	/**
	 * Instantiates a new debtor financial institution.
	 * 
	 * @param bic the bic
	 */
	public DebtorFinancialInstitution(String bic) {
		this.bic = new ID(bic);
	}

	/**
	 * Gets the bic
	 * 
	 * @return the bic
	 */
	public String getBic() {
		return bic.getValue();
	}

	/**
	 * Sets the bicid.
	 * 
	 * @param bic the bic
	 * @return the debtor financial institution
	 */
	public DebtorFinancialInstitution setBic(String bic) {
		this.bic = new ID(bic);
		return this;
	}

	/**
	 * Gets the german bankleitzahl.
	 * 
	 * @return the german bankleitzahl id
	 */
	public String getGermanBankleitzahl() {
		return germanBankleitzahl.getValue();
	}

	/**
	 * Sets the german bankleitzahl id.
	 * 
	 * @param blz the blz
	 * @return the debtor financial institution
	 */
	public DebtorFinancialInstitution setGermanBankleitzahl(String blz) {
		this.germanBankleitzahl = new ID(blz);
		return this;
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
	 * @param institutionName the new name
	 */
	public void setName(String institutionName) {
		this.name = institutionName;
	}

}

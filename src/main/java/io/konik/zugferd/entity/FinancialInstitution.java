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

import io.konik.zugferd.unqualified.ID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Creditor Financial Institution.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "bic", "germanBankleitzahl", "name" })
public class FinancialInstitution {

	@XmlElement(name = "BICID")
	private ID bic;

	@XmlElement(name = "GermanBankleitzahlID")
	private ID germanBankleitzahl;

	@XmlElement(name = "Name")
	private String name;

	FinancialInstitution() {
      super();
   }

   /**
    * Instantiates a new financial institution.
    *
    * @param bic the bic
    */
	public FinancialInstitution(String bic) {
      super();
      setBic(bic);
   }

   /**
	 * Gets the BIC.
	 * 
	 * @return the bic
	 */
	public String getBic() {
		return bic.getValue();
	}

	/**
    * Sets the BIC.
    *
    * @param bic the new bic
    * @return the financial institution
    */
	public FinancialInstitution setBic(String bic) {
		this.bic = new ID(bic);
		return this;
	}

	/**
	 * Gets the german bankleitzahl.
	 * 
	 * @return the german bankleitzahl
	 */
	public String getGermanBankleitzahl() {
		return germanBankleitzahl.getValue();
	}

	/**
    * Sets the german bankleitzahl.
    *
    * @param germanBankleitzahl the new german bankleitzahl
    * @return the financial institution
    */
	public FinancialInstitution setGermanBankleitzahl(String germanBankleitzahl) {
		this.germanBankleitzahl = new ID(germanBankleitzahl);
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
    * @param name the new name
    * @return the financial institution
    */
	public FinancialInstitution setName(String name) {
		this.name = name;
		return this;
	}

}

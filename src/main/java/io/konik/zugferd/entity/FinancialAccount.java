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
 * = The Creditor Financial Account.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "iban", "proprietaryId" })
public class FinancialAccount {

	@XmlElement(name = "IBANID")
	private ID iban;

	@XmlElement(name = "ProprietaryID")
	private ID proprietaryId;

	/**
    * Instantiates a new financial account.
    */
	FinancialAccount() {
      super();
   }
	
	/**
    * Instantiates a new financial account.
    *
    * @param iban the iban
    */
	public FinancialAccount(String iban) {
      super();
      setIban(iban);
   }

   /**
	 * Gets the iban.
	 * 
	 * @return the iban
	 */
	public String getIban() {
		return iban.getValue();
	}

	/**
    * Sets the iban.
    *
    * @param iban the new iban
    * @return the financial account
    */
	public FinancialAccount setIban(String iban) {
		this.iban = new ID(iban);
		return this;
	}

	/**
	 * Gets the proprietary id.
	 * 
	 * @return the proprietary id
	 */
	public String getProprietaryID() {
		return proprietaryId.getValue();
	}

	/**
    * Sets the proprietary id.
    *
    * @param proprietaryId the new proprietary id
    * @return the financial account
    */
	public FinancialAccount setProprietaryID(String proprietaryId) {
		this.proprietaryId = new ID(proprietaryId);
		return this;
	}

}

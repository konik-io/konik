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
 * The Class CreditorFinancialAccount.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorFinancialAccountType", propOrder = { "iban", "proprietaryId" })
public class CreditorFinancialAccount {

	/** The ibanid. */
	@XmlElement(name = "IBANID")
	private ID iban;

	/** The proprietary id. */
	@XmlElement(name = "ProprietaryID")
	private ID proprietaryId;

	/**
	 * Gets the iban.
	 * 
	 * @return the iban
	 */
	public ID getIban() {
		return iban;
	}

	/**
	 * // * Sets the iban.
	 * 
	 * @param iban the new iban
	 */
	public void setIban(ID iban) {
		this.iban = iban;
	}

	/**
	 * Gets the proprietary id.
	 * 
	 * @return the proprietary id
	 */
	public ID getProprietaryID() {
		return proprietaryId;
	}

	/**
	 * Sets the proprietary id.
	 * 
	 * @param proprietaryId the new proprietary id
	 */
	public void setProprietaryID(ID proprietaryId) {
		this.proprietaryId = proprietaryId;
	}

}

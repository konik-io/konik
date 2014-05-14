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
 * The Class DebtorFinancialAccount.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebtorFinancialAccountType", propOrder = { "iban", "proprietaryId" })
public class DebtorFinancialAccount {

	/** The ibanid. */
	@XmlElement(name = "IBANID")
	private ID iban;

	/** The proprietary id. */
	@XmlElement(name = "ProprietaryID")
	private ID proprietaryId;

	/** Instantiates a new debtor financial account. */
	public DebtorFinancialAccount() {
	}

	/**
	 * Instantiates a new debtor financial account.
	 * 
	 * @param iban the iban
	 */
	public DebtorFinancialAccount(String iban) {
		this.iban = new ID(iban);
	}

	/**
	 * Gets the ibanid.
	 * 
	 * @return the ibanid
	 */
	public String getIban() {
		return iban.getValue();
	}

	/**
	 * Sets the ibanid.
	 * 
	 * @param iban the new iban
	 * @return the debtor financial account
	 */
	public DebtorFinancialAccount setIban(String iban) {
		this.iban = new ID(iban);
		return this;
	}

	/**
	 * Gets the proprietary id.
	 * 
	 * @return the proprietary id
	 */
	public ID getProprietaryId() {
		return proprietaryId;
	}

	/**
	 * Sets the proprietary id.
	 * 
	 * @param proprietaryId the new proprietary id
	 * @return the debtor financial account
	 */
	public DebtorFinancialAccount setProprietaryId(ID proprietaryId) {
		this.proprietaryId = proprietaryId;
		return this;
	}

}

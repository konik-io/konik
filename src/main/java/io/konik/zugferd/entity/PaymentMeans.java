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

import io.konik.zugferd.datatype.qualified.PaymentMeansCode;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class TradeSettlementPaymentMeans.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeSettlementPaymentMeansType", propOrder = { "code", "information", "payerAccount",
		"payeeAccount", "payerInstitution", "payeeInstitution" })
public class PaymentMeans {

	/** The UNCL 4461 type code. */
   @Valid
	@XmlElement(name = "TypeCode")
	private PaymentMeansCode code;

	/** The information. */
	@XmlElement(name = "Information")
	private List<String> information;

	/** The payer/buyer party debtor financial account. */
	@Valid
	@XmlElement(name = "PayerPartyDebtorFinancialAccount")
	private DebtorFinancialAccount payerAccount;

	/** The payee/seller party creditor financial account. */
	@Valid
	@XmlElement(name = "PayeePartyCreditorFinancialAccount")
	private CreditorFinancialAccount payeeAccount;

	/** The payer specified debtor financial institution. */
	@Valid
	@XmlElement(name = "PayerSpecifiedDebtorFinancialInstitution")
	private DebtorFinancialInstitution payerInstitution;

	/** The payee specified creditor financial institution. */
	@Valid
	@XmlElement(name = "PayeeSpecifiedCreditorFinancialInstitution")
	private CreditorFinancialInstitution payeeInstitution;

	/**
	 * Gets the UNCL 4461 type code.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @return the UNCL 4461 type code
	 * @see <a href="http://www.unece.org/trade/untdid/i98a/uncl/uncl4461.htm">UNCL 4461</a>
	 */
	public String getTypeCode() {
		return code.getValue();
	}

	/**
	 * Sets the UNCL 4461 type code.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @param paymentCode the new UNCL 4461 payment code
	 * @return the trade settlement payment means
	 * @see <a href="http://www.unece.org/trade/untdid/i98a/uncl/uncl4461.htm">UNCL 4461</a>
	 */
	public PaymentMeans setTypeCode(String paymentCode) {
		this.code = new PaymentMeansCode(paymentCode);
		return this;
	}

	/**
	 * Gets the free text payment method information.<br/>
	 * Profile: COMFORT<br/>
	 * Example: <code>Cash, Credit Card</code>
	 * 
	 * @return the information
	 */
	public List<String> getInformation() {
		if (information == null) {
			information = new ArrayList<String>();
		}
		return this.information;
	}

	/**
	 * Adds the free text payment method information.<br/>
	 * Profile: COMFORT<br/>
	 * Example: <code>Cash, Credit Card</code>
	 * 
	 * @param information the information
	 * @return the trade settlement payment means
	 */
	public PaymentMeans addInformation(String information) {
		getInformation().add(information);
		return this;
	}

	/**
	 * Gets the payer/buyer debtor financial account.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @return the payer party debtor financial account
	 */
	public DebtorFinancialAccount getPayerAccount() {
		return payerAccount;
	}

	/**
	 * Sets the payer/buyer party debtor financial account.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @param payerAccount the payer account
	 * @return the trade settlement payment means
	 */
	public PaymentMeans setPayerAccount(DebtorFinancialAccount payerAccount) {
		this.payerAccount = payerAccount;
		return this;
	}

	/**
	 * Gets the payee/seller party creditor financial account.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @return the payee party creditor financial account
	 */
	public CreditorFinancialAccount getPayeeAccount() {
		return payeeAccount;
	}

	/**
	 * Sets the payee/seller party creditor financial account.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @param payeeAccount the payee account
	 * @return the trade settlement payment means
	 */
	public PaymentMeans setPayeeAccount(CreditorFinancialAccount payeeAccount) {
		this.payeeAccount = payeeAccount;
		return this;
	}

	/**
	 * Gets the payer/buyer specified debtor financial institution.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @return the payer specified debtor financial institution
	 */
	public DebtorFinancialInstitution getPayerInstitution() {
		return payerInstitution;
	}

	/**
	 * Sets the payer/buyer specified debtor financial institution.<br/>
	 * Profile: COMFORT<br/>
	 * 
	 * @param payerInstitution the payer institution
	 * @return the trade settlement payment means
	 */
	public PaymentMeans setPayerInstitution(DebtorFinancialInstitution payerInstitution) {
		this.payerInstitution = payerInstitution;
		return this;
	}

	/**
	 * Gets the payee/seller specified creditor financial institution.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @return the payee specified creditor financial institution
	 */
	public CreditorFinancialInstitution getPayeeInstitution() {
		return payeeInstitution;
	}

	/**
	 * Sets the payee/seller specified creditor financial institution.<br/>
	 * Profile: BASIC<br/>
	 * 
	 * @param payeeInstitution the payee institution
	 * @return the trade settlement payment means
	 */
	public PaymentMeans setPayeeInstitution(CreditorFinancialInstitution payeeInstitution) {
		this.payeeInstitution = payeeInstitution;
		return this;
	}

}

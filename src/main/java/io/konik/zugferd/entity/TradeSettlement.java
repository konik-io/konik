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


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Class SupplyChainTradeSettlement. <br/>
 * Contains the payment related information.
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeSettlementType", propOrder = { "paymentReference", "invoiceCurrency",
		"invoicee", "paymentMeans", "tradeTax", "billingPeriod", "allowanceCharge", "serviceCharge",
		"paymentTerms", "monetarySummation", "accountingAccount" })
public class TradeSettlement {

	/** The payment reference or reason for payment */
	@XmlElement(name = "PaymentReference")
	private String paymentReference;

	/** The invoice currency code. */
	@XmlElement(name = "InvoiceCurrencyCode")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	private String invoiceCurrency;

	/** The invoicee trade party. */
	@Valid
	@XmlElement(name = "InvoiceeTradeParty")
	private TradeParty invoicee;

	/** The specified trade settlement payment means. */
	@Valid
	@XmlElement(name = "SpecifiedTradeSettlementPaymentMeans")
	private List<PaymentMeans> paymentMeans;

	/** The applicable trade tax. */
	@Valid
	@XmlElement(name = "ApplicableTradeTax")
	private List<TradeTax> tradeTax;

	/** The billing period. */
	@Valid
	@XmlElement(name = "BillingSpecifiedPeriod")
	private BillingPeriod billingPeriod;

	/** The trade allowance charge. */
	@Valid
	@XmlElement(name = "SpecifiedTradeAllowanceCharge")
	private List<AllowanceCharge> allowanceCharge;

	/** The logistics service charge. */
	@Valid
	@XmlElement(name = "SpecifiedLogisticsServiceCharge")
	private List<LogisticsServiceCharge> serviceCharge;

	/** The trade payment terms. */
	@Valid
	@XmlElement(name = "SpecifiedTradePaymentTerms")
	private List<PaymentTerms> paymentTerms;

	/** The trade settlement monetary summation. */
	@Valid
	@XmlElement(name = "SpecifiedTradeSettlementMonetarySummation")
	private MonetarySummation monetarySummation;

	/** The receivable specified trade accounting account. */
	@XmlElement(name = "ReceivableSpecifiedTradeAccountingAccount")
	private AccountingAccount accountingAccount;

	/**
	 * Gets the payment reference.<br/>
	 * Can be same as invoice number.<br/>
	 * Profile: BASIC<br/>
	 *
	 * @return the payment reference
	 */
	public String getPaymentReference() {
		return paymentReference;
	}

	/**
	 * Sets the payment reference or note to payee<br/>
	 * Can be same as invoice number.<br/>
	 * Profile: BASIC<br/>
	 *
	 * @param referenceText the reference text
	 * @return the trade settlement
	 */
	public TradeSettlement setPaymentReference(String referenceText) {
		this.paymentReference = referenceText;
		return this;
	}

	/**
	 * Gets the invoice currency code as ISO 4217 3A <br/>
	 * Profile: BASIC<br/>
	 *
	 * @return the invoice currency code
	 * @see <a href="http://en.wikipedia.org/wiki/ISO_4217">ISO 4217 3A currency code</a>
	 */
	public String getInvoiceCurrency() {
		return invoiceCurrency;
	}

	/**
	 * Sets the invoice currency code in ISO 4217 3A.<br/>
	 * Profile: BASIC<br/>
	 *
	 * @param invoiceCurrencyCode the new ISO 4217 3A invoice currency code
	 * @return the supply chain trade settlement
	 * @see <a href="http://en.wikipedia.org/wiki/ISO_4217">ISO 4217 3A currency code</a>
	 */
	public TradeSettlement setInvoiceCurrency(String invoiceCurrencyCode) {
		this.invoiceCurrency = invoiceCurrencyCode;
		return this;
	}

	/**
	 * Gets the invoicee trade party.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @return the invoicee trade party
	 */
	public TradeParty getInvoicee() {
		return invoicee;
	}

	/**
	 * Sets the invoicee trade party.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @param invoicee the new invoicee trade party
	 * @return the supply chain trade settlement
	 */
	public TradeSettlement setInvoicee(TradeParty invoicee) {
		this.invoicee = invoicee;
		return this;
	}

	/**
	 * Gets the specified trade settlement payment means.
	 *
	 * @return the specified trade settlement payment means
	 */
	public List<PaymentMeans> getPaymentMeans() {
		if (paymentMeans == null) {
			paymentMeans = new ArrayList<PaymentMeans>();
		}
		return this.paymentMeans;
	}

	/**
	 * Adds the payment method.
	 *
	 * @param newPaymentMethod the new payment method
	 * @return the supply chain trade settlement
	 */
	public TradeSettlement addPaymentMeans(PaymentMeans newPaymentMethod) {
		getPaymentMeans().add(newPaymentMethod);
		return this;
	}

	/**
	 * Gets the applicable trade tax.
	 *
	 * @return the applicable trade tax
	 */
	public List<TradeTax> getTradeTax() {
		if (tradeTax == null) {
			tradeTax = new ArrayList<TradeTax>();
		}
		return this.tradeTax;
	}

	/**
	 * Adds the trade tax.
	 *
	 * @param tradeTax the trade tax
	 * @return the trade settlement
	 */
	public TradeSettlement addTradeTax(TradeTax tradeTax) {
		getTradeTax().add(tradeTax);
		return this;
	}

	/**
	 * Gets the billing specified period.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @return the billing specified period
	 */
	public BillingPeriod getBillingPeriod() {
		return billingPeriod;
	}

	/**
	 * Sets the billing specified period.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @param billingPeriod the new billing specified period
	 * @return the supply chain trade settlement
	 */
	public TradeSettlement setBillingPeriod(BillingPeriod billingPeriod) {
		this.billingPeriod = billingPeriod;
		return this;
	}

	/**
	 * Gets the trade allowance charge.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @return the specified trade allowance charge
	 */
	public List<AllowanceCharge> getAllowanceCharge() {
		if (allowanceCharge == null) {
			allowanceCharge = new ArrayList<AllowanceCharge>();
		}
		return this.allowanceCharge;
	}

	/**
	 * Adds the trade allowance charge.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @param allowanceCharge the allowance charge
	 * @return the trade settlement
	 */
	public TradeSettlement addAllowanceCharge(AllowanceCharge allowanceCharge) {
		getAllowanceCharge().add(allowanceCharge);
		return this;
	}

	/**
	 * Gets the specified logistics service charge.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @return the specified logistics service charge
	 */
	public List<LogisticsServiceCharge> getServiceCharge() {
		if (serviceCharge == null) {
			serviceCharge = new ArrayList<LogisticsServiceCharge>();
		}
		return this.serviceCharge;
	}

	/**
	 * Adds the specified logistics service charge.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @param logisticsServiceCharge the logistics service charge
	 * @return the trade settlement
	 */
	public TradeSettlement addServiceCharge(LogisticsServiceCharge logisticsServiceCharge) {
		getServiceCharge().add(logisticsServiceCharge);
		return this;
	}

	/**
	 * Gets the specified trade payment terms.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @return the specified trade payment terms
	 */
	public List<PaymentTerms> getPaymentTerms() {
		if (paymentTerms == null) {
			paymentTerms = new ArrayList<PaymentTerms>();
		}
		return this.paymentTerms;
	}

	/**
	 * Adds the payment terms.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @param paymentTerms the trade payment terms
	 * @return the trade settlement
	 */
	public TradeSettlement addPaymentTerms(PaymentTerms paymentTerms) {
		getPaymentTerms().add(paymentTerms);
		return this;
	}

	/**
	 * Gets the trade settlement monetary summation.<br/>
	 * Profile: BASIC<br/>
	 *
	 * @return the specified trade settlement monetary summation
	 */
	public MonetarySummation getMonetarySummation() {
		return monetarySummation;
	}

	/**
	 * Sets the trade settlement monetary summation.<br/>
	 * Profile: BASIC<br/>
	 *
	 * @param monetarySummation the new monetary summation
	 * @return the supply chain trade settlement
	 */
	public TradeSettlement setMonetarySummation(MonetarySummation monetarySummation) {
		this.monetarySummation = monetarySummation;
		return this;
	}

	/**
	 * Gets the receivable specified trade accounting account.<br/>
	 * Profile: EXTENDED<br/>
	 *
	 * @return the trade accounting account
	 */
	public AccountingAccount getAccountingAccount() {
		return accountingAccount;
	}

	/**
	 * Sets the receivable specified trade accounting account.<br/>
	 * Profile: EXTENDED<br/>
	 *
	 * @param accountingAccount the new receivable specified trade accounting account
	 * @return the supply chain trade settlement
	 */
	public TradeSettlement setAccountingAccount(AccountingAccount accountingAccount) {
		this.accountingAccount = accountingAccount;
		return this;
	}

}

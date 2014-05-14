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


import com.neovisionaries.i18n.CurrencyCode;

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
 * The Class SupplyChainTradeSettlement. 

 * Contains the payment related information.
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeSettlementType", propOrder = { "paymentReference", "currencyCode",
		"invoicee", "paymentMeans", "tradeTax", "billingPeriod", "allowanceCharge", "serviceCharge",
		"paymentTerms", "monetarySummation", "bookingReference" })
public class TradeSettlement {

	/** The payment reference or reason for payment */
	@XmlElement(name = "PaymentReference")
	private String paymentReference;

	/** The invoice currency code. */
	@XmlElement(name = "InvoiceCurrencyCode")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	private String currencyCode;

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
	private Period billingPeriod;

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
	private List<PaymentTerm> paymentTerms;

	/** The trade settlement monetary summation. */
	@Valid
	@XmlElement(name = "SpecifiedTradeSettlementMonetarySummation")
	private MonetarySummation monetarySummation;

	/** The receivable specified trade accounting account. */
	@XmlElement(name = "ReceivableSpecifiedTradeAccountingAccount")
	private Account bookingReference;

	/**
	 * Gets the payment reference.

	 * Can be same as invoice number.

	 * Profile: BASIC

	 *
	 * @return the payment reference
	 */
	public String getPaymentReference() {
		return paymentReference;
	}

	/**
	 * Sets the payment reference or note to payee

	 * Can be same as invoice number.

	 * Profile: BASIC

	 *
	 * @param referenceText the reference text
	 * @return the trade settlement
	 */
	public TradeSettlement setPaymentReference(String referenceText) {
		this.paymentReference = referenceText;
		return this;
	}

	/**
	 * Gets the invoice currency code
	 *
	 * Profile: BASIC
	 * @return the +ISO 4217 3A+ currency code
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

   /**
    * Gets the currency.
    *
    * @return the currency
    */
   public CurrencyCode getCurrency() {
      return CurrencyCode.getByCode(currencyCode);
   }
   
	/**
    * Sets the invoice currency code.
    * Profile: BASIC
    *
    * @param currencyCode the new +ISO 4217 3A+ currency code
    * @return the trade settlement
    */
	public TradeSettlement setCurrency(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}
	
	/**
    * Sets the invoice currency.
    *
    * @param currency the currency
    * @return the trade settlement
    */
  	public TradeSettlement setCurrency(CurrencyCode currency) {
	      this.currencyCode = currency.name();
	      return this;
	   }


	/**
	 * Gets the invoicee trade party.

	 * Profile: COMFORT

	 *
	 * @return the invoicee trade party
	 */
	public TradeParty getInvoicee() {
		return invoicee;
	}

	/**
	 * Sets the invoicee trade party.

	 * Profile: COMFORT

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
	 * Adds a trade tax.

	 * @param additionalTradeTax 
	 * @return the trade settlement
	 */
	public TradeSettlement addTradeTax(TradeTax additionalTradeTax) {
		getTradeTax().add(additionalTradeTax);
		return this;
	}

	/**
	 * Gets the billing specified period.

	 * Profile: COMFORT

	 *
	 * @return the billing specified period
	 */
	public Period getBillingPeriod() {
		return billingPeriod;
	}

	/**
	 * Sets the billing specified period.

	 * Profile: COMFORT

	 *
	 * @param billingPeriod the new billing specified period
	 * @return the supply chain trade settlement
	 */
	public TradeSettlement setBillingPeriod(Period billingPeriod) {
		this.billingPeriod = billingPeriod;
		return this;
	}

	/**
	 * Gets the trade allowance charge.

	 * Profile: COMFORT

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
	 * Adds the trade allowance charge.

	 * Profile: COMFORT

	 *
	 * @param additionalAllowanceCharge an additional allowance charge
	 * @return the trade settlement
	 */
	public TradeSettlement addAllowanceCharge(AllowanceCharge additionalAllowanceCharge) {
		getAllowanceCharge().add(additionalAllowanceCharge);
		return this;
	}

	/**
	 * Gets the specified logistics service charge.

	 * Profile: COMFORT

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
	 * Adds the specified logistics service charge.

	 * Profile: COMFORT

	 *
	 * @param logisticsServiceCharge the logistics service charge
	 * @return the trade settlement
	 */
	public TradeSettlement addServiceCharge(LogisticsServiceCharge logisticsServiceCharge) {
		getServiceCharge().add(logisticsServiceCharge);
		return this;
	}

	/**
	 * Gets the specified trade payment terms.

	 * Profile: COMFORT

	 *
	 * @return the specified trade payment terms
	 */
	public List<PaymentTerm> getPaymentTerms() {
		if (paymentTerms == null) {
			paymentTerms = new ArrayList<PaymentTerm>();
		}
		return this.paymentTerms;
	}

	/**
	 * Adds a Payment Term
    * Profile: COMFORT.
    *
    * @param additionalPaymentTerm the additional payment term
    * @return the trade settlement
    */
	public TradeSettlement addPaymentTerm(PaymentTerm additionalPaymentTerm) {
		getPaymentTerms().add(additionalPaymentTerm);
		return this;
	}

	/**
	 * Gets the trade settlement monetary summation.

	 * Profile: BASIC

	 *
	 * @return the specified trade settlement monetary summation
	 */
	public MonetarySummation getMonetarySummation() {
		return monetarySummation;
	}

	/**
	 * Sets the trade settlement monetary summation.

	 * Profile: BASIC

	 *
	 * @param monetarySummation the new monetary summation
	 * @return the supply chain trade settlement
	 */
	public TradeSettlement setMonetarySummation(MonetarySummation monetarySummation) {
		this.monetarySummation = monetarySummation;
		return this;
	}

	/**
    * Gets the booking reference account.
    * Profile: EXTENDED
    *
    * @return the account of the booking reference
    */
	public Account getBookingReference() {
		return bookingReference;
	}

	/**
    * Sets the booking reference account.
    * Profile: EXTENDED
    *
    * @param bookingReference the booking reference account.
    * @return the trade
    */
	public TradeSettlement setBookingReference(Account bookingReference) {
		this.bookingReference = bookingReference;
		return this;
	}

}

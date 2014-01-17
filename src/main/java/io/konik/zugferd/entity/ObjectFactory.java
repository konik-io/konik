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

import javax.xml.bind.annotation.XmlRegistry;

/** A factory for creating Object objects. */
@XmlRegistry
public class ObjectFactory {

	/** Instantiates a new object factory. */
	public ObjectFactory() {
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade address
	 */
	public Address createTradeAddress() {
		return new Address();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the creditor financial institution
	 */
	public CreditorFinancialInstitution createCreditorFinancialInstitution() {
		return new CreditorFinancialInstitution();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the debtor financial account
	 */
	public DebtorFinancialAccount createDebtorFinancialAccount() {
		return new DebtorFinancialAccount();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade price
	 */
	public TradePrice createTradePrice() {
		return new TradePrice();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade payment terms
	 */
	public PaymentTerms createTradePaymentTerms() {
		return new PaymentTerms();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the supply chain trade agreement
	 */
	public TradeAgreement createSupplyChainTradeAgreement() {
		return new TradeAgreement();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the logistics service charge
	 */
	public LogisticsServiceCharge createLogisticsServiceCharge() {
		return new LogisticsServiceCharge();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the debtor financial institution
	 */
	public DebtorFinancialInstitution createDebtorFinancialInstitution() {
		return new DebtorFinancialInstitution();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the supply chain trade delivery
	 */
	public Delivery createSupplyChainTradeDelivery() {
		return new Delivery();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the note
	 */
	public Note createNote() {
		return new Note();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the specified period
	 */
	public BillingPeriod createSpecifiedPeriod() {
		return new BillingPeriod();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the supply chain event
	 */
	public Event createSupplyChainEvent() {
		return new Event();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade country
	 */
	public TradeCountry createTradeCountry() {
		return new TradeCountry();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade party
	 */
	public TradeParty createTradeParty() {
		return new TradeParty();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the universal communication
	 */
	public UniversalCommunication createUniversalCommunication() {
		return new UniversalCommunication();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the supply chain trade transaction
	 */
	public Trade createTradeTransaction() {
		return new Trade();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade tax
	 */
	public TradeTax createTradeTax() {
		return new TradeTax();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the tax registration
	 */
	public TaxRegistration createTaxRegistration() {
		return new TaxRegistration();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the supply chain trade settlement
	 */
	public TradeSettlement createSupplyChainTradeSettlement() {
		return new TradeSettlement();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the exchanged document
	 */
	public ExchangeDocument createExchangedDocument() {
		return new ExchangeDocument();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade product
	 */
	public TradeProduct createTradeProduct() {
		return new TradeProduct();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade accounting account
	 */
	public AccountingAccount createTradeAccountingAccount() {
		return new AccountingAccount();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the document context parameter
	 */
	public DocumentContextParameter createDocumentContextParameter() {
		return new DocumentContextParameter();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade allowance charge
	 */
	public AllowanceCharge createTradeAllowanceCharge() {
		return new AllowanceCharge();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the supply chain trade line item
	 */
	public Item createItem() {
		return new Item();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the document line document
	 */
	public DocumentLine createDocumentLineDocument() {
		return new DocumentLine();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade contact
	 */
	public Contact createTradeContact() {
		return new Contact();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation createTradeSettlementMonetarySummation() {
		return new MonetarySummation();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the creditor financial account
	 */
	public CreditorFinancialAccount createCreditorFinancialAccount() {
		return new CreditorFinancialAccount();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the exchanged document context
	 */
	public ExchangeDocumentContext createExchangedDocumentContext() {
		return new ExchangeDocumentContext();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the trade settlement payment means
	 */
	public PaymentMeans createTradeSettlementPaymentMeans() {
		return new PaymentMeans();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the referenced document
	 */
	public ReferencedDocument createReferencedDocument() {
		return new ReferencedDocument();
	}

}

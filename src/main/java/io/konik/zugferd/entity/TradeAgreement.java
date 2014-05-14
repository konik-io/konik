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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The Trade Agreement.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeAgreementType", propOrder = { "buyerReference", "seller", "buyer",
		"buyerOrder", "contract", "grossPrice", "netPrice", "customerOrder" })
public class TradeAgreement {

	@XmlElement(name = "BuyerReference")
	private String buyerReference;

	@NotNull@Valid
	@XmlElement(name = "SellerTradeParty")
	private TradeParty seller;

	@Valid
	@XmlElement(name = "BuyerTradeParty")
	private TradeParty buyer;

	@Valid
	@XmlElement(name = "BuyerOrderReferencedDocument")
	private ReferencedDocument buyerOrder;

	@Valid
	@XmlElement(name = "ContractReferencedDocument")
	private ReferencedDocument contract;

	@Valid
	@XmlElement(name = "GrossPriceProductTradePrice")
	private TradePrice grossPrice;

	@Valid
	@XmlElement(name = "NetPriceProductTradePrice")
	private TradePrice netPrice;

	@Valid
	@XmlElement(name = "CustomerOrderReferencedDocument")
	private ReferencedDocument customerOrder;

	/**
    * Instantiates a new supply chain trade agreement with basic parameters.
    *
    * @param sellerTradeParty the seller trade party
    * @param buyerTradeParty the buyer trade party
    * @param buyerOrderReferencedDocument the buyer order referenced document
    */
	public TradeAgreement(TradeParty sellerTradeParty, TradeParty buyerTradeParty,
			ReferencedDocument buyerOrderReferencedDocument) {
		super();
		this.seller = sellerTradeParty;
		this.buyer = buyerTradeParty;
		this.buyerOrder = buyerOrderReferencedDocument;
	}

	/** Instantiates a new supply chain trade agreement. */
	public TradeAgreement() {
	}

	/**
	 * Gets the buyer reference.

	 * The reference to ease the attribution for the buyer

	 * Profile: COMFORT when part of {@link Trade}

	 *
	 * @return the buyer reference
	 */
	public String getBuyerReference() {
		return buyerReference;
	}

	/**
	 * Sets the buyer reference. 

	 * The reference to ease the attribution for the buyer

	 * Profile: COMFORT when part of {@link Trade}

	 *
	 * @param buyerReference the new buyer reference
	 * @return the trade agreement
	 */
	public TradeAgreement setBuyerReference(String buyerReference) {
		this.buyerReference = buyerReference;
		return this;
	}

	/**
	 * Gets the seller trade party.
	 *
	 * @return the seller trade party
	 */
	public TradeParty getSellerTradeParty() {
		return seller;
	}

	/**
	 * Sets the seller trade party.
	 *
	 * @param seller the new seller trade party
	 * @return the trade agreement
	 */
	public TradeAgreement setSellerTradeParty(TradeParty seller) {
		this.seller = seller;
		return this;
	}

	/**
	 * Gets the buyer trade party.
	 *
	 * @return the buyer trade party
	 */
	public TradeParty getBuyerTradeParty() {
		return buyer;
	}

	/**
	 * Sets the buyer trade party.
	 *
	 * @param buyer the new buyer trade party
	 * @return the supply chain trade agreement
	 */
	public TradeAgreement setBuyerTradeParty(TradeParty buyer) {
		this.buyer = buyer;
		return this;
	}

	/**
	 * Gets the buyer order referenced document.
	 *
	 * @return the buyer order referenced document
	 */
	public ReferencedDocument getBuyerOrder() {
		return buyerOrder;
	}

	/**
	 * Sets the buyer order referenced document.
	 *
	 * @param buyerOrder the new buyer order referenced document
	 * @return the supply chain trade agreement
	 */
	public TradeAgreement setBuyerOrder(ReferencedDocument buyerOrder) {
		this.buyerOrder = buyerOrder;
		return this;
	}

	/**
	 * Gets the contract referenced document.

	 * Profile: COMFORT 

	 *
	 * @return the contract referenced document
	 */
	public ReferencedDocument getContract() {
		return contract;
	}

	/**
	 * Sets the contract referenced document.

	 * Profile: COMFORT 

	 *
	 * @param contract the new contract referenced document
	 * @return the supply chain trade agreement
	 */
	public TradeAgreement setContract(ReferencedDocument contract) {
		this.contract = contract;
		return this;
	}

	/**
	 * Gets the gross price product trade price.
	 *
	 * @return the gross price product trade price
	 */
	public TradePrice getGrossPriceProduct() {
		return grossPrice;
	}

	/**
	 * Sets the gross price product trade price.
	 *
	 * @param grossPrice the new gross price product trade price
	 * @return the supply chain trade agreement
	 */
	public TradeAgreement setGrossPriceProduct(TradePrice grossPrice) {
		this.grossPrice = grossPrice;
		return this;
	}

	/**
	 * Gets the net price product trade price.
	 *
	 * @return the net price product trade price
	 */
	public TradePrice getNetPriceProduct() {
		return netPrice;
	}

	/**
	 * Sets the net price product trade price.
	 *
	 * @param netPrice the new net price product trade price
	 * @return the supply chain trade agreement
	 */
	public TradeAgreement setNetPriceProduct(TradePrice netPrice) {
		this.netPrice = netPrice;
		return this;
	}

	/**
	 * Gets the customer order referenced document.

	 * Profile: COMFORT 

	 *
	 * @return the customer order referenced document
	 */
	public ReferencedDocument getCustomerOrder() {
		return customerOrder;
	}

	/**
	 * Sets the customer order referenced document. 

	 * Profile: COMFORT 

	 *
	 * @param customerOrder the new customer order referenced document
	 * @return the supply chain trade agreement
	 */
	public TradeAgreement setCustomerOrder(ReferencedDocument customerOrder) {
		this.customerOrder = customerOrder;
		return this;
	}

}

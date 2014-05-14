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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Trade Item.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeLineItemType", propOrder = { "position", "agreement", "delivery","settlement", "product" })
public class Item {

   @Valid
	@XmlElement(name = "AssociatedDocumentLineDocument")
	private DocumentLine position;

   @Valid
	@XmlElement(name = "SpecifiedSupplyChainTradeAgreement")
	private TradeAgreement agreement;

   @Valid
	@XmlElement(name = "SpecifiedSupplyChainTradeDelivery")
	private Delivery delivery;

   @Valid
	@XmlElement(name = "SpecifiedSupplyChainTradeSettlement")
	private TradeSettlement settlement;

   @Valid
	@XmlElement(name = "SpecifiedTradeProduct")
	private TradeProduct product;

   /**
    * Gets the item position document.
    *
    * @return the position
    */
	public DocumentLine getPosition() {
		return position;
	}

	/**
    * Sets the item position document.
    *
    * @param position the new position
    */
	public void setPosition(DocumentLine position) {
		this.position = position;
	}

	/**
	 * Gets the specified supply chain trade agreement.
	 *
	 * @return the specified supply chain trade agreement
	 */
	public TradeAgreement getAgreement() {
		return agreement;
	}

	/**
	 * Sets the specified supply chain trade agreement.
	 *
	 * @param agreement the new specified supply chain trade agreement
	 * @return the item
	 */
	public Item setAgreement(TradeAgreement agreement) {
		this.agreement = agreement;
		return this;
	}

	/**
	 * Gets the specified supply chain trade delivery.
	 *
	 * @return the specified supply chain trade delivery
	 */
	public Delivery getDelivery() {
		return delivery;
	}

	/**
	 * Sets the specified supply chain trade delivery.
	 *
	 * @param delivery the new specified supply chain trade delivery
	 * @return the item
	 */
	public Item setDelivery(Delivery delivery) {
		this.delivery = delivery;
		return this;
	}

	/**
	 * Gets the specified supply chain trade settlement.
	 *
	 * @return the specified supply chain trade settlement
	 */
	public TradeSettlement getSettlement() {
		return settlement;
	}

	/**
	 * Sets the specified supply chain trade settlement.
	 *
	 * @param settlement the new specified supply chain trade settlement
	 * @return the item
	 */
	public Item setSettlement(TradeSettlement settlement) {
		this.settlement = settlement;
		return this;
	}

	/**
	 * Gets the specified trade product.
	 *
	 * @return the specified trade product
	 */
	public TradeProduct getProduct() {
		return product;
	}

	/**
	 * Sets the specified trade product.
	 *
	 * @param product the product
	 * @return the item
	 */
	public Item setProduct(TradeProduct product) {
		this.product = product;
		return this;
	}
}

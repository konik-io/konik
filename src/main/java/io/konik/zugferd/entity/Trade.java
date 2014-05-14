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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class Trade. 

 * Groups the various aspects a invoice trade transaction.

 * 
 * The Trade Transaction is divided into the "global" trade agreements, delivery and trade settlement
 * parameters that can be overwritten/complemented on item basis.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeTransactionType", propOrder = { "agreement", "delivery", "tradeSettlement",
		"items" })
public class Trade {

	/** The contract agreements. */
   @NotNull
	@XmlElement(name = "ApplicableSupplyChainTradeAgreement")
	private TradeAgreement agreement;

	/** The trade delivery. */
   @Valid
	@XmlElement(name = "ApplicableSupplyChainTradeDelivery")
	private Delivery delivery;

	/** The payment settlement. */
   @Valid
	@XmlElement(name = "ApplicableSupplyChainTradeSettlement")
	private TradeSettlement tradeSettlement;

	/** The items. */
   @Valid
	@XmlElement(name = "IncludedSupplyChainTradeLineItem")
	private List<Item> items;

	/**
    * Gets the agreement.
    *
    * @return the agreement
    */
	public TradeAgreement getAgreement() {
      return agreement;
   }

   /**
    * Sets the agreement.
    *
    * @param agreement the new agreement
    */
   public void setAgreement(TradeAgreement agreement) {
      this.agreement = agreement;
   }

   /**
	 * Gets the applicable supply chain trade delivery.
	 * 
	 * @return the applicable supply chain trade delivery
	 */
	public Delivery getDelivery() {
		return delivery;
	}

	/**
	 * Sets the applicable supply chain trade delivery.
	 * 
	 * @param delivery the new applicable supply chain trade delivery
	 * @return the supply chain trade transaction
	 */
	public Trade setDelivery(Delivery delivery) {
		this.delivery = delivery;
		return this;
	}

	/**
	 * Gets the applicable supply chain trade settlement.
	 * 
	 * @return the applicable supply chain trade settlement
	 */
	public TradeSettlement getTradeSettlement() {
		return tradeSettlement;
	}

	/**
	 * Sets the applicable supply chain trade settlement.
	 * 
	 * @param tradeSettlement the new trade settlement
	 */
	public void setTradeSettlement(TradeSettlement tradeSettlement) {
		this.tradeSettlement = tradeSettlement;
	}

	/**
	 * Gets the item.
	 * 
	 * @return the items
	 */
	public List<Item> getItems() {
		if (items == null) {
			items = new ArrayList<Item>();
		}
		return this.items;
	}

	/**
	 * Adds an item.
	 * 
	 * @param item the item
	 * @return the trade transaction
	 */
	public Trade addItem(Item item) {
		getItems().add(item);
		return this;
	}

}

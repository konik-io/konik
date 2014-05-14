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
 * = The Trade.
 *  
 * Groups the various aspects of an trade transaction.
 * 
 * A Trade is divided into the "global" trade agreements, delivery and trade settlement
 * parameters that can be overwritten/complemented on item basis.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeTransactionType", propOrder = { "agreement", "delivery", "tradeSettlement",
		"items" })
public class Trade {

   @NotNull
	@XmlElement(name = "ApplicableSupplyChainTradeAgreement")
	private TradeAgreement agreement;

   @Valid
	@XmlElement(name = "ApplicableSupplyChainTradeDelivery")
	private Delivery delivery;

   @Valid
	@XmlElement(name = "ApplicableSupplyChainTradeSettlement")
	private TradeSettlement tradeSettlement;

   @Valid
	@XmlElement(name = "IncludedSupplyChainTradeLineItem")
	private List<Item> items;

	/**
    * Gets the trade agreement.
    *
    * @return the agreement
    */
	public TradeAgreement getAgreement() {
      return agreement;
   }

   /**
    * Sets the trade agreement.
    *
    * @param agreement the new agreement
    */
   public void setAgreement(TradeAgreement agreement) {
      this.agreement = agreement;
   }

   /**
	 * Gets the trade delivery.
	 * 
	 * @return the trade delivery
	 */
	public Delivery getDelivery() {
		return delivery;
	}

	/**
	 * Sets the trade delivery.
	 * 
	 * @param delivery the new trade delivery
	 * @return the trade 
	 */
	public Trade setDelivery(Delivery delivery) {
		this.delivery = delivery;
		return this;
	}

	/**
	 * Gets the trade settlement.
	 * 
	 * @return the trade settlement
	 */
	public TradeSettlement getTradeSettlement() {
		return tradeSettlement;
	}

	/**
	 * Sets the trade settlement.
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
	 * @return the trade 
	 */
	public Trade addItem(Item item) {
		getItems().add(item);
		return this;
	}

}

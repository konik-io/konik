/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.entity.trade;

import io.konik.zugferd.entity.trade.item.Item;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Trade transaction.
 *  
 * A Trade contains "global" agreements, delivery and settlement. On Item basis those parameters  can be refined.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeTransactionType", propOrder = { "agreement", "delivery", "settlement","items" })
public class Trade {

   @NotNull @Valid
	@XmlElement(name = "ApplicableSupplyChainTradeAgreement")
	private Agreement agreement;

   @NotNull @Valid
	@XmlElement(name = "ApplicableSupplyChainTradeDelivery")
	private Delivery delivery;

   @NotNull @Valid
	@XmlElement(name = "ApplicableSupplyChainTradeSettlement")
	private Settlement settlement;

   @NotNull @Valid
	@XmlElement(name = "IncludedSupplyChainTradeLineItem")
	private List<Item> items;

	/**
    * Gets the trade agreement.
    *
    * @return the agreement
    */
	public Agreement getAgreement() {
      return agreement;
   }

   /**
    * Sets the trade agreement.
    *
    * @param agreement the new agreement
    * @return the trade
    */
   public Trade setAgreement(Agreement agreement) {
      this.agreement = agreement;
      return this;
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
	public Settlement getSettlement() {
		return settlement;
	}

	/**
    * Sets the trade settlement.
    *
    * @param tradeSettlement the new trade settlement
    * @return the trade
    */
	public Trade setSettlement(Settlement tradeSettlement) {
		this.settlement = tradeSettlement;
		return this;
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

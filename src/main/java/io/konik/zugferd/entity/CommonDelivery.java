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

import io.konik.jaxb.bindable.entity.SupplyChainEventAdapter;
import io.konik.zugferd.entity.trade.item.ReferencedDocumentItem;
import io.konik.zugferd.unqualified.ZfDate;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Common Delivery class.
 * 
 * @param <R> The {@link ReferencedDocument} or the {@link ReferencedDocumentItem} that each Delivery might contain.
 */
@XmlTransient
@XmlType(name = "SupplyChainTradeDeliveryType")
public abstract class CommonDelivery<R extends ReferencedDocument>{
   
   @Valid
   @XmlElement(name = "ShipToTradeParty")
   private TradeParty shipTo;
   
   @Valid
   @XmlElement(name = "UltimateShipToTradeParty")
   private TradeParty ultimateShipTo;
   
   @Valid
   @XmlElement(name = "ActualDeliverySupplyChainEvent")
   @XmlJavaTypeAdapter(value = SupplyChainEventAdapter.class)
   private ZfDate actualDelivery;

   protected CommonDelivery() {
      super();
   }

   /**
    * Gets the ship to.
    *
    * @return the ship to
    */
   
   public TradeParty getShipTo() {
      return shipTo;
   }

   /**
    * Sets the ship to.
    *
    * @param shipTo the ship to
    * @return the delivery
    */
   public CommonDelivery<R> setShipTo(TradeParty shipTo) {
      this.shipTo = shipTo;
      return this;
   }

   /**
    * Gets the ultimate ship to.
    *
    * @return the ultimate ship to
    */
 
   public TradeParty getUltimateShipTo() {
      return ultimateShipTo;
   }

   /**
    * Sets the ultimate ship to.
    *
    * @param ultimateShipTo the ultimate ship to
    * @return the delivery
    */
   public CommonDelivery<R> setUltimateShipTo(TradeParty ultimateShipTo) {
      this.ultimateShipTo = ultimateShipTo;
      return this;
   }

   /**
    * Gets the actual delivery event.
    *
    * @return the actual event
    */
   public ZfDate getActualDelivery() {
      return actualDelivery;
   }

   /**
    * Sets the actual delivery event.
    *
    * @param actualDelivery the actual delivery
    * @return the delivery
    */
   public CommonDelivery<R> setActualDelivery(ZfDate actualDelivery) {
      this.actualDelivery = actualDelivery;
      return this;
   }

   /**
    * Gets the despatch advice.
    *
    * @return the despatch advice
    */
   public abstract R getDespatchAdvice() ;
   
   /**
    * Sets the despatch advice.
    *
    * @param despatchAdvice the despatch advice
    * @return 
    */
   public abstract CommonDelivery<R> setDespatchAdvice(R despatchAdvice);

   /**
    * Gets the delivery note.
    *
    * @return the note
    */
   public abstract R getDeliveryNote(); 
   
   /**
    * Sets the delivery note.
    *
    * @param deliveryNote the delivery note
    * @return the delivery
    */
   public abstract CommonDelivery<R> setDeliveryNote(R deliveryNote);

}
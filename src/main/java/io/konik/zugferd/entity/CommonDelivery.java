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

import io.konik.zugferd.entity.trade.item.ReferencedDocumentLine;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Common Delivery class.
 * 
 * @param <REF> The {@link ReferencedDocument} or the {@link ReferencedDocumentLine} that each Delivery might contain.
 */
@XmlTransient
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "SupplyChainTradeDeliveryType")
//TODO: maybe make the model consistent having all protected fields here and implements the getter/setter in the subclass
public abstract class CommonDelivery<REF extends ReferencedDocument>{
   
   @Valid
   @XmlElement(name = "ShipToTradeParty")
   private TradeParty shipTo;
   @Valid
   @XmlElement(name = "UltimateShipToTradeParty")
   private TradeParty ultimateShipTo;
   @Valid
   @XmlElement(name = "ActualDeliverySupplyChainEvent")
   private Event actualDelivery;
   
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
   public CommonDelivery<REF> setShipTo(TradeParty shipTo) {
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
   public CommonDelivery<REF> setUltimateShipTo(TradeParty ultimateShipTo) {
      this.ultimateShipTo = ultimateShipTo;
      return this;
   }

   /**
    * Gets the actual delivery event.
    *
    * @return the actual event
    */
   public Event getActualDelivery() {
      return actualDelivery;
   }

   /**
    * Sets the actual delivery event.
    *
    * @param actualDelivery the actual delivery
    * @return the delivery
    */
   public CommonDelivery<REF> setActualDelivery(Event actualDelivery) {
      this.actualDelivery = actualDelivery;
      return this;
   }

   /**
    * Gets the despatch advice.
    *
    * @return the despatch advice
    */
   public abstract ReferencedDocument getDespatchAdvice();
   
   /**
    * Sets the despatch advice.
    *
    * @param despatchAdvice the despatch advice
    * @return 
    */
   public abstract  CommonDelivery<REF> setDespatchAdvice(REF despatchAdvice);

   /**
    * Gets the note.
    *
    * @return the note
    */
   public abstract REF getNote();
   
   /**
    * Sets the note.
    *
    * @param note the note
    * @return the delivery
    */
   public abstract CommonDelivery<REF> setNote(REF note);

}
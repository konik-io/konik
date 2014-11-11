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
package io.konik.zugferd.entity.trade.item;

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.CommonDelivery;
import io.konik.zugferd.entity.TradeParty;
import io.konik.zugferd.unqualified.Quantity;
import io.konik.zugferd.unqualified.ZfDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Trade Delivery
 * 
 */
@XmlType(propOrder = { "billed", "chargeFree", "packageQuantity", "shipTo", "ultimateShipTo", "actualDelivery",
      "despatchAdvice", "receivingAdvice", "deliveryNote" })
public class SpecifiedDelivery extends CommonDelivery<ReferencedDocumentItem> {

   @XmlElement(name = "BilledQuantity")
   private Quantity billed;

   @XmlElement(name = "ChargeFreeQuantity")
   private Quantity chargeFree;

   @XmlElement(name = "PackageQuantity")
   private Quantity packageQuantity;

   @XmlElement(name = "DespatchAdviceReferencedDocument")
   private ReferencedDocumentItem despatchAdvice;

   @XmlElement(name = "ReceivingAdviceReferencedDocument")
   private ReferencedDocumentItem receivingAdvice;

   @XmlElement(name = "DeliveryNoteReferencedDocument")
   private ReferencedDocumentItem deliveryNote;

   /** Instantiates a new trade delivery. */
   public SpecifiedDelivery() {
   }

   /**
    * The Constructor.
    *
    * @param billed the billed
    */
   public SpecifiedDelivery(Quantity billed) {
      super();
      this.billed = billed;
   }

   /**
    * The Constructor.
    *
    * @param billed the billed
    * @param actualDelivery the actual delivery
    */
   public SpecifiedDelivery(Quantity billed, ZfDate actualDelivery) {
      super();
      this.billed = billed;
      setActualDelivery(actualDelivery);
   }

   /**
    * Gets the billed quantity.
    * 
    * @return the billed quantity
    */
   @Basic
   @Valid
   @NotNull
   public Quantity getBilled() {
      return billed;
   }

   /**
    * Sets the billed quantity.
    * 
    * @param billedQuantity the new billed quantity
    * @return the delivery
    */
   public SpecifiedDelivery setBilled(Quantity billedQuantity) {
      this.billed = billedQuantity;
      return this;
   }

   /**
    * Gets the charge free.
    *
    * @return the charge free
    */
   @Extended
   @Valid
   public Quantity getChargeFree() {
      return chargeFree;
   }

   /**
    * Sets the charge free.
    *
    * @param chargeFree the charge free
    * @return the item delivery
    */
   public SpecifiedDelivery setChargeFree(Quantity chargeFree) {
      this.chargeFree = chargeFree;
      return this;
   }

   /**
    * Gets the package quantity.
    *
    * @return the package quantity
    */
   @Extended
   @Valid
   public Quantity getPackageQuantity() {
      return packageQuantity;
   }
   
   /**
    * Sets the package quantity.
    *
    * @param packageQuantity the package quantity
    * @return the item delivery
    */
   public SpecifiedDelivery setPackageQuantity(Quantity packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }
   
   @Extended
   @Valid
   @Override
   public TradeParty getShipTo() {
      return super.getShipTo();
   }
   
   @Extended
   @Valid
   @Override
   public TradeParty getUltimateShipTo() {
      return super.getUltimateShipTo();
   }

   @Extended
   @Override
   public ZfDate getActualDelivery() {
      return super.getActualDelivery();
   }
   
   @Extended
   @Valid
   @Override
   public ReferencedDocumentItem getDespatchAdvice() {
      return despatchAdvice;
   }

   @Override
   public SpecifiedDelivery setDespatchAdvice(ReferencedDocumentItem despatchAdvice) {
      this.despatchAdvice = despatchAdvice;
      return this;
   }

   /**
    * Gets the receiving advice.
    *
    * @return the receiving advice
    */
   @Extended
   @Valid
   public ReferencedDocumentItem getReceivingAdvice() {
      return receivingAdvice;
   }

   /**
    * Sets the receiving advice.
    *
    * @param receivingAdvice the receiving advice
    * @return the item delivery
    */
   public SpecifiedDelivery setReceivingAdvice(ReferencedDocumentItem receivingAdvice) {
      this.receivingAdvice = receivingAdvice;
      return this;
   }

   @Extended
   @Valid
   @Override
   public ReferencedDocumentItem getDeliveryNote() {
      return deliveryNote;
   }

   @Override
   public SpecifiedDelivery setDeliveryNote(ReferencedDocumentItem deliveryNote) {
      this.deliveryNote = deliveryNote;
      return this;
   }
}

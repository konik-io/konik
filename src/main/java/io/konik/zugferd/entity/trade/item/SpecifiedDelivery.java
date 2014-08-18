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

import io.konik.zugferd.entity.CommonDelivery;
import io.konik.zugferd.unqualified.Quantity;
import io.konik.zugferd.unqualified.ZfDate;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Trade Delivery
 * 
 * Profile:: EXTENDED
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "billed", "chargeFree","packageQuantity", "shipTo", "ultimateShipTo", "actualDelivery", "despatchAdvice","receivingAdvice", "deliveryNote" })
public class SpecifiedDelivery extends CommonDelivery<ReferencedDocumentItem>{

   @Valid
   @NotNull
   @XmlElement(name = "BilledQuantity")
   private Quantity billed; 

   @Valid
   @XmlElement(name = "ChargeFreeQuantity")
   private Quantity chargeFree;

   @Valid
   @XmlElement(name = "PackageQuantity")
   private Quantity packageQuantity; 

   @Valid
   @XmlElement(name = "DespatchAdviceReferencedDocument")
   private ReferencedDocumentItem despatchAdvice;

   @Valid
   @XmlElement(name = "ReceivingAdviceReferencedDocument")
   private List<ReferencedDocumentItem> receivingAdvice;

   @Valid
   @XmlElement(name = "DeliveryNoteReferencedDocument")
   private ReferencedDocumentItem deliveryNote;

   /** Instantiates a new trade delivery. */
   public SpecifiedDelivery() {
   }

   /**
    * The Constructor.
    *
    * Profile:: BASIC
    *
    * @param billed the billed
    */
   public SpecifiedDelivery(Quantity billed)  {
      super();
      this.billed = billed;
   }

   
   /**
    * The Constructor.
    *
    * Profile:: EXTENDED
    *
    * @param billed the billed
    * @param actualDelivery the actual delivery
    */
   public SpecifiedDelivery(Quantity billed, ZfDate actualDelivery)  {
      super();
      this.billed = billed;
      setActualDelivery(actualDelivery);
   }


   /**
    * Gets the billed quantity.
    * 
    * Profile:: BASIC
    *
    * @return the billed quantity
    */
   public Quantity getBilled() {
      return billed;
   }

   /**
    * Sets the billed quantity.
    * 
    * Profile:: BASIC
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
   public List<ReferencedDocumentItem> getReceivingAdvice() {
      return receivingAdvice;
   }

   /**
    * Sets the receiving advice.
    *
    * @param receivingAdvice the receiving advice
    * @return the item delivery
    */
   public SpecifiedDelivery setReceivingAdvice(List<ReferencedDocumentItem> receivingAdvice) {
      this.receivingAdvice = receivingAdvice;
      return this;
   }

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

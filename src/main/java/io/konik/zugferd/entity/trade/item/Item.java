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

import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.entity.PositionDocument;
import io.konik.zugferd.entity.Product;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * = The Trade Item.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeLineItemType", propOrder = { "position", "agreement", "delivery", "settlement",
      "product" })
public class Item implements Serializable {

   @XmlElement(name = "AssociatedDocumentLineDocument")
   private PositionDocument position;

   @XmlElement(name = "SpecifiedSupplyChainTradeAgreement")
   private SpecifiedAgreement agreement;

   @XmlElement(name = "SpecifiedSupplyChainTradeDelivery")
   private SpecifiedDelivery delivery;

   @XmlElement(name = "SpecifiedSupplyChainTradeSettlement")
   private SpecifiedSettlement settlement;

   @XmlElement(name = "SpecifiedTradeProduct")
   private Product product;

   /**
    * Gets the item Line number.
    *
    * @return the position
    */
   @Comfort
   @Valid
   //@NotNull(groups = Comfort.class)
   public PositionDocument getPosition() {
      return position;
   }

   /**
    * Sets the new item Line number.
    *
    * @param newPosition the new Line number.
    * @return the trade item
    */
   public Item setPosition(PositionDocument newPosition) {
      this.position = newPosition;
      return this;
   }

   /**
    * Gets the item level agreement.
    *
    * @return the item level agreement
    */
   @Valid
   public SpecifiedAgreement getAgreement() {
      return agreement;
   }

   /**
    * Sets the item level agreement.
    *
    * @param newItemAgreement the new the item level agreement.
    * @return the trade item
    */
   public Item setAgreement(SpecifiedAgreement newItemAgreement) {
      this.agreement = newItemAgreement;
      return this;
   }

   /**
    * Gets item level delivery.
    *
    * @return the item level delivery
    */
   @Valid
   public SpecifiedDelivery getDelivery() {
      return delivery;
   }

   /**
    * Sets item level delivery.
    *
    * @param newItemDelivery the new item level delivery
    * @return the trade item
    */
   public Item setDelivery(SpecifiedDelivery newItemDelivery) {
      this.delivery = newItemDelivery;
      return this;
   }

   /**
    * Gets the item level settlement.
    *
    * @return the item level settlement
    */
   @Valid
   public SpecifiedSettlement getSettlement() {
      return settlement;
   }

   /**
    * Sets the item level settlement.
    *
    * @param newItemSettlement the new item level settlement
    * @return the trade item
    */
   public Item setSettlement(SpecifiedSettlement newItemSettlement) {
      this.settlement = newItemSettlement;
      return this;
   }

   /**
    * Gets the trade product.
    *
    * @return the product
    */
   @Valid
   public Product getProduct() {
      return product;
   }

   /**
    * Sets the trade product.
    *
    * @param newProduct the product
    * @return the trade item
    */
   public Item setProduct(Product newProduct) {
      this.product = newProduct;
      return this;
   }
}

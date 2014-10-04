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
package io.konik.zugferd.entity.trade.item;

import io.konik.builder.GenerateBuilder;
import io.konik.builder.PojoBuilder;
import io.konik.zugferd.entity.Document;
import io.konik.zugferd.entity.Product;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * = The Trade Item.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeLineItemType", propOrder = { "lineDocument", "agreement", "delivery", "settlement",
      "product" })
@GenerateBuilder
public class Item {

   @Valid
   @XmlElement(name = "AssociatedDocumentLineDocument")
   private Document lineDocument;

   @Valid
   @XmlElement(name = "SpecifiedSupplyChainTradeAgreement")
   private SpecifiedAgreement agreement;

   @Valid
   @XmlElement(name = "SpecifiedSupplyChainTradeDelivery")
   private SpecifiedDelivery delivery;

   @Valid
   @XmlElement(name = "SpecifiedSupplyChainTradeSettlement")
   private SpecifiedSettlement settlement;

   @Valid
   @XmlElement(name = "SpecifiedTradeProduct")
   private Product product;

   /**
    * Gets the item position document.
    *
    * @return the position
    */
   public Document getLineDocument() {
      return lineDocument;
   }

   /**
    * Sets the new item line document.
    *
    * @param newLineDocument the new position
    */
   public void setLineDocument(Document newLineDocument) {
      this.lineDocument = newLineDocument;
      
   }

   /**
    * Gets the specified supply chain trade agreement.
    *
    * @return the specified supply chain trade agreement
    */
   public SpecifiedAgreement getAgreement() {
      return agreement;
   }

   /**
    * Sets the specified supply chain trade agreement.
    *
    * @param agreement the new specified supply chain trade agreement
    */
   public void setAgreement(SpecifiedAgreement agreement) {
      this.agreement = agreement;
      
   }

   /**
    * Gets the specified supply chain trade delivery.
    *
    * @return the specified supply chain trade delivery
    */
   public SpecifiedDelivery getDelivery() {
      return delivery;
   }

   /**
    * Sets the specified supply chain trade delivery.
    *
    * @param delivery the new specified supply chain trade delivery
    */
   public void setDelivery(SpecifiedDelivery delivery) {
      this.delivery = delivery;
      
   }

   /**
    * Gets the specified supply chain trade settlement.
    *
    * @return the specified supply chain trade settlement
    */
   public SpecifiedSettlement getSettlement() {
      return settlement;
   }

   /**
    * Sets the specified supply chain trade settlement.
    *
    * @param settlement the new specified supply chain trade settlement
    */
   public void setSettlement(SpecifiedSettlement settlement) {
      this.settlement = settlement;
      
   }

   /**
    * Gets the specified trade product.
    *
    * @return the specified trade product
    */
   public Product getProduct() {
      return product;
   }

   /**
    * Sets the specified trade product.
    *
    * @param product the product
    */
   public void setProduct(Product product) {
      this.product = product;
      
   }
}

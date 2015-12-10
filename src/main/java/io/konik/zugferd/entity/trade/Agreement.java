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
package io.konik.zugferd.entity.trade;

import io.konik.jaxb.bindable.entity.TradeDeliveryTermsAdapter;
import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.CommonAgreement;
import io.konik.zugferd.entity.ReferencedDocument;
import io.konik.zugferd.entity.TradeParty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * = The Trade Agreement.
 * 
 */
@XmlType(propOrder = { "buyerReference", "seller", "buyer", "productEndUser", "deliveryTerms", "buyerOrder",
      "contract", "additional", "customerOrder" })
public class Agreement implements CommonAgreement<ReferencedDocument, ReferencedDocumentAdditional> {

   private String buyerReference;
   private TradeParty seller;
   private TradeParty buyer;
   private TradeParty productEndUser;
   private String deliveryTerms;
   private ReferencedDocument buyerOrder;
   private ReferencedDocument contract;
   private List<ReferencedDocumentAdditional> additional;
   private ReferencedDocument customerOrder;

   /**
    * Gets the buyer reference.
    * 
    * The reference to ease the attribution for the buyer
    * 
    * @return the buyer reference
    */
   @Comfort
   @XmlElement(name = "BuyerReference")
   public String getBuyerReference() {
      return buyerReference;
   }

   /**
    * Sets the buyer reference.
    * 
    * The reference to ease the attribution for the buyer
    * 
    * @param buyerReference the new buyer reference
    * @return the trade agreement
    */
   public Agreement setBuyerReference(String buyerReference) {
      this.buyerReference = buyerReference;
      return this;
   }

   /**
    * Gets the seller trade party
    *
    * @return the seller
    */
   @NotNull
   @Valid
   @Basic
   @XmlElement(name = "SellerTradeParty")
   public TradeParty getSeller() {
      return seller;
   }

   /**
    * Sets the seller trade party
    *
    * @param seller the seller
    * @return the agreement
    */
   public Agreement setSeller(TradeParty seller) {
      this.seller = seller;
      return this;
   }

   /**
    * Gets the product end user.
    *
    * @return the product end user
    */
   @Valid
   @Extended
   @XmlElement(name = "ProductEndUserTradeParty")
   public TradeParty getProductEndUser() {
      return productEndUser;
   }

   /**
    * Sets the product end user.
    *
    * @param productEndUser the new product end user
    * @return the agreement
    */
   public Agreement setProductEndUser(TradeParty productEndUser) {
      this.productEndUser = productEndUser;
      return this;
   }

   /**
    * Gets the buyer trade party.
    *
    * @return the buyer trade party
    */
   @XmlElement(name = "BuyerTradeParty")
   public TradeParty getBuyer() {
      return buyer;
   }

   /**
    * Sets the buyer trade party.
    *
    * @param buyer the new buyer trade party
    * @return the supply chain trade agreement
    */
   public Agreement setBuyer(TradeParty buyer) {
      this.buyer = buyer;
      return this;
   }

   /**
    * Gets the delivery terms Incoterms code.
    *
    * @return the delivery terms Incoterms code
    */
   @Extended
   @XmlElement(name = "ApplicableTradeDeliveryTerms")
   @XmlJavaTypeAdapter(value = TradeDeliveryTermsAdapter.class)
   public String getDeliveryTerms() {
      return deliveryTerms;
   }

   /**
    * Sets the delivery terms Incoterms code.
    *
    * @param deliveryTerms the delivery Incoterms terms
    * @return 
    */
   public Agreement setDeliveryTerms(String deliveryTerms) {
      this.deliveryTerms = deliveryTerms;
      return this;
   }

   /**
    * Gets the buyer order referenced document.
    *
    * @return the buyer order referenced document
    */
   @Comfort
   @Override
   @XmlElement(name = "BuyerOrderReferencedDocument")
   public ReferencedDocument getBuyerOrder() {
      return buyerOrder;
   }

   /**
    * Sets the buyer order referenced document.
    *
    * @param buyerOrder the new buyer order referenced document
    * @return the supply chain trade agreement
    */
   @Override
   public Agreement setBuyerOrder(ReferencedDocument buyerOrder) {
      this.buyerOrder = buyerOrder;
      return this;
   }

   /**
    * Gets the contract referenced document.
    * 
    * @return the contract referenced document
    */
   @Comfort
   @Override
   @XmlElement(name = "ContractReferencedDocument")
   public ReferencedDocument getContract() {
      return contract;
   }

   /**
    * Sets the contract referenced document.
    * 
    * @param contract the new contract referenced document
    * @return the supply chain trade agreement
    */
   @Override
   public Agreement setContract(ReferencedDocument contract) {
      this.contract = contract;
      return this;
   }

   /**
    * Gets the additional.
    *
    * @return the additional
    */
   @Extended
   @Override
   @XmlElement(name = "AdditionalReferencedDocument")
   public List<ReferencedDocumentAdditional> getAdditional() {
      if (additional == null) {
         additional = new ArrayList<ReferencedDocumentAdditional>();
      }
      return additional;
   }

   /**
    * Adds the additional.
    *
    * @param additionalReference the additional reference
    * @return the common agreement
    */
   @Override
   public Agreement addAdditional(ReferencedDocumentAdditional additionalReference) {
      getAdditional().add(additionalReference);
      return this;
   }

   /**
    * Gets the customer order referenced document.
    * 
    * @return the customer order referenced document
    */
   @Comfort
   @Override
   @XmlElement(name = "CustomerOrderReferencedDocument")
   public ReferencedDocument getCustomerOrder() {
      return customerOrder;
   }

   /**
    * Sets the customer order referenced document.
    * 
    * @param customerOrder the new customer order referenced document
    * @return the supply chain trade agreement
    */
   @Override
   public Agreement setCustomerOrder(ReferencedDocument customerOrder) {
      this.customerOrder = customerOrder;
      return this;
   }
}

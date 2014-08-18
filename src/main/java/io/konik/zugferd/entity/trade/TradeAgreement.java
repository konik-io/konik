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
import io.konik.zugferd.entity.CommonAgreement;
import io.konik.zugferd.entity.ReferencedDocument;
import io.konik.zugferd.entity.TradeParty;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * = The Trade Agreement.
 * 
 */
@XmlType(propOrder = { "buyerReference", "seller", "buyer","productEndUser","deliveryTerms",
      "buyerOrder", "contract", "additional", "customerOrder" })
public class TradeAgreement implements CommonAgreement<ReferencedDocument,ReferencedDocumentAdditional>{
   
   private String buyerReference;
   @Valid
   private TradeParty seller;
   @Valid
   private TradeParty buyer;
   @Valid
   private TradeParty productEndUser;
   @Valid
   private String deliveryTerms;
   @Valid
   private ReferencedDocument buyerOrder;
   @Valid
   private ReferencedDocument contract;
   @Valid
   private List<ReferencedDocumentAdditional> additional;
   @Valid
   private ReferencedDocument customerOrder;

   
   /**
    * Gets the buyer reference.
    * 
    * The reference to ease the attribution for the buyer
    * 
    * Profile:: COMFORT
    * 
    * @return the buyer reference
    */
   @XmlElement(name = "BuyerReference")
   public String getBuyerReference() {
      return buyerReference;
   }

   /**
    * Sets the buyer reference. 
    * 
    * The reference to ease the attribution for the buyer
    * 
    * Profile:: COMFORT
    *
    * @param buyerReference the new buyer reference
    * @return the trade agreement
    */
   public TradeAgreement setBuyerReference(String buyerReference) {
      this.buyerReference = buyerReference;
      return this;
   }
   

   /**
    * Gets the seller.
    *
    * @return the seller
    */
   @XmlElement(name = "SellerTradeParty")
   public TradeParty getSeller() {
      return seller;
   }

   /**
    * Sets the seller.
    *
    * @param seller the seller
    * @return the agreement
    */
   public TradeAgreement setSeller(TradeParty seller) {
      this.seller = seller;
      return this;
   }

   /**
    * Gets the product end user.
    *
    * @return the product end user
    */
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
   public TradeAgreement setProductEndUser(TradeParty productEndUser) {
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
   public TradeAgreement setBuyer(TradeParty buyer) {
      this.buyer = buyer;
      return this;
   }
   
   /**
    * Gets the delivery terms.
    *
    * Profile:: EXTENDED
    *
    * @return the delivery terms
    */
   @XmlElement(name = "ApplicableTradeDeliveryTerms")
   @XmlJavaTypeAdapter(value = TradeDeliveryTermsAdapter.class)
   public String getDeliveryTerms() {
      return deliveryTerms;
   }

   /**
    * Sets the delivery terms.
    *
    * Profile:: EXTENDED
    *
    * @param deliveryTerms the delivery terms
    */
   public void setDeliveryTerms(String deliveryTerms) {
      this.deliveryTerms = deliveryTerms;
   }
   
   /**
    * Gets the buyer order referenced document.
    *
    * @return the buyer order referenced document
    */
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
   public TradeAgreement setBuyerOrder(ReferencedDocument buyerOrder) {
      this.buyerOrder = buyerOrder;
      return this;
   }

   /**
    * Gets the contract referenced document.
    * 
    * Profile:: COMFORT 
    *
    * @return the contract referenced document
    */
   @Override
   @XmlElement(name = "ContractReferencedDocument")
   public ReferencedDocument getContract() {
      return contract;
   }

   /**
    * Sets the contract referenced document.
    * 
    * Profile:: COMFORT 
    *
    * @param contract the new contract referenced document
    * @return the supply chain trade agreement
    */
   @Override
   public TradeAgreement setContract(ReferencedDocument contract) {
      this.contract = contract;
      return this;
   }
   
   /**
    * Gets the additional.
    *
    * @return the additional
    */
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
   public TradeAgreement addAdditional(ReferencedDocumentAdditional additionalReference) {
      getAdditional().add(additionalReference);
      return this;
   }
   
   /**
    * Gets the customer order referenced document.
    * 
    * Profile:: COMFORT 
    *
    * @return the customer order referenced document
    */
   @Override
   @XmlElement(name = "CustomerOrderReferencedDocument")
   public ReferencedDocument getCustomerOrder() {
      return customerOrder;
   }

   /**
    * Sets the customer order referenced document.
    *  
    * Profile:: COMFORT 
    *
    * @param customerOrder the new customer order referenced document
    * @return the supply chain trade agreement
    */
   @Override
   public TradeAgreement setCustomerOrder(ReferencedDocument customerOrder) {
      this.customerOrder = customerOrder;
      return this;
   }
}

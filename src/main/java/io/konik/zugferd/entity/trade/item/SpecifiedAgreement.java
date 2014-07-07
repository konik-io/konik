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

import io.konik.zugferd.entity.CommonAgreement;
import io.konik.zugferd.entity.GrossPrice;
import io.konik.zugferd.entity.Price;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;


/**
 * = The Agreement on trade item level.
 */
public class SpecifiedAgreement extends CommonAgreement<ReferencedDocumentLine> {

   /**
    * Gets the buyer order referenced document.
    *
    * @return the buyer order referenced document
    */
   @Override
   @XmlElement(type=ReferencedDocumentLine.class)
   public ReferencedDocumentLine getBuyerOrder() {
      return buyerOrder;
   }


   /**
    * Sets the buyer order referenced document.
    *
    * @param buyerOrder the new buyer order referenced document
    * @return the supply chain trade agreement
    */
   @Override
   public SpecifiedAgreement setBuyerOrder(ReferencedDocumentLine buyerOrder) {
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
   @XmlElement(type=ReferencedDocumentLine.class)// trade.agreement(IssueDateTime, ID) + item.agreement(LineID)
   public ReferencedDocumentLine getContract() {
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
   public SpecifiedAgreement setContract(ReferencedDocumentLine contract) {
      this.contract = contract;
      return this;
   }
   
   @Override
   @XmlElement(type=ReferencedDocumentLine.class)
   public List<ReferencedDocumentLine> getAdditional() {
      if (additional == null) {
         additional = new ArrayList<ReferencedDocumentLine>();
      }
      return additional;
   }
   
   @Override
   public CommonAgreement<ReferencedDocumentLine> addAdditional(ReferencedDocumentLine additionalReference) {
      getAdditional().add(additionalReference);
      return this;
   }

   /**
    * Gets the gross price product trade price.
    *
    * @return the gross price product trade price
    */
   public GrossPrice getGrossPriceProduct() {
      return grossPrice;
   }

   /**
    * Sets the gross price product trade price.
    *
    * @param grossPrice the new gross price product trade price
    * @return the supply chain trade agreement
    */
   public SpecifiedAgreement setGrossPriceProduct(GrossPrice grossPrice) {
      this.grossPrice = grossPrice;
      return this;
   }

   /**
    * Gets the net price product trade price.
    *
    * @return the net price product trade price
    */
   public Price getNetPriceProduct() {
      return netPrice;
   }

   /**
    * Sets the net price product trade price.
    *
    * @param netPrice the new net price product trade price
    * @return the supply chain trade agreement
    */
   public SpecifiedAgreement setNetPriceProduct(Price netPrice) {
      this.netPrice = netPrice;
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
   @XmlElement(type=ReferencedDocumentLine.class)
   public ReferencedDocumentLine getCustomerOrder() {
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
   public SpecifiedAgreement setCustomerOrder(ReferencedDocumentLine customerOrder) {
      this.customerOrder = customerOrder;
      return this;
   }



}

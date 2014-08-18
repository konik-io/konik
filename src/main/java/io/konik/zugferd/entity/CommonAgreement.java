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

import io.konik.zugferd.entity.trade.Agreement;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Agreement
 * 
 * This base agreement class contain only fields. {@link CommonAgreement} and {@link Agreement} provide a different view
 * on the underlying Data,
 * we have this common field structure class because otherwise we would have two +SupplyChainTradeAgreementType+s and
 * this is not allowed in JaxB
 * 
 * @param <REF> the different Referenced Document
 * @param <ADDREF> additional Referenced Document
 */
@XmlTransient
@XmlType(name = "SupplyChainTradeAgreementType")
public interface CommonAgreement<REF extends ReferencedDocument, ADDREF extends ReferencedDocument> {
   /**
    * Gets the buyer order referenced document.
    *
    * @return the buyer order referenced document
    */
   public REF getBuyerOrder();

   /**
    * Sets the buyer order referenced document.
    *
    * @param buyerOrder the new buyer order referenced document
    * @return the supply chain trade agreement
    */
   public CommonAgreement<REF,ADDREF> setBuyerOrder(REF buyerOrder);

   /**
    * Gets the contract referenced document.
    * 
    * Profile:: COMFORT
    *
    * @return the contract referenced document
    */
   public REF getContract();

   /**
    * Sets the contract referenced document.
    * 
    * Profile:: COMFORT
    *
    * @param contract the new contract referenced document
    * @return the supply chain trade agreement
    */
   public CommonAgreement<REF,ADDREF> setContract(REF contract);

   /**
    * Gets the additional referenced document
    *
    * @return the additional
    */
   public List<ADDREF> getAdditional();

   /**
    * Sets the additional referenced document.
    *
    * @param additionalReference the additional reference
    * @return the common agreement
    */
   public CommonAgreement<REF,ADDREF> addAdditional(ADDREF additionalReference);

   /**
    * Gets the customer order referenced document.
    * 
    * Profile:: COMFORT
    *
    * @return the customer order referenced document
    */
   public REF getCustomerOrder();

   /**
    * Sets the customer order referenced document.
    * 
    * Profile:: COMFORT
    *
    * @param customerOrder the new customer order referenced document
    * @return the supply chain trade agreement
    */
   public CommonAgreement<REF,ADDREF> setCustomerOrder(REF customerOrder);

}

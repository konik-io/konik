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
import io.konik.zugferd.entity.trade.item.SpecifiedAgreement;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Agreement
 * 
 * This base agreement class contain only fields. {@link Agreement} and {@link SpecifiedAgreement} provide a different
 * view
 * on the underlying Data,
 * we have this common field structure class because otherwise we would have two +SupplyChainTradeAgreementType+s and
 * this is not allowed in JaxB
 * 
 * @param <R> the different Referenced Document
 * @param <A> additional Referenced Document
 */
@XmlTransient
@XmlType(name = "SupplyChainTradeAgreementType")
public interface CommonAgreement<R extends ReferencedDocument, A extends ReferencedDocument> {
   /**
    * Gets the buyer order referenced document.
    *
    * @return the buyer order referenced document
    */
   R getBuyerOrder();

   /**
    * Sets the buyer order referenced document.
    *
    * @param buyerOrder the new buyer order referenced document
    */
   void setBuyerOrder(R buyerOrder);

   /**
    * Gets the contract referenced document.
    * 
    * Profile:: COMFORT
    *
    * @return the contract referenced document
    */
   R getContract();

   /**
    * Sets the contract referenced document.
    * 
    * Profile:: COMFORT
    *
    * @param contract the new contract referenced document
    */
   void setContract(R contract);

   /**
    * Gets the additional referenced document
    *
    * @return the additional
    */
   List<A> getAdditional();

   /**
    * Sets the additional referenced document.
    *
    * @param additionalReference the additional reference
    */
   void addAdditional(A additionalReference);

   /**
    * Gets the customer order referenced document.
    * 
    * Profile:: COMFORT
    *
    * @return the customer order referenced document
    */
   R getCustomerOrder();

   /**
    * Sets the customer order referenced document.
    * 
    * Profile:: COMFORT
    *
    * @param customerOrder the new customer order referenced document
    */
   void setCustomerOrder(R customerOrder);

}

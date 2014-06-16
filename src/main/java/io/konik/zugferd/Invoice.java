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
package io.konik.zugferd;

import io.konik.zugferd.entity.Context;
import io.konik.zugferd.entity.Header;
import io.konik.zugferd.entity.Trade;
import io.konik.zugferd.profile.Profile;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = ZUGFeRD Invoice Model.
 */
@XmlRootElement(name = "Invoice")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "context", "header", "trade" })
public class Invoice {

   /** The context. Groups properties of the xml message. */
   @NotNull
   @XmlElement(name = "SpecifiedExchangedDocumentContext")
   private Context context;

   /** The document related header information. */
   @NotNull
   @XmlElement(name = "HeaderExchangedDocument")
   private Header header;

   /** The trade transactions. */
   @NotNull
   @XmlElement(name = "SpecifiedSupplyChainTradeTransaction")
   private Trade trade;

   /**
    * Creates a new invoice.
    */
   Invoice() {
      this.context = new Context();
      this.header = new Header();
   }

   /**
    * Instantiates a new invoice with a invoice profile.
    * 
    * @param profile the profile
    */
   public Invoice(Profile profile) {
      this.context = new Context(profile);
      this.header = new Header();
   }

   /**
    * Gets the specified exchanged document context.
    * 
    * @return the exchanged document context
    */
   public Context getContext() {
      return context;
   }

   /**
    * Sets the exchanged document context.
    * 
    * @param context the new exchanged document context
    * @return the invoice
    */
   public Invoice setContext(Context context) {
      this.context = context;
      return this;
   }

   /**
    * Gets the document header
    * 
    * @return the exchange document header
    */
   public Header getHeader() {
      return header;
   }

   /**
    * Sets the header.
    * 
    * @param header the new exchange document header
    * @return the invoice
    */
   public Invoice setHeader(Header header) {
      this.header = header;
      return this;
   }

   /**
    * Gets the trade.
    *
    * @return the trade
    */
   public Trade getTrade() {
      return trade;
   }

   /**
    * Sets the trade.
    *
    * @param trade the new trade
    * @return the invoice
    */
   public Invoice setTrade(Trade trade) {
      this.trade = trade;
      return this;
   }



}

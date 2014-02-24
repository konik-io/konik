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
package io.konik.zugferd;

import io.konik.invoice.profiles.InvoiceProfiles;
import io.konik.zugferd.entity.ExchangeDocument;
import io.konik.zugferd.entity.ExchangeDocumentContext;
import io.konik.zugferd.entity.Trade;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The ZUGFeRD Invoice Model.
 * 
 * @author Vadim Bauer
 */
@XmlRootElement(name = "Invoice")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "context", "header", "trades" })
public class Invoice {

   /** The context. Groups properties of the xml message. */
   @Valid
   @XmlElement(name = "SpecifiedExchangedDocumentContext")
   private ExchangeDocumentContext context;

   /** The document related header information. */
   @Valid
   @XmlElement(name = "HeaderExchangedDocument")
   private ExchangeDocument header;

   /** The specified supply chain trade transactions. */
   @Valid
   @XmlElement(name = "SpecifiedSupplyChainTradeTransaction")
   private List<Trade> trades;

   public Invoice() {
   }

   /**
    * Instantiates a new invoice with the given invoice profile.
    * 
    * @param profile the profile
    */
   public Invoice(InvoiceProfiles profile) {
      this.context = new ExchangeDocumentContext(profile);
      this.header = new ExchangeDocument();
   }

   /**
    * Gets the specified exchanged document context.
    * 
    * @return the exchanged document context
    */
   public ExchangeDocumentContext getContext() {
      return context;
   }

   /**
    * Sets the exchanged document context.
    * 
    * @param context the new exchanged document context
    * @return the invoice
    */
   public Invoice setContext(ExchangeDocumentContext context) {
      this.context = context;
      return this;
   }

   /**
    * Gets the document header
    * 
    * @return the exchange document header
    */
   public ExchangeDocument getHeader() {
      return header;
   }

   /**
    * Sets the header.
    * 
    * @param header the new exchange document header
    * @return the invoice
    */
   public Invoice setHeader(ExchangeDocument header) {
      this.header = header;
      return this;
   }

   /**
    * Gets the specified supply chain trade transaction.
    * 
    * @return the specified supply chain trade transaction
    */
   public List<Trade> getTrades() {
      if (trades == null) {
         trades = new ArrayList<Trade>();
      }
      return this.trades;
   }

   /**
    * Adds a trade to invoice.
    * 
    * @param trade the trade transaction
    * @return the invoice
    */
   public Invoice addTrade(Trade trade) {
      getTrades().add(trade);
      return this;
   }

}

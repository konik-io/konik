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
package io.konik.examples;

import static io.konik.invoice.profiles.InvoiceProfiles.BASIC;
import static io.konik.utils.SampleInvoiceUtils.getSchemaValidator;
import static io.konik.zugferd.datatype.qualified.DateTimeFormat.F102;
import io.konik.utils.SampleInvoiceUtils;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.datatype.qualified.DateTime;
import io.konik.zugferd.datatype.unqualified.Amount;
import io.konik.zugferd.entity.Address;
import io.konik.zugferd.entity.DebtorFinancialAccount;
import io.konik.zugferd.entity.DebtorFinancialInstitution;
import io.konik.zugferd.entity.Delivery;
import io.konik.zugferd.entity.Event;
import io.konik.zugferd.entity.ExchangeDocument;
import io.konik.zugferd.entity.Item;
import io.konik.zugferd.entity.MonetarySummation;
import io.konik.zugferd.entity.PaymentMeans;
import io.konik.zugferd.entity.TaxRegistration;
import io.konik.zugferd.entity.Trade;
import io.konik.zugferd.entity.TradeAgreement;
import io.konik.zugferd.entity.TradeParty;
import io.konik.zugferd.entity.TradeProduct;
import io.konik.zugferd.entity.TradeSettlement;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * The example class shows how easy it is to create a compact invoice.
 * 
 */
public class MinimalInvoice {

   private Invoice createMinimalValidInvoice() {
      Invoice invoice = new Invoice(BASIC);
      invoice.setHeader(new ExchangeDocument().setId("20131122-42").setTypeCode("380")
            .setIssued(new DateTime(new Date())).addName("Rechnung"));

      Trade tradeTransaction = new Trade();
      tradeTransaction.addAgreement(new TradeAgreement().setSellerTradeParty(
            new TradeParty().setName("Seller Inc.").setAddress(new Address("35578", "Fontanestr, 14", "Wetzlar", "DE"))
                  .addTaxRegistration(new TaxRegistration("DE122...", "FC"))).setBuyerTradeParty(
            new TradeParty().setName("Buyer Inc.").setAddress(new Address("50667", "Domkloster 4", "Köln", "DE"))
                  .addTaxRegistration(new TaxRegistration("DE123...", "FC"))));

      tradeTransaction.setDelivery(new Delivery().setEvent(new Event(new Date(), F102)));

      tradeTransaction.setTradeSettlement(new TradeSettlement().setPaymentReference("20131122-42").setInvoiceCurrency("EUR")
            .addPaymentMeans(new PaymentMeans().setPayerAccount(new DebtorFinancialAccount("DE01234..")).setPayerInstitution(
                  new DebtorFinancialInstitution("GENO...")))
            .setMonetarySummation(new MonetarySummation().
                  setNetTotal(new Amount(100d, "EUR")).setTaxTotal(new Amount(19d, "EUR")).setGrandTotal(new Amount(119d, "EUR"))));
      
      tradeTransaction.addItem(new Item().setProduct(new TradeProduct().setName("Webcam HD")));

      invoice.addTrade(tradeTransaction);
      return invoice;
   }

   @Test
   public void creatBasicInvoice() throws JAXBException, SAXException, IOException {
      //setup
      Invoice invoice = createMinimalValidInvoice();
      Marshaller marshaller = SampleInvoiceUtils.createZfMarshaller();

      ByteArrayOutputStream os = new ByteArrayOutputStream();
      marshaller.marshal(invoice, os);

      //		System.out.println(os.toString());

      //validate
      getSchemaValidator().validate(new StreamSource(new StringReader(os.toString())));
   }
}

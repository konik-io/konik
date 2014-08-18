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
package io.konik.examples;

import static com.neovisionaries.i18n.CurrencyCode.EUR;
import static io.konik.utils.InvoiceLoaderUtils.getSchemaValidator;
import static io.konik.zugferd.profile.Profile.COMFORT;
import static io.konik.zugferd.unece.codes.DocumentCode._380;
import static io.konik.zugferd.unece.codes.Reference.FC;
import static io.konik.zugferd.unece.codes.UnitOfMeasurement.UNIT;
import static org.apache.commons.lang3.time.DateUtils.addDays;
import static org.apache.commons.lang3.time.DateUtils.addMonths;
import static org.assertj.core.api.Assertions.assertThat;
import static org.custommonkey.xmlunit.XMLUnit.compareXML;
import io.konik.InvoiceTransformer;
import io.konik.PrittyPrintInvoiceTransformer;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.Address;
import io.konik.zugferd.entity.FinancialAccount;
import io.konik.zugferd.entity.FinancialInstitution;
import io.konik.zugferd.entity.Header;
import io.konik.zugferd.entity.Item;
import io.konik.zugferd.entity.PaymentMeans;
import io.konik.zugferd.entity.Product;
import io.konik.zugferd.entity.TaxRegistration;
import io.konik.zugferd.entity.Trade;
import io.konik.zugferd.entity.TradeParty;
import io.konik.zugferd.entity.trade.TradeMonetarySummation;
import io.konik.zugferd.entity.trade.TradeAgreement;
import io.konik.zugferd.entity.trade.TradeDelivery;
import io.konik.zugferd.entity.trade.TradeSettlement;
import io.konik.zugferd.entity.trade.item.ReferencedDocumentItem;
import io.konik.zugferd.entity.trade.item.SpecifiedDelivery;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Quantity;
import io.konik.zugferd.unqualified.ZfDate;
import io.konik.zugferd.unqualified.ZfDateDay;
import io.konik.zugferd.unqualified.ZfDateMonth;
import io.konik.zugferd.unqualified.ZfDateWeek;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.google.common.io.ByteSource;

/**
 * The example class shows how easy it is to create a compact invoice.
 */
@SuppressWarnings("javadoc")
public class ComfortInvoice {

   ZfDate today = new ZfDateDay();
   ZfDate nextMonth = new ZfDateMonth(addMonths(today, 1));
   ZfDate inSixWeeks = new ZfDateWeek(addDays(today, 42));

   private Invoice createAllElementInvoiceModel() {
      
      Invoice invoice = new Invoice(COMFORT);    // <1>
      invoice.setHeader(new Header()
         .setInvoiceNumber("20131122-42")
         .setCode(_380)
         .setIssued(today)
         .setName("Rechnung")
         .setContractualDueDate(inSixWeeks));
      
      Trade trade = new Trade();
      trade.setAgreement(new TradeAgreement()     // <2>
            .setSeller(new TradeParty()
                  .setName("Seller Inc.")
                  .setAddress(new Address("80331", "Marienplatz 1", "München", "DE"))
                  .addTaxRegistration(new TaxRegistration("DE122...", FC)))
            .setBuyer(new TradeParty()
                  .setName("Buyer Inc.")
                  .setAddress(new Address("50667", "Domkloster 4", "Köln", "DE"))
                  .addTaxRegistration(new TaxRegistration("DE123...", FC))));
      
      trade.setDelivery(new TradeDelivery(nextMonth));
      
      trade.setSettlement(new TradeSettlement()
            .setPaymentReference("20131122-42")
            .setCurrency(EUR)
            .addPaymentMeans(new PaymentMeans()
               .setPayerAccount(new FinancialAccount("DE01234.."))
                  .setPayerInstitution(new FinancialInstitution("GENO...")))
            .setMonetarySummation(new TradeMonetarySummation()
               .setLineTotal(new Amount(100, EUR))
               .setTaxTotal(new Amount(19, EUR))
               .setGrandTotal(new Amount(119, EUR))));
      
      trade.addItem(new Item()
         .setProduct(new Product().setName("Saddle"))
         .setDelivery(new SpecifiedDelivery(new Quantity(1, UNIT))
            .setDeliveryNote(new ReferencedDocumentItem(1,"DOC:0815"))));
      invoice.setTrade(trade);
      
      return invoice;
   }

   
   public void transformModelAndWriteToDisk(Invoice invoice) throws IOException {
      InvoiceTransformer transformer = new PrittyPrintInvoiceTransformer();     // <1>
      FileOutputStream outputStream = new FileOutputStream("target/all-element-invoice.xml");
      transformer.fromModel(invoice, outputStream);      // <2>
   }
   
   
   @Test
   public void creatInvoice() throws IOException {
      //setup
      Invoice invoice = createAllElementInvoiceModel();
      transformModelAndWriteToDisk(invoice);
   }
   
   @Test
   public void validateInvoice() throws IOException, SAXException {
      //setup
      Invoice invoice = createAllElementInvoiceModel();
      InvoiceTransformer transformer = new PrittyPrintInvoiceTransformer();

      //execute
      byte[] xmlInvoice = transformer.fromModel(invoice);

      //verify
      InputStream is = ByteSource.wrap(xmlInvoice).openBufferedStream();
      getSchemaValidator().validate(new StreamSource(is));
   }

   @Test
   public void compareXMLOfInvoice() throws IOException, SAXException {
      //setup
      Invoice invoiceModel = createAllElementInvoiceModel();
      InvoiceTransformer transformer = new PrittyPrintInvoiceTransformer();
      //convert model to xml
      ByteArrayOutputStream bas = new ByteArrayOutputStream(102400);
      transformer.fromModel(invoiceModel,bas);
      String invoice = new String(bas.toByteArray(),"UTF-8");

      //execute
      Invoice model = transformer.toModel(new ByteArrayInputStream(bas.toByteArray()));
      String invoiceCompare = new String(transformer.fromModel(model),"UTF-8");
      
      Diff xmlDiff = compareXML(invoice, invoiceCompare);
      printOutIfNotIdentical(invoice, invoiceCompare, xmlDiff);
      assertThat(xmlDiff.identical()).as(xmlDiff.toString()).isTrue();
   }


   private void printOutIfNotIdentical(String invoice, String invoiceCompare, Diff xmlDiff) {
      if (!xmlDiff.identical()) {
         System.out.println("Initial Invoice\n" + invoice);
         System.out.println("Second round Marshalling\n" + invoiceCompare);
      }
   }

   @BeforeClass
   public static void setupXMLUnit() {
      XMLUnit.setIgnoreWhitespace(true);
      XMLUnit.setIgnoreAttributeOrder(false);
      XMLUnit.setIgnoreComments(true);
   }
}

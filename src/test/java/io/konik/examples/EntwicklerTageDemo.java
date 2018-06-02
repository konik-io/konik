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

import com.google.common.io.ByteSource;
import io.konik.InvoiceTransformer;
import io.konik.PdfHandler;
import io.konik.validation.InvoiceValidator;
import io.konik.zugferd.Document;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.*;
import io.konik.zugferd.entity.trade.*;
import io.konik.zugferd.entity.trade.item.*;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unqualified.*;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.neovisionaries.i18n.CountryCode.DE;
import static com.neovisionaries.i18n.CurrencyCode.EUR;
import static io.konik.utils.InvoiceLoaderUtils.getSchemaValidator;
import static io.konik.zugferd.profile.ConformanceLevel.BASIC;
import static io.konik.zugferd.unece.codes.DocumentCode._220;
import static io.konik.zugferd.unece.codes.Reference.VA;
import static io.konik.zugferd.unece.codes.UnitOfMeasurement.UNIT;
import static org.apache.commons.lang3.time.DateUtils.addMonths;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The example shows hot to read ZUGFeRD Invoice.
 */
@SuppressWarnings("javadoc")
public class EntwicklerTageDemo {

   Logger log = Logger.getLogger(EntwicklerTageDemo.class.getSimpleName());
   
   ZfDate today = new ZfDateDay();
   ZfDate nextMonth = new ZfDateMonth(addMonths(today, 1));


   InputStream inputPdf = getClass().getResourceAsStream("/acme_invoice-42.pdf");


   // tag::createInvoice[]
   private Document createOrder() {
      Document order = new Document(BASIC);    // <1>
      order.setHeader(new Header()
         .setInvoiceNumber("20151106-42")
         .setCode(_220)
         .setIssued(today)         
         .setName("Bestellung"));
      
      Trade trade = new Trade();
      trade.setAgreement(new Agreement()    // <2>
            .setSeller(new TradeParty()
                  .setName("FeRD Management und Consulting GmbH")
                  .setAddress(new Address("50933", "Stolberger Str. 108a", "Köln", DE))
                  .addTaxRegistrations(new TaxRegistration("DE122...", VA)))
            .setBuyer(new TradeParty()
                  .setName("Bei Spiel GmbH")
                  .setAddress(new Address("12345", "Ecke 12", "Stadthausen", DE))
                  .addTaxRegistrations(new TaxRegistration("DE136695976", VA))));
      
      trade.setDelivery(new Delivery(nextMonth));
      
      trade.setSettlement(new Settlement()
            .setPaymentReference("PER-42")
            .setCurrency(EUR)
            .addPaymentMeans(new PaymentMeans()
               .setPayerAccount(new DebtorFinancialAccount("DE01234.."))
                  .setPayerInstitution(new FinancialInstitution("GENO...")))
            .setMonetarySummation(new MonetarySummation()
               .setLineTotal(new Amount(498, EUR))
               .setChargeTotal(new Amount(0,EUR))
               .setAllowanceTotal(new Amount(0, EUR))
               .setTotalPrepaid(new Amount(0, EUR))
               .setTaxBasisTotal(new Amount(498, EUR))
               .setTaxTotal(new Amount("74.70", EUR))
               .setDuePayable(new Amount("572.70", EUR))
               .setGrandTotal(new Amount("572.70", EUR))));

      ItemTax tax = new ItemTax();
      tax.setPercentage(BigDecimal.valueOf(15));
      tax.setType(TaxCode.VAT);
      
      trade.addItem(new Item()
         .setProduct(new Product().setName("Saddle"))
         .setAgreement(new SpecifiedAgreement().setGrossPrice(new GrossPrice(new Amount(498, EUR))).setNetPrice(new Price(new Amount(498, EUR))))
         .setSettlement(new SpecifiedSettlement().addTradeTax(tax))
         .setDelivery(new SpecifiedDelivery(new Quantity(1, UNIT))));
      order.setTrade(trade);
      
      return order;
   }
   // end::createInvoice[]
   

   
   @Test
   public void creatOrder() throws IOException {
      Document order  = createOrder();

      PdfHandler zfHandler = new PdfHandler();
      zfHandler.appendInvoice(order, inputPdf, new FileOutputStream("target/acme_invoice-42_ZUGFeRD.pdf"));
   }


   @Test
   @Ignore("Missing pdf file")
   public void validateIncomingInvoiceForError() {
      //setup
      PdfHandler zfHandler = new PdfHandler();
      Invoice invoice = zfHandler.extractInvoice(getClass().getResourceAsStream("/Jochen_invoice.pdf"));

      InvoiceValidator invoiceValidator = new InvoiceValidator();   // <1>

      //execute
      Set<ConstraintViolation<Invoice>> violations = invoiceValidator.validate(invoice);   // <2>

      for (ConstraintViolation<Invoice> violation : violations) {
         log.log(Level.INFO, violation.getMessage() + " at: " + violation.getPropertyPath() );
      }
      //verify
      assertThat(violations.size()).isZero();   // <3>
   }



   @Test
   public void compareInvoiceToOrder() {

   }


   @Test
   public void extractBookingRelevantInformation() {

   }

   @Test
   public void validateInvoiceAgainstSchema() throws IOException, SAXException {
      //setup
      Invoice invoice = createOrder();
      InvoiceTransformer transformer = new InvoiceTransformer();

      
      //execute
      byte[] xmlInvoice = transformer.fromModel(invoice);

      //verify
      InputStream is = ByteSource.wrap(xmlInvoice).openBufferedStream();
      getSchemaValidator().validate(new StreamSource(is)); 
   }
   
   
   @Test
   // tag::validateInvoice[]
   public void validateInvoice() {
      //setup
      Invoice invoice = createOrder();
      InvoiceValidator invoiceValidator = new InvoiceValidator();   // <1>

      //execute
      Set<ConstraintViolation<Invoice>> violations = invoiceValidator.validate(invoice);   // <2>

      for (ConstraintViolation<Invoice> violation : violations) {       
        log.log(Level.INFO, violation.getMessage() + " at: " + violation.getPropertyPath() );
      }
      //verify
      assertThat(violations.size()).isZero();   // <3>
   }
   // end::validateInvoice[]

   @Test
   // tag::validateInvoiceWithoutSchema[]
   public void validateInvoiceWithoutSchema() {
     // setup
     Invoice invoice = createOrder();
     InvoiceValidator invoiceValidator = new InvoiceValidator(); // <1>

     // execute
     Set<ConstraintViolation<Invoice>> violations = invoiceValidator.validate(invoice, false); // <2>

     for (ConstraintViolation<Invoice> violation : violations) {
       log.log(Level.INFO, violation.getMessage() + " at: " + violation.getPropertyPath());
     }
     // verify
     assertThat(violations.size()).isZero(); // <3>
   }
   // end::validateInvoiceWithoutSchema[]

   @Test
   // tag::validateInvoiceWithSchema[]
   public void validateInvoiceWithSchema() {
     // setup
     Invoice invoice = createOrder();
     InvoiceValidator invoiceValidator = new InvoiceValidator(); // <1>

     // execute
     Set<ConstraintViolation<Invoice>> violations = invoiceValidator.validate(invoice, true); // <2>

     for (ConstraintViolation<Invoice> violation : violations) {
       log.log(Level.INFO, violation.getMessage() + " at: " + violation.getPropertyPath());
     }
     // verify
     assertThat(violations.size()).isZero(); // <3>
   }
   // end::validateInvoiceWithSchema[]
   
   @Test
   // tag::appendInvoiceToPdf[]
   public void appendInvoiceToPdf() throws IOException {
      Invoice invoice = createOrder();
      PdfHandler handler = new PdfHandler();   // <1>
      InputStream inputPdf = getClass().getResourceAsStream("/acme_invoice-42.pdf");
      OutputStream resultingPdf = new FileOutputStream("target/acme_invoice-42_ZUGFeRD.pdf");
      handler.appendInvoice(invoice, inputPdf, resultingPdf);   // <2>
   }
   // end::appendInvoiceToPdf[]
   
   
   @Test
   // tag::extracInvoiceFromPdf[]
   public void extracInvoiceFromPdf() {
      PdfHandler handler = new PdfHandler();   // <1>
      InputStream inputZugferdPdfStream = getClass().getResourceAsStream("/acme_invoice-42_ZUGFeRD.pdf");
      Invoice invoice = handler.extractInvoice(inputZugferdPdfStream);   // <2>
      assertThat(invoice).isNotNull();
   }
   // end::extracInvoiceFromPdf[]
   
}

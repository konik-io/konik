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
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.*;
import io.konik.zugferd.entity.trade.*;
import io.konik.zugferd.entity.trade.item.*;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unqualified.*;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.neovisionaries.i18n.CountryCode.DE;
import static com.neovisionaries.i18n.CurrencyCode.EUR;
import static io.konik.utils.InvoiceLoaderUtils.getSchemaValidator;
import static io.konik.zugferd.profile.ConformanceLevel.BASIC;
import static io.konik.zugferd.unece.codes.DocumentCode._380;
import static io.konik.zugferd.unece.codes.Reference.FC;
import static io.konik.zugferd.unece.codes.UnitOfMeasurement.UNIT;
import static org.apache.commons.io.FileUtils.openOutputStream;
import static org.apache.commons.lang3.time.DateUtils.addMonths;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The example class shows how easy it is to create a compact invoice.
 */
@SuppressWarnings("javadoc")
public class MinimalInvoice {

   Logger log = Logger.getLogger(MinimalInvoice.class.getSimpleName());

   ZfDate today = new ZfDateDay();
   ZfDate nextMonth = new ZfDateMonth(addMonths(today, 1));

   // tag::createInvoice[]
   private Invoice createInvoice() {

      Invoice invoice = new Invoice(BASIC); // <1>
      invoice
            .setHeader(new Header().setInvoiceNumber("20131122-42").setCode(_380).setIssued(today).setName("Rechnung"));

      Trade trade = new Trade();
      trade.setAgreement(new Agreement() // <2>
            .setSeller(new TradeParty().setName("Seller Inc.")
                  .setAddress(new Address("80331", "Marienplatz 1", "München", DE))
                  .addTaxRegistrations(new TaxRegistration("DE122...", FC)))
            .setBuyer(
                  new TradeParty().setName("Buyer Inc.").setAddress(new Address("50667", "Domkloster 4", "Köln", DE))
                        .addTaxRegistrations(new TaxRegistration("DE123...", FC))));

      trade.setDelivery(new Delivery(nextMonth));

      ItemTax itemTax = new ItemTax();
      itemTax.setPercentage(BigDecimal.valueOf(19));
      itemTax.setType(TaxCode.VAT);

      trade.addItem(new Item().setProduct(new Product().setName("Saddle"))
            .setAgreement(new SpecifiedAgreement().setGrossPrice(new GrossPrice(new Amount(100, EUR)))
                  .setNetPrice(new Price(new Amount(100, EUR))))
            .setSettlement(new SpecifiedSettlement().addTradeTax(itemTax))
            .setDelivery(new SpecifiedDelivery(new Quantity(1, UNIT))));

      trade.setSettlement(new Settlement().setPaymentReference("20131122-42").setCurrency(EUR)
            .addPaymentMeans(new PaymentMeans().setPayerAccount(new DebtorFinancialAccount("DE01234.."))
                  .setPayerInstitution(new FinancialInstitution("GENO...")))
            .setMonetarySummation(
                  new MonetarySummation().setLineTotal(new Amount(100, EUR)).setChargeTotal(new Amount(0, EUR))
                        .setAllowanceTotal(new Amount(0, EUR)).setTaxBasisTotal(new Amount(100, EUR))
                        .setTaxTotal(new Amount(19, EUR)).setDuePayable(new Amount(119, EUR))
                        .setTotalPrepaid(new Amount(0, EUR)).setGrandTotal(new Amount(119, EUR))));

      invoice.setTrade(trade);

      return invoice;
   }
   // end::createInvoice[]

   // tag::transformInvoiceToXml[]
   public void transformInvoiceToXml(Invoice invoice) throws IOException {
      InvoiceTransformer transformer = new InvoiceTransformer(); // <1>
      FileOutputStream outputStream = openOutputStream(new File("build/test-results/pdfs/minimal-invoice.xml"));
      transformer.fromModel(invoice, outputStream); // <2>
   }
   // end::transformInvoiceToXml[]

   @Test
   public void creatMinimalInvoice() throws IOException {
      Invoice invoice = createInvoice();
      transformInvoiceToXml(invoice);
   }

   @Test
   public void validateInvoiceAgainstSchema() throws IOException, SAXException {
      //setup
      Invoice invoice = createInvoice();
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
      Invoice invoice = createInvoice();
      InvoiceValidator invoiceValidator = new InvoiceValidator(); // <1>

      //execute
      Set<ConstraintViolation<Invoice>> violations = invoiceValidator.validate(invoice); // <2>

      for (ConstraintViolation<Invoice> violation : violations) {
         log.log(Level.INFO, violation.getMessage() + " at: " + violation.getPropertyPath());
      }
      //verify
      assertThat(violations.size()).isZero(); // <3>
   }
   // end::validateInvoice[]

   @Test
   // tag::appendInvoiceToPdf[]
   public void appendInvoiceToPdf() throws IOException {
      Invoice invoice = createInvoice();
      PdfHandler handler = new PdfHandler(); // <1>
      InputStream inputPdf = getClass().getResourceAsStream("/acme_invoice-42.pdf");
      OutputStream resultingPdf = openOutputStream(new File("build/test-results/pdfs/acme_invoice-42_ZUGFeRD.pdf"));
      handler.appendInvoice(invoice, inputPdf, resultingPdf); // <2>
   }
   // end::appendInvoiceToPdf[]

   @Test
   // tag::extracInvoiceFromPdf[]
   public void extracInvoiceFromPdf() {
      PdfHandler handler = new PdfHandler(); // <1>
      InputStream inputZugferdPdfStream = getClass().getResourceAsStream("/acme_invoice-42_ZUGFeRD.pdf");
      Invoice invoice = handler.extractInvoice(inputZugferdPdfStream); // <2>
      assertThat(invoice).isNotNull();
   }
   // end::extracInvoiceFromPdf[]

}

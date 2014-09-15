package io.konik;

import static org.assertj.core.api.Assertions.assertThat;
import io.konik.utils.RandomInvoiceGenerator;
import io.konik.zugferd.Invoice;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class PdfHandlerTest {

   PdfHandler pdfHandler;

   @Before
   public void setUp() throws Exception {
      pdfHandler = new PdfHandler();
   }

   @Test
   public void extractInvoice() throws Exception {
      InputStream is = getClass().getResourceAsStream("/Musterrechnung_Einfach_Basic.pdf");

      Invoice invoice = pdfHandler.extractInvoice(is);

      assertThat(invoice).isNotNull();
      assertThat(invoice.getHeader().getInvoiceNumber()).isEqualTo("471102");
   }

   @Test
   public void appendInvoice() throws Exception {
      Invoice invoice = new RandomInvoiceGenerator().generate(Invoice.class);
      InputStream inputPdf = getClass().getResourceAsStream("/Musterrechnung_Einfach_Basic.pdf");
      OutputStream resultingPdf = new FileOutputStream("target/appendInvoiceTestResult.pdf");
      pdfHandler.appendInvoice(invoice, inputPdf, resultingPdf);
   }

}

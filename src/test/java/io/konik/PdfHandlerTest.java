package io.konik;

import static org.assertj.core.api.Assertions.assertThat;
import io.konik.harness.FileExtractor;
import io.konik.utils.RandomInvoiceGenerator;
import io.konik.zugferd.Invoice;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ServiceLoader;

import org.apache.pdfbox.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class PdfHandlerTest {

   PdfHandler pdfHandler;
   FileExtractor fileExtractor;

   @Before
   public void setUp() throws Exception {
      pdfHandler = new PdfHandler();
      this.fileExtractor = ServiceLoader.load(FileExtractor.class).iterator().next();
   }

   @Test
   public void extractInvoice() throws Exception {
      InputStream is = getClass().getResourceAsStream("/Musterrechnung_Einfach_Basic.pdf");

      Invoice invoice = pdfHandler.extractInvoice(is);

      assertThat(invoice).isNotNull();
      assertThat(invoice.getHeader().getInvoiceNumber()).isEqualTo("471102");
      
   }
   
   
   @Test
   public void extractInvoice_lowLevel() throws Exception {
      InputStream is = getClass().getResourceAsStream("/Musterrechnung_Einfach_Basic.pdf");

      InputStream stream = fileExtractor.extractToStream(is);
      
      assertThat(stream).isNotNull();
      String invoice = new String(IOUtils.toByteArray(stream),"UTF-8");
      assertThat(invoice).contains("471102");
      stream.close();
   }

   @Test
   public void appendInvoice() throws Exception {
      Invoice invoice = new RandomInvoiceGenerator().generate(Invoice.class);
      InputStream inputPdf = getClass().getResourceAsStream("/Musterrechnung_Einfach_Basic.pdf");
      OutputStream resultingPdf = new FileOutputStream("target/appendInvoiceTestResult.pdf");
      pdfHandler.appendInvoice(invoice, inputPdf, resultingPdf);
   }

}

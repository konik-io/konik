package io.konik;

import static org.assertj.core.api.Assertions.assertThat;
import io.konik.zugferd.Invoice;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class PdfHandlerTest {

   PdfHandler pdfHandler;
   
   @Before
   public void setUp() throws Exception {
      pdfHandler = new PdfHandler();
   }

//   @Test
//   public void PdfHandlerFileAppenderFileExtractorInvoiceTransformer() throws Exception {
//      throw new RuntimeException("not yet implemented");
//   }
//
//   @Test
//   public void PdfHandler() throws Exception {
//      throw new RuntimeException("not yet implemented");
//   }
//
//   @Test
//   public void attachInvoice() throws Exception {
//      throw new RuntimeException("not yet implemented");
//   }

   @Test
   public void getInvoice() throws Exception {
      InputStream is = getClass().getResourceAsStream("/Musterrechnung_Einfach_Basic.pdf");

      Invoice invoice = pdfHandler.getInvoice(is);
      
      assertThat(invoice).isNotNull();
      assertThat(invoice.getHeader().getInvoiceNumber()).isEqualTo("471102");
   }

}

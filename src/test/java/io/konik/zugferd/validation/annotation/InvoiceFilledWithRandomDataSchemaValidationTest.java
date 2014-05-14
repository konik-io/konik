package io.konik.zugferd.validation.annotation;

import static io.konik.utils.InvoiceTestingUtils.createZfMarshaller;
import static io.konik.utils.InvoiceTestingUtils.getSchemaValidator;
import static org.junit.Assert.assertNotNull;
import io.konik.utils.RandomInvoiceGenerator;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.ObjectFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

import net._01001111.text.LoremIpsum;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.google.common.io.Files;
@SuppressWarnings("javadoc")
public class InvoiceFilledWithRandomDataSchemaValidationTest {
   
   LoremIpsum jlorem = new LoremIpsum();

   @Test
   public void randomXmlDataSchemaValidationTest() throws JAXBException, SAXException, IOException {
      //setup
      Invoice invoice = new RandomInvoiceGenerator().generate();
      
      StringWriter xmlOutcome = new StringWriter();

      //exec
      createZfMarshaller().marshal(new ObjectFactory().createInvoice(invoice), xmlOutcome);
      
      //validate
      String xmlInvoiceString = xmlOutcome.toString();
      assertNotNull(xmlInvoiceString);
      System.out.println(xmlInvoiceString);
      Files.write(xmlInvoiceString, new File("target/random_zf_invoice.xml"), Charset.forName("UTF-8"));

      //validate
      StringReader reader = new StringReader(xmlInvoiceString);
      getSchemaValidator().validate(new StreamSource(reader));
   }

}

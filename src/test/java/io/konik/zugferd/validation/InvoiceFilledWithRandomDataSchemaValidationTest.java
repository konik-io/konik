package io.konik.zugferd.validation;

import static io.konik.invoice.profiles.InvoiceProfiles.BASIC;
import static io.konik.utils.SampleInvoiceUtils.createZfMarshaller;
import static io.konik.utils.SampleInvoiceUtils.getSchemaValidator;
import static org.junit.Assert.assertNotNull;
import io.konik.utils.RandomDataGenerator;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.ObjectFactory;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

import net._01001111.text.LoremIpsum;

import org.junit.Test;
import org.xml.sax.SAXException;

public class InvoiceFilledWithRandomDataSchemaValidationTest {
   
   LoremIpsum jlorem = new LoremIpsum();

   @Test
   public void randomXmlDataSchemaValidationTest() throws JAXBException, SAXException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
      //setup
      Invoice invoice = new Invoice(BASIC);
      new RandomDataGenerator().populteData(invoice);
      
      StringWriter xmlOutcome = new StringWriter();

      //exec
      createZfMarshaller().marshal(new ObjectFactory().createInvoice(invoice), xmlOutcome);
      
      //validate
      String xmlInvoiceString = xmlOutcome.toString();
      assertNotNull(xmlInvoiceString);
//      System.out.println(xmlInvoiceString);

      //validate
      StringReader reader = new StringReader(xmlInvoiceString);
      getSchemaValidator().validate(new StreamSource(reader));
   }

}

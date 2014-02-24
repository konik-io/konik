package io.konik.utils;

import static java.lang.Boolean.TRUE;
import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import static javax.xml.bind.JAXBContext.newInstance;
import static org.apache.commons.lang3.Validate.notNull;
import static org.junit.Assert.assertNotNull;

import java.net.URL;

import io.konik.zugferd.Invoice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class InvoiceTestingUtils {

   public static Invoice generateRandomDateInvoice() {
      Invoice invoice = new Invoice();
      new RandomDataGenerator().populteDataQuite(invoice); 
      return invoice;
   }
   public static Invoice loadInvoice() throws JAXBException{
      Unmarshaller unmarshaller = newInstance("io.konik.zugferd").createUnmarshaller();
      JAXBElement<Invoice> invoice = unmarshaller.unmarshal(loadSampleXmlContent(), Invoice.class);
      assertNotNull(invoice);
      assertNotNull(invoice.getValue());
      return invoice.getValue();
   }
   
   public static Source loadSampleXmlContent() {
      Source source = new StreamSource(InvoiceTestingUtils.class.getResourceAsStream("/ZUGFeRD-invoice.xml"));
      assertNotNull(source);
      return source;
   }
   
   
   public static Validator getSchemaValidator() throws SAXException {
      SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
      URL schemaInvoice = notNull(InvoiceTestingUtils.class.getResource("/zfSchema/Invoice.xsd"));
      Schema invoiceSchema = sf.newSchema(schemaInvoice);
      return invoiceSchema.newValidator();
   }
   
   
   public static Marshaller createZfMarshaller() throws JAXBException {
      Marshaller marshaller = newInstance("io.konik.zugferd").createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, TRUE );
      return marshaller;
   }
   
   public static Unmarshaller createZfUnmarshaller() throws JAXBException {
      return newInstance("io.konik.zugferd").createUnmarshaller();
   }

}

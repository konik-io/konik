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
package io.konik.utils;

import static java.lang.Boolean.TRUE;
import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import static javax.xml.bind.JAXBContext.newInstance;
import static org.apache.commons.lang3.Validate.notNull;
import io.konik.zugferd.Invoice;

import java.net.URL;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
@SuppressWarnings("javadoc")
public class InvoiceLoaderUtils {

   private static final String ZF_1_SCHEMA_XSD = "/zfSchema/ZUGFeRD_1p0.xsd";
   public static final String ZF_MUSTERRECHNUNG_EINFACH_XML = "/Musterrechnung_Einfach.xml";

   public static Invoice generateRandomInvoice() {
      return new RandomInvoiceGenerator().generate(Invoice.class);
   }
   
   
//   public static Invoice loadInvoice() throws JAXBException{
//      Unmarshaller unmarshaller = newInstance("io.konik.zugferd").createUnmarshaller();
//      JAXBElement<Invoice> invoice = unmarshaller.unmarshal(loadZfBasicXmlInvoice(), Invoice.class);
//      assertNotNull(invoice);
//      assertNotNull(invoice.getValue());
//      return invoice.getValue();
//   }
   
//   public static InputStream loadZfBasicXmlInvoiceAsStream() {
//      InputStream is = InvoiceLoaderUtils.class.getResourceAsStream(ZF_MUSTERRECHNUNG_EINFACH_XML);
//      assertNotNull(is);
//      return is;
//   }
   
//   public static Source loadZfBasicXmlInvoice() {
//      Source source = new StreamSource(loadZfBasicXmlInvoiceAsStream());
//      assertNotNull(source);
//      return source;
//   }
   
   
   public static Validator getSchemaValidator() throws SAXException {
      SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
      URL schemaInvoice = notNull(InvoiceLoaderUtils.class.getResource(ZF_1_SCHEMA_XSD));
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

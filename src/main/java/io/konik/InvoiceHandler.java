/* Copyright (C) 2014 konik.io
 *
 * This file is part of the Konik library.
 *
 * The Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * The Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the Konik library. If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import static javax.xml.bind.JAXBContext.newInstance;
import io.konik.exception.KonikInvoiceHandlingException;
import io.konik.zugferd.Invoice;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * The Invoice Handler manages the invoice marshaling and unmarshalling.
 * 
 */
public class InvoiceHandler {

   /**
    * Unmarshall xml input stream to object model.
    * 
    * @param xmlIs the xml input stream
    * @return the invoice model
    */
   public static Invoice unmarshall(InputStream xmlIs) {
      try {
         Unmarshaller unmarshaller = createZfUnmarshaller();
         return unmarshaller.unmarshal(new StreamSource(xmlIs), Invoice.class).getValue();
      } catch (JAXBException e) {
         throw new KonikInvoiceHandlingException("Marshalling error", e);
      }

   }

   /**
    * Marshals the invoice model to xml stream.
    * 
    * @param invoice the invoice model
    * @param output the output stream to write to.
    */
   public static void marshall(Invoice invoice, OutputStream output) {
      try {
         createZfMarshaller().marshal(invoice, output);
      } catch (JAXBException e) {
         throw new KonikInvoiceHandlingException("Marshalling error", e);
      }
   }

   /**
    * Marshals the invoice model to xml byte array
    * 
    * @param invoice the invoice
    * @return the byte[]
    */
   public static byte[] marshall(Invoice invoice) {
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16000);
      marshall(invoice, outputStream);
      return outputStream.toByteArray();
   }

   static Validator getSchemaValidator() throws SAXException {
      SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
      URL schemaInvoice = InvoiceHandler.class.getResource("/zfSchema/Invoice.xsd");
      Schema invoiceSchema = sf.newSchema(schemaInvoice);
      return invoiceSchema.newValidator();
   }

   public static Marshaller createZfMarshaller() throws JAXBException {
      Marshaller marshaller = newInstance("io.konik.zugferd").createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
      return marshaller;
   }

   static Unmarshaller createZfUnmarshaller() throws JAXBException {
      return newInstance("io.konik.zugferd").createUnmarshaller();
   }
}

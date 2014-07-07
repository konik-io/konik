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

import static javax.xml.bind.JAXBContext.newInstance;
import io.konik.exception.TransformationException;
import io.konik.zugferd.Invoice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * Transforms invoices from one representation to another. In other words marshaling and unmarshalling.
 * 
 */
@Named
@Singleton
public class InvoiceTransformer {

   private static final String KONIK_CONTEXT = "io.konik.zugferd";
  
   private final JAXBContext jaxbContext;

   /**
    * Instantiates a default invoice transformer.
    */
   public InvoiceTransformer() {
      try {
         this.jaxbContext = newInstance(KONIK_CONTEXT);
      } catch (JAXBException e) {
         throw new TransformationException("Could not instantiate JaxB Context", e);
      }
   }
   
   /**
    * Instantiates a new invoice transformer providing a JAXB Context
    *
    * @param jaxbContext the JAXB context
    */
   @Inject
   public InvoiceTransformer(JAXBContext jaxbContext) {
      this.jaxbContext = jaxbContext;
   }
   
   /**
    * Transform from XML input stream to the invoice model.
    * 
    * @param xmlInputStream the xml input stream
    * @return the invoice model
    */
   public Invoice toModel(InputStream xmlInputStream) {
      try {
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         return unmarshaller.unmarshal(new StreamSource(xmlInputStream), Invoice.class).getValue();
      } catch (JAXBException e) {
         throw new TransformationException("Marshalling error", e);
      }
   }

   /**
    * Transform from XML content from File to the invoice model.
    * 
    * @param file the file
    * @return the invoice
    */
   @SuppressWarnings("unchecked")
   public Invoice toModel(File file) {
      try {
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         return ((JAXBElement<Invoice>) unmarshaller.unmarshal(file)).getValue();
      } catch (JAXBException e) {
         throw new TransformationException("Marshalling error", e);
      }
   }
   /**
    * Transform from Invoice model to xml byte array.
    * 
    * @param invoice the invoice
    * @return the byte[]
    */
   public byte[] fromModel(Invoice invoice) {
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16000);
      try {
         Marshaller marshaller = createMarshaller();
         marshaller.marshal(invoice, outputStream);
      } catch (JAXBException e) {
         throw new TransformationException("Marshalling error", e);
      }
      return outputStream.toByteArray();
   }
   
   /**
    * Transform from Invoice model to output stream.
    *
    * @param invoice the invoice
    * @param outputStream the output stream
    */
   public void fromModel(Invoice invoice, OutputStream outputStream) {
      try {
         Marshaller marshaller = createMarshaller();
         marshaller.marshal(invoice, outputStream );
      } catch (JAXBException e) {
         throw new TransformationException("Marshalling error", e);
      }
   }



   /**
    * Gets the ZUGFeRD schema Validator.
    * 
    * @return the Schema Validator
    * @throws SAXException the SAX exception
    */
   public Validator getZfSchemaValidator() throws SAXException {
      SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
      URL schemaInvoice = InvoiceTransformer.class.getResource("/zfSchema/ZUGFeRD_1p0.xsd");
      Schema invoiceSchema = sf.newSchema(schemaInvoice);
      return invoiceSchema.newValidator();
   }
   
   
   private Marshaller createMarshaller() throws JAXBException {
       Marshaller marshaller = jaxbContext.createMarshaller();
       marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatXmlOutput());
       return marshaller;
   }

   protected Boolean formatXmlOutput() {
      return Boolean.FALSE;
   }
   
}

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
import io.konik.harness.FileAppender;
import io.konik.harness.FileExtractor;
import io.konik.zugferd.Invoice;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ServiceLoader;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Transforms invoices from one representation to another. In other words marshaling and unmarshalling.
 * 
 */
@Named
@Singleton
public class PdfHandler {

   private static final String MARSHALLING_ERROR = "Marshalling error";

   private static final String KONIK_CONTEXT = "io.konik.zugferd";

   private final JAXBContext jaxbContext;

   private FileAppender fileAppender;
   private FileExtractor fileExtractor;
   private InvoiceTransformer transformer;

   /**
    * Instantiates a new pdf handler.
    *
    * @param fileAppender the file appender
    * @param fileExtractor the file extractor
    * @param transformer the invoice model transformer
    */
   @Inject
   public PdfHandler(FileAppender fileAppender, FileExtractor fileExtractor,InvoiceTransformer transformer) {
      try {
         this.jaxbContext = newInstance(KONIK_CONTEXT);
      } catch (JAXBException e) {
         throw new TransformationException("Could not instantiate JaxB Context", e);
      }
      if (fileAppender == null || fileExtractor == null || transformer == null) {
//         this.fileAppender = ServiceLoader.load(FileAppender.class).iterator().next();
         this.fileExtractor = ServiceLoader.load(FileExtractor.class).iterator().next();
         this.transformer = new InvoiceTransformer();
      } else {
         this.fileAppender = fileAppender;
         this.fileExtractor = fileExtractor;
         this.transformer = transformer;
      }
      
   }

   /**
    * Instantiates a default invoice transformer.
    */
   public PdfHandler() {
      this(null,null,null);
   }

   public void attachInvoice(Invoice invoice){
      
   }
   
   
   /**
    * Gets the invoice.
    *
    * @param pdfFile the pdf file
    * @return the invoice
    * @throws FileNotFoundException the file not found exception
    */
   public Invoice getInvoice(File pdfFile) throws FileNotFoundException {
      byte[] xmlInvoice = fileExtractor.extract(new FileInputStream(pdfFile));
      return transformer.toModel(new ByteArrayInputStream(xmlInvoice));
   }
   
   /**
    * Gets the invoice.
    *
    * @param pdfInputStream the pdf input stream
    * @return the invoice
    */
   public Invoice getInvoice(InputStream pdfInputStream) {
      byte[] xmlInvoice = fileExtractor.extract(pdfInputStream);
      return transformer.toModel(new ByteArrayInputStream(xmlInvoice));
   }
}

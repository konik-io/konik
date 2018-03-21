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

import static java.util.logging.Level.WARNING;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import com.google.common.collect.Lists;
import io.konik.csv.pdf.FileAppenderPriorityComparator;
import io.konik.csv.pdf.FileAppenderPriorityComparator.Order;
import io.konik.harness.FileAppender;
import io.konik.harness.FileExtractor;
import io.konik.harness.appender.DefaultAppendParameter;
import io.konik.harness.exception.InvoiceAppendError;
import io.konik.zugferd.Invoice;

/**
 * Transforms, appends or extracts invoices to PDFs.
 */
@Named
@Singleton
public class PdfHandler {

   private static final Logger LOG = Logger.getLogger(PdfHandler.class.getName());
   
   private final FileAppender fileAppender;
   private final FileExtractor fileExtractor;
   private final InvoiceTransformer transformer;

   /**
    * Instantiates a new PDF handler.
    *
    * @param fileAppender the file appender
    * @param fileExtractor the file extractor
    * @param transformer the invoice model transformer
    */
   @Inject
   public PdfHandler(FileAppender fileAppender, FileExtractor fileExtractor, InvoiceTransformer transformer) {
      this.fileAppender = fileAppender;
      this.fileExtractor = fileExtractor;
      this.transformer = transformer;
   }

   /**
    * Instantiates a default invoice transformer using the Service loader to inject an PDF carriage that should be on the classpath.
    * 
    * If error is thrown check you have a Konik PDF Carriage on the classpath.
    */
   public PdfHandler() {
      Iterator iterator = ServiceLoader.load(FileAppender.class).iterator();
      List<FileAppender> appenders = Lists.<FileAppender>newArrayList(iterator);

      if (appenders.isEmpty()) {
         throw new IllegalStateException("FileAppender implementation not found in the classpath!");
      }

      Collections.sort(appenders, new FileAppenderPriorityComparator(Order.DESC));

      this.fileAppender = appenders.get(0);
      this.fileExtractor = ServiceLoader.load(FileExtractor.class).iterator().next();
      this.transformer = new InvoiceTransformer();
   }

   /**
    * Append an invoice to a PDF.  
    * 
    * The resulting Pdf Output is based on the input PDF, but might be converted to PDF/A-3 when needed.
    * 
    * @param invoice that should be attached to the pdf.
    * @param inputPdf to witch we are going to append the invoice to, input will not be modified
    * @param resultingPdf is the modified copy of the input PDF with the invoice.
    */
   public void appendInvoice(final Invoice invoice, final InputStream inputPdf, final OutputStream resultingPdf) {
      try {
         append(invoice, inputPdf, resultingPdf);
      } catch (IOException e) {
         throw new InvoiceAppendError("Not able to append invoice to PDF", e);
      }
   }

   private void append(final Invoice invoice, final InputStream inputPdf, final OutputStream resultingPdf) throws IOException {
      PipedOutputStream pipedOutputStream = new PipedOutputStream();
      PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream, 65536);
      try {
         String version = invoice.getContext().getGuideline().getVersion().versionAlt();
         String confomanceLevel = invoice.getContext().getGuideline().getConformanceLevel().name();
         transformer.fromModelAsync(invoice, pipedOutputStream);
         DefaultAppendParameter parameter = new DefaultAppendParameter(inputPdf, pipedInputStream, resultingPdf,
               version, confomanceLevel);
         fileAppender.append(parameter);
      } finally {
         pipedInputStream.close();
      }
   }
   
   private void appendSync(final Invoice invoice, final InputStream inputPdf, final OutputStream resultingPdf) {
      String version = invoice.getContext().getGuideline().getVersion().versionAlt();
      String confomanceLevel = invoice.getContext().getGuideline().getConformanceLevel().name();
      byte[] invoiceModel = transformer.fromModel(invoice);
      DefaultAppendParameter parameter = new DefaultAppendParameter(inputPdf, new ByteArrayInputStream(invoiceModel),
            resultingPdf, version, confomanceLevel);
      fileAppender.append(parameter);
   }

   /**
    * Extract invoice from given pdf file
    *
    * @param pdfFile the pdf file containing the ZUGFeRD XML File 
    * @return the transformed ZUGFeRD invoice
    * @throws FileNotFoundException if the pdf is not found 
    */
   public Invoice extractInvoice(File pdfFile) throws FileNotFoundException {
      byte[] xmlInvoice = fileExtractor.extract(new FileInputStream(pdfFile));
      return transformer.toModel(new ByteArrayInputStream(xmlInvoice));
   }

   /**
    * Extract invoice from given pdf stream
    *
    * @param pdfInputStream the pdf input stream
    * @return the transformed ZUGFeRD invoice
    */
   public Invoice extractInvoice(InputStream pdfInputStream) {
      InputStream invoiceInputStream = fileExtractor.extractToStream(pdfInputStream);
      Invoice invoiceModel = transformer.toModel(invoiceInputStream);
      closeQuietly(invoiceInputStream);
      return invoiceModel;
      
   }

   private static void closeQuietly(InputStream stream) {
      try {
         if (stream != null) {
            stream.close();
         }
      }catch(IOException e) {
         LOG.log(WARNING, "Could not close InputStream. This can be a memory leak as the PDF might still be open.", e);
      }
   }
}

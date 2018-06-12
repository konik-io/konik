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
package io.konik.benchmark;

import static com.google.common.io.ByteStreams.toByteArray;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openjdk.jmh.annotations.Mode.Throughput;
import static org.openjdk.jmh.annotations.Scope.Thread;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.junit.Ignore;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.runner.RunnerException;

import com.google.common.io.Files;

import io.konik.InvoiceTransformer;
import io.konik.PdfHandler;
import io.konik.carriage.pdfbox.PDFBoxInvoiceAppender;
import io.konik.harness.FileAppender;
import io.konik.harness.appender.DefaultAppendParameter;
import io.konik.utils.InvoiceLoaderUtils;
import io.konik.zugferd.Invoice;

@State(Thread)
@BenchmarkMode(Throughput)
@OutputTimeUnit(SECONDS)
@SuppressWarnings("javadoc")
public class InvoiceTransformerBenchmark extends DefaultBenchmark {

   private final InvoiceTransformer transformer = new InvoiceTransformer();
   private byte[] invoice;
   private final FileAppender appender = new PDFBoxInvoiceAppender();
   Invoice invoiceModel;
   File tempDir;

   PdfHandler pdfHandler = new PdfHandler();

   @Setup
   public void setup() throws IOException {
      InputStream is = getClass().getResourceAsStream(InvoiceLoaderUtils.ZF_MUSTERRECHNUNG_EINFACH_XML);
      invoice = toByteArray(is);
      invoiceModel = transformer.toModel(new ByteArrayInputStream(invoice));
      assertThat(invoice).isNotNull();
      tempDir = Files.createTempDir();
   }

   //   @Benchmark
   public void xmlToModel() throws Exception {
      transformer.toModel(new ByteArrayInputStream(invoice));
   }

   //   @Benchmark
   public void fromModelAsync() throws Exception {
      transformer.fromModelAsync(invoiceModel,
            new FileOutputStream(new File(tempDir, System.currentTimeMillis() + ".xml")));
   }

   //   @Benchmark
   @Threads(4)
   public void fromModelAsyncThreads() throws Exception {
      transformer.fromModelAsync(invoiceModel,
            new FileOutputStream(new File(tempDir, System.currentTimeMillis() + ".xml")));
   }

   @Benchmark
   @Threads(8)
   public void fromModelToPDF_8Threads() throws Exception {
      final PipedInputStream in = new PipedInputStream();
      final PipedOutputStream out = new PipedOutputStream(in);
      InputStream pdfIn = getClass().getResourceAsStream("/acme_invoice-42.pdf");

      transformer.fromModelAsync(invoiceModel, out);
      appender.append(new DefaultAppendParameter(pdfIn, in, new ByteArrayOutputStream(), "1.0", "TEST"));
   }

   @Benchmark
   @Threads(8)
   public void fromModelToPDFAllinOne_8Threads() throws Exception {
      InputStream pdfIn = getClass().getResourceAsStream("/acme_invoice-42.pdf");
      pdfHandler.appendInvoice(invoiceModel, pdfIn, new ByteArrayOutputStream());
   }

   @Test
   @Ignore
   public void runInvoiceTransformerBenchmark() throws RunnerException {
      runDefault();
   }

}

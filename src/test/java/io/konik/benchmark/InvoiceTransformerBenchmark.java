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
import io.konik.InvoiceTransformer;
import io.konik.utils.InvoiceLoaderUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.RunnerException;

@State(Thread)
@BenchmarkMode(Throughput)
@OutputTimeUnit(SECONDS)
@SuppressWarnings("javadoc")
public class InvoiceTransformerBenchmark extends DefaultBenchmark {

   private final InvoiceTransformer transformer = new InvoiceTransformer();
   private byte[] invoice;
   
   @Setup
   public void setup() throws IOException {
      invoice = toByteArray(InvoiceLoaderUtils.loadZfBasicXmlInvoiceAsStream());
      assertThat(invoice).isNotNull();
   }

   @Benchmark
   public void from_inputStream() throws Exception {
      transformer.toModel(new ByteArrayInputStream(invoice));
   }
   
   @Test
   public void benchmark_iTextPdfInvoiceAppender() throws RunnerException {
      runDefault();
   }

}

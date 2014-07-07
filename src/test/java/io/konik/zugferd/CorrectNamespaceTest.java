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
package io.konik.zugferd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import io.konik.InvoiceTransformer;
import io.konik.utils.RandomInvoiceGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;
@SuppressWarnings("javadoc")
public class CorrectNamespaceTest {
   
   @Test
   public void randomXmlDataSchemaValidationTest() throws IOException {
      //setup
      Invoice invoice = new RandomInvoiceGenerator().generate(Invoice.class);
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      InvoiceTransformer invoiceTransformer = new InvoiceTransformer();

      //exec
      invoiceTransformer.from(invoice, outputStream);
      
      //validate
      String xmlInvoiceString = outputStream.toString("UTF-8");
      assertNotNull(xmlInvoiceString);
      assertThat(xmlInvoiceString).containsOnlyOnce("xmlns:rsm=");
   }

}

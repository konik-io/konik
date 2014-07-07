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
import io.konik.InvoiceTransformer;
import io.konik.utils.RandomInvoiceGenerator;

import java.io.UnsupportedEncodingException;

import org.junit.BeforeClass;
import org.junit.Test;
@SuppressWarnings("javadoc")
public class CorrectNamespacePrefixTest {
   
   static String xmlInvoice;
   
   @BeforeClass
   public static void createRandomInvoiceFile() throws UnsupportedEncodingException {
      Invoice invoice = new RandomInvoiceGenerator().generate(Invoice.class);
      InvoiceTransformer invoiceTransformer = new InvoiceTransformer();
      xmlInvoice = new String(invoiceTransformer.fromModel(invoice),"UTF-8");
      assertThat(xmlInvoice).isNotEmpty();
   }
   @Test
   public void startsWithRsm() {
      assertThat(xmlInvoice).containsOnlyOnce("<rsm:CrossIndustryDocument");
   }

   @Test
   public void invoiceContaisnPrefix_ram() {
      assertThat(xmlInvoice).containsOnlyOnce("xmlns:ram=\"urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12\"");
   }
   
   @Test
   public void invoiceContaisnPrefix_rsm() {
      assertThat(xmlInvoice).containsOnlyOnce("xmlns:rsm=\"urn:ferd:CrossIndustryDocument:invoice:1p0\"");
   }
   
   @Test
   public void invoiceContaisnPrefix_udt() {
      assertThat(xmlInvoice).containsOnlyOnce("xmlns:udt=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:15\"");
   }
}

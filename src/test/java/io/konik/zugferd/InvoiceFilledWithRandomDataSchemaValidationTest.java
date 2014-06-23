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

import static io.konik.utils.InvoiceLoaderUtils.createZfMarshaller;
import static io.konik.utils.InvoiceLoaderUtils.getSchemaValidator;
import static org.junit.Assert.assertNotNull;
import io.konik.utils.RandomInvoiceGenerator;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.ObjectFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

import net._01001111.text.LoremIpsum;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.google.common.io.Files;
@SuppressWarnings("javadoc")
public class InvoiceFilledWithRandomDataSchemaValidationTest {
   
   LoremIpsum jlorem = new LoremIpsum();

   @Test
   public void randomXmlDataSchemaValidationTest() throws JAXBException, SAXException, IOException {
      //setup
      Invoice invoice = new RandomInvoiceGenerator().generate(Invoice.class);
      
      StringWriter xmlOutcome = new StringWriter();

      //exec
      createZfMarshaller().marshal(new ObjectFactory().createInvoice(invoice), xmlOutcome);
      
      //validate
      String xmlInvoiceString = xmlOutcome.toString();
      assertNotNull(xmlInvoiceString);
//      System.out.println(xmlInvoiceString);
      Files.write(xmlInvoiceString, new File("target/random_zf_invoice.xml"), Charset.forName("UTF-8"));

      //validate
      StringReader reader = new StringReader(xmlInvoiceString);
      getSchemaValidator().validate(new StreamSource(reader));
   }

}

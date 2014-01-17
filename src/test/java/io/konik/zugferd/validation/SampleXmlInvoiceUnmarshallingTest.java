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
package io.konik.zugferd.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import io.konik.utils.SampleInvoiceUtils;
import io.konik.zugferd.Invoice;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;

public class SampleXmlInvoiceUnmarshallingTest {

   @Test
   public void unmarshalSampleInvoice() throws JAXBException {
      Unmarshaller unmarshaller = SampleInvoiceUtils.createZfUnmarshaller();
      Source source = new StreamSource(getClass().getResourceAsStream("/ZUGFeRD-invoice.xml"));
      
      Invoice invoice = unmarshaller.unmarshal(source, Invoice.class).getValue();
      assertNotNull(invoice);
      assertEquals("471102", invoice.getHeader().getId().getValue());
   }
}

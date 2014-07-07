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

import static org.junit.Assert.assertTrue;
import io.konik.utils.InvoiceLoaderUtils;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
@SuppressWarnings("javadoc")
public class SampleXmlInvoiceMarshallingTest {

	@Test
	public void marshalSampleInvoice() throws JAXBException {
	   //prep
		Invoice invoice = InvoiceLoaderUtils.loadInvoice();

		Marshaller marshaller = InvoiceLoaderUtils.createZfMarshaller();

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		marshaller.marshal(new ObjectFactory().createInvoice(invoice), os);
		String xmlString = os.toString();

		assertTrue(xmlString.length() > 0);
		// new FileOutputStream("out.xml").write(xmlString.getBytes());
	}
}

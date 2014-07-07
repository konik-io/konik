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

import static io.konik.utils.InvoiceLoaderUtils.getSchemaValidator;
import static org.assertj.core.api.Assertions.assertThat;
import io.konik.utils.InvoiceLoaderUtils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.xml.sax.SAXException;


@SuppressWarnings("javadoc")
public class SampleInvoiceValidationRoundtripTest {
   
   
	@Test
	public void validateExistingInvoiceAginstSchema() throws SAXException, IOException, JAXBException {
		Source xmlSource = InvoiceLoaderUtils.loadZfBasicXmlInvoice();
		Validator validator = InvoiceLoaderUtils.getSchemaValidator();
		validator.validate(xmlSource);
	}

   @Test
   public void unmarshallExistingInvoiceAndValidateOutput() throws SAXException, IOException, JAXBException {
      //setup
      Marshaller marshaller = InvoiceLoaderUtils.createZfMarshaller();
      Invoice invoice = InvoiceLoaderUtils.loadInvoice();

      //exec
      StringWriter stringWriter = new StringWriter(10000);
      marshaller.marshal(invoice, stringWriter);
      //marshaller.marshal(invoice, new File("sample_invoice_out.xml"));

      StringReader reader = new StringReader(stringWriter.toString());
      getSchemaValidator().validate(new StreamSource(reader));
   }
   

   @Test
   public void unmarshallRandomZfInvoice_1() throws SAXException, IOException, JAXBException {
      //setup
      StreamSource source = new StreamSource(getClass().getResourceAsStream("/random_zf_invoice_1.xml"));
      StreamSource sourceCopy = new StreamSource(getClass().getResourceAsStream("/random_zf_invoice_1.xml"));

      //execute
      Unmarshaller unmarshaller = InvoiceLoaderUtils.createZfUnmarshaller();
      Invoice invoice = unmarshaller.unmarshal(sourceCopy,Invoice.class).getValue();
      
      //verify
      assertThat(invoice).isNotNull();
      getSchemaValidator().validate(source);
   }
   
   
}

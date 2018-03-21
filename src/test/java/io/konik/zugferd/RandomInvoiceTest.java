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
import static org.junit.Assert.assertNotNull;
import static org.unitils.reflectionassert.ReflectionComparatorMode.IGNORE_DEFAULTS;
import static org.unitils.reflectionassert.ReflectionComparatorMode.LENIENT_DATES;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.lang3.StringUtils;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import org.xml.sax.SAXException;
import com.google.common.io.Files;
import io.konik.InvoiceTransformer;
import io.konik.PrittyPrintInvoiceTransformer;
import io.konik.utils.RandomInvoiceGenerator;
import io.konik.validation.InvoiceValidator;

@SuppressWarnings("javadoc")
public class RandomInvoiceTest {
   static Charset utf8 = Charset.forName("UTF-8");
   private static final String TARGET_RANDOM_ZF_INVOICE_XML = "target/random_zf_invoice.xml";
   private static final String TARGET_RANDOM_ZF_INVOICE_XML_2ND = "target/random_zf_invoice_2ndrun.xml";

   private final static InvoiceTransformer transformer = new PrittyPrintInvoiceTransformer();
   
   private static Invoice randomInvoice;
   private static String randomInvoiceAsXml;
   private static InvoiceValidator validator;

   @BeforeClass
   public static void setup() {
      initXmlDiff();
      validator = new InvoiceValidator(Validation.buildDefaultValidatorFactory().getValidator(), null);
      createInvoiceContent();
   }

   private static void createInvoiceContent() {
      randomInvoice = new RandomInvoiceGenerator().generate(Invoice.class);
      assertNotNull(randomInvoice);
      byte[] xmlFromModel = transformer.fromModel(randomInvoice);
      randomInvoiceAsXml = new String(xmlFromModel,utf8);
      assertNotNull(randomInvoiceAsXml);
   }

   private static void initXmlDiff() {
      XMLUnit.setIgnoreWhitespace(true);
      XMLUnit.setIgnoreAttributeOrder(false);
      XMLUnit.setIgnoreComments(true);
   }

   @Test
   public void writeRandomInvoiceToFileSystem() throws IOException {
      File xmlInvoiceOutputfile = new File(TARGET_RANDOM_ZF_INVOICE_XML);
      Files.write(randomInvoiceAsXml, xmlInvoiceOutputfile, utf8);
      String firstLine = Files.readFirstLine(xmlInvoiceOutputfile, utf8);
      assertThat(firstLine).startsWith("<?xml version=");
   }
   
   @Test
   public void validateRandomInvoiceAgainstSchema() throws  SAXException, IOException {
      //validate
      StringReader reader = new StringReader(randomInvoiceAsXml);
      getSchemaValidator().validate(new StreamSource(reader));
   }

   @Test
//   @Ignore("Until Random Generator is correct.")
   public void validateRandomInvoice(){
      //setup
//      Class<?>[] validationGroups = InvoiceValidator.resolveIntoValidationGroups(invoice.getContext().getGuideline().getConformanceLevel());

      //execute
      Set<ConstraintViolation<Invoice>> validationResult = validator.validate(randomInvoice);
      
      //verify
      if (!validationResult.isEmpty()) {
         System.out.println("Validation Errors:"); 
         for (ConstraintViolation<Invoice> constraintViolation : validationResult) {
            String left = StringUtils.rightPad(constraintViolation.getPropertyPath().toString(), 100);
          System.out.println(left + constraintViolation.getMessage() + " invalid value is: " + constraintViolation.getInvalidValue()); 
         }
         assertThat(validationResult).as("See System out for details").isEmpty();
      }
   }

   
   @Test
   public void compareXMLFileForDifferences() throws SAXException, IOException {
      Invoice controlInvoice = transformer.toModel(new ByteArrayInputStream(randomInvoiceAsXml.getBytes()));
      byte[] toModel = transformer.fromModel(controlInvoice);
      Files.write(toModel, new File(TARGET_RANDOM_ZF_INVOICE_XML_2ND));
      String controlInvoiceAsXml = new String(toModel,utf8);
      
      //Verify
      Diff diff = new Diff(randomInvoiceAsXml, controlInvoiceAsXml);
      assertThat(diff.identical()).as(diff.toString()).isTrue();
   }
   
   
   @Test
   @Ignore("rounding is indicated as error")
   public void compareInvoiceModels()  {
      Invoice invoice2 = transformer.toModel(new ByteArrayInputStream(randomInvoiceAsXml.getBytes()));
      ReflectionAssert.assertReflectionEquals(randomInvoice,invoice2,IGNORE_DEFAULTS,LENIENT_DATES);
   }
   

}

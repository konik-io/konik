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

import static com.google.common.io.Files.getFileExtension;
import static io.konik.validation.InvoiceValidator.resolveIntoValidationGroups;
import static java.nio.charset.Charset.forName;
import static org.assertj.core.api.Assertions.assertThat;
import io.konik.InvoiceTransformer;
import io.konik.PrittyPrintInvoiceTransformer;
import io.konik.utils.InvoiceLoaderUtils;
import io.konik.utils.NumberDifferenceXmlComparisson;
import io.konik.validator.NotBlankValidator;
import io.konik.zugferd.profile.Profile;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

@SuppressWarnings("javadoc")
@RunWith(Parameterized.class)
public class AllSampleXmlInvoicesTest {
   
   private static final String TEST_FILE_LOCATION = "src/test/resources";

   private static final String UTF_8 = "UTF-8";

   private static Validator validator;

   @Parameter
   public File testFile;
   
   @Parameter(value=1)
   public String testFileName;
   
   InvoiceTransformer transformer = new PrittyPrintInvoiceTransformer();
   
   @BeforeClass
   public static void setup() {
      XMLUnit.setIgnoreWhitespace(true);
      XMLUnit.setIgnoreAttributeOrder(false);
      XMLUnit.setIgnoreComments(true);
      //validator
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      NotBlankValidator notBlankValidator = factory.getConstraintValidatorFactory().getInstance(NotBlankValidator.class);
      assertThat(notBlankValidator).isNotNull();
      validator = factory.getValidator();
   }
   
   @Parameters(name = "{1}")
   public static Iterable<Object[]> findAllInvoiceXMlFiles() {
      Collection<Object[]> result = Lists.newArrayList();
      File xmlDir = new File(TEST_FILE_LOCATION);
      Iterable<File> traversal = Files.fileTreeTraverser().children(xmlDir);
      for (File file : traversal) {
         if (file.isFile() && getFileExtension(file.getName()).equals("xml")){
            result.add(new Object[]{file,file.getName()});
         }
      }
      return result;
   }

   @Test
   public void unmarshalInvoice() {
      //execute
      Invoice invoice = transformer.toModel(testFile);

      //verify
      assertThat(invoice).isNotNull();
   }

   @Test
   public void validateInvoiceAgainstSchema() throws SAXException, IOException {
      InvoiceLoaderUtils.getSchemaValidator().validate(new StreamSource(testFile));
   }
   
   @Test
   public void validateInvoiceModel() {
      //setup
      Invoice invoice = transformer.toModel(testFile);
      Profile profile = invoice.getContext().getGuideline();
      Class<?>[] validationGroups = resolveIntoValidationGroups(profile);

      //execute
      Set<ConstraintViolation<Invoice>> validationResult = validator.validate(invoice,validationGroups);
      
      //verify
      if (!validationResult.isEmpty()) {
         ConstraintViolation<Invoice> violation = validationResult.iterator().next();
//         assertThat(validationResult).as(violation.getMessage()+"value %s, path %s",violation.getInvalidValue(),violation.getPropertyPath().toString()).isEmpty();
         assertThat(validationResult).as(violation.getMessage()).isEmpty();
      }
   }



   @Test
   public void marshallBackInvoiceModelAndDiffXml() throws Exception {
      //setup
      String testFileContent = Files.toString(testFile, forName(UTF_8));
      Invoice model = transformer.toModel(testFile);
      

      //execute 
      byte[] invoiceAsByteArray = transformer.fromModel(model);
      
      //verify
      String remarshalledInvoice = new String(invoiceAsByteArray,UTF_8);
      Files.write(remarshalledInvoice.getBytes(), new File("./target/test_"+testFileName));
//      System.out.println(remarshalledInvoice);
      Diff diff = new Diff(testFileContent, remarshalledInvoice);
      diff. overrideDifferenceListener(new NumberDifferenceXmlComparisson());
      XMLAssert.assertXMLEqual(diff, true);
  }
}

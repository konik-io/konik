package io.konik.zugferd;

import static java.nio.charset.Charset.forName;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xml.sax.SAXException;

import com.google.common.io.Files;

import io.konik.InvoiceTransformer;
import io.konik.PrittyPrintInvoiceTransformer;
import io.konik.utils.NumberDifferenceXmlComparison;
import io.konik.validation.InvoiceValidator;

@RunWith(Parameterized.class)
public class ZugferdSpecificExamplesTest {

   private static final String ROOT = "src/test/resources/zugferd_examples/";

   @Parameterized.Parameters(name = "Invoice {0} has {1} error(s)")
   public static Collection<Object[]> getData() {
      return Arrays.asList(new Object[][] { { "ZUGFeRD_1p0_COMFORT_Einfach_Original.xml", 0 },
            { "ZUGFeRD_1p0_EXTENDED_Warenrechnung.xml", 2 }, { "large_zugferd_invoice.xml", 5 },
            { "duePayable.xml", 0 }, { "productName.xml", 1 }, { "totalAllowanceCharge.xml", 5 },
            { "totalAllowanceCharge2.xml", 0 }, { "totalAllowanceChargeWithDiscountAndSurcharge.xml", 0 },
            { "totalAllowanceChargeWithDiscountAndSurchargeWithMissingTotalAllowanceCharge.xml", 1 }, });
   }

   @Parameterized.Parameter
   public String file;

   @Parameterized.Parameter(1)
   public int expectedNumberOfErrors;

   InvoiceTransformer transformer = new PrittyPrintInvoiceTransformer();

   private static File stringFileNameToFile(String name) {
      return new File(ROOT + name);
   }

   @BeforeClass
   public static void setup() {
      XMLUnit.setIgnoreWhitespace(true);
      XMLUnit.setIgnoreAttributeOrder(false);
      XMLUnit.setIgnoreComments(true);
   }

   @Test
   public void unmarshalInvoice() {
      //execute
      Invoice invoice = transformer.toModel(stringFileNameToFile(file));

      //verify
      assertThat(invoice).isNotNull();
   }

   @Test
   public void validateInvoiceAgainstSchema() throws SAXException, IOException {
      transformer.getZfSchemaValidator().validate(new StreamSource(stringFileNameToFile(file)));
   }

   @Test
   public void validateInvoiceAndCompareWithExpectedNumberOfErrors() {
      //setup:
      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(stringFileNameToFile(file));
      InvoiceValidator invoiceValidator = new InvoiceValidator();

      //when:
      Set<ConstraintViolation<Invoice>> validationResult = invoiceValidator.validate(invoice);

      //then:
      printErrorsIfPresent(validationResult);
      assertThat(validationResult).hasSize(expectedNumberOfErrors);
   }

   @Test
   public void marshallBackInvoiceModelAndDiffXml() throws Exception {
      //setup:
      File testFile = stringFileNameToFile(file);
      String testFileContent = Files.toString(testFile, forName("UTF-8"));
      Invoice model = transformer.toModel(testFile);

      //when:
      byte[] invoiceAsByteArray = transformer.fromModel(model);

      //then:
      String remarshalledInvoice = new String(invoiceAsByteArray, "UTF-8");
      Files.write(remarshalledInvoice.getBytes(), new File("./target/test_" + file));
      Diff diff = new Diff(testFileContent, remarshalledInvoice);
      diff.overrideDifferenceListener(new NumberDifferenceXmlComparison());
      XMLAssert.assertXMLEqual(diff, true);
   }

   private static void printErrorsIfPresent(final Set<ConstraintViolation<Invoice>> constraintViolations) {
      if (constraintViolations != null) {
         for (ConstraintViolation<Invoice> constraintViolation : constraintViolations) {
            System.out.printf("%-60s: %s | Invalid value: %s%n", constraintViolation.getPropertyPath(),
                  constraintViolation.getMessage(), constraintViolation.getInvalidValue());
         }
      }
   }
}

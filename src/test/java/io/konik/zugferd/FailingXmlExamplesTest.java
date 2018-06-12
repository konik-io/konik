package io.konik.zugferd;

import static io.konik.validation.InvoiceValidator.resolveIntoValidationGroups;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import io.konik.InvoiceTransformer;
import io.konik.PrittyPrintInvoiceTransformer;
import io.konik.validator.NullableNotBlankValidator;
import io.konik.zugferd.profile.ConformanceLevel;

@RunWith(Parameterized.class)
public class FailingXmlExamplesTest {

   private static final String SAMPLES_DIR = "/fail_samples/";

   private static Validator validator;

   @Parameter(value = 0)
   public String xmlFileName;

   private InvoiceTransformer transformer = new PrittyPrintInvoiceTransformer();

   @Parameters(name = "{0}")
   public static Iterable<String[]> getAllIncorrectXmlFiles() {
      List<String[]> files = new LinkedList<String[]>();
      files.add(new String[] { "RE-20151029_4.Bestellung.xml" });
      files.add(new String[] { "RE-20151029_4.xml" });
      return files;
   }

   @BeforeClass
   public static void setup() {
      XMLUnit.setIgnoreWhitespace(true);
      XMLUnit.setIgnoreAttributeOrder(false);
      XMLUnit.setIgnoreComments(true);

      //validator
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      NullableNotBlankValidator notBlankValidator = factory.getConstraintValidatorFactory()
            .getInstance(NullableNotBlankValidator.class);
      assertThat(notBlankValidator).isNotNull();
      validator = factory.getValidator();
   }

   @Test
   public void validateIncorrectXmlFiles() {
      //given:
      InputStream xml = getClass().getResourceAsStream(SAMPLES_DIR + xmlFileName);

      //when:
      Invoice invoice = transformer.toModel(xml);
      ConformanceLevel conformanceLevel = invoice.getContext().getGuideline().getConformanceLevel();
      Class<?>[] validationGroups = resolveIntoValidationGroups(conformanceLevel);
      Set<ConstraintViolation<Invoice>> validationResult = validator.validate(invoice, validationGroups);

      //then:
      for (ConstraintViolation<Invoice> violation : validationResult) {
         System.out.println(violation.toString());
      }

      assertThat(validationResult).isNotEmpty();
   }
}

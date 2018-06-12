package io.konik.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.groups.Default;

import org.apache.bval.jsr.DefaultMessageInterpolator;
import org.junit.Test;

import io.konik.InvoiceTransformer;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.Invoice;

public class MonetarySummationValidatorTest {

   @Test
   public void shouldNotComplaintAboutCorrectInvoiceMonetarySummation() {
      //given:
      InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges.xml");
      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(xml);
      MonetarySummationValidator validator = new MonetarySummationValidator(new DefaultMessageInterpolator());

      //when:
      Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice,
            new Class[] { Default.class, Comfort.class, Extended.class });

      //then:
      assertThat(violations).isEmpty();
   }

   @Test
   public void shouldComplainAboutIncorrectMonetarySummation() {
      //given:
      InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges_with_errors.xml");
      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(xml);
      MonetarySummationValidator validator = new MonetarySummationValidator(new DefaultMessageInterpolator());

      //when:
      Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice,
            new Class[] { Default.class, Comfort.class, Extended.class });

      //then:
      for (ConstraintViolation<Invoice> violation : violations) {
         System.out.printf("%-70s: %s%n", violation.getPropertyPath().toString(), violation.getMessage());
      }

      assertThat(violations).hasSize(1);

      assertThat(violations.iterator().next().getMessage()).contains("[202.70]");
      assertThat(violations.iterator().next().getInvalidValue()).isEqualTo(new BigDecimal("202.71"));

      assertThat(violations.iterator().next().getPropertyPath().toString())
            .isEqualTo("trade.settlement.monetarySummation.lineTotal");
   }

   @Test
   public void shouldValidateInvoiceExample3() {
      //given:
      InputStream xml = getClass()
            .getResourceAsStream("/ZUGFeRD_Invoice_monetary_summation_recalculation_failed_input.xml");
      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(xml);
      MonetarySummationValidator validator = new MonetarySummationValidator(new DefaultMessageInterpolator());

      //when:
      Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice,
            new Class[] { Default.class, Comfort.class, Extended.class });

      //then:
      for (ConstraintViolation<Invoice> violation : violations) {
         System.out.printf("%-70s: %s%n", violation.getPropertyPath().toString(), violation.getMessage());
      }
      assertThat(violations).hasSize(0);

   }

   @Test
   public void shouldValidateInvoiceExample4() {
      //given:
      InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_navision_calculation_error.xml");
      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(xml);
      MonetarySummationValidator validator = new MonetarySummationValidator(new DefaultMessageInterpolator());

      //when:
      Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice,
            new Class[] { Default.class, Comfort.class, Extended.class });

      //then:
      for (ConstraintViolation<Invoice> violation : violations) {
         System.out.printf("%-70s: %s%n", violation.getPropertyPath().toString(), violation.getMessage());
      }
      assertThat(violations).hasSize(2);

   }

   @Test
   public void shouldValidateInvoiceAllowanceChargeTotalIncludingItemQuantity() {
      //given:
      InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_navision_discounts_error.xml");
      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(xml);
      MonetarySummationValidator validator = new MonetarySummationValidator(new DefaultMessageInterpolator());

      //when:
      Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice,
            new Class[] { Default.class, Comfort.class, Extended.class });

      //then:
      for (ConstraintViolation<Invoice> violation : violations) {
         System.out.printf("%-70s: %s%n", violation.getPropertyPath().toString(), violation.getMessage());
      }
      assertThat(violations).hasSize(0);

   }

}
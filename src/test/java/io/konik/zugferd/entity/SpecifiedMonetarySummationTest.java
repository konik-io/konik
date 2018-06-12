package io.konik.zugferd.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Test;

import com.neovisionaries.i18n.CurrencyCode;

import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.util.TestValidatorFactory;

@SuppressWarnings("javadoc")
public class SpecifiedMonetarySummationTest extends TestValidatorFactory {

   private static Validator validator = TestValidatorFactory.getValidator();

   @Test
   public void validate() {
      SpecifiedMonetarySummation summation = new SpecifiedMonetarySummation();
      summation.setLineTotal(new Amount("0.00", CurrencyCode.EUR));
      summation.setTotalAllowanceCharge(new Amount("0.00", CurrencyCode.EUR));
      Set<ConstraintViolation<SpecifiedMonetarySummation>> validationResult = validator.validate(summation);
      assertThat(validationResult.isEmpty()).isTrue();
   }
}

package io.konik.zugferd.util;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import io.konik.validator.NullableNotBlankValidator;
import io.konik.validator.ValidFinancialAccountValidator;

@SuppressWarnings("javadoc")
public class TestValidatorFactory {

   public static Validator getValidator() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      assertThat(factory.getConstraintValidatorFactory().getInstance(NullableNotBlankValidator.class)).isNotNull();
      assertThat(factory.getConstraintValidatorFactory().getInstance(ValidFinancialAccountValidator.class)).isNotNull();
      Validator validator = factory.getValidator();
      return validator;
   }
}

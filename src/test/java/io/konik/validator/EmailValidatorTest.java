package io.konik.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class EmailValidatorTest {

   @Test
   public void isValidWithPlus() throws Exception {
      EmailValidator emailValidator = new EmailValidator();
      boolean valid = emailValidator.isValid("Foo.Bar+1106sk@gmail.com", null);
      assertThat(valid).isTrue();
   }

   @Test
   public void isValidWithUpperCase() throws Exception {
      EmailValidator emailValidator = new EmailValidator();
      boolean valid = emailValidator.isValid("vb+spamprotect@gmail.com", null);
      assertThat(valid).isTrue();
   }

   @Test
   public void isValidWithTwoDomain() throws Exception {
      EmailValidator emailValidator = new EmailValidator();
      boolean valid = emailValidator.isValid("v@test.io", null);
      assertThat(valid).isTrue();
   }

}

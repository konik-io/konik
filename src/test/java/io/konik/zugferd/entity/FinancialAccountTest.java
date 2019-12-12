package io.konik.zugferd.entity;

import io.konik.zugferd.util.TestValidatorFactory;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("javadoc")
public class FinancialAccountTest extends TestValidatorFactory {

   private static Validator validator = TestValidatorFactory.getValidator();

   @Test
   public void validateHasIban() {
      FinancialAccount account = new CreditorFinancialAccount("iban");
      Set<ConstraintViolation<FinancialAccount>> validationResult = validator.validate(account);
      assertThat(validationResult.isEmpty()).isTrue();
   }

   @Test
   public void validateHasPropiataryId() {
      FinancialAccount account = new CreditorFinancialAccount();
      account.setProprietaryId("Prop ID");
      Set<ConstraintViolation<FinancialAccount>> validationResult = validator.validate(account);
      assertThat(validationResult.isEmpty()).isTrue();
   }

   @Test
   public void validateDebtorHasNoValidateIbanOrPropiataryId() {
      FinancialAccount account = new DebtorFinancialAccount();
      Set<ConstraintViolation<FinancialAccount>> validationResult = validator.validate(account);
      assertThat(validationResult.isEmpty()).isFalse();
      assertThat(validationResult.size()).isEqualTo(1);
   }

   @Test
   public void validateCreditorHasNoIbanOrPropiataryId() {
      FinancialAccount account = new CreditorFinancialAccount();
      Set<ConstraintViolation<FinancialAccount>> validationResult = validator.validate(account);
      assertThat(validationResult.isEmpty()).isFalse();
      assertThat(validationResult.size()).isEqualTo(1);
   }
}

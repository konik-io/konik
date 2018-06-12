package io.konik.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import com.neovisionaries.i18n.CurrencyCode;

import io.konik.zugferd.unqualified.Amount;

public class AmountsTest {

   @Test(expected = IllegalArgumentException.class)
   public void shouldThrowIllegalArgumentExceptionIfFirstAmountIsNull() {
      //when:
      Amounts.add(null, null);
   }

   @Test(expected = IllegalArgumentException.class)
   public void shouldThrowIllegalArgumentExceptionIfAmountsHaveDifferentCurrencies() {
      //when:
      Amounts.add(Amounts.zero(CurrencyCode.USD), Amounts.zero(CurrencyCode.EUR));
   }

   @Test
   public void shouldTreatNullValueAsZeroWhenAddingToNonNullAmountAsAFirstParameter() {
      //given:
      Amount amount = new Amount(BigDecimal.valueOf(43.55), CurrencyCode.USD);
      //when:
      Amount result = Amounts.add(amount, null);
      //then:
      assertThat(result).isEqualToComparingFieldByField(amount);
   }

   @Test
   public void shouldTreatNullValueAsZeroWhenAddingToNonNullAmountAsASecondParameter() {
      //given:
      Amount amount = new Amount(BigDecimal.valueOf(43.55), CurrencyCode.USD);
      //when:
      Amount result = Amounts.add(null, amount);
      //then:
      assertThat(result).isEqualToComparingFieldByField(amount);
   }
}
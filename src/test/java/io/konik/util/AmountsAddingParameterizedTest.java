package io.konik.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.neovisionaries.i18n.CurrencyCode;

import io.konik.zugferd.unqualified.Amount;

@RunWith(Parameterized.class)
public class AmountsAddingParameterizedTest {

   private static final CurrencyCode CURRENCY = CurrencyCode.USD;

   @Parameters(name = "Case {index}: {0} + {1} = {2}")
   public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] { { BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO },
            { BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE },
            { BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(10), BigDecimal.valueOf(-100), BigDecimal.valueOf(-90) },
            { BigDecimal.valueOf(2.34), BigDecimal.valueOf(3.11), BigDecimal.valueOf(5.45) } });
   }

   @Parameter
   public BigDecimal first;

   @Parameter(1)
   public BigDecimal second;

   @Parameter(2)
   public BigDecimal result;

   @Test
   public void test() {
      assertThat(Amounts.add(new Amount(first, CURRENCY), new Amount(second, CURRENCY)))
            .isEqualToComparingFieldByField(new Amount(result, CURRENCY));
   }
}
package io.konik.util;

import static java.math.BigDecimal.valueOf;
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
public class AmountsNegationTest {

   @Parameters(name = "Case {index}: negation of {0} USD is {1} USD")
   public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] { { BigDecimal.ZERO, BigDecimal.ZERO }, { valueOf(10), valueOf(-10) },
            { valueOf(1), valueOf(-1) }, { valueOf(-0.002), valueOf(0.002) },
            { valueOf(-421.233), valueOf(421.233) } });
   }

   @Parameter
   public BigDecimal input;

   @Parameter(1)
   public BigDecimal expectedResult;

   @Test
   public void test() {
      assertThat(Amounts.negate(new Amount(input, CurrencyCode.USD)))
            .isEqualToComparingFieldByField(new Amount(expectedResult, CurrencyCode.USD));
   }
}
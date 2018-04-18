package io.konik.validation;

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

import io.konik.validation.AmountCalculator.InvoiceAllowanceTotalCalculator;
import io.konik.zugferd.entity.SpecifiedAllowanceCharge;
import io.konik.zugferd.entity.trade.Settlement;
import io.konik.zugferd.unqualified.Amount;

@RunWith(Parameterized.class)
public class InvoiceAllowanceTotalCalculatorTest {

   private static final CurrencyCode CURRENCY = CurrencyCode.USD;

   @Parameters(name = "Calculating allowance total for case {index}: expected {0}")
   public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] { { BigDecimal.ZERO, new SpecifiedAllowanceCharge[] {} },
            { BigDecimal.valueOf(2.23), new SpecifiedAllowanceCharge[] { chargeActual(BigDecimal.valueOf(2.23)) } },
            { BigDecimal.valueOf(14.54), new SpecifiedAllowanceCharge[] { chargeActual(BigDecimal.valueOf(10.43)),
                  chargeActual(BigDecimal.valueOf(4.11)) } } });
   }

   @Parameter
   public BigDecimal expectedAllowanceTotal;

   @Parameter(1)
   public SpecifiedAllowanceCharge[] charges;

   @Test
   public void test() {
      //given:
      Settlement settlement = new Settlement();
      for (SpecifiedAllowanceCharge charge : charges) {
         settlement.addAllowanceCharge(charge);
      }
      InvoiceAllowanceTotalCalculator calculator = new InvoiceAllowanceTotalCalculator();
      //when:
      Amount amount = calculator.apply(settlement);
      //then:
      assertThat(amount.getValue()).isEqualByComparingTo(expectedAllowanceTotal);
   }

   private static SpecifiedAllowanceCharge chargeActual(BigDecimal value) {
      SpecifiedAllowanceCharge charge = new SpecifiedAllowanceCharge();
      charge.setActual(new Amount(value, CURRENCY));
      charge.setDiscount();
      return charge;
   }
}
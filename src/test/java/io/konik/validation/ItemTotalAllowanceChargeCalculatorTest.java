package io.konik.validation;

import com.neovisionaries.i18n.CurrencyCode;
import io.konik.util.Amounts;
import io.konik.zugferd.entity.AllowanceCharge;
import io.konik.zugferd.entity.GrossPrice;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.SpecifiedAgreement;
import io.konik.zugferd.unqualified.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static io.konik.validation.AmountCalculator.ItemTotalAllowanceChargeCalculator;
import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ItemTotalAllowanceChargeCalculatorTest {

   private static final CurrencyCode CURRENCY_CODE = CurrencyCode.USD;
   private static final Random RANDOM = new Random();

   @Parameters(name = "Calculating expected total allowance charge = {0} USD")
   public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] {
            { BigDecimal.ZERO, new AllowanceCharge[] {} },
            { valueOf(1), new AllowanceCharge[] { charge(valueOf(1)) } },
            { valueOf(5.23), new AllowanceCharge[] { charge(valueOf(0.23)), charge(valueOf(2.00)), charge(valueOf(1.5)),
                  charge(valueOf(1.5)) } },
            { valueOf(2), new AllowanceCharge[] { charge(valueOf(5.01)), charge(valueOf(-3.01)) } }
      });
   }

   @Parameter
   public BigDecimal expectedTotalAllowanceCharge;

   @Parameter(1)
   public AllowanceCharge[] allowanceCharges;

   @Test
   public void test() {
      //given:
      Item item = createItem();
      ItemTotalAllowanceChargeCalculator calculator = new ItemTotalAllowanceChargeCalculator(CURRENCY_CODE);

      //when:
      Amount totalAllowanceCharge = calculator.apply(item);

      //then:
      assertThat(totalAllowanceCharge.getValue())
            .isEqualByComparingTo(expectedTotalAllowanceCharge);
   }

   private Item createItem() {
      Item item = new Item();
      GrossPrice grossPrice = new GrossPrice(Amounts.zero(CURRENCY_CODE));
      grossPrice.addAllowanceCharge(allowanceCharges);

      SpecifiedAgreement agreement = new SpecifiedAgreement();
      agreement.setGrossPrice(grossPrice);

      item.setAgreement(agreement);
      return item;
   }

   private static AllowanceCharge charge(final BigDecimal value) {
      AllowanceCharge charge = new AllowanceCharge();
      charge.setActual(new Amount(value.abs(), CURRENCY_CODE));

      if (value.signum() < 0) {
         charge.setDiscount();
      } else {
         charge.setSurcharge();
      }
      return charge;
   }
}
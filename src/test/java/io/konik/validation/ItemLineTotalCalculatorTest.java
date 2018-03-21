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

import io.konik.validation.AmountCalculator.ItemLineTotalCalculator;
import io.konik.zugferd.entity.GrossPrice;
import io.konik.zugferd.entity.Price;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.SpecifiedAgreement;
import io.konik.zugferd.entity.trade.item.SpecifiedDelivery;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Quantity;

@RunWith(Parameterized.class)
public class ItemLineTotalCalculatorTest {

	private static final CurrencyCode CURRENCY = CurrencyCode.USD;

	@Parameters(name = "Calculating line total for case {index}: {0} USD x {1} = {2} USD")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{ BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE },
				{ BigDecimal.valueOf(9.99), BigDecimal.ONE, BigDecimal.valueOf(9.99) },
				{ BigDecimal.valueOf(0.43), BigDecimal.valueOf(25), BigDecimal.valueOf(10.75) }
		});
	}

	@Parameter
	public BigDecimal netPrice;

	@Parameter(1)
	public BigDecimal quantity;

	@Parameter(2)
	public BigDecimal expectedLineTotal;

	@Test
	public void test() {
		//given:
		Item item = createItem();
		ItemLineTotalCalculator calculator = new ItemLineTotalCalculator();

		//when:
		Amount amount = calculator.apply(item);

		//then:
		assertThat(amount.getValue()).isEqualByComparingTo(expectedLineTotal);
	}

	private Item createItem() {
		Item item = new Item();

		SpecifiedDelivery delivery = new SpecifiedDelivery();
		delivery.setBilled(new Quantity(quantity, UnitOfMeasurement.UNIT));

		SpecifiedAgreement agreement = new SpecifiedAgreement();
		agreement.setGrossPrice(new GrossPrice(new Amount(netPrice, CURRENCY)));
		agreement.setNetPrice(new Price(new Amount(netPrice, CURRENCY)));

		item.setDelivery(delivery);
		item.setAgreement(agreement);
		return item;
	}
}
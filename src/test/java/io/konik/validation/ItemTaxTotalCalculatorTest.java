package io.konik.validation;

import com.neovisionaries.i18n.CurrencyCode;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.ItemTax;
import io.konik.zugferd.entity.trade.item.SpecifiedSettlement;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unqualified.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static io.konik.validation.AmountCalculator.ItemTaxTotalCalculator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ItemTaxTotalCalculatorTest {

	private static final CurrencyCode CURRENCY_CODE = CurrencyCode.USD;

	@Parameters(name = "Calculating tax amount for case {index}: {0} * {1}% = {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{ BigDecimal.valueOf(100), BigDecimal.valueOf(23), BigDecimal.valueOf(23) },
				{ BigDecimal.valueOf(99), BigDecimal.ZERO, BigDecimal.ZERO },
				{ BigDecimal.valueOf(43.12), BigDecimal.valueOf(8), BigDecimal.valueOf(3.45) }
		});
	}

	@Parameter
	public BigDecimal lineTotal;

	@Parameter(1)
	public BigDecimal taxPercentage;

	@Parameter(2)
	public BigDecimal expectedTaxAmount;

	@Test
	public void test() {
		//given:
		Item item = createItem();
		ItemTaxTotalCalculator calculator = new ItemTaxTotalCalculator(new Amount(lineTotal, CURRENCY_CODE));

		//when:
		Amount taxTotal = calculator.apply(item);

		//then:
		assertThat(taxTotal.getValue()).isEqualByComparingTo(expectedTaxAmount);
	}

	private Item createItem() {
		Item item = new Item();

		ItemTax tax = new ItemTax();
		tax.setPercentage(taxPercentage);
		tax.setType(TaxCode.VAT);

		SpecifiedSettlement settlement = new SpecifiedSettlement();
		settlement.addTradeTax(tax);

		item.setSettlement(settlement);
		return item;
	}
}
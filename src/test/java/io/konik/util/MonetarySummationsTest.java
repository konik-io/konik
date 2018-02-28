package io.konik.util;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import org.junit.Test;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import io.konik.zugferd.unqualified.Amount;

public class MonetarySummationsTest {

	private static final CurrencyCode CURRENCY_CODE = CurrencyCode.USD;
	private static final Amount ZERO_AMOUNT = new Amount(BigDecimal.ZERO, CURRENCY_CODE);

	@Test
	public void shouldCreateNewMonetarySummationWithZeroAllowanceTotal() {
		//when:
		MonetarySummation summation = MonetarySummations.newMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(summation.getAllowanceTotal())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}
	@Test
	public void shouldCreateNewMonetarySummationWithZeroChargeTotal() {
		//when:
		MonetarySummation summation = MonetarySummations.newMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(summation.getChargeTotal())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}
	@Test
	public void shouldCreateNewMonetarySummationWithZeroDuePayable() {
		//when:
		MonetarySummation summation = MonetarySummations.newMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(summation.getDuePayable())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}
	@Test
	public void shouldCreateNewMonetarySummationWithZeroGrandTotal() {
		//when:
		MonetarySummation summation = MonetarySummations.newMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(summation.getGrandTotal())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}
	@Test
	public void shouldCreateNewMonetarySummationWithZeroLineTotal() {
		//when:
		MonetarySummation summation = MonetarySummations.newMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(summation.getLineTotal())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}
	@Test
	public void shouldCreateNewMonetarySummationWithZeroTaxBasisTotal() {
		//when:
		MonetarySummation summation = MonetarySummations.newMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(summation.getTaxBasisTotal())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}
	@Test
	public void shouldCreateNewMonetarySummationWithZeroTaxTotal() {
		//when:
		MonetarySummation summation = MonetarySummations.newMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(summation.getTaxTotal())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}
	@Test
	public void shouldCreateNewMonetarySummationWithZeroTotalPrepaid() {
		//when:
		MonetarySummation summation = MonetarySummations.newMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(summation.getTotalPrepaid())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}

	@Test
	public void shouldCreateNewSpecifiedMonetarySummationWithZeroLineTotal() {
		//when:
		SpecifiedMonetarySummation monetarySummation = MonetarySummations.newSpecifiedMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(monetarySummation.getLineTotal())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}

	@Test
	public void shouldCreateNewSpecifiedMonetarySummationWithZeroAllowanceTotal() {
		//when:
		SpecifiedMonetarySummation monetarySummation = MonetarySummations.newSpecifiedMonetarySummation(CURRENCY_CODE);
		//then:
		assertThat(monetarySummation.getTotalAllowanceCharge())
				.isEqualToComparingFieldByField(ZERO_AMOUNT);
	}
}
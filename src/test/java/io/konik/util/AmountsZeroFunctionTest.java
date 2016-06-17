package io.konik.util;

import com.neovisionaries.i18n.CurrencyCode;
import io.konik.zugferd.unqualified.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class AmountsZeroFunctionTest {

	@Parameters(name = "{index}: currency = {0}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{ CurrencyCode.USD },
				{ CurrencyCode.EUR },
				{ CurrencyCode.PLN },
				{ CurrencyCode.CHF },
				{ CurrencyCode.GBP },
				{ CurrencyCode.MXV },
				{ CurrencyCode.CHW }
		});
	}

	@Parameter
	public CurrencyCode currencyCode;

	@Test
	public void test() {
		assertThat(Amounts.zero(currencyCode))
				.isEqualToComparingFieldByField(new Amount(BigDecimal.ZERO, currencyCode));
	}
}
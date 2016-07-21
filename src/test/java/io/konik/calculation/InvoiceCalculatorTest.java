package io.konik.calculation;

import io.konik.InvoiceTransformer;
import io.konik.calculation.InvoiceCalculator;
import io.konik.calculation.InvoiceMonetarySummationCompleter;
import io.konik.calculation.ItemSpecifiedMonetarySummationCompleter;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;

import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceCalculatorTest {

	@Test
	public void shouldCorrectInvoiceMonetarySummationAndItemsSpecifiedMonetarySummations() {
		//given:
		InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges.xml");
		InvoiceTransformer transformer = new InvoiceTransformer();
		Invoice invoice = transformer.toModel(xml);
		InvoiceCalculator corrector = new InvoiceCalculator(invoice);
		corrector.applyCorrection(new InvoiceMonetarySummationCompleter());
		corrector.applyCorrection(new ItemSpecifiedMonetarySummationCompleter());

		//when:
		Invoice corrected = corrector.complete();

		//then:
		assertThat(invoice.getTrade().getSettlement().getMonetarySummation())
				.isNotEqualTo(corrected.getTrade().getSettlement().getMonetarySummation());

		for (int i = 0; i < invoice.getTrade().getItems().size(); i++) {
			SpecifiedMonetarySummation monetarySummation = invoice.getTrade().getItems().get(i).getSettlement().getMonetarySummation();

			if (monetarySummation != null) {
				assertThat(monetarySummation)
						.isNotEqualTo(corrected.getTrade().getItems().get(i).getSettlement().getMonetarySummation());
			}
		}
	}
}
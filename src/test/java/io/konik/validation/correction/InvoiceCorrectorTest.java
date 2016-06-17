package io.konik.validation.correction;

import io.konik.InvoiceTransformer;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceCorrectorTest {

	@Test
	public void shouldCorrectInvoiceMonetarySummationAndItemsSpecifiedMonetarySummations() {
		//given:
		InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges.xml");
		InvoiceTransformer transformer = new InvoiceTransformer();
		Invoice invoice = transformer.toModel(xml);
		InvoiceCorrector corrector = new InvoiceCorrector(invoice);
		corrector.applyCorrection(new InvoiceMonetarySummationCorrection());
		corrector.applyCorrection(new ItemSpecifiedMonetarySummationCorrection());

		//when:
		Invoice corrected = corrector.correct();

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
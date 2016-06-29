package io.konik.validation;

import io.konik.InvoiceTransformer;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.MonetarySummation;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountCalculatorTest {

	@Test
	public void shouldCalculateMonetarySummationForExistingInvoice() throws IOException {
		//given:
		InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges.xml");
		InvoiceTransformer transformer = new InvoiceTransformer();
		Invoice invoice = transformer.toModel(xml);
		MonetarySummation invoiceMonetarySummation = invoice.getTrade().getSettlement().getMonetarySummation();

		//when:
		MonetarySummation summation = AmountCalculator.calculateMonetarySummation(invoice);

		//then:
		assertThat(summation.getTaxTotal())
				.isEqualToComparingFieldByField(invoiceMonetarySummation.getTaxTotal());

		assertThat(summation.getLineTotal())
				.isEqualToComparingFieldByField(invoiceMonetarySummation.getLineTotal());

		assertThat(summation.getTotalPrepaid())
				.isEqualToComparingFieldByField(invoiceMonetarySummation.getTotalPrepaid());

		assertThat(summation.getTaxBasisTotal())
				.isEqualToComparingFieldByField(invoiceMonetarySummation.getTaxBasisTotal());

		assertThat(summation.getAllowanceTotal())
				.isEqualToComparingFieldByField(invoiceMonetarySummation.getAllowanceTotal());

		assertThat(summation.getChargeTotal())
				.isEqualToComparingFieldByField(invoiceMonetarySummation.getChargeTotal());

		assertThat(summation.getDuePayable())
				.isEqualToComparingFieldByField(invoiceMonetarySummation.getDuePayable());

		assertThat(summation.getGrandTotal())
				.isEqualToComparingFieldByField(invoiceMonetarySummation.getGrandTotal());
	}


}
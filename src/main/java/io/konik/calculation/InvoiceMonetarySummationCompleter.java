package io.konik.calculation;

import io.konik.validation.AmountCalculator;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.MonetarySummation;

import javax.validation.constraints.NotNull;

/**
 * Recalculates invoice settlement {@link MonetarySummation} and replaces it in the {@link Invoice} object.
 */
public final class InvoiceMonetarySummationCompleter implements Correction<Invoice> {

	@Override
	public Invoice correct(@NotNull final Invoice invoice) {
		if (invoice.getTrade() != null && invoice.getTrade().getSettlement() != null) {
			MonetarySummation monetarySummation = AmountCalculator.calculateMonetarySummation(invoice);
			invoice.getTrade().getSettlement().setMonetarySummation(monetarySummation);
		}
		return invoice;
	}
}

package io.konik.calculation;

import io.konik.validation.AmountCalculator;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.MonetarySummation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

/**
 * Recalculates invoice settlement {@link MonetarySummation} and replaces it in the {@link Invoice} object.
 */
public final class InvoiceMonetarySummationCompleter implements Correction<Invoice> {

	protected static Logger log = LoggerFactory.getLogger(InvoiceMonetarySummationCompleter.class);

	@Override
	public Invoice correct(@NotNull final Invoice invoice) {

		log.debug("Running InvoiceMonetarySummationCompleter...");

		if (invoice.getTrade() != null && invoice.getTrade().getSettlement() != null) {
			MonetarySummation monetarySummation = AmountCalculator.calculateMonetarySummation(invoice);
			invoice.getTrade().getSettlement().setMonetarySummation(monetarySummation);
		}
		return invoice;
	}
}

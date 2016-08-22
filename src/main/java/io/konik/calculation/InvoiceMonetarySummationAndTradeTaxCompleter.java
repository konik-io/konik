package io.konik.calculation;

import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.TradeTax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.util.List;

import static io.konik.validation.AmountCalculator.*;

/**
 * Recalculates invoice settlement {@link MonetarySummation} and replaces it in the {@link Invoice} object.
 */
public final class InvoiceMonetarySummationAndTradeTaxCompleter implements Correction<Invoice> {

	protected static Logger log = LoggerFactory.getLogger(InvoiceMonetarySummationAndTradeTaxCompleter.class);

	@Override
	public Invoice correct(@NotNull final Invoice invoice) {

		log.debug("Running InvoiceMonetarySummationCompleter...");

		if (invoice.getTrade() != null && invoice.getTrade().getSettlement() != null) {
			RecalculationResult result = recalculate(invoice);
			MonetarySummation monetarySummation = result.getMonetarySummation();
			invoice.getTrade().getSettlement().setMonetarySummation(monetarySummation);

			TaxAggregator taxAggregator = result.getTaxAggregator();
			List<TradeTax> taxes = taxAggregator.generateTradeTaxList(
					invoice.getTrade().getSettlement().getCurrency(),
					invoice.getTrade().getSettlement().getTradeTax()
			);

			invoice.getTrade().getSettlement().getTradeTax().clear();

			for (TradeTax tradeTax : taxes) {
				invoice.getTrade().getSettlement().addTradeTax(tradeTax);
			}

		}
		return invoice;
	}
}

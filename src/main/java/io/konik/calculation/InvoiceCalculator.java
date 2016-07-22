package io.konik.calculation;

import io.konik.util.Invoices;
import io.konik.zugferd.Invoice;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Completes the {@link Invoice} and calculates with specified {@link Correction}s or additions.
 */
public final class InvoiceCalculator {

	private final Invoice invoice;
	private final List<Correction<Invoice>> corrections = new CopyOnWriteArrayList<Correction<Invoice>>();

	/**
	 * 
	 * @param invoice
	 */
	public InvoiceCalculator(@NotNull final Invoice invoice) {
		this.invoice = invoice;
		corrections.add(new InvoiceMonetarySummationCompleter());
		corrections.add(new ItemSpecifiedMonetarySummationCompleter());
	}

	/**
	 * Registers {@link Correction} to apply on the {@link Invoice}
	 * @param correction
	 */
	public void applyCorrection(final Correction<Invoice> correction) {
		this.corrections.add(correction);
	}

	/**
	 * Resets calculator and removes all applied {@link Correction}s.
	 */
	public void reset() {
		this.corrections.clear();
	}

	/**
	 * Runs all registered {@link Correction}s on the {@link Invoice}
	 * @return
	 */
	public Invoice complete() {
		Invoice correctedInvoice = Invoices.clone(invoice);
		for (Correction<Invoice> correction : corrections) {
			correctedInvoice = correction.correct(correctedInvoice);
		}
		return correctedInvoice;
	}
}

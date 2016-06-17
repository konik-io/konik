package io.konik.validation.correction;

import io.konik.util.Invoices;
import io.konik.zugferd.Invoice;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Corrects {@link Invoice} with specified {@link Correction}s.
 */
public final class InvoiceCorrector {

	private final Invoice invoice;
	private final List<Correction<Invoice>> corrections = new CopyOnWriteArrayList<Correction<Invoice>>();

	public InvoiceCorrector(@NotNull final Invoice invoice) {
		this.invoice = invoice;
	}

	/**
	 * Registers {@link Correction} to apply on the {@link Invoice}
	 * @param correction
	 */
	public void applyCorrection(final Correction<Invoice> correction) {
		this.corrections.add(correction);
	}

	/**
	 * Runs all registered {@link Correction}s on the {@link Invoice}
	 * @return
	 */
	public Invoice correct() {
		Invoice correctedInvoice = Invoices.clone(invoice);
		for (Correction<Invoice> correction : corrections) {
			correctedInvoice = correction.correct(correctedInvoice);
		}
		return correctedInvoice;
	}
}

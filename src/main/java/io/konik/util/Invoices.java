package io.konik.util;

import org.apache.commons.lang3.SerializationUtils;
import io.konik.zugferd.Invoice;

/**
 * Helper functions for {@link Invoice} class.
 */
public final class Invoices {

	/**
	 * Clones deeply given {@link Invoice}
	 * @param invoice
	 * @return
	 */
	public static Invoice clone(final Invoice invoice) {
		return SerializationUtils.clone(invoice);
	}
}

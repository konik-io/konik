package io.konik.sdk.invoice;

import io.konik.zugferd.Invoice;

public interface InvoiceApi {

	InvoiceDocument getInvoice(String id);
}

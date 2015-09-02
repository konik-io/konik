package io.konik.sdk.invoice;

import io.konik.zugferd.Invoice;

import java.io.InputStream;

public interface InvoiceApi {

	InvoiceDocument getInvoice(String id);

	CreatedInvoice createInvoice(Invoice invoice);

	CreatedInvoice createDraftInvoice(Invoice invoice);

	InputStream downloadPdf(String invoiceId);
}

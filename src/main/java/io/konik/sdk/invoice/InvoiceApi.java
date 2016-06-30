package io.konik.sdk.invoice;

import io.konik.zugferd.Invoice;

import java.io.InputStream;

public interface InvoiceApi {

	InvoiceDocument getInvoice(String id);

	InvoiceResponse createInvoice(Invoice invoice);

	InvoiceResponse createDraftInvoice(Invoice invoice);

	InvoiceResponse updateInvoice(String invoiceId, Invoice invoice);

	InvoiceResponse updateDraftInvoice(String invoiceId, Invoice invoice);

	InputStream downloadInvoiceAsPDF(String invoiceId);

	void deleteInvoice(String invoiceId);

	boolean sendInvoice(String invoiceId, String email, String message);

	boolean sendInvoice(String invoiceId, String email);

	InvoiceResponse uploadInvoice(InputStream pdf, InvoiceDocument.Type type);

	StatusResponse updateStatus(String invoiceId, Status status);
}

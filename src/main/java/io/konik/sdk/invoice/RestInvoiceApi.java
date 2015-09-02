package io.konik.sdk.invoice;

import io.konik.InvoiceTransformer;
import io.konik.sdk.http.ZinvoiceHttpClient;
import io.konik.zugferd.Invoice;

import java.io.InputStream;


public class RestInvoiceApi implements InvoiceApi{

	private final ZinvoiceHttpClient httpClient;

	private final InvoiceTransformer invoiceTransformer;

	public RestInvoiceApi(ZinvoiceHttpClient zinvoiceHttpClient) {
		this.httpClient = zinvoiceHttpClient;
		this.invoiceTransformer = new InvoiceTransformer();
	}

	public RestInvoiceApi(ZinvoiceHttpClient zinvoiceHttpClient, InvoiceTransformer invoiceTransformer) {
		this.httpClient = zinvoiceHttpClient;
		this.invoiceTransformer = invoiceTransformer;
	}

	@Override
	public InvoiceDocument getInvoice(String id) {
		InvoiceDocument.Response response = httpClient.get("/invoice/" + id, InvoiceDocument.Response.class);
		if (response != null) {
			return response.getDocument();
		}
		return null;
	}

	@Override
	public CreatedInvoice createInvoice(Invoice invoice) {
		byte[] invoiceXml = invoiceTransformer.fromModel(invoice);
		return httpClient.post("/invoice", invoiceXml, "application/xml", CreatedInvoice.class);
	}

	@Override
	public CreatedInvoice createDraftInvoice(Invoice invoice) {
		byte[] invoiceXml = invoiceTransformer.fromModel(invoice);
		return httpClient.post("/invoice/draft", invoiceXml, "application/xml", CreatedInvoice.class);
	}

	@Override
	public InputStream downloadPdf(String invoiceId) {
		return httpClient.download("/invoice/"+invoiceId+"/pdf");
	}
}

package io.konik.sdk.invoice;

import com.google.api.client.http.HttpResponseException;
import io.konik.InvoiceTransformer;
import io.konik.sdk.http.InsufficientCreditsAmountException;
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
	public InputStream downloadInvoiceAsPDF(String invoiceId) {
		try {
			return httpClient.download("/invoice/" + invoiceId + "/pdf");
		} catch (RuntimeException e) {
			if (e.getCause() instanceof HttpResponseException) {
				HttpResponseException responseException = (HttpResponseException) e.getCause();
				if (responseException.getStatusCode() == 409) {
					throw new InsufficientCreditsAmountException();
				}
			}
			throw e;
		}
	}

	@Override
	public void deleteInvoice(String invoiceId) {
		httpClient.delete("/invoice/"+invoiceId);
	}
}

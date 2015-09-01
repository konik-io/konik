package io.konik.sdk.invoice;

import io.konik.sdk.http.ZinvoiceHttpClient;

public class RestInvoiceApi implements InvoiceApi{

	private final ZinvoiceHttpClient zinvoiceHttpClient;

	public RestInvoiceApi(ZinvoiceHttpClient zinvoiceHttpClient) {
		this.zinvoiceHttpClient = zinvoiceHttpClient;
	}

	@Override
	public InvoiceDocument getInvoice(String id) {
		InvoiceDocument.Response response = zinvoiceHttpClient.get("/invoice/"+id, InvoiceDocument.Response.class);
		if (response != null) {
			return response.getDocument();
		}
		return null;
	}
}

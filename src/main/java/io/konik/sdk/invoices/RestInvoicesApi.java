package io.konik.sdk.invoices;

import io.konik.sdk.http.ZinvoiceHttpClient;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RestInvoicesApi implements InvoicesApi {

	private final ZinvoiceHttpClient httpClient;

	public RestInvoicesApi(ZinvoiceHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Returns all invoices from outbox.
	 * @return
	 */
	public List<InvoicesListElement> outbox() {
		InvoicesListElement[] response = httpClient.get("/invoices/outbox", InvoicesListElement[].class);
		return new LinkedList<InvoicesListElement>(Arrays.asList(response));
	}

	/**
	 * Returns all invoices from inbox.
	 * @return
	 */
	public List<InvoicesListElement> inbox() {
		InvoicesListElement[] response = httpClient.get("/invoices/inbox", InvoicesListElement[].class);
		return new LinkedList<InvoicesListElement>(Arrays.asList(response));
	}
}

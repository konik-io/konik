package io.konik.sdk.invoice;

public class CreatedInvoice {

	private String invoiceId;

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Override
	public String toString() {
		return "CreatedInvoice{" +
				"invoiceId='" + invoiceId + '\'' +
				'}';
	}
}

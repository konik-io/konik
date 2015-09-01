package io.konik.sdk.invoices;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.konik.sdk.json.DateDeserializer;
import io.konik.sdk.json.DateTimeDeserializer;

import java.math.BigDecimal;
import java.util.Date;

public class InvoicesListElement {

	private String id;

	private String documentType;

	private String status;

	private String number;

	@JsonDeserialize(using = DateDeserializer.class)
	private Date performanceDate;

	private String buyerName;

	private String sellerName;

	private BigDecimal amount;

	private String currency;

	@JsonDeserialize(using = DateTimeDeserializer.class)
	private Date createdDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getPerformanceDate() {
		return performanceDate;
	}

	public void setPerformanceDate(Date performanceDate) {
		this.performanceDate = performanceDate;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "InvoicesListElement{" +
				"id='" + id + '\'' +
				", documentType='" + documentType + '\'' +
				", status=" + status +
				", number='" + number + '\'' +
				", performanceDate=" + performanceDate +
				", buyerName='" + buyerName + '\'' +
				", sellerName='" + sellerName + '\'' +
				", amount=" + amount +
				", currency='" + currency + '\'' +
				", createdDate=" + createdDate +
				'}';
	}
}

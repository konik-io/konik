/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.entity;

import io.konik.zugferd.unqualified.Amount;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Monetary Summation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeSettlementMonetarySummationType", propOrder = { "netTotal", "chargeTotal",
		"allowanceTotal", "taxBasisTotal", "taxTotal", "grandTotal", "totalPrepaid", "duePayable" })
public class MonetarySummation {

	/** The "net total" amount. */
   @Valid
	@XmlElement(name = "LineTotalAmount")
	private Amount netTotal;

	/** The charges total amount. */
   @Valid
	@XmlElement(name = "ChargeTotalAmount")
	private Amount chargeTotal;

	/** The allowance total amount. */
   @Valid
	@XmlElement(name = "AllowanceTotalAmount")
	private Amount allowanceTotal;

	/** The tax basis total amount. The invoice net sum = netTotal + charges - allowance. */
	@XmlElement(name = "TaxBasisTotalAmount")
	@Valid
	private Amount taxBasisTotal;

	/** The total tax amount. */
	@Valid
	@XmlElement(name = "TaxTotalAmount")
	private Amount taxTotal;

	/** The grand total amount. */
	@Valid
	@XmlElement(name = "GrandTotalAmount")
	private Amount grandTotal;

	/** The total prepaid amount. */
	@Valid
	@XmlElement(name = "TotalPrepaidAmount")
	private Amount totalPrepaid;

	/** The due payable amount. */
	@Valid
	@XmlElement(name = "DuePayableAmount")
	private Amount duePayable;

	/**
	 * Gets the line total amount.

	 * Profile: BASIC

	 * 
	 * @return the line total amount
	 */
	public Amount getNetTotal() {
		return netTotal;
	}

	/**
	 * Sets the line total amount.

	 * Profile: BASIC

	 * 
	 * @param netTotal the new line total amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setNetTotal(Amount netTotal) {
		this.netTotal = netTotal;
		return this;
	}

	/**
	 * Gets the charge total amount.

	 * Profile: BASIC

	 * 
	 * @return the charge total amount
	 */
	public Amount getChargeTotal() {
		return chargeTotal;
	}

	/**
	 * Sets the charge total amount.

	 * Profile: BASIC

	 * 
	 * @param chargeTotal the new charge total amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setChargeTotal(Amount chargeTotal) {
		this.chargeTotal = chargeTotal;
		return this;
	}

	/**
	 * Gets the allowance total amount.

	 * Profile: BASIC

	 * 
	 * @return the allowance total amount
	 */
	public Amount getAllowanceTotal() {
		return allowanceTotal;
	}

	/**
	 * Sets the allowance total amount.

	 * Profile: BASIC

	 * 
	 * @param allowanceTotal the new allowance total amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setAllowanceTotal(Amount allowanceTotal) {
		this.allowanceTotal = allowanceTotal;
		return this;
	}

	/**
	 * Gets the tax basis total amount.

	 * The invoice net sum = netTotal + charges - allowence.

	 * Profile: BASIC

	 * 
	 * @return the tax basis total amount
	 */
	public Amount getTaxBasisTotal() {
		return taxBasisTotal;
	}

	/**
	 * Sets the tax basis total amount.

	 * The invoice net sum = netTotal + charges - allowence.

	 * Profile: BASIC

	 * 
	 * @param taxBasisTotal the new tax basis total amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setTaxBasisTotal(Amount taxBasisTotal) {
		this.taxBasisTotal = taxBasisTotal;
		return this;
	}

	/**
	 * Gets the total tax amount.

	 * Profile: BASIC

	 * 
	 * @return the tax total amount
	 */
	public Amount getTaxTotal() {
		return taxTotal;
	}

	/**
	 * Sets the total tax amount.

	 * Profile: BASIC

	 * 
	 * @param taxTotal the new tax total amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setTaxTotal(Amount taxTotal) {
		this.taxTotal = taxTotal;
		return this;
	}

	/**
	 * Gets the grand total amount.

	 * Profile: BASIC

	 * 
	 * @return the grand total amount
	 */
	public Amount getGrandTotal() {
		return grandTotal;
	}

	/**
	 * Sets the grand total amount.

	 * Profile: BASIC

	 * 
	 * @param grandTotal the new grand total amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setGrandTotal(Amount grandTotal) {
		this.grandTotal = grandTotal;
		return this;
	}

	/**
	 * Gets the total prepaid amount.

	 * Profile: COMFORT

	 * 
	 * @return the total prepaid amount
	 */
	public Amount getTotalPrepaid() {
		return totalPrepaid;
	}

	/**
	 * Sets the total prepaid amount.

	 * Profile: COMFORT

	 * 
	 * @param totalPrepaid the new total prepaid amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setTotalPrepaid(Amount totalPrepaid) {
		this.totalPrepaid = totalPrepaid;
		return this;
	}

	/**
	 * Gets the due payable amount.

	 * Profile: COMFORT

	 * 
	 * @return the due payable amount
	 */
	public Amount getDuePayable() {
		return duePayable;
	}

	/**
	 * Sets the due payable amount.

	 * Profile: COMFORT

	 * 
	 * @param duePayable the new due payable amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setDuePayable(Amount duePayable) {
		this.duePayable = duePayable;
		return this;
	}

}

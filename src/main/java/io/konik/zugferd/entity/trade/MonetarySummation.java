/* Copyright (C) 2014 konik.io
 *
 * This file is part of the Konik library.
 *
 * The Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * The Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the Konik library. If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.entity.trade;

import io.konik.validator.annotation.Basic;
import io.konik.zugferd.entity.CommonMonetarySummation;
import io.konik.zugferd.unqualified.Amount;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Monetary Summation
 * 
 */
@XmlType(propOrder = { "lineTotal", "chargeTotal",
		"allowanceTotal", "taxBasisTotal", "taxTotal", "grandTotal", "totalPrepaid", "duePayable" })
public class MonetarySummation  extends CommonMonetarySummation{

   @Basic
   @Valid
   @NotNull
	@XmlElement(name = "ChargeTotalAmount")
	private Amount chargeTotal;

   @Basic
   @Valid
   @NotNull
	@XmlElement(name = "AllowanceTotalAmount")
	private Amount allowanceTotal;

   @Basic
   @Valid
   @NotNull
   @XmlElement(name = "TaxBasisTotalAmount")
	private Amount taxBasisTotal;
   
   @Basic
   @Valid
   @NotNull
	@XmlElement(name = "TaxTotalAmount")
	private Amount taxTotal;

   @Basic
   @Valid
   @NotNull
	@XmlElement(name = "GrandTotalAmount")
	private Amount grandTotal;
   
   @Basic
   @Valid
	@XmlElement(name = "TotalPrepaidAmount")
	private Amount totalPrepaid;
   
   @Basic
   @Valid
	@XmlElement(name = "DuePayableAmount")
	private Amount duePayable;

	/**
	 * Gets the line total amount.
	 * 
	 * @return the line total amount
	 */
	@Override
	@Basic
	@NotNull
   public Amount getLineTotal() {
		return lineTotal;
	}

	/**
	 * Sets the line total amount.
	 * 
	 * @param lineTotal the new line total amount
	 * @return the trade settlement monetary summation
	 */
	@Override
   public MonetarySummation setLineTotal(Amount lineTotal) {
		this.lineTotal = lineTotal;
		return this;
	}

	/**
	 * Gets the charge total amount.
	 * 
	 * Profile:: BASIC
	 * 
	 * 
	 * @return the charge total amount
	 */
	public Amount getChargeTotal() {
		return chargeTotal;
	}

	/**
	 * Sets the charge total amount.
	 * 
	 * Profile:: BASIC
	 * 
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
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the allowance total amount
	 */
	public Amount getAllowanceTotal() {
		return allowanceTotal;
	}

	/**
	 * Sets the allowance total amount.
	 * 
	 * Profile:: BASIC
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
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the tax basis total amount
	 */
	public Amount getTaxBasisTotal() {
		return taxBasisTotal;
	}

	/**
	 * Sets the tax basis total amount.
	 * 
	 * The invoice net sum = netTotal + charges - allowence.
	 * 
	 * Profile:: BASIC
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
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the tax total amount
	 */
	public Amount getTaxTotal() {
		return taxTotal;
	}

	/**
	 * Sets the total tax amount.
	 * 
	 * Profile:: BASIC
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
	 * 
	 * Profile:: BASIC
	 * 
	 * @return the grand total amount
	 */
	public Amount getGrandTotal() {
		return grandTotal;
	}

	/**
	 * Sets the grand total amount.
	 * 
	 * Profile:: BASIC
	 * 
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
	 * 
	 * Profile:: COMFORT
	 * 
	 * 
	 * @return the total prepaid amount
	 */
	public Amount getTotalPrepaid() {
		return totalPrepaid;
	}

	/**
	 * Sets the total prepaid amount.

	 * Profile:: COMFORT

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
	 * 
	 * Profile:: COMFORT
	 * 
	 * @return the due payable amount
	 */
	public Amount getDuePayable() {
		return duePayable;
	}

	/**
	 * Sets the due payable amount.
	 * 
	 * Profile:: COMFORT
	 * 
	 * @param duePayable the new due payable amount
	 * @return the trade settlement monetary summation
	 */
	public MonetarySummation setDuePayable(Amount duePayable) {
		this.duePayable = duePayable;
		return this;
	}

}

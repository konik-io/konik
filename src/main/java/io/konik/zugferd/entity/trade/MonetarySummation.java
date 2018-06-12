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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.entity.CommonMonetarySummation;
import io.konik.zugferd.unqualified.Amount;

/**
 * = The Monetary Summation of a trade settlement
 * 
 */
@XmlType(propOrder = { "lineTotal", "chargeTotal", "allowanceTotal", "taxBasisTotal", "taxTotal", "grandTotal",
      "totalPrepaid", "duePayable" })
public class MonetarySummation implements CommonMonetarySummation {

   @Valid
   @XmlElement(name = "LineTotalAmount")
   private Amount lineTotal;

   @XmlElement(name = "ChargeTotalAmount")
   private Amount chargeTotal;

   @XmlElement(name = "AllowanceTotalAmount")
   private Amount allowanceTotal;

   @XmlElement(name = "TaxBasisTotalAmount")
   private Amount taxBasisTotal;

   @XmlElement(name = "TaxTotalAmount")
   private Amount taxTotal;

   @XmlElement(name = "GrandTotalAmount")
   private Amount grandTotal;

   @XmlElement(name = "TotalPrepaidAmount")
   private Amount totalPrepaid;

   @XmlElement(name = "DuePayableAmount")
   private Amount duePayable;

   @Override
   public Amount getLineTotal() {
      return lineTotal;
   }

   @Override
   public MonetarySummation setLineTotal(Amount lineTotal) {
      this.lineTotal = lineTotal;
      return this;
   }

   /**
    * Gets the total amount of surcharges.
    * 
    * @return the charge total amount
    */
   @Basic
   @Valid
   @NotNull
   public Amount getChargeTotal() {
      return chargeTotal;
   }

   /**
    * Sets the total amount of surcharges.
    * 
    * @param chargeTotal the new charge total amount
    * @return the trade settlement monetary summation
    */
   public MonetarySummation setChargeTotal(Amount chargeTotal) {
      this.chargeTotal = chargeTotal;
      return this;
   }

   /**
    * Gets the total amount of discounts.
    * 
    * @return the allowance total amount
    */
   @Basic
   @Valid
   @NotNull
   public Amount getAllowanceTotal() {
      return allowanceTotal;
   }

   /**
    * Sets the total amount of discounts.
    * 
    * @param allowanceTotal the new allowance total amount
    * @return the trade settlement monetary summation
    */
   public MonetarySummation setAllowanceTotal(Amount allowanceTotal) {
      this.allowanceTotal = allowanceTotal;
      return this;
   }

   /**
    * Gets the invoice total value excluding VAT.
    * 
    * Example:: The taxBasisTotal = netTotal + chargeTotal - allowanceTotal.
    * 
    * @return the tax basis total amount
    */
   @Basic
   @Valid
   @NotNull
   public Amount getTaxBasisTotal() {
      return taxBasisTotal;
   }

   /**
    * Sets the invoice total value excluding VAT.
    * 
    * Example:: The taxBasisTotal = netTotal + chargeTotal - allowanceTotal.
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
    * @return the tax total amount
    */
   @Basic
   @Valid
   @NotNull
   public Amount getTaxTotal() {
      return taxTotal;
   }

   /**
    * Sets the total tax amount.
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
    * Example:: grandTotal == + taxTotal
    * 
    * @return the grand total amount
    */
   @Basic
   @Valid
   @NotNull
   public Amount getGrandTotal() {
      return grandTotal;
   }

   /**
    * Sets the grand total amount.
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
    * @return the total prepaid amount
    */
   @Comfort
   @Valid
   public Amount getTotalPrepaid() {
      return totalPrepaid;
   }

   /**
    * Sets the total prepaid amount.
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
    * @return the due payable amount
    */
   @Comfort
   @Valid
   public Amount getDuePayable() {
      return duePayable;
   }

   /**
    * Sets the due payable amount.
    * 
    * @param duePayable the new due payable amount
    * @return the trade settlement monetary summation
    */
   public MonetarySummation setDuePayable(Amount duePayable) {
      this.duePayable = duePayable;
      return this;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("MonetarySummation [");
      if (lineTotal != null) builder.append("lineTotal=").append(lineTotal).append(", ");
      if (chargeTotal != null) builder.append("chargeTotal=").append(chargeTotal).append(", ");
      if (allowanceTotal != null) builder.append("allowanceTotal=").append(allowanceTotal).append(", ");
      if (taxBasisTotal != null) builder.append("taxBasisTotal=").append(taxBasisTotal).append(", ");
      if (taxTotal != null) builder.append("taxTotal=").append(taxTotal).append(", ");
      if (grandTotal != null) builder.append("grandTotal=").append(grandTotal).append(", ");
      if (totalPrepaid != null) builder.append("totalPrepaid=").append(totalPrepaid).append(", ");
      if (duePayable != null) builder.append("duePayable=").append(duePayable);
      builder.append("]");
      return builder.toString();
   }

}

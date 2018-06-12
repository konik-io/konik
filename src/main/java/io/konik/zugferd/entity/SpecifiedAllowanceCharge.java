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
package io.konik.zugferd.entity;

import static io.konik.zugferd.unqualified.Indicator.falseIndicator;
import static io.konik.zugferd.unqualified.Indicator.trueIndicator;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.konik.jaxb.adapter.TwoDigitRoundingAdapter;
import io.konik.jaxb.bindable.unqualified.PercentRoundingAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Indicator;
import io.konik.zugferd.unqualified.Quantity;

/**
 * 
 * = The Specified Allowance Charge.
 */
@XmlType(name = "", propOrder = { "surcharge", "sequence", "calculationPercent", "basis", "basisQuantity", "actual",
      "reasonCode", "reason", "category" })

public class SpecifiedAllowanceCharge implements CommonAllowanceCharge {

   @XmlElement(name = "ChargeIndicator")
   private Indicator surcharge;

   @XmlElement(name = "SequenceNumeric")
   private BigDecimal sequence;

   @XmlElement(name = "CalculationPercent")
   @XmlJavaTypeAdapter(PercentRoundingAdapter.class)
   private BigDecimal calculationPercent;

   @XmlElement(name = "BasisAmount")
   @XmlJavaTypeAdapter(TwoDigitRoundingAdapter.class)
   private Amount basis;

   @XmlElement(name = "BasisQuantity")
   private Quantity basisQuantity;

   @XmlElement(name = "ActualAmount")
   @XmlJavaTypeAdapter(TwoDigitRoundingAdapter.class)
   private Amount actual;

   @XmlElement(name = "ReasonCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String reasonCode;

   @XmlElement(name = "Reason")
   private String reason;

   @XmlElement(name = "CategoryTradeTax")
   private AppliedTax category;

   /**
    * Instantiates a new allowance charge.
    */
   public SpecifiedAllowanceCharge() {
      surcharge = Indicator.falseIndicator();
   }

   /**
    * Checks if is a surcharge.
    *
    * @return true if charge
    */
   @Override
   @NotNull(groups = Comfort.class)
   public boolean isSurcharge() {
      return surcharge.getIndicator();
   }

   /**
    * Checks if is discount.
    *
    * @return true if is discount
    */
   @Override
   @NotNull(groups = Comfort.class)
   public boolean isDiscount() {
      return !surcharge.getIndicator();
   }

   /**
    * Sets amount to be a surcharge.
    *
    * @return the allowance charge to be true
    */
   @Override
   public SpecifiedAllowanceCharge setSurcharge() {
      this.surcharge = trueIndicator();
      return this;
   }

   /**
    * Sets the amount to be a discount.
    *
    * @return the allowance discount to be true
    */
   @Override
   public SpecifiedAllowanceCharge setDiscount() {
      this.surcharge = falseIndicator();
      return this;
   }

   /**
    * Gets the sequence number of the allowance charge
    *
    * @return the sequence
    */
   @Override
   @Extended
   public BigDecimal getSequence() {
      return sequence;
   }

   /**
    * Sets the sequence number of the allowance charge.
    *
    * @param sequence the new sequence
    * @return the allowance charge
    */
   @Override
   public SpecifiedAllowanceCharge setSequence(BigDecimal sequence) {
      this.sequence = sequence;
      return this;
   }

   /**
    * Gets the calculation percent of the allowance charge
    *
    * @return the calculation percent
    */
   @Override
   @Extended
   public BigDecimal getCalculationPercent() {
      return calculationPercent;
   }

   /**
    * Sets the calculation percent of the allowance charge.
    *
    * @param calculationPercent the new calculation percent
    * @return the allowance charge
    */
   @Override
   public SpecifiedAllowanceCharge setCalculationPercent(BigDecimal calculationPercent) {
      this.calculationPercent = calculationPercent;
      return this;
   }

   /**
    * Gets the basis amount of the allowance charge.
    * 
    * @return the basis amount
    */
   @Override
   @Valid
   @Extended
   public Amount getBasis() {
      return basis;
   }

   /**
    * Sets the basis amount of the allowance charge.
    *
    * @param basisAmount the new basis amount
    * @return the allowance charge
    */
   @Override
   public SpecifiedAllowanceCharge setBasis(Amount basisAmount) {
      this.basis = basisAmount;
      return this;
   }

   /**
    * Gets the basis quantity.
    *
    * @return the basis quantity
    */
   @Override
   @Extended
   @Valid
   public Quantity getBasisQuantity() {
      return basisQuantity;
   }

   /**
    * Sets the basis quantity.
    *
    * @param basisQuantity the new basis quantity
    * @return the allowance charge
    */
   @Override
   public SpecifiedAllowanceCharge setBasisQuantity(Quantity basisQuantity) {
      this.basisQuantity = basisQuantity;
      return this;
   }

   /**
    * Gets the actual amount.
    * 
    * @return the actual amount
    */
   @Override
   @Valid
   @NotNull(groups = Comfort.class)
   public Amount getActual() {
      return actual;
   }

   /**
    * Sets the actual amount.
    *
    * @param actualAmount the new actual amount
    * @return the allowance charge
    */
   @Override
   public SpecifiedAllowanceCharge setActual(Amount actualAmount) {
      this.actual = actualAmount;
      return this;
   }

   /**
    * Gets the reason code for the reason content.
    *
    * @return the reason code
    */
   @Override
   @Extended
   public String getReasonCode() {
      return reasonCode;
   }

   /**
    * Sets the reason code for the reason content.
    *
    * @param reasonCode the new reason code
    * @return the allowance charge
    */
   @Override
   public SpecifiedAllowanceCharge setReasonCode(String reasonCode) {
      this.reasonCode = reasonCode;
      return this;
   }

   /**
    * Gets the reason free text
    * 
    * @return the reason
    */
   @Override
   @Comfort
   public String getReason() {
      return reason;
   }

   /**
    * Sets the reason free text
    *
    * @param reason the new reason
    * @return the allowance charge
    */
   @Override
   public SpecifiedAllowanceCharge setReason(String reason) {
      this.reason = reason;
      return this;
   }

   /**
    * Gets the category.
    *
    * @return the category
    */
   @Comfort
   public AppliedTax getCategory() {
      return category;
   }

   /**
    * Sets the category.
    *
    * @param category the new category
    * @return the allowance charge
    */
   public SpecifiedAllowanceCharge setCategory(AppliedTax category) {
      this.category = category;
      return this;
   }

}

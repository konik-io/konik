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
import io.konik.jaxb.adapter.AmountHighRoundingAdapter;
import io.konik.jaxb.bindable.unqualified.PercentRoundingAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Indicator;
import io.konik.zugferd.unqualified.Quantity;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * = The Allowance Charge 
 * 
 * Represents trade surcharges and discounts as well as a reason.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeAllowanceChargeType", propOrder = { "surcharge","sequence","calculationPercent", "basis", "basisQuantity","actual",
		"reasonCode", "reason", "category" })
public class AllowanceCharge {

	@XmlElement(name = "ChargeIndicator")
	@NotNull(groups=Comfort.class)
	private Indicator surcharge;

   @XmlElement(name = "SequenceNumeric")
   private BigDecimal sequence;
   
   @XmlElement(name = "CalculationPercent")
   @XmlJavaTypeAdapter(PercentRoundingAdapter.class)
   private BigDecimal calculationPercent;
   
	@Valid
	@XmlElement(name = "BasisAmount")
	@XmlJavaTypeAdapter(value = AmountHighRoundingAdapter.class)
	private Amount basis;

	@Valid
	@XmlElement(name = "BasisQuantity")
	private Quantity basisQuantity;
   
	@Valid
	@NotNull(groups=Comfort.class)
	@XmlElement(name = "ActualAmount")
	@XmlJavaTypeAdapter(value = AmountHighRoundingAdapter.class)
	private Amount actual;

   @XmlElement(name = "ReasonCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String reasonCode;

	@XmlElement(name = "Reason")
	private String reason;

	@XmlElement(name = "CategoryTradeTax")
	protected Tax category;
	
	/**
    * Instantiates a new allowance charge.
    */
	public AllowanceCharge(){
	   surcharge = Indicator.falseIndicator();
	}
	/**
    * Checks if is a surcharge.
    *
    * @return true if charge otherwise discount
    */
	public boolean isSurcharge() {
		return surcharge.getIndicator();
	}
	
	  /**
    * Checks if is discount.
    *
    * @return true if discount otherwise charge
    */
  	public boolean isDiscount() {
	      return !surcharge.getIndicator();
	   }

	/**
    * Sets amount to be a surcharge.
    *
    * @return the allowance charge
    */
	public AllowanceCharge setSurcharge() {
		this.surcharge = trueIndicator();
		return this;
	}
	
	/**
    * Sets the amount to be a discount.
    *
    * @return the allowance charge
    */
   public AllowanceCharge setDiscount() {
      this.surcharge = falseIndicator();
      return this;
   }

	/**
	 * Gets the basis amount.
	 * 
	 * @return the basis amount
	 */
	public Amount getBasis() {
		return basis;
	}

	/**
    * Sets the basis amount.
    *
    * @param basisAmount the new basis amount
    * @return the allowance charge
    */
	public AllowanceCharge setBasis(Amount basisAmount) {
		this.basis = basisAmount;
		return this;
	}

	/**
	 * Gets the actual amount.
	 * 
	 * @return the actual amount
	 */
	public Amount getActual() {
		return actual;
	}

	/**
    * Sets the actual amount.
    *
    * @param actualAmount the new actual amount
    * @return the allowance charge
    */
	public AllowanceCharge setActual(Amount actualAmount) {
		this.actual = actualAmount;
		return this;
	}

	/**
	 * Gets the reason.
	 * 
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
    * Sets the reason.
    *
    * @param reason the new reason
    * @return the allowance charge
    */
	public AllowanceCharge setReason(String reason) {
		this.reason = reason;
		return this;
	}
}



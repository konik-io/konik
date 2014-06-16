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
 * = The Allowance Charge 
 * Represents the detail information about surcharges and discounts.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeAllowanceChargeType", propOrder = { "surcharge", "basisAmount", "actualAmount",
		"reason", "category" })
public class AllowanceCharge {

	@XmlElement(name = "ChargeIndicator")
	private boolean surcharge;

	@Valid
	@XmlElement(name = "BasisAmount")
	private Amount basisAmount;

	@Valid
	@XmlElement(name = "ActualAmount")
	private Amount actualAmount;

	@XmlElement(name = "Reason")
	private String reason;

	@XmlElement(name = "CategoryTradeTax")
	private Tax category;

	/**
    * Checks if is a surcharge.
    *
    * @return true if charge otherwise discount
    */
	public boolean isSurcharge() {
		return surcharge;
	}
	
	  /**
    * Checks if is discount.
    *
    * @return true if discount otherwise charge
    */
  	public boolean isDiscount() {
	      return !surcharge;
	   }

	/**
    * Sets amount to be a surcharge.
    *
    * @return the allowance charge
    */
	public AllowanceCharge setSurcharge() {
		this.surcharge = true;
		return this;
	}
	
	/**
    * Sets the amount to be a discount.
    *
    * @return the allowance charge
    */
   public AllowanceCharge setDiscount() {
      this.surcharge = false;
      return this;
   }

	/**
	 * Gets the basis amount.
	 * 
	 * @return the basis amount
	 */
	public Amount getBasisAmount() {
		return basisAmount;
	}

	/**
    * Sets the basis amount.
    *
    * @param basisAmount the new basis amount
    * @return the allowance charge
    */
	public AllowanceCharge setBasisAmount(Amount basisAmount) {
		this.basisAmount = basisAmount;
		return this;
	}

	/**
	 * Gets the actual amount.
	 * 
	 * @return the actual amount
	 */
	public Amount getActualAmount() {
		return actualAmount;
	}

	/**
    * Sets the actual amount.
    *
    * @param actualAmount the new actual amount
    * @return the allowance charge
    */
	public AllowanceCharge setActualAmount(Amount actualAmount) {
		this.actualAmount = actualAmount;
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

   /**
    * Gets the category.
    *
    * @return the category
    */
   public Tax getCategory() {
      return category;
   }

   /**
    * Sets the category.
    *
    * @param category the new category
    * @return the allowance charge
    */
   public AllowanceCharge setCategory(Tax category) {
      this.category = category;
      return this;
   }
}

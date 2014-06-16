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
import io.konik.zugferd.unqualified.Quantity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Price.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePriceType", propOrder = { "chargeAmount", "basisQuantity", "allowanceCharge" })
public class Price {

	/** The charge amount. */
   @Valid
	@XmlElement(name = "ChargeAmount")
	private Amount chargeAmount;

	/** The basis quantity. */
   @Valid
	@XmlElement(name = "BasisQuantity")
	private Quantity basisQuantity;

	/** The applied trade allowance charge. */
   @Valid
	@XmlElement(name = "AppliedTradeAllowanceCharge")
	private List<AllowanceCharge> allowanceCharge;

	/**
	 * Gets the charge amount.
	 * 
	 * @return the charge amount
	 */
	public Amount getChargeAmount() {
		return chargeAmount;
	}

	/**
    * Sets the charge amount.
    *
    * @param chargeAmount the new charge amount
    * @return the price
    */
	public Price setChargeAmount(Amount chargeAmount) {
		this.chargeAmount = chargeAmount;
		return this;
	}

	/**
	 * Gets the basis quantity.
	 * 
	 * @return the basis quantity
	 */
	public Quantity getBasisQuantity() {
		return basisQuantity;
	}

	/**
    * Sets the basis quantity.
    *
    * @param quantity the new basis quantity
    * @return the price
    */
	public Price setBasisQuantity(Quantity quantity) {
		this.basisQuantity = quantity;
		return this;
	}

	/**
	 * Gets the applied trade allowance charge.
	 * 
	 * @return the applied trade allowance charge
	 */
	public List<AllowanceCharge> getAllowanceCharge() {
		if (allowanceCharge == null) {
			allowanceCharge = new ArrayList<AllowanceCharge>();
		}
		return this.allowanceCharge;
	}

}

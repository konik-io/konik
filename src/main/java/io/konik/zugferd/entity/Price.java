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

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.konik.jaxb.adapter.FourDigitRoundingAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Quantity;

/**
 * = The Price
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePriceType", propOrder = { "chargeAmount", "basis", "allowanceCharges" })
public class Price implements Serializable {

   @XmlElement(name = "ChargeAmount")
   @XmlJavaTypeAdapter(value = FourDigitRoundingAdapter.class)
   private Amount chargeAmount;

   @XmlElement(name = "BasisQuantity")
   private Quantity basis;

   @XmlElement(name = "AppliedTradeAllowanceCharge")
   protected List<AllowanceCharge> allowanceCharges;//grossprice

   Price() {
   }

   /**
    * Instantiates a new price.
    *
    * @param chargeAmount the charge amount
    */
   public Price(Amount chargeAmount) {
      super();
      this.chargeAmount = chargeAmount;
   }

   /**
    * Gets the charge amount.
    * 
    * @return the charge amount
    */
   @Valid
   @NotNull(groups = Comfort.class)
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
    * Gets the unit of price base quantity.
    * 
    * @return the basis quantity
    */
   @Valid
   @Comfort
   public Quantity getBasis() {
      return basis;
   }

   /**
    * Sets the unit of price base quantity.
    *
    * @param quantity the new basis quantity
    * @return the price
    */
   public Price setBasis(Quantity quantity) {
      this.basis = quantity;
      return this;
   }

}

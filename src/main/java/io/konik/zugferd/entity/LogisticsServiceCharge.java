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

import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.NotBlank;
import io.konik.zugferd.unqualified.Amount;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * = The Logistics Service Charge
 * 
 * Represents the transport and packaging costs.
 */
@Comfort
@XmlType(name = "LogisticsServiceChargeType", propOrder = { "description", "amount", "tradeTax" })
public class LogisticsServiceCharge implements Serializable {

   @XmlElement(name = "Description")
   private String description;
   
   @XmlElement(name = "AppliedAmount")
   private Amount amount;

   @XmlElement(name = "AppliedTradeTax")
   private List<AppliedTax> tradeTax;

   /**
    * Gets human readable description of the charge type
    * 
    * Example:: Shipping and handling charges
    * 
    * @return the description
    */
   @NotBlank   
   public String getDescription() {
      return description;
   }

   /**
    * Sets human readable description of the charge type
    * 
    * Example:: Shipping and handling charges
    * 
    * @param description the new description
    * @return the logistics service charge
    */
   public LogisticsServiceCharge setDescription(String description) {
      this.description = description;
      return this;
   }

   /**
    * Gets amount of the logistics service charge.
    * 
    * @return the logistics service charge amount
    */
   @Valid
   public Amount getAmount() {
      return amount;
   }

   /**
    * Sets amount of the logistics service charge.
    *
    * @param amount the new logistics service charge amount
    * @return the logistics service charge
    */
   public LogisticsServiceCharge setAmount(Amount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Gets the applied trade tax for the logistics service charge amount
    * 
    * @return the applied trade tax
    */
   @Valid
   public List<AppliedTax> getTradeTax() {
      if (tradeTax == null) {
         tradeTax = new ArrayList<AppliedTax>();
      }
      return this.tradeTax;
   }

   /**
    * Adds a trade tax for the logistics service charge amount
    *
    * @param additionalTradeTax the additional trade tax
    * @return the logistics service charge
    */
   public LogisticsServiceCharge addTradeTax(AppliedTax additionalTradeTax) {
      getTradeTax().add(additionalTradeTax);
      return this;
   }

}

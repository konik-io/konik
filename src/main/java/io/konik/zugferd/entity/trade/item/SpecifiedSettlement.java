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
package io.konik.zugferd.entity.trade.item;

import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.AccountingAccount;
import io.konik.zugferd.entity.MonetarySummation;
import io.konik.zugferd.entity.Period;
import io.konik.zugferd.entity.CommonSettlement;

import java.util.ArrayList;
import java.util.List;

/**
 * = The Trade Item Settlement
 * 
 * Contains payment related information on an Item basis.
 */
public class SpecifiedSettlement extends CommonSettlement<SpecifiedTax,MonetarySummation>{

   /**
    * Gets the applicable trade tax.
    *
    * @return the applicable trade tax
    */
   @Override
   public List<SpecifiedTax> getTradeTax() {
      if (tradeTax == null) {
         tradeTax = new ArrayList<SpecifiedTax>();
      }
      return this.tradeTax;
   }

   /**
    * Adds a trade tax.
    * 
    * @param additionalTradeTax
    * @return the trade settlement
    */
   @Override
   public SpecifiedSettlement addTradeTax(SpecifiedTax additionalTradeTax) {
      getTradeTax().add(additionalTradeTax);
      return this;
   }

   /**
    * Gets the billing specified period.
    * 
    * Profile:: COMFORT
    *
    * @return the billing specified period
    */
   @Override
   public Period getBillingPeriod() {
      return billingPeriod;
   }

   /**
    * Sets the billing specified period.
    * 
    * Profile:: COMFORT
    * 
    *
    * @param billingPeriod the new billing specified period
    * @return the supply chain trade settlement
    */
   @Override
   public SpecifiedSettlement setBillingPeriod(Period billingPeriod) {
      this.billingPeriod = billingPeriod;
      return this;
   }


   /**
    * Gets the specified booking reference.
    * 
    * Profile:: EXTENDED
    *
    * @return the specified booking reference
    */
   @Extended
   public AccountingAccount getSpecifiedBookingReference() {
      return specifiedBookingReference;
   }

   /**
    * Sets the specified booking reference.
    *
    * Profile:: EXTENDED
    *
    * @param specifiedBookingReference the specified booking reference
    * @return 
    */
   public SpecifiedSettlement setSpecifiedBookingReference(AccountingAccount specifiedBookingReference) {
      this.specifiedBookingReference = specifiedBookingReference;
      return this;
   }

   /**
    * Gets the trade settlement monetary summation.
    * 
    * Profile:: BASIC
    * 
    * @return the specified trade settlement monetary summation
    */
   @Override
   public MonetarySummation getMonetarySummation() {
      return monetarySummation;
   }

   /**
    * Sets the trade settlement monetary summation.
    * 
    * Profile:: BASIC
    * 
    * @param monetarySummation the new monetary summation
    * @return the supply chain trade settlement
    */
   @Override
   public SpecifiedSettlement setMonetarySummation(MonetarySummation monetarySummation) {
      this.monetarySummation = monetarySummation;
      return this;
   }
}

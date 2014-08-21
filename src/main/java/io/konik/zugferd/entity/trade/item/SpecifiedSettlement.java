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

import io.konik.jaxb.bindable.entity.AccountingAccountAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.CommonSettlement;
import io.konik.zugferd.entity.Period;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Trade Item Settlement
 * 
 * Contains payment related information on an Item basis.
 */
@XmlType(propOrder = { "tradeTax", "billingPeriod", "bookingReference", "monetarySummation" })
public class SpecifiedSettlement implements CommonSettlement<SpecifiedTax, SpecifiedMonetarySummation> {

   @Valid
   @XmlElement(name = "ApplicableTradeTax")
   private List<SpecifiedTax> tradeTax;

   @Valid
   @XmlElement(name = "BillingSpecifiedPeriod")
   private Period billingPeriod;

   @XmlElement(name = "SpecifiedTradeAccountingAccount")
   @XmlJavaTypeAdapter(AccountingAccountAdapter.class)
   private String bookingReference;

   @Valid
   @XmlElement(name = "SpecifiedTradeSettlementMonetarySummation")
   private SpecifiedMonetarySummation monetarySummation;

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
   public String getBookingReference() {
      return bookingReference;
   }

   /**
    * Sets the specified booking reference.
    *
    * Profile:: EXTENDED
    *
    * @param specifiedBookingReference the specified booking reference
    * @return
    */
   public SpecifiedSettlement setBookingReference(String specifiedBookingReference) {
      this.bookingReference = specifiedBookingReference;
      return this;
   }

   /**
    * Gets the trade settlement monetary summation.
    *
    * @return the monetary summation
    */
   @Override
   @Comfort
   public SpecifiedMonetarySummation getMonetarySummation() {
      return monetarySummation;
   }

   /**
    * Sets the trade settlement monetary summation.
    * 
    * @param monetarySummation the new monetary summation
    * @return the supply chain trade settlement
    */
   @Override
   public SpecifiedSettlement setMonetarySummation(SpecifiedMonetarySummation monetarySummation) {
      this.monetarySummation = monetarySummation;
      return this;
   }
}

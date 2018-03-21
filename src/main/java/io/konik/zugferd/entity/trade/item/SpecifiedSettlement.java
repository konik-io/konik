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

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import io.konik.jaxb.bindable.entity.AccountingAccountAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.CommonSettlement;
import io.konik.zugferd.entity.Period;

/**
 * = The Trade Item Settlement
 * 
 * Contains payment related information on an Item basis.
 */
@XmlType(propOrder = { "tradeTax", "billingPeriod", "bookingReference", "monetarySummation" })
public class SpecifiedSettlement implements CommonSettlement<ItemTax, SpecifiedMonetarySummation> {

   @XmlElement(name = "ApplicableTradeTax")
   private List<ItemTax> tradeTax;

   @XmlElement(name = "BillingSpecifiedPeriod")
   private Period billingPeriod;

   @XmlElement(name = "SpecifiedTradeAccountingAccount")
   @XmlJavaTypeAdapter(AccountingAccountAdapter.class)
   private String bookingReference;

   
   @XmlElement(name = "SpecifiedTradeSettlementMonetarySummation")
   private SpecifiedMonetarySummation monetarySummation;

   @Valid
   @Override
   public List<ItemTax> getTradeTax() {
      if (tradeTax == null) {
         tradeTax = new ArrayList<ItemTax>();
      }
      return this.tradeTax;
   }

   @Override
   public SpecifiedSettlement addTradeTax(ItemTax additionalTradeTax) {
      getTradeTax().add(additionalTradeTax);
      return this;
   }

   @Extended
   @Valid
   @Override
   public Period getBillingPeriod() {
      return billingPeriod;
   }

   @Override
   public SpecifiedSettlement setBillingPeriod(Period billingPeriod) {
      this.billingPeriod = billingPeriod;
      return this;
   }

   /**
    * Gets the specified booking reference.
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
    * @param specifiedBookingReference the specified booking reference
    * @return the specified settlement
    */
   public SpecifiedSettlement setBookingReference(String specifiedBookingReference) {
      this.bookingReference = specifiedBookingReference;
      return this;
   }

   @Override
   @Comfort
   public SpecifiedMonetarySummation getMonetarySummation() {
      return monetarySummation;
   }

   @Override
   public SpecifiedSettlement setMonetarySummation(SpecifiedMonetarySummation monetarySummation) {
      this.monetarySummation = monetarySummation;
      return this;
   }
}

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

import io.konik.zugferd.entity.AccountingAccount;
import io.konik.zugferd.entity.CommonSettlement;
import io.konik.zugferd.entity.LogisticsServiceCharge;
import io.konik.zugferd.entity.MonetarySummation;
import io.konik.zugferd.entity.PaymentMeans;
import io.konik.zugferd.entity.PaymentTerm;
import io.konik.zugferd.entity.Period;
import io.konik.zugferd.entity.SpecifiedAllowanceCharge;
import io.konik.zugferd.entity.TradeParty;

import java.util.ArrayList;
import java.util.List;

import com.neovisionaries.i18n.CurrencyCode;

/**
 * = The Trade Settlement
 * 
 * Contains payment and price related information specific to a trade 
 */
public class TradeSettlement extends CommonSettlement<TradeTax, MonetarySummation>{

   /**
    * Gets the payment reference.
    * 
    * Can be same as invoice number.
    * 
    * Profile:: BASIC
    * 
    *
    * @return the payment reference
    */
   public String getPaymentReference() {
      return paymentReference;
   }

   /**
    * Sets the payment reference or note to payee
    * 
    * Can be same as invoice number.
    * 
    * Profile:: BASIC
    * 
    *
    * @param referenceText the reference text
    * @return the trade settlement
    */
   public TradeSettlement setPaymentReference(String referenceText) {
      this.paymentReference = referenceText;
      return this;
   }

    /**
    * Gets the invoice currency code
    * specifiedBookingReference
    * Profile:: BASIC.
    *
    * @return the +ISO 4217 3A+ currency code
    */
   public CurrencyCode getCurrency() {
      return currency;
   }

   /**
    * Sets the invoice currency code.
    * Profile:: BASIC
    *
    * @param currency the new currency
    * @return the trade settlement
    */

   public TradeSettlement setCurrency(CurrencyCode currency) {
      this.currency = currency;
      return this;
   }

   /**
    * Gets the invoicee trade party.
    * 
    * Profile:: COMFORT
    * 
    *
    * @return the invoicee trade party
    */
   public TradeParty getInvoicee() {
      return invoicee;
   }

   /**
    * Sets the invoicee trade party.
    * 
    * Profile:: COMFORT
    * 
    *
    * @param invoicee the new invoicee trade party
    * @return the supply chain trade settlement
    */
   public TradeSettlement setInvoicee(TradeParty invoicee) {
      this.invoicee = invoicee;
      return this;
   }
   

   /**
    * Gets the payee.
    *
    * @return the payee
    */
   public TradeParty getPayee() {
      return payee;
   }

   /**
    * Sets the payee.
    *
    * @param payee the payee
    * @return the settlement
    */
   public TradeSettlement setPayee(TradeParty payee) {
      this.payee = payee;
      return this;
   }

   /**
    * Gets the specified trade settlement payment means.
    *
    * @return the specified trade settlement payment means
    */
   public List<PaymentMeans> getPaymentMeans() {
      if (paymentMeans == null) {
         paymentMeans = new ArrayList<PaymentMeans>();
      }
      return this.paymentMeans;
   }

   /**
    * Adds the payment method.
    *
    * @param newPaymentMethod the new payment method
    * @return the supply chain trade settlement
    */
   public TradeSettlement addPaymentMeans(PaymentMeans newPaymentMethod) {
      getPaymentMeans().add(newPaymentMethod);
      return this;
   }

   /**
    * Gets the applicable trade tax.
    *
    * @return the applicable trade tax
    */
   @Override
   public List<TradeTax> getTradeTax() {
      if (tradeTax == null) {
         tradeTax = new ArrayList<TradeTax>();
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
   public TradeSettlement addTradeTax(TradeTax additionalTradeTax) {
      getTradeTax().add(additionalTradeTax);
      return this;
   }

   /**
    * Gets the billing specified period.
    * 
    * Profile:: COMFORT
    * 
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
   public TradeSettlement setBillingPeriod(Period billingPeriod) {
      this.billingPeriod = billingPeriod;
      return this;
   }

   /**
    * Gets the trade allowance charge.
    * 
    * Profile:: COMFORT
    * 
    *
    * @return the specified trade allowance charge
    */
   public List<SpecifiedAllowanceCharge> getAllowanceCharge() {
      if (allowanceCharge == null) {
         allowanceCharge = new ArrayList<SpecifiedAllowanceCharge>();
      }
      return this.allowanceCharge;
   }

   /**
    * Adds the trade allowance charge.
    * 
    * Profile:: COMFORT
    * 
    *
    * @param additionalAllowanceCharge an additional allowance charge
    * @return the trade settlement
    */
   public TradeSettlement addAllowanceCharge(SpecifiedAllowanceCharge additionalAllowanceCharge) {
      getAllowanceCharge().add(additionalAllowanceCharge);
      return this;
   }

   /**
    * Gets the specified logistics service charge.
    * 
    * Profile:: COMFORT
    * 
    *
    * @return the specified logistics service charge
    */
   public List<LogisticsServiceCharge> getServiceCharge() {
      if (serviceCharge == null) {
         serviceCharge = new ArrayList<LogisticsServiceCharge>();
      }
      return this.serviceCharge;
   }

   /**
    * Adds the specified logistics service charge.
    * 
    * Profile:: COMFORT
    * 
    *
    * @param logisticsServiceCharge the logistics service charge
    * @return the trade settlement
    */
   public TradeSettlement addServiceCharge(LogisticsServiceCharge logisticsServiceCharge) {
      getServiceCharge().add(logisticsServiceCharge);
      return this;
   }

   /**
    * Gets the specified trade payment terms.
    * 
    * Profile:: COMFORT
    * 
    *
    * @return the specified trade payment terms
    */
   public List<PaymentTerm> getPaymentTerms() {
      if (paymentTerms == null) {
         paymentTerms = new ArrayList<PaymentTerm>();
      }
      return this.paymentTerms;
   }

   /**
    * Adds a Payment Term
    * Profile:: COMFORT.
    *
    * @param additionalPaymentTerm the additional payment term
    * @return the trade settlement
    */
   public TradeSettlement addPaymentTerm(PaymentTerm additionalPaymentTerm) {
      getPaymentTerms().add(additionalPaymentTerm);
      return this;
   }

   /**
    * Gets the trade settlement monetary summation.
    * 
    * Profile:: BASIC
    * 
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
    *
    * @param monetarySummation the new monetary summation
    * @return the supply chain trade settlement
    */
   @Override
   public TradeSettlement setMonetarySummation(MonetarySummation monetarySummation) {
      this.monetarySummation = monetarySummation;
      return this;
   }

   /**
    * Gets the booking reference account.
    * Profile:: EXTENDED
    *
    * @return the account of the booking reference
    */
   public AccountingAccount getReceivableBookingReference() {
      return receivableBookingReference;
   }

   /**
    * Sets the booking reference account.
    * Profile:: EXTENDED
    *
    * @param bookingReference the booking reference account.
    * @return the trade
    */
   public TradeSettlement setReceivableBookingReference(AccountingAccount bookingReference) {
      this.receivableBookingReference = bookingReference;
      return this;
   }

}

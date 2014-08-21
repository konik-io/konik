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

import io.konik.jaxb.bindable.entity.AccountingAccountAdapter;
import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.CommonSettlement;
import io.konik.zugferd.entity.LogisticsServiceCharge;
import io.konik.zugferd.entity.PaymentMeans;
import io.konik.zugferd.entity.PaymentTerm;
import io.konik.zugferd.entity.Period;
import io.konik.zugferd.entity.SpecifiedAllowanceCharge;
import io.konik.zugferd.entity.TradeParty;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.neovisionaries.i18n.CurrencyCode;

/**
 * = The Trade Settlement
 * 
 * Contains payment and price related information specific to a trade
 */
@XmlType(propOrder = { "paymentReference", "currency", "invoicee", "payee", "paymentMeans", "tradeTax",
      "billingPeriod", "allowanceCharge", "serviceCharge", "paymentTerms", "monetarySummation",
      "receivableBookingReference" })
public class Settlement implements CommonSettlement<TradeTax, MonetarySummation> {

   @XmlElement(name = "PaymentReference")
   private String paymentReference;

   @XmlElement(name = "InvoiceCurrencyCode")
   private CurrencyCode currency;

   @Valid
   @XmlElement(name = "InvoiceeTradeParty")
   private TradeParty invoicee;

   @Valid
   @XmlElement(name = "PayeeTradeParty")
   private TradeParty payee;

   @Valid
   @XmlElement(name = "SpecifiedTradeSettlementPaymentMeans")
   private List<PaymentMeans> paymentMeans;

   @Valid
   @XmlElement(name = "ApplicableTradeTax")
   private List<TradeTax> tradeTax;

   @Valid
   @XmlElement(name = "BillingSpecifiedPeriod")
   private Period billingPeriod;

   @Valid
   @XmlElement(name = "SpecifiedTradeAllowanceCharge")
   private List<SpecifiedAllowanceCharge> allowanceCharge;

   @Valid
   @XmlElement(name = "SpecifiedLogisticsServiceCharge")
   private List<LogisticsServiceCharge> serviceCharge;

   @Valid
   @XmlElement(name = "SpecifiedTradePaymentTerms")
   private List<PaymentTerm> paymentTerms;

   @Valid
   @XmlElement(name = "SpecifiedTradeSettlementMonetarySummation")
   private MonetarySummation monetarySummation;

   @XmlElement(name = "ReceivableSpecifiedTradeAccountingAccount")
   @XmlJavaTypeAdapter(AccountingAccountAdapter.class)
   private String receivableBookingReference;

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
   public Settlement setPaymentReference(String referenceText) {
      this.paymentReference = referenceText;
      return this;
   }

   /**
    * Gets the invoice currency code
    * specifiedBookingReference
    *
    * @return the +ISO 4217 3A+ currency code
    */
   @Basic
   public CurrencyCode getCurrency() {
      return currency;
   }

   /**
    * Sets the invoice currency code.
    *
    * @param currency the new currency
    * @return the trade settlement
    */

   public Settlement setCurrency(CurrencyCode currency) {
      this.currency = currency;
      return this;
   }

   /**
    * Gets the invoicee trade party.
    * 
    * @return the invoicee trade party
    */
   @Comfort
   public TradeParty getInvoicee() {
      return invoicee;
   }

   /**
    * Sets the invoicee trade party.
    * 
    * Profile:: COMFORT
    *
    * @param invoicee the new invoicee trade party
    * @return the supply chain trade settlement
    */
   public Settlement setInvoicee(TradeParty invoicee) {
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
   public Settlement setPayee(TradeParty payee) {
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
   public Settlement addPaymentMeans(PaymentMeans newPaymentMethod) {
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
   public Settlement addTradeTax(TradeTax additionalTradeTax) {
      getTradeTax().add(additionalTradeTax);
      return this;
   }

   /**
    * Gets the billing specified period.
    * 
    * @return the billing specified period
    */

   @Comfort
   @Override
   public Period getBillingPeriod() {
      return billingPeriod;
   }

   /**
    * Sets the billing specified period.
    * 
    * @param billingPeriod the new billing specified period
    * @return the supply chain trade settlement
    */
   @Override
   public Settlement setBillingPeriod(Period billingPeriod) {
      this.billingPeriod = billingPeriod;
      return this;
   }

   /**
    * Gets the trade allowance charge.
    * 
    * @return the specified trade allowance charge
    */
   @Comfort
   public List<SpecifiedAllowanceCharge> getAllowanceCharge() {
      if (allowanceCharge == null) {
         allowanceCharge = new ArrayList<SpecifiedAllowanceCharge>();
      }
      return this.allowanceCharge;
   }

   /**
    * Adds the trade allowance charge.
    * 
    * @param additionalAllowanceCharge an additional allowance charge
    * @return the trade settlement
    */
   @Comfort
   public Settlement addAllowanceCharge(SpecifiedAllowanceCharge additionalAllowanceCharge) {
      getAllowanceCharge().add(additionalAllowanceCharge);
      return this;
   }

   /**
    * Gets the specified logistics service charge.
    * 
    * @return the specified logistics service charge
    */
   @Comfort
   public List<LogisticsServiceCharge> getServiceCharge() {
      if (serviceCharge == null) {
         serviceCharge = new ArrayList<LogisticsServiceCharge>();
      }
      return this.serviceCharge;
   }

   /**
    * Adds the specified logistics service charge.
    * 
    * @param logisticsServiceCharge the logistics service charge
    * @return the trade settlement
    */
   @Comfort
   public Settlement addServiceCharge(LogisticsServiceCharge logisticsServiceCharge) {
      getServiceCharge().add(logisticsServiceCharge);
      return this;
   }

   /**
    * Gets the specified trade payment terms.
    * 
    * @return the specified trade payment terms
    */
   @Comfort
   public List<PaymentTerm> getPaymentTerms() {
      if (paymentTerms == null) {
         paymentTerms = new ArrayList<PaymentTerm>();
      }
      return this.paymentTerms;
   }

   /**
    * Adds a Payment Term
    * 
    *
    * @param additionalPaymentTerm the additional payment term
    * @return the trade settlement
    */
   @Comfort
   public Settlement addPaymentTerm(PaymentTerm additionalPaymentTerm) {
      getPaymentTerms().add(additionalPaymentTerm);
      return this;
   }

   /**
    * Gets the trade settlement monetary summation.
    * 
    * @return the specified trade settlement monetary summation
    */
   @NotNull
   @Basic
   @Override
   public MonetarySummation getMonetarySummation() {
      return monetarySummation;
   }

   /**
    * Sets the trade settlement monetary summation.
    * 
    * @param monetarySummation the new monetary summation
    * @return the supply chain trade settlement
    */
   @Basic
   @Override
   public Settlement setMonetarySummation(MonetarySummation monetarySummation) {
      this.monetarySummation = monetarySummation;
      return this;
   }

   /**
    * Gets the booking reference account.
    *
    * @return the account of the booking reference
    */
   @Extended
   public String getReceivableBookingReference() {
      return receivableBookingReference;
   }

   /**
    * Sets the booking reference account.
    * Profile:: EXTENDED
    *
    * @param bookingReference the booking reference account.
    * @return the trade
    */
   public Settlement setReceivableBookingReference(String bookingReference) {
      this.receivableBookingReference = bookingReference;
      return this;
   }

}

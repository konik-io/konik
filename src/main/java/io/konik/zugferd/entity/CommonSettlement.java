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

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.neovisionaries.i18n.CurrencyCode;

/**
 * = The Trade Settlement
 * 
 * Contains payment related information.
 * @param <TAX> Tax
 * @param <MS> MonetarySummation
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeSettlementType", propOrder = { "paymentReference", "currency", "invoicee","payee",
      "paymentMeans", "tradeTax", "billingPeriod", "allowanceCharge", "serviceCharge", "paymentTerms","specifiedBookingReference",
      "monetarySummation", "receivableBookingReference" })
public abstract class CommonSettlement<TAX extends Tax, MS extends MonetarySummation> {

   /** The payment reference or reason for payment */
   @XmlElement(name = "PaymentReference")
   protected String paymentReference; 

   /** The invoice currency code. */
   @XmlElement(name = "InvoiceCurrencyCode")
   protected CurrencyCode currency;// not in item

   /** The invoicee trade party. */
   @Valid
   @XmlElement(name = "InvoiceeTradeParty")
   protected TradeParty invoicee;// not in item
   
   @XmlElement(name = "PayeeTradeParty")
   @Valid
   protected TradeParty payee;// not in item

   /** The specified trade settlement payment means. */
   @Valid
   @XmlElement(name = "SpecifiedTradeSettlementPaymentMeans")
   protected List<PaymentMeans> paymentMeans;// not in item

   /** The applicable trade tax. */
   @Valid
   @XmlElement(name = "ApplicableTradeTax")
   protected List<TAX> tradeTax;

   /** The billing period. */
   @Valid
   @XmlElement(name = "BillingSpecifiedPeriod")
   protected Period billingPeriod;  //COMMON

   /** The trade allowance charge. */
   @Valid
   @XmlElement(name = "SpecifiedTradeAllowanceCharge")
   protected List<SpecifiedAllowanceCharge> allowanceCharge; 

   /** The logistics service charge. */
   @Valid
   @XmlElement(name = "SpecifiedLogisticsServiceCharge")
   protected List<LogisticsServiceCharge> serviceCharge;//TODO: trade.settlement.serviceCharge.tradeTax NO CalculatedAmount, ExemptionReason, BasisAmount, LineTotalBasisAmount, AllowanceChargeBasisAmount

   /** The trade payment terms. */
   @Valid
   @XmlElement(name = "SpecifiedTradePaymentTerms")
   protected List<PaymentTerm> paymentTerms;

   @Valid
   @XmlElement(name = "SpecifiedTradeAccountingAccount")
   protected AccountingAccount specifiedBookingReference; //TODO: only in item.settlement
   
   /** The trade settlement monetary summation. */
   @Valid
   @XmlElement(name = "SpecifiedTradeSettlementMonetarySummation")
   protected MS monetarySummation;
   //TODO: trade.item.settlement.monetarySummation ONLY lineTotal, allowanceTotal 
   //TODO: trade.settlement.monetarySummation no allowanceTotal
   
   /** The receivable specified trade accounting account. */
   @XmlElement(name = "ReceivableSpecifiedTradeAccountingAccount")
   protected AccountingAccount receivableBookingReference; //TODO: trade.settlement only
   
   /**
    * Gets the billing specified period.
    * 
    * Profile:: COMFORT
    * 
    *
    * @return the billing specified period
    */
   public abstract Period getBillingPeriod();

   /**
    * Sets the billing specified period.
    * 
    * Profile:: COMFORT
    * 
    *
    * @param billingPeriod the new billing specified period
    * @return the supply chain trade settlement
    */
   public abstract CommonSettlement<TAX, MS> setBillingPeriod(Period billingPeriod);
    
   /**
    * Gets the applicable trade tax.
    *
    * @return the applicable trade tax
    */
   public abstract List<TAX> getTradeTax();

   /**
    * Adds a trade tax.
    * 
    * @param additionalTradeTax
    * @return the trade settlement
    */
   public abstract CommonSettlement<TAX, MS> addTradeTax(TAX additionalTradeTax);

   /**
    * Gets the trade settlement monetary summation.
    * 
    * Profile:: BASIC
    *
    * @return the specified trade settlement monetary summation
    */
   public abstract MS getMonetarySummation();

   /**
    * Sets the trade settlement monetary summation.
    * 
    * Profile:: BASIC
    *
    * @param monetarySummation the new monetary summation
    * @return the supply chain trade settlement
    */
   public abstract CommonSettlement<TAX, MS> setMonetarySummation(MS monetarySummation);

}

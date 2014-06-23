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

import io.konik.zugferd.unece.codes.PaymentMeansCode;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Payment Means
 * 
 * Detailed information on the means of payment.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeSettlementPaymentMeansType", propOrder = { "code", "information", "payerAccount", "payeeAccount",
      "payerInstitution", "payeeInstitution" })
@ValidateOnExecution
public class PaymentMeans {

   @Valid
   @XmlElement(name = "TypeCode")
   private PaymentMeansCode code;

   @XmlElement(name = "Information")
   private List<String> information;

   @Valid
   @XmlElement(name = "PayerPartyDebtorFinancialAccount")
   private FinancialAccount payerAccount;

   @Valid
   @XmlElement(name = "PayeePartyCreditorFinancialAccount")
   private FinancialAccount payeeAccount;

   @Valid
   @XmlElement(name = "PayerSpecifiedDebtorFinancialInstitution")
   private FinancialInstitution payerInstitution;

   @Valid
   @XmlElement(name = "PayeeSpecifiedCreditorFinancialInstitution")
   private FinancialInstitution payeeInstitution;

   /**
    * Gets the +UNCL 4461+ type code.
    * 
    * Profile:: COMFORT
    * 
    * @return the UNCL 4461 type code
    * @see http://www.unece.org/trade/untdid/d13b/tred/tred4461.htm[UN/EDIFACT 4461 Payment means code^]
    */
   public PaymentMeansCode getCode() {
      return code;
   }

   /**
    * Sets the +UNCL 4461+ code.
    *
    * Profile:: *COMFORT*
    * 
    * @param paymentMeansCode the new UNCL 4461 payment means code
    * @return the trade settlement payment means
    * @see http://www.unece.org/trade/untdid/d13b/tred/tred4461.htm[UN/EDIFACT 4461 Payment means code^]
    */
   public PaymentMeans setCode(PaymentMeansCode paymentMeansCode) {
      this.code = paymentMeansCode;
      return this;
   }

   /**
    * Gets the free text payment method information.
    * 
    * Profile:: COMFORT
    * 
    * Example:: +Cash, Credit Card+
    * 
    * @return the information
    */
   public List<String> getInformation() {
      if (information == null) {
         information = new ArrayList<String>();
      }
      return this.information;
   }

   /**
    * Adds the free text payment method information.
    * 
    * Profile:: COMFORT
    * 
    * Example:: +Cash, Credit Card+
    *
    * @param additionalInformation the additional information
    * @return the payment means
    */
   public PaymentMeans addInformation(String additionalInformation) {
      getInformation().add(additionalInformation);
      return this;
   }

   /**
    * Gets the payer/buyer debtor financial account.
    * 
    * Profile:: COMFORT
    * 
    * 
    * @return the payer party debtor financial account
    */
   public FinancialAccount getPayerAccount() {
      return payerAccount;
   }

   /**
    * Sets the payer/buyer party debtor financial account.
    * 
    * Profile:: COMFORT
    * 
    * 
    * @param payerAccount the payer account
    * @return the trade settlement payment means
    */
   public PaymentMeans setPayerAccount(FinancialAccount payerAccount) {
      this.payerAccount = payerAccount;
      return this;
   }

   /**
    * Gets the payee/seller party creditor financial account.
    * 
    * Profile:: BASIC
    * 
    * 
    * @return the payee party creditor financial account
    */
   public FinancialAccount getPayeeAccount() {
      return payeeAccount;
   }

   /**
    * Sets the payee/seller party creditor financial account.
    * 
    * Profile:: BASIC
    * 
    * 
    * @param payeeAccount the payee account
    * @return the trade settlement payment means
    */
   public PaymentMeans setPayeeAccount(FinancialAccount payeeAccount) {
      this.payeeAccount = payeeAccount;
      return this;
   }

   /**
    * Gets the payer/buyer specified debtor financial institution.
    * 
    * Profile:: COMFORT
    * 
    * 
    * @return the payer specified debtor financial institution
    */
   public FinancialInstitution getPayerInstitution() {
      return payerInstitution;
   }

   /**
    * Sets the payer/buyer specified debtor financial institution.
    * 
    * Profile:: COMFORT
    * 
    * 
    * @param payerInstitution the payer institution
    * @return the trade settlement payment means
    */
   public PaymentMeans setPayerInstitution(FinancialInstitution payerInstitution) {
      this.payerInstitution = payerInstitution;
      return this;
   }

   /**
    * Gets the payee/seller specified creditor financial institution.
    * 
    * Profile:: BASIC
    * 
    * 
    * @return the payee specified creditor financial institution
    */
   public FinancialInstitution getPayeeInstitution() {
      return payeeInstitution;
   }

   /**
    * Sets the payee/seller specified creditor financial institution.
    * 
    * Profile:: BASIC
    * 
    * 
    * @param payeeInstitution the payee institution
    * @return the trade settlement payment means
    */
   public PaymentMeans setPayeeInstitution(FinancialInstitution payeeInstitution) {
      this.payeeInstitution = payeeInstitution;
      return this;
   }

}

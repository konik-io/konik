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
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.unece.codes.PaymentMeansCode;
import io.konik.zugferd.unqualified.ExtendedID;

/**
 * = The Payment Means
 * 
 * Detailed information on the means of payment.
 */
@XmlType(name = "TradeSettlementPaymentMeansType", propOrder = { "code", "informations", "mandateReference",
      "payerAccount", "payeeAccount", "payerInstitution", "payeeInstitution" })
public class PaymentMeans implements Serializable {

   @XmlElement(name = "TypeCode")
   private PaymentMeansCode code;

   @XmlElement(name = "Information")
   private List<String> informations;

   @XmlElement(name = "ID")
   private ExtendedID mandateReference;

   @XmlElement(name = "PayerPartyDebtorFinancialAccount")
   private DebtorFinancialAccount payerAccount;

   @XmlElement(name = "PayeePartyCreditorFinancialAccount")
   private CreditorFinancialAccount payeeAccount;

   @XmlElement(name = "PayerSpecifiedDebtorFinancialInstitution")
   private FinancialInstitution payerInstitution;

   @XmlElement(name = "PayeeSpecifiedCreditorFinancialInstitution")
   private FinancialInstitution payeeInstitution;

   /**
    * Gets the +UNCL 4461+ type code.
    * 
    * @return the UNCL 4461 type code
    * @see http://www.unece.org/trade/untdid/d13b/tred/tred4461.htm[UN/EDIFACT 4461 Payment means code^]
    */
   @Comfort
   public PaymentMeansCode getCode() {
      return code;
   }

   /**
    * Sets the +UNCL 4461+ code.
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
    * Free text containing payment method information.
    * 
    * Example:: +Cash, Credit Card+
    * 
    * @return the information
    */
   @Comfort
   public List<String> getInformations() {
      if (informations == null) {
         informations = new ArrayList<String>();
      }
      return this.informations;
   }

   /**
    * Adds the free text payment method information.
    * 
    * Example:: +Cash, Credit Card+
    *
    * @param additionalInformation the additional information
    * 
    * @return the payment means
    */
   public PaymentMeans addInformation(String additionalInformation) {
      getInformations().add(additionalInformation);
      return this;
   }

   /**
    * Gets the mandate reference and client creditor id.
    *
    * {@link http://de.wikipedia.org/wiki/Mandatsreferenz}
    * 
    * @return the mandate reference and client creditor id
    */
   @Valid
   @Basic
   public ExtendedID getMandateReference() {
      return mandateReference;
   }

   /**
    * Sets the mandate reference and client creditor id.
    * 
    * {@link http://de.wikipedia.org/wiki/Mandatsreferenz}
    *
    * @param mandateReference the new mandate reference and client creditor id
    */
   public void setMandateReference(ExtendedID mandateReference) {
      this.mandateReference = mandateReference;
   }

   /**
    * Gets the payer/buyer financial account.
    * 
    * @return the payer financial account
    */
   @Valid
   @Comfort
   public DebtorFinancialAccount getPayerAccount() {
      return payerAccount;
   }

   /**
    * Sets the payer/buyer financial account.
    *
    * @param payerAccount the payer account
    * @return the payment means
    */
   public PaymentMeans setPayerAccount(DebtorFinancialAccount payerAccount) {
      this.payerAccount = payerAccount;
      return this;
   }

   /**
    * Gets the payee/seller financial account.
    * 
    * @return the payee financial account
    */
   @Valid
   @Basic
   public CreditorFinancialAccount getPayeeAccount() {
      return payeeAccount;
   }

   /**
    * Sets the payee/seller party creditor financial account.
    * 
    * @param payeeAccount the payee account
    * @return the trade settlement payment means
    */
   public PaymentMeans setPayeeAccount(CreditorFinancialAccount payeeAccount) {
      this.payeeAccount = payeeAccount;
      return this;
   }

   /**
    * Gets the payer/buyer specified debtor financial institution.
    * 
    * @return the payer specified debtor financial institution
    */
   @Valid
   @Comfort
   public FinancialInstitution getPayerInstitution() {
      return payerInstitution;
   }

   /**
    * Sets the payer/buyer specified debtor financial institution.
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
    * @return the payee specified creditor financial institution
    */
   @Valid
   @Basic
   public FinancialInstitution getPayeeInstitution() {
      return payeeInstitution;
   }

   /**
    * Sets the payee/seller specified creditor financial institution.
    * 
    * @param payeeInstitution the payee institution
    * @return the trade settlement payment means
    */
   public PaymentMeans setPayeeInstitution(FinancialInstitution payeeInstitution) {
      this.payeeInstitution = payeeInstitution;
      return this;
   }

}

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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *  
 * The Creditor Financial Account.
 */
@XmlType(name = "CreditorFinancialAccountType", propOrder = { "iban", "accountName", "proprietaryId" })
public class CreditorFinancialAccount implements FinancialAccount {

   @XmlElement(name = "IBANID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String iban;

   @XmlElement(name = "AccountName")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   protected String accountName;

   @XmlElement(name = "ProprietaryID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String proprietaryId;

   /**
    * Instantiates a new creditor financial account.
    */
   public CreditorFinancialAccount() {
   }

   /**
    * Instantiates a new creditor financial account.
    *
    * @param iban the iban
    */
   public CreditorFinancialAccount(String iban) {
      super();
      this.iban = iban;
   }

   /**
    * Instantiates a new creditor financial account.
    *
    * @param iban the iban
    * @param accountName the account name
    */
   public CreditorFinancialAccount(String iban, String accountName) {
      super();
      this.iban = iban;
      this.accountName = accountName;
   }

   @Override
   public String getIban() {
      return iban;
   }

   @Override
   public CreditorFinancialAccount setIban(String iban) {
      this.iban = iban;
      return this;
   }

   /**
    * Gets the account owner name.
    *
    * @return the account name
    */
   public String getAccountName() {
      return accountName;
   }

   /**
    * Sets the account owner name.
    *
    * @param value the value
    * @return the creditor financial account
    */
   public CreditorFinancialAccount setAccountName(String value) {
      this.accountName = value;
      return this;
   }

   @Override
   public String getProprietaryId() {
      return proprietaryId;
   }

   @Override
   public CreditorFinancialAccount setProprietaryId(String proprietaryId) {
      this.proprietaryId = proprietaryId;
      return this;
   }

}

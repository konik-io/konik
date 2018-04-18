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
 * = The Debtor Financial Account.
 */
@XmlType(name = "DebtorFinancialAccountType", propOrder = { "iban", "proprietaryId" })
public class DebtorFinancialAccount implements FinancialAccount {

   @XmlElement(name = "IBANID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String iban;

   @XmlElement(name = "ProprietaryID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String proprietaryId;

   /**
    * Instantiates a new debtor financial account.
    */
   public DebtorFinancialAccount() {
   }

   /**
    * Instantiates a new debtor financial account.
    *
    * @param iban the iban
    */
   public DebtorFinancialAccount(String iban) {
      this.iban = iban;
   }

   @Override
   public String getIban() {
      return iban;
   }

   @Override
   public DebtorFinancialAccount setIban(String iban) {
      this.iban = iban;
      return this;
   }

   @Override
   public String getProprietaryId() {
      return proprietaryId;
   }

   @Override
   public DebtorFinancialAccount setProprietaryId(String proprietaryId) {
      this.proprietaryId = proprietaryId;
      return this;
   }
}

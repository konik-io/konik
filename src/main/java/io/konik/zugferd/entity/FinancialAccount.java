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

import java.io.Serializable;

import io.konik.validator.annotation.ValidFinancialAccount;

/**
 * = The Financial Account.
 */
@ValidFinancialAccount
public interface FinancialAccount extends Serializable {

   /**
    * Gets the iban.
    * 
    * @return the iban
    */
   String getIban();

   /**
    * Sets the iban.
    *
    * @param iban the new iban
    * @return the financial account
    */
   FinancialAccount setIban(String iban);

   /**
    * Gets the german account number.
    * 
    * @return the proprietary id
    */
   String getProprietaryId();

   /**
    * Sets the  german account number.
    *
    * @param proprietaryId the new proprietary id
    * @return the financial account
    */
   FinancialAccount setProprietaryId(String proprietaryId);

}

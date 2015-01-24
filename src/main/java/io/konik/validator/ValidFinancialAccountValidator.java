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
package io.konik.validator;

import static io.konik.util.Strings.isNotEmpty;
import io.konik.validator.annotation.ValidFinancialAccount;
import io.konik.zugferd.entity.FinancialAccount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *  
 * The Valid Financial Account Validator will check if a Financial Account 
 * has a not empty {@link FinancialAccount#getIban()} or {@link FinancialAccount#getProprietaryId()}.
 */
public class ValidFinancialAccountValidator implements  ConstraintValidator<ValidFinancialAccount, FinancialAccount> {

   /**
    * Initialize.
    *
    * @param constraintAnnotation the constraint annotation
    */
   @Override
   public void initialize(ValidFinancialAccount constraintAnnotation) {
   }

   /**
    * Checks if is valid.
    *
    * @param contact the contact
    * @param context the context
    * @return true, if is valid
    */
   @Override
   public boolean isValid(FinancialAccount account, ConstraintValidatorContext context) {
      if (account != null) {
         return isNotEmpty(account.getProprietaryId()) || isNotEmpty(account.getIban());           
      }
      return true;
   }
}
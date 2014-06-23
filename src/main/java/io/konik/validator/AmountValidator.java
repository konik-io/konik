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
package io.konik.validator;

import io.konik.validator.annotation.ValidAmount;
import io.konik.zugferd.unqualified.Amount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * = The Amount Validator.
 * 
 * Validator for {@link ValidAmount} Annotations.
 */
public class AmountValidator implements ConstraintValidator<ValidAmount,Amount>{

   @Override
   public void initialize(ValidAmount constraintAnnotation) {
      // TODO Auto-generated method stub
   }

   @Override
   public boolean isValid(Amount value, ConstraintValidatorContext context) {
      // TODO Auto-generated method stub
      return false;
   }

}

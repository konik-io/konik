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

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import io.konik.validator.annotation.Email;

/**
 *  
 * The Email Validator for the @Email Annotation
 */
public class EmailValidator implements ConstraintValidator<Email, String> {
   private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

   private static final Pattern EMAIL_COMPILED_PATTERN = Pattern.compile(EMAIL_PATTERN);

   @Override
   public void initialize(Email constraintAnnotation) {

   }

   @Override
   public boolean isValid(String email, ConstraintValidatorContext context) {
      if (email == null) {
         return true;
      }
      return EMAIL_COMPILED_PATTERN.matcher(email).matches();
   }
}

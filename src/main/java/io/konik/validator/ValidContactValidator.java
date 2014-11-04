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
import io.konik.validator.annotation.ValidContact;
import io.konik.zugferd.entity.Contact;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validates if the Contact is valid by having a contact name or department
 */
public class ValidContactValidator implements  ConstraintValidator<ValidContact,Contact> {

   @Override
   public void initialize(ValidContact constraintAnnotation) {
   }

   @Override
   public boolean isValid(Contact contact, ConstraintValidatorContext context) {
      String name = contact.getName();
      String department = contact.getDepartment();
      if (isNotEmpty(name) || isNotEmpty(department)) {
         return true;
      }
      return false;
   }



}

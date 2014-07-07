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

import io.konik.validator.annotation.NullableNotBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * = The Not Blank Validator.
 * 
 * Validator for the {@link NullableNotBlank} annotation.
 * 
 * @see {@link NullableNotBlank}
 */
public class NotBlankValidator implements ConstraintValidator<NullableNotBlank, CharSequence> {

   /**
    * Initialize.
    *
    * @param annotation the annotation
    */
   @Override
   public void initialize(NullableNotBlank annotation) {
   }

   /**
    * Checks that the trimmed string is not Blank.
    *
    * @param charSequence The character sequence to validate.
    * @param constraintValidatorContext context in which the constraint is evaluated.
    *
    * @return Returns +true+ if the string is +null+ or the length of +charSequence+ is greater zero omitting leading
    * and trailing whitespace.
    * Otherwise it will return +false+.
    */
   @Override
   public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
      if (charSequence == null) { return true; }
      return charSequence.toString().trim().length() > 0;
   }
}
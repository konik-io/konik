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
package io.konik.validator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import io.konik.validator.NotBlankValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

/**
 * Validate that if a string is not null it should be not empty or consists of only whitespaces.
 * Compared to {@code NotEmpty} this validator will not accept whitespaces as valid.
 * Compared to {@code NotBlank} this validator will accept null as valid.
 */
@Documented
@Constraint(validatedBy = { NotBlankValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface NullableNotBlank {

   /**
    * Message.
    *
    * @return the string
    */
   String message() default "{io.konik.validator.NotBlank.message}";

   /**
    * Groups.
    *
    * @return the class<?>[]
    */
   Class<?>[] groups() default {};

   /**
    * Payload.
    *
    * @return the class<? extends payload>[]
    */
   Class<? extends Payload>[] payload() default {};

   /**
    * Multiple {@code @NotBlank} annotations on the same element.
    */
   @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
   @Retention(RUNTIME)
   @Documented
   public @interface List {

      /**
       * Value.
       *
       * @return the not blank[]
       */
      NullableNotBlank[] value();
   }
}
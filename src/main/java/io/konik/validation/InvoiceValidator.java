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
package io.konik.validation;

import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.profile.ConformanceLevel;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

/**
 * Validates the invoice against the declared invoice profile.
 */
@Named
@Singleton
public class InvoiceValidator {

   private Validator validator;

   /**
    * Instantiates a new invoice validator.
    *
    * @param validator the validator
    */
   @Inject
   public InvoiceValidator(Validator validator) {
      super();
      this.validator = validator;
   }

   /**
    * Validate the invoice
    *
    * @param invoice the invoice
    * @return the sets the
    */
   public Set<ConstraintViolation<Invoice>> validate(Invoice invoice) {
      ConformanceLevel conformanceLevel = invoice.getContext().getGuideline().getConformanceLevel();
      Class<?>[] validationGroups = resolveIntoValidationGroups(conformanceLevel);
      return validator.validate(invoice, validationGroups);
   }

   /**
    * Resolve the given profile into bean validation groups.
    *
    * @param conformanceLevel the given profile
    * @return the class[] list of validation group classes
    */
   public static Class<?>[] resolveIntoValidationGroups(ConformanceLevel conformanceLevel) {
      switch (conformanceLevel) {
      case BASIC:
         return new Class[] { Default.class };
      case COMFORT:
         return new Class[] { Default.class, Comfort.class };
      case EXTENDED:
         return new Class[] { Default.class, Comfort.class, Extended.class };
      default:
         throw new IllegalArgumentException("Provided Profile:" + conformanceLevel + "not covered");
      }
   }
}

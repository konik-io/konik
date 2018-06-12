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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.bval.jsr.DefaultMessageInterpolator;
import org.xml.sax.SAXException;

import io.konik.InvoiceTransformer;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.profile.ConformanceLevel;

/**
 * Validates the invoice against the declared invoice profile.
 */
@Named
@Singleton
public class InvoiceValidator {

   private final Validator validator;
   private final MonetarySummationValidator monetarySummationValidator;

   /**
    * Instantiates a new invoice validator.
    *
    * @param validator the validator
    * @param monetarySummationValidator 
    */
   @Inject
   public InvoiceValidator(Validator validator, MonetarySummationValidator monetarySummationValidator) {
      super();
      this.validator = validator;
      this.monetarySummationValidator = monetarySummationValidator;
   }

   /**
    * Instantiates a new invoice validator.
    *
    * @param validator the validator
    */
   public InvoiceValidator(Validator validator) {
      super();
      this.validator = validator;
      this.monetarySummationValidator = new MonetarySummationValidator(new DefaultMessageInterpolator());
   }

   /**
    * Instantiates a new default invoice validator, based on the Bean Validation provider
    */
   public InvoiceValidator() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      this.validator = factory.getValidator();
      this.monetarySummationValidator = new MonetarySummationValidator(new DefaultMessageInterpolator());
   }

   /**
   * Validate the invoice without scheme-validation
   *
   * @param invoice the invoice
   * @return the sets the
   */
   public Set<ConstraintViolation<Invoice>> validate(Invoice invoice) {
      return validate(invoice, false);
   }

   /**
   * Validate the invoice
   *
   * @param invoice the invoice
   * @param shallBeVvalidatedWithScheme true if the Validation should validate the invoice with the scheme aswell.
   * @return the sets the
   */
   public Set<ConstraintViolation<Invoice>> validate(Invoice invoice, boolean shallBeVvalidatedWithScheme) {
      ConformanceLevel conformanceLevel = invoice.getContext().getGuideline().getConformanceLevel();
      Class<?>[] validationGroups = resolveIntoValidationGroups(conformanceLevel);
      Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice, validationGroups);

      if (monetarySummationValidator != null) {
         violations.addAll(monetarySummationValidator.validate(invoice, validationGroups));
      }

      if (shallBeVvalidatedWithScheme) {
         try {
            validateWithShema(invoice);
         } catch (IOException e) {
            violations.add(new Violation(invoice, e.getLocalizedMessage(), "invoice.io.error",
                  e.getMessage(), "error"));
         } catch (SAXException e) {
            violations.add(new Violation(invoice, e.getLocalizedMessage(), "scheme.validation.error",
                  e.getMessage(), "error"));
         }
      }

      return violations;
   }

   private void validateWithShema(Invoice invoice) throws IOException, SAXException {
      InvoiceTransformer invoiceTransformer = new InvoiceTransformer();
      Source xmlFile = new StreamSource(new ByteArrayInputStream(invoiceTransformer.fromModel(invoice)));
      invoiceTransformer.getZfSchemaValidator().validate(xmlFile);
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

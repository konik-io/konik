/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintTarget;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import javax.validation.Path;
import javax.validation.Payload;
import javax.validation.metadata.ConstraintDescriptor;

import org.apache.bval.jsr.util.PathImpl;

import io.konik.zugferd.Invoice;

class Violation implements ConstraintViolation<Invoice> {

   private final Invoice invoice;
   private final String message;
   private final String messageTemplate;
   private final String propertyPath;
   private final Object invalidValue;

   public Violation(Invoice invoice, String message, String messageTemplate, String propertyPath,
         Object invalidValue) {
      this.invoice = invoice;
      this.message = message;
      this.messageTemplate = messageTemplate;
      this.propertyPath = propertyPath;
      this.invalidValue = invalidValue;
   }

   @Override
   public String getMessage() {
      return message;
   }

   @Override
   public String getMessageTemplate() {
      return messageTemplate;
   }

   @Override
   public Invoice getRootBean() {
      return invoice;
   }

   @Override
   public Class<Invoice> getRootBeanClass() {
      return Invoice.class;
   }

   @Override
   public Object getLeafBean() {
      return null;
   }

   @Override
   public Object[] getExecutableParameters() {
      return new Object[0];
   }

   @Override
   public Object getExecutableReturnValue() {
      return null;
   }

   @Override
   public Path getPropertyPath() {
      return PathImpl.createPathFromString(propertyPath);
   }

   @Override
   public Object getInvalidValue() {
      return invalidValue;
   }

   @Override
   public ConstraintDescriptor<?> getConstraintDescriptor() {
      return null;
   }

   @Override
   public <U> U unwrap(Class<U> type) {
      return null;
   }

   static class Context implements MessageInterpolator.Context {

      private final Object currentValue;
      private final Object expectedValue;

      public Context(Object currentValue, Object expectedValue) {
         this.currentValue = currentValue;
         this.expectedValue = expectedValue;
      }

      @Override
      public ConstraintDescriptor<?> getConstraintDescriptor() {
         return new ConstraintDescriptor<Annotation>() {
            @Override
            public Annotation getAnnotation() {
               return null;
            }

            @Override
            public String getMessageTemplate() {
               return "{io.konik.validation.amount.calculation.error}";
            }

            @Override
            public Set<Class<?>> getGroups() {
               return null;
            }

            @Override
            public Set<Class<? extends Payload>> getPayload() {
               return null;
            }

            @Override
            public ConstraintTarget getValidationAppliesTo() {
               return null;
            }

            @Override
            public List<Class<? extends ConstraintValidator<Annotation, ?>>> getConstraintValidatorClasses() {
               return new LinkedList<Class<? extends ConstraintValidator<Annotation, ?>>>();
            }

            @Override
            public Map<String, Object> getAttributes() {
               Map<String, Object> map = new HashMap<String, Object>();
               map.put("currentValue", currentValue);
               map.put("expectedValue", expectedValue);
               return map;
            }

            @Override
            public Set<ConstraintDescriptor<?>> getComposingConstraints() {
               return new HashSet<ConstraintDescriptor<?>>();
            }

            @Override
            public boolean isReportAsSingleViolation() {
               return false;
            }
         };
      }

      @Override
      public Object getValidatedValue() {
         return currentValue;
      }

      @Override
      public <T> T unwrap(Class<T> type) {
         return null;
      }
   }
}

/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
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
}

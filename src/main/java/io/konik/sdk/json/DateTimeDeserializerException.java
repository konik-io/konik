/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.sdk.json;

import java.text.ParseException;

public class DateTimeDeserializerException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DateTimeDeserializerException(ParseException e) {
    super(e);
  }
}

/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.sdk.json;

import java.text.ParseException;

public class DateDeserializerException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DateDeserializerException(ParseException e) {
    super(e);
  }

}

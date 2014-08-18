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
package io.konik.zugferd.unqualified;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ZUGFeRD Specific Date with a format code.
 */
public abstract class ZfDate extends Date {

   private static final long serialVersionUID = -6394296382630804411L;

   /**
    * Instantiates a new zf date.
    *
    * @param date the date
    */
   public ZfDate(Date date) {
      this(date.getTime());
   }

   /**
    * Instantiates a new zf date.
    */
   public ZfDate() {
      super();
   }

   /**
    * Instantiates a new zf date.
    *
    * @param date the date
    */
   public ZfDate(long date) {
      super(date);
   }
   
   /**
    * Instantiates a new zf date with the formatted date string
    *
    * @param formattedDate the formatted date
    */
   public ZfDate(String formattedDate) {
      setDate(formattedDate);
   }

   /**
    * The format code for the String representation of the Date.
    *
    * @return the format code
    */
   abstract public String getFormatCode();

   /**
    * Gets the formatter.
    *
    * @return the formatter
    */
   abstract SimpleDateFormat getFormatter();

   /**
    * the String representation of the date applying the format given by the code.
    *
    * @return the date as formated string
    */
   @Override
   public String toString() {
      return getFormatter().format(this);
   }

   /**
    * Sets the date based on the provided formatted date string.
    *
    * @param formattedDate the new date
    */
   public void setDate(String formattedDate) {
      try {
         Date date = getFormatter().parse(formattedDate);
         setTime(date.getTime());
      } catch (ParseException e) {
         throw new IllegalArgumentException("New date can not be set", e);
      }
   }
}

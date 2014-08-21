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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The ZUGFeRD Date with year and month.
 */
public class ZfDateMonth extends ZfDate {
   private static final long serialVersionUID = 2756814691171025048L;

   /** The format code for year and month. */
   public static final String CODE = "610";
   private static final String DATE_PATTERN = "yyyyMM";
   private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
      @Override
      protected SimpleDateFormat initialValue() {
         return new SimpleDateFormat(DATE_PATTERN);
      }
   };

   /**
    * Instantiates a new zf date with current year and month
    */
   public ZfDateMonth() {
      super();
   }

   /**
    * Instantiates a new zf date with current year and month
    *
    * @param date the date
    */
   public ZfDateMonth(Date date) {
      super(date);
   }

   /**
    * Instantiates a new zf date month.
    *
    * @param date the date
    */
   public ZfDateMonth(long date) {
      super(date);
   }

   /**
    * Instantiates a new zf date month.
    *
    * @param formattedDate the formatted date
    */
   public ZfDateMonth(String formattedDate) {
      super(formattedDate);
   }

   /**
    * Gets the format code.
    *
    * @return the format code
    */
   @Override
   public String getFormatCode() {
      return CODE;
   }

   @Override
   SimpleDateFormat getFormatter() {
      return formatter.get();
   }

}

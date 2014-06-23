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
package io.konik.zugferd.unece.codes;

import static io.konik.util.KonikEnum.isKnownCode;
import io.konik.exception.TransformationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * = The Date Time Types 
 * 
 * Enumeration contains some of the +UNEC 2379+ codes and formats. This Enumeration does not contain periods formats.
 *
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred2379.htm[UN/EDIFACT 2379 Date or time or period format code^]
 */
public enum DateTimeType {

   /** The code "MMddyy". */
   _3("MMddyy"),
   
   /** The code "ddMMyyyy". */
   _4("ddMMyyyy"),
   
   /** The code "ddMMyyyyHHmm". */
   _5("ddMMyyyyHHmm"),
//   /** The code "yyyyMMB" */
//   _6("yyyyMMB"),
   /** The code "yyyyMMw". */
   _7("yyyyMMw"),
//   /** The code "yyyyMMddS" */
//   _8("yyyyMMddS"),
//   /** The code "yyyyMMddPP" */
//   _9("yyyyMMddPP"),
   /** The code " yyyyMMdd'T'HHmm". */
   _10(" yyyyM'T'HHmm"),
   
   /** The code "yyMMdd". */
   _101("yyMMdd"),
   
   /** The code "yyyyMMdd". */
   _102("yyyyMMdd"),
   
   /** The code "yywwu". */
   _103("yywwF"),
//   /** The code "MMww-MMww" */
//   _104("MMww-MMww"),
   /** The code "yyDDD". */
   _105("yyDDD"),
   
   /** The code "MMdd". */
   _106("MMdd"),
   
   /** The code "DDD". */
   _107("DDD"),
   
   /** The code "ww". */
   _108("ww"),
   
   /** The code "MM". */
   _109("MM"),
   
   /** The code "dd". */
   _110("dd"),
   
   /*
    * Date + Time
    */
   
   /** The code "yyMMddHHmm". */
   _201("yyMMddHHmm"),
   
   /** The code "yyMMddHHmmss". */
   _202("yyMMddHHmmss"),
   
   /** The code "yyyyMMddHHmm". */
   _203("yyyyMMddHHmm"),
   
   /** The code "yyyyMMddHHmmss". */
   _204("yyyyMMddHHmmss"),
   
   /** The code "yyyyMMddHHmmXX". */
   _205("yyyyMMddHHmmZ"),
   
   /** The code "yyMMddHHmmXX". */
   _206("yyMMddHHmmZ"),
   
   /** The code "yyMMddHHmmssXX". */
   _207("yyMMddHHmmssZ"),
   
   /** The code "yyyyMMddHHmmssXX". */
   _208("yyyyMMddHHmmssZ"),
   
   /** The code "HHmmssXX". */
   _209("HHmmssZ"),
//   /** The code "HHmmssXX-HHmmssXX" */
//   _210("HHmmssXX-HHmmssXX"),
  
   /** The code "yyMMddHHmmXX". */
   _301("yyMMddHHmmZ"),
   
   /** The code "yyMMddHHmmssXX". */
   _302("yyMMddHHmmssZ"),
   
   /** The code "yyyyMMddHHmmXX". */
   _303("yyyyMMddHHmmZ"),
   
   /** The code "yyyyMMddHHmmssXX". */
   _304("yyyyMMddHHmmssZ"),
   
   /** The code "MMddHHmm". */
   _305("MMddHHmm"),
   
   /** The code "ddHHmm". */
   _306("ddHHmm"),
   
   /** The code "HHmm". */
   _401("HHmm"),
   
   /** The code "HHmmss". */
   _402("HHmmss"),
   
   /** The code "HHmmssXX". */
   _404("HHmmssZ"),
//   /** The code "MMMMss" */
//   _405("MMMMss"),
//   /** The code "XX" */
//   _406("XX"),
//   /** The code "HHmmHHmm" */
//   _501("HHmmHHmm"),
//   /** The code "HHmmss-HHmmss" */
//   _502("HHmmss-HHmmss"),
//   /** The code "HHmmssXX-HHmmssXX" */
//   _503("HHmmssXX-HHmmssXX"),
//   /** The code "CC" */
//   _600("CC"),
   /** The code "yy". */
   _601("yy"),
   
   /** The code "yyyy". */
   _602("yyyy"),
//   /** The code "yyS" */
//   _603("yyS"),
//   /** The code "yyyyS" */
//   _604("yyyyS"),
//   /** The code "yyyyQ" */
//   _608("yyyyQ"),
   /** The code "yyMM". */
   _609("yyMM"),
   
   /** The code "yyyyMM". */
   _610("yyyyMM"),
//   /** The code "yyMMA" */
//   _613("yyMMA"),
//   /** The code "yyyyMMA" */
//   _614("yyyyMMA"),
   /** The code "yyww". */
   _615("yyww"),
   
   /** The code "yyyyww". */
   _616("yyyyww");
//   /** The code "yy-yy" */
//   _701("yy-yy"),
//   /** The code "yyyy-yyyy" */
//   _702("yyyy-yyyy"),
//   /** The code "yyS-yyS" */
//   _703("yyS-yyS"),
//   /** The code "yyyyS-yyyyS" */
//   _704("yyyyS-yyyyS"),
//   /** The code "yyPyyP" */
//   _705("yyPyyP"),
//   /** The code "yyyyP-yyyyP" */
//   _706("yyyyP-yyyyP"),
//   /** The code "yyQ-yyQ" */
//   _707("yyQ-yyQ"),
//   /** The code "yyyyQ-yyyyQ" */
//   _708("yyyyQ-yyyyQ"),
//   /** The code "yyMM-yyMM" */
//   _709("yyMM-yyMM"),
//   /** The code "yyyyMM-yyyyMM" */
//   _710("yyyyMM-yyyyMM"),
//   /** The code "yyMMddHHmm-yyMMddHHmm" */
//   _713("yyMMddHHmm-yyMMddHHmm"),
//   /** The code "yyww-yyww" */
//   _715("yyww-yyww"),
//   /** The code "yyyyww-yyyyww" */
//   _716("yyyyww-yyyyww"),
//   /** The code "yyMMdd-yyMMdd" */
//   _717("yyMMdd-yyMMdd"),
//   /** The code "yyyyMMdd-yyyyMMdd" */
//   _718("yyyyMMdd-yyyyMMdd"),
//   /** The code "yyyyMMddHHmm-yyyyMMddHHmm" */
//   _719("yyyyMMddHHmm-yyyyMMddHHmm"),
//   /** The code "DHHmm-DHHmm" */
//   _720("DHHmm-DHHmm"),
//   /** The code "Year" */
//   _801("Year"),
//   /** The code "Month" */
//   _802("Month"),
//   /** The code "Week" */
//   _803("Week"),
//   /** The code "Day" */
//   _804("Day"),
//   /** The code "Hour" */
//   _805("Hour"),
//   /** The code "Minute" */
//   _806("Minute"),
//   /** The code "Second" */
//   _807("Second"),
//   /** The code "Semester" */
//   _808("Semester"),
//   /** The code "_our months period" */
//   _809("_our months period"),
//   /** The code "Trimester" */
//   _810("Trimester"),
//   /** The code "Half month" */
//   _811("Half month"),
//   /** The code "Ten days" */
//   _812("Ten days"),
//   /** The code "Day of the week" */
//   _813("Day of the week"),
//   /** The code "Working days" */
//   _814("Working days");

   /** The prefix of enum "_". */
   private static final String PREFIX = "_";

   /** The pattern e.g. +yyyyMMdd+ */
   private final String pattern;

   /** The thread local formatter. */
   private final ThreadLocal<SimpleDateFormat> formatter;

   /**
    * Instantiates a new date time type.
    *
    * @param pattern the pattern
    */
   private DateTimeType(final String pattern) {
      this.pattern = pattern;
      this.formatter = new ThreadLocal<SimpleDateFormat>() {
         @Override
         protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(pattern);
         }
      };
   }
   
   /**
    * Gets the code.
    *
    * @return the code
    */
   public String getCode() {
      return name().substring(1);
   }

   /**
    * Gets the pattern.
    *
    * @return the pattern
    */
   public String getPattern() {
      return pattern;
   }
   

   /**
    * Format the given date to a string.
    *
    * @param date the date
    * @return the string
    */
   public String format(final Date date) {
      return formatter.get().format(date);
   }

   /**
    * Format the given date to string.
    *
    * @param date the date
    * @return the string
    */
   public String format(final Long date) {
      return formatter.get().format(date);
   }

   /**
    * Parses the given value to a date object.
    *
    * @param value the date value
    * @return the parsed date
    */
   public Date parse(final String value) {
      try {
         return formatter.get().parse(value);
      } catch (ParseException e) {
         throw new TransformationException("Not able to read the given date value: " + value);
      }
   }

   /**
    * Answers if the provided +UNEC 2379+ format code is known.
    *
    * @param code the format code
    * @return true, if code is known
    */
   public static boolean isKnown(String code) {
      return isKnownCode(DateTimeType.class, PREFIX + code);
   }

   /**
    * Return a DateTimeType by the given code string.
    *
    * @param code the date code
    * @return the known DateTimeType
    */
   public static DateTimeType getByCode(String code) {
      return DateTimeType.valueOf(PREFIX + code);
   }
   
   /**
    * Dumps the code, pattern and name as a string.
    *
    * @return the string
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("BasicProfile [").append("name=").append(this.name()).append(" ,pattern=").append(pattern).append("]");
      return builder.toString();
   }


   
   
}
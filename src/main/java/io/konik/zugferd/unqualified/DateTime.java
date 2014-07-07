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

import static io.konik.zugferd.unece.codes.DateTimeType._102;
import io.konik.zugferd.unece.codes.DateTimeType;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * = Date Time
 * 
 * Consist of the string date +value+ and a +code+ number. The +code+ number indicates how to interpret the string date.
 * 
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred2379.htm[UN/EDIFACT 2379 Date or time or period format code^]
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "DateTimeType", propOrder = { "dateTimeString" })
public class DateTime {
   
   @NotNull
   @XmlElement(name = "DateTimeString")
   private DateTime.DateTimeString dateTimeString;

   /** Instantiates a new date time with todays value and code 102. */
   public DateTime() {
      this(_102);
   }

   /**
    * Instantiates a new date time with the given date and the code 102.
    * @param date the date as long
    */
   public DateTime(Date date) {
      this(_102, date);
   }
   
   /**
    * Instantiates a new date time with the given date and the code 102.
    * @param date the date as long
    */
   public DateTime(long date) {
      this(_102, new Date(date));
   }
   
   /**
    * Instantiates a new date time with todays value and the given type.
    * 
    * @param type the {@link DateTimeType}
    */
   public DateTime(DateTimeType type) {
      this(type, new Date());
   }
   
   /**
    * Instantiates a new date time with the given type and given date.
    *
    * @param type the type
    * @param date the date
    */
   public DateTime(DateTimeType type, Date date) {
      this(type.getCode(),type.format(date));
   }
   
   /**
    * Instantiates a new date time.
    *
    * @param format the date time format code
    * @param value the date value formatted according to the format
    */
   public DateTime(String format, String value) {
      this.dateTimeString =  new DateTimeString(format,value);
   }

   /**
    * Gets the formatted date value.
    * 
    * @return the formatted value
    */
   public String getValue() {
      return dateTimeString.value;
   }
   
   /**
    * Gets the date format code.

    * Example:: +102+
    * 
    * @return the code
    */
   public String getFormat() {
      return dateTimeString.format;
   }
   
   /**
    * As date.
    *
    * @return the date
    */
   public Date asDate() {
      return DateTimeType.getByCode(dateTimeString.format).parse(dateTimeString.value);
   }
   
   @XmlAccessorType(XmlAccessType.FIELD)
   @XmlType(name = "", propOrder = { "value" })
   static class DateTimeString {
      @XmlValue
      final String value;
      @XmlAttribute(name = "format")
      final String format;

      DateTimeString(){
         value=null;
         format=null;
      }
      
      DateTimeString(String format,String value) {
         super();
         this.value = value;
         this.format = format;
      }

   }
}

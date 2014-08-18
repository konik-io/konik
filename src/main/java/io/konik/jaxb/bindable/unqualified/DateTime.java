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

package io.konik.jaxb.bindable.unqualified;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * The bindable DateTime which is converted into ZfDate
 */
@XmlType(name = "DateTimeType", propOrder = { "dateTimeString" })
public class DateTime {

   @XmlElement(name = "DateTimeString")
   final DateTime.DateTimeString dateTimeString;
   
   DateTime(String formattedDate, String formatCode) {
      super();
      this.dateTimeString = new DateTimeString(formattedDate,formatCode);
   }

   DateTime() {
      this.dateTimeString=null;
   }

   /**
    * The Class DateTimeString.
    */
   @XmlAccessorType(XmlAccessType.FIELD)
   @XmlType(name = "", propOrder = { "value" })
   public static class DateTimeString {

      @XmlValue
      final String value;

      @XmlAttribute(name = "format")
      final String format;
      
      DateTimeString() {
         this.value = null;
         this.format = null;
      }

      DateTimeString(String value, String format) {
         super();
         this.value = value;
         this.format = format;
      }

      
   }

}

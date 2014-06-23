/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.unece.codes;

/**
 * = The Unit Of Measurement Enumeration
 * 
 * Based on Recommendation N°. 20 - Codes for Units of Measure Used in International Trade
 * 
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred6411.htm[UN/EDIFACT 6411 Measurement unit code^]
 * 
 */
public enum UnitOfMeasurement {

   /** A unit of count defining the number of articles (items). */
   ARTICLE("NAR", "A unit of count defining the number of articles (items)"),

   /** A unit of count defining the number of pieces */
   UNIT("C62", "A unit of count defining the number of pieces"),

   /** A number of objects grouped together to a set */
   SET("SET", "a number of objects grouped together"),

   /** The number of pairs. */
   PAIR("NPR", "number of pairs"),

   /** The Hectare (ha). */
   HECTARE("HAR", "Hectare (ha)"),

   /** The Hour (h). */
   HOUR("HUR", "Hour (h)"),

   /** The Kilogram (kg). */
   KILOGRAM("KGM", "Kilogram (kg)"),

   /** The Kilometer (km). */
   KILOMETER("KTM", "Kilometer (km)"),

   /** The Kilowatt hour (kWh). */
   KILOWATT_HOUR("KWH", "Kilowatt hour (kWh)"),

   /** The lump sum. */
   LUMP_SUM("LS", "lump sum"),

   /** The Liter (l). */
   LITRE("LTR", "Liter (l)"),

   /** The Minute (min). */
   MINUTE("MIN", "Minute (min)"),

   /** The square millimeter (mm2). */
   MILLIMETER_SQUARE("MMK,", "square millimeter (mm2)"),

   /** The Millimeter (mm). */
   MILLIMETER("MMT", "Millimeter (mm)"),

   /** The square meter (m2). */
   METER_SQUARE("MTK", "square meter  (m2)"),

   /** The cubic meter (m3). */
   METER_CUBIC("MTQ", "cubic meter (m3)"),

   /** The Meter (m). */
   METER("MTR,", "Meter (m)"),

   /** The Second (s). */
   SECOND("SEC", "Second (s)"),

   /** The Percent (%). */
   PERCENT("P1", "Percent (%)"),

   /** The metric ton (t). */
   TON_METRIC("TNE", "Metric ton (t)"),

   /** The day count */
   DAY("DAY", "days count"),

   /** The week. */
   WEEK("WEE", "Week"),

   /** The Month. */
   MONTH("MON", "Month");

   /** The description. */
   public final String description;

   /**
    * Instantiates a new unit types.
    *
    * @param code the code
    * @param description the description
    */
   UnitOfMeasurement(String code, String description) {
      this.description = description;
   }
   
   /**
    * Gets the code.
    *
    * @return the code
    */
   public String getCode() {
      return name();
   }
   
   /**
    * Gets the description.
    *
    * @return the description
    */
   public String getDescription() {
      return description;
   }

   /**
    * Gets the type by code.
    *
    * @param code the code
    * @return the type by code
    */
   public static UnitOfMeasurement getByCode(String code) {
      for (UnitOfMeasurement v : values()) {
         if (v.name().intern() == code.intern()) return v;
      }
      return null;
   }
   
   @Override
   public String toString() {
      return new StringBuilder().append("[").append(getCode()).append("] ").append(description).toString();
   }
}

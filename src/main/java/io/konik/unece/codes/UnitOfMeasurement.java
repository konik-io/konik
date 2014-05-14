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
package io.konik.unece.codes;

/**
 * = The Unit Of Measurement Enumeration
 * 
 * Based on Recommendation N°. 20 - Codes for Units of Measure Used in International Trade
 * 
 * Abbreviations for most units of measurements use small letters and periods.
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
   ha("HAR", "Hectare (ha)"),

   /** The Hour (h). */
   h("HUR", "Hour (h)"),

   /** The Kilogram (kg). */
   kg("KGM", "Kilogram (kg)"),

   /** The Kilometer (km). */
   km("KTM", "Kilometer (km)"),

   /** The Kilowatt hour (kWh). */
   kWh("KWH", "Kilowatt hour (kWh)"),

   /** The lump sum. */
   LS("LS", "lump sum"),

   /** The Liter (l). */
   l("LTR", "Liter (l)"),

   /** The Minute (min). */
   min("MIN", "Minute (min)"),

   /** The square millimeter (mm2). */
   mm_sq("MMK,", "square millimeter (mm2)"),

   /** The Millimeter (mm). */
   mm("MMT", "Millimeter (mm)"),

   /** The square meter (m2). */
   m_sq("MTK", "square meter  (m2)"),

   /** The cubic meter (m3). */
   m_cu("MTQ", "cubic meter (m3)"),

   /** The Meter (m). */
   m("MTR,", "Meter (m)"),

   /** The Second (s). */
   s("SEC", "Second (s)"),

   /** The Percent (%). */
   pct("P1", "Percent (%)"),

   /** The metric ton (t). */
   t("TNE", "metric ton (t)"),

   /** The day count */
   DAY("DAY", "days count"),

   /** The week. */
   WEEK("WEE", "Week"),

   /** The Month. */
   MONTH("MON", "Month");

   /** The code. */
   public final String code;

   /** The description. */
   public final String description;

   /**
    * Instantiates a new unit types.
    *
    * @param code the code
    * @param description the description
    */
   UnitOfMeasurement(String code, String description) {
      this.code = code;
      this.description = description;
   }

   /**
    * Gets the type by code.
    *
    * @param code the code
    * @return the type by code
    */
   public static UnitOfMeasurement getTypeByCode(String code) {
      for (UnitOfMeasurement v : values()) {
         if (v.code.intern() == code.intern()) return v;
      }
      return null;
   }
}

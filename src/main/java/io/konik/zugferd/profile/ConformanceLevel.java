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
package io.konik.zugferd.profile;

import static io.konik.util.Strings.isNullOrEmpty;

/**
 * The latest Version Invoice Profiles.
 */
public enum ConformanceLevel {

   /** The conformance level basic*/
   BASIC,
   /** The conformance level profile */
   COMFORT,
   /** The conformance level extended */
   EXTENDED;

   private static final String DELIMITER = ":";

   /**
    * Instantiates a new profile type.
    */
   ConformanceLevel() {
   }
   
   @Override
   public String toString() {
      return name().toLowerCase();
   }

   /**
    * Parses the full name and extract the conformance level
    *
    * @param fullName the full name
    * @return the conformance level
    */
   public static ConformanceLevel extractConformanceLevel(String fullName) {
      if (isNullOrEmpty(fullName)) {throw new EnumConstantNotPresentException(ConformanceLevel.class, fullName);}
      String[] tokens = fullName.split(DELIMITER);
      int lastTokenPosition = tokens.length-1;
      String level = tokens[lastTokenPosition];
      return valueOf(level.toUpperCase());
   }

}
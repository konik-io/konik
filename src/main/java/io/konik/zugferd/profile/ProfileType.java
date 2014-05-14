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

/**
 * The Invoice Profiles.
 */
public enum ProfileType {
   /** The basic profile */
   BASIC,
   /** The comfort profile */
   COMFORT,
   /** The extended profile */
   EXTENDED;

   /** The ZUGFeRD name space prefix */
   public final static String NS = "urn:ferd:invoice";
   
   /** The ZUGFeRD VERSION. */
   public final static String VERSION = "rc";

   /** The full name. with namespace:version:profileName*/
   public final String fullName;
   
   /** The simple name. */
   public final String simpleName;
   
   /** The conformance level is simple name in capital letters */
   public final String conformanceLevel;

   /**
    * Instantiates a new profile type.
    */
   ProfileType() {
      conformanceLevel = name();
      simpleName = conformanceLevel.toLowerCase();
      fullName = NS + ":" + VERSION + ":" + simpleName;
   }

   /**
    * Get a profile by full name.
    *
    * @param fullName the full name
    * @return the profile
    */
   public static ProfileType getProfile(String fullName) {
      for (ProfileType v : values()) {
         if(v.fullName.equals(fullName)) {
            return v;   
         }
      }
      throw new EnumConstantNotPresentException(ProfileType.class, fullName);
   }

   /**
    * Gets the profile by name.
    *
    * @param name the simple name
    * @return the profile by name case independent
    */
   public static ProfileType getProfileByName(String name) {
      for (ProfileType v : values()) {
         if(v.simpleName.equals(name.toLowerCase())) {
            return v;
         }
      }
      throw new EnumConstantNotPresentException(ProfileType.class, name);
   }
   
   /**
    * Checks if is basic.
    *
    * @param fullName the full name
    * @return true, if is basic
    */
   public static boolean isBasic(String fullName) {
      return fullName.endsWith(BASIC.simpleName);
   }
   
   /**
    * Checks if is comfort.
    *
    * @param fullName the full name
    * @return true, if is comfort
    */
   public static boolean isComfort(String fullName) {
      return fullName.endsWith(COMFORT.simpleName);
   }
   
   /**
    * Checks if is extended.
    *
    * @param fullName the full name
    * @return true, if is extended
    */
   public static boolean isExtended(String fullName) {
      return fullName.endsWith(EXTENDED.simpleName);
   }

   /**
    * Extract version from full name.
    *
    * @param fullName the full name
    * @return the version of provided in the full name or empty string
    */
   public static String extractVersion(String fullName) {
      if (fullName==null || fullName.isEmpty()) {
         return "";
      }
      String[] tokens = fullName.split(":");
      if (tokens.length<4) {
         return "";
      }
      return tokens[3];
      
      
   }
}
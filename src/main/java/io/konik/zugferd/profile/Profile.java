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
 * The latest Version Invoice Profiles.
 */
public enum Profile {

   /** The basic profile */
   BASIC,
   /** The comfort profile */
   COMFORT,
   /** The extended profile */
   EXTENDED;

   private static final String DELIMITED = ":";
   private final static String NS = "urn:ferd:CrossIndustryDocument:invoice";

   /**
    * Instantiates a new profile type.
    */
   Profile() {
   }

   /**
    * Gets the full name with the latest version.
    * 
    * Full name consists of namespace:version:profile
    * 
    * Example:: urn:ferd:CrossIndustryDocument:invoice:1p0:basic
    *
    * @return the full name
    */
   public String fullName() {
      return fullName(ProfileVersion.latestVersion());
   }

   /**
    * constructs the full name with the given version. 
    * Full name consists of namespace:version:profile
    * 
    * Example:: urn:ferd:CrossIndustryDocument:invoice:1p0:basic
    *
    * @param version the version
    * @return the string the full name 
    */
   public String fullName(ProfileVersion version) {
      StringBuilder fullName = new StringBuilder();
      fullName.append(NS).append(DELIMITED).append(version.version()).append(DELIMITED).append(simpleName());
      return fullName.toString();
   }

   /**
    * Gets the simple name.
    * 
    * Simple may be basic, comfort or extended.
    * 
    * Example:: basic, comfort, extended
    * 
    * @return the simple name basic, comfort or extended.
    */
   public String simpleName() {
      return name().toLowerCase();
   }

   /**
    * Gets the conformance level.
    * 
    * Is the {@link #simpleName()} in capital or {@link #name()}
    * 
    * Example:: BASIC, COMFORT, EXTENDED
    * 
    * @see #simpleName()
    * @return the conformance level
    */
   public String getConformanceLevel() {
      return name();
   }

   /**
    * Get a profile by full name.
    *
    * @param fullName the full name
    * @return the profile
    */
   public static Profile getProfile(String fullName) {
      for (Profile v : values()) {
         ProfileVersion version = ProfileVersion.extractVersion(fullName);
         if (v.fullName(version).equals(fullName)) { return v; }
      }
      throw new EnumConstantNotPresentException(Profile.class, fullName);
   }

   /**
    * Gets the profile by name.
    *
    * @param name the simple name
    * @return the profile by name case independent
    */
   public static Profile getProfileByName(String name) {
      for (Profile v : values()) {
         if (v.simpleName().equals(name.toLowerCase())) { return v; }
      }
      throw new EnumConstantNotPresentException(Profile.class, name);
   }

   /**
    * Checks if is basic.
    *
    * @param fullName the full name
    * @return true, if is basic
    */
   public static boolean isBasic(String fullName) {
      return fullName.endsWith(BASIC.simpleName());
   }

   /**
    * Checks if is comfort.
    *
    * @param fullName the full name
    * @return true, if is comfort
    */
   public static boolean isComfort(String fullName) {
      return fullName.endsWith(COMFORT.simpleName());
   }

   /**
    * Checks if is extended.
    *
    * @param fullName the full name
    * @return true, if is extended
    */
   public static boolean isExtended(String fullName) {
      return fullName.endsWith(EXTENDED.simpleName());
   }


}
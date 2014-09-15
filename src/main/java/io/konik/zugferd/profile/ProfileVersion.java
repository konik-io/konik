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

import io.konik.util.Strings;

/**
 * = The known ZUGFeRD profile versions.
 */
public enum ProfileVersion {

   /** The release candidate. */
   RC("rc","rc"),

   /** The release candidate extended. */
   RCE("rce","rce"),

   /** The version 1.0 */
   V1P0("1p0","1.0");

   private static final String DELIMITER = ":";
   private final String version;
   private final String versionAlt;
   
   private ProfileVersion(String version, String versionAlt) {
      this.version = version;
      this.versionAlt = versionAlt;
   }

   /**
    * Version.
    *
    * @return the version string
    */
   public String version() {
      return version;
   }
   
   /**
    * alternative representation of the version with the .(dot).
    *
    * @return the alternative representation of the version
    */
   public String versionAlt() {
      return versionAlt;
   }

   /**
    * Latest version of the ZUGFeRD Specification.
    *
    * @return the string
    */
   public static ProfileVersion latestVersion() {
      return ProfileVersion.values()[ProfileVersion.values().length - 1];
   }

   /**
    * Parses the given version string
    *
    * @param version the version
    * @return the profile version or IllegalArgumentException if provided version is not known.
    */
   public static ProfileVersion parse(String version) {
      for (ProfileVersion profileVersion : ProfileVersion.values()) {
         if (profileVersion.versionAlt().equals(version) ||
               profileVersion.version().equals(version)) { return profileVersion; }
      }
      throw new EnumConstantNotPresentException(ProfileVersion.class, version);
   }

   /**
    * Extract version from full name.
    *
    * @param fullName the full name
    * @return the version of provided in the full name or empty string
    */
   public static ProfileVersion extractVersion(String fullName) {
      if (Strings.isNullOrEmpty(fullName)) { return null; }
      String[] tokens = fullName.split(DELIMITER);
      int versionTokenPosition = tokens.length-2;
      String version = tokens[versionTokenPosition];
      return parse(version);
   }

   @Override
   public String toString() {
      return version();
   }
}
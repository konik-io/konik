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
package io.konik.invoice.profiles;

/**
 * The Invoice Profiles.
 */
public enum InvoiceProfile {
   /** The basic profile */
   BASIC,
   /** The comfort profile */
   COMFORT,
   /** The extended profile */
   EXTENDED;

   public final static String NS = "urn:ferd:invoice";
   public final static String VERSION = "rc";

   public final String fullName;
   public final String simpleName;
   public final String conformanceLevel;

   InvoiceProfile() {
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
   public static InvoiceProfile getProfile(String fullName) {
      for (InvoiceProfile v : values()) {
         if(v.fullName.equals(fullName)) {
            return v;   
         }
      }
      throw new EnumConstantNotPresentException(InvoiceProfile.class, fullName);
   }

   /**
    * Gets the profile by name.
    *
    * @param name the simple name
    * @return the profile by name case independent
    */
   public static InvoiceProfile getProfileByName(String name) {
      for (InvoiceProfile v : values()) {
         if(v.simpleName.equals(name.toLowerCase())) {
            return v;
         }
      }
      throw new EnumConstantNotPresentException(InvoiceProfile.class, name);
   }
}
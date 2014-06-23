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
package io.konik.zugferd.profile;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The ZUGFeRD full Profile Name
 * 
 * Construction schema. namespace:version:[basic, comfort or extended]
 * 
 * Example:: urn:ferd:invoice:rce:extended
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentContextParameterType", propOrder = { "id" })
public class Profile {

   @NotNull
   @XmlElement(name = "ID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private final String id;
   
   /**
    * Instantiates a new profile.
    */
   Profile() {
      this.id = null;
   }
   
   /**
    * Instantiates a new profile.
    *
    * @param fullName the full name
    */
   public Profile(String fullName) {
      this.id = fullName;
   }

   /**
    * Instantiates a new profile.
    *
    * @param type the type
    */
   public Profile(ProfileType type) {
      this.id = type.fullName;
   }

   /**
    * Gets the profile name.

    * e.g. urn:ferd:invoice:rc:basic
    *
    * @return the full profile name
    */
   public String getFullName() {
      return id;
   }
   
   /**
    * Gets the simple name of the profile

    * e.g basic,comfort or extended.
    *
    * @return the simple name of the profile
    */
   public String getSimpleName() {
      return id.substring(id.lastIndexOf(':'));
   }
   
   /**
    * Checks if profile is basic.
    *
    * @return true, if is basic
    */
   public boolean isBasic() {
      return ProfileType.isBasic(id);
   }
   
   /**
    * Checks if profile is comfort.
    *
    * @return true, if is comfort
    */
   public boolean isComfort() {
      return ProfileType.isComfort(id);
   }
   
   /**
    * Checks if profile is extended.
    *
    * @return true, if is extended
    */
   public boolean isExtended() {
      return ProfileType.isExtended(id);
   }
   
   /**
    * Gets the version of the invoice.
    *
    * @return the version of the underlying invoice.
    */
   public String getVersion() {
      return ProfileType.extractVersion(id);
   }

}

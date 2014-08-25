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
 * 
 * The ZUGFeRD Profile consists of three parts. The namespace the version and the conformance level.
 */
public class Profile {
   private static final String DELIMITER = ":";
   private static final String NS = "urn:ferd:CrossIndustryDocument:invoice:";
   
   private String namespace;
   private ProfileVersion version;
   private ConformanceLevel conformanceLevel;
   
   /**
    * Instantiates a new profile.
    */
   public Profile() {}
   
   /**
    * Instantiates a new profile with the latest version
    *
    * @param conformanceLevel the conformance level
    */
   public Profile(ConformanceLevel conformanceLevel) {
      super();
      this.namespace = NS;
      this.version = ProfileVersion.latestVersion();
      this.conformanceLevel = conformanceLevel;
   }

   /**
    * Instantiates a new profile.
    *
    * @param namespace the namespace
    * @param version the version
    * @param conformanceLevel the conformance level
    */
   public Profile(String namespace, ProfileVersion version, ConformanceLevel conformanceLevel) {
      super();
      this.namespace = namespace;
      this.version = version;
      this.conformanceLevel = conformanceLevel;
   }

   /**
    * Gets the namespace.
    *
    * @return the namespace
    */
   public String getNamespace() {
      return namespace;
   }
   
   /**
    * Sets the namespace.
    *
    * @param namespace the namespace
    * @return the profile
    */
   public Profile setNamespace(String namespace) {
      this.namespace = namespace;
      return this;
   }
   
   /**
    * Gets the version.
    *
    * @return the version
    */
   public ProfileVersion getVersion() {
      return version;
   }
   
   /**
    * Sets the version.
    *
    * @param version the new version
    * @return the profile
    */
   public Profile setVersion(ProfileVersion version) {
      this.version = version;
      return this;
   }
   
   /**
    * Gets the conformance level.
    *
    * @return the conformance level
    */
   public ConformanceLevel getConformanceLevel() {
      return conformanceLevel;
   }
   
   /**
    * Sets the conformance level.
    *
    * @param conformanceLevel the new conformance level
    * @return the profile
    */
   public Profile setConformanceLevel(ConformanceLevel conformanceLevel) {
      this.conformanceLevel = conformanceLevel;
      return this;
   }
   
   
   /**
    * Gets the full name consisting of the namespace, version, conformance level.
    *
    * @return the full name
    */
   public String fullName(){
      return namespace+version.toString()+DELIMITER+conformanceLevel.toString();
   }
   
   
   
}

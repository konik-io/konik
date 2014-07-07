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
package io.konik.zugferd.entity;

import io.konik.zugferd.profile.Profile;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Exchanged Document Context
 * 
 * Grouping of the properties of the message.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangedDocumentContextType", propOrder = { "test", "profile" })
public class Context {

   @XmlElement(name = "TestIndicator")
   private boolean test;

   @Valid
   @XmlElement(name = "GuidelineSpecifiedDocumentContextParameter")
   private Profile profile;

   /**
    * Instantiates a new context.
    */
   public Context() {
   }

   /**
    * Instantiates a new context with a profile
    * 
    * @param profile the profile
    */
   public Context(Profile profile) {
      this.profile = profile;
   }

   /**
    * The test indicator flags the invoice such that it should not be processed in the target system.
    * 
    * The sales tax liability does not arise. This flag is used in particular in the introductory period of new business
    * relationships.
    * 
    * Profile:: BASIC
    * 
    * Default:: +false+
    * 
    * @return true if this invoice is for testing purpose only
    */
   public boolean isTest() {
      return test;
   }

   /**
    * The test indicator flags the invoice such that it should not be processed in the target system.
    * 
    * The sales tax liability does not arise. This flag is used in particular in the introductory period of new business
    * relationships.
    * 
    * Profile:: BASIC
    * 
    * Default:: +false+
    * 
    * @param test the new indicates if this invoice is for testing purpose only
    * @return the context
    */
   public Context setTest(boolean test) {
      this.test = test;
      return this;
   }

   /**
    * Gets the guideline or profile of the invoice
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code urn:ferd:invoice:1.0:comfort}
    * 
    * @return the profile
    */
   public Profile getProfile() {
      return this.profile;
   }

   /**
    * Sets the guideline or profile of the invoice
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code urn:ferd:invoice:1.0:comfort}
    *
    * @param profile the new profile
    * @return the context
    */
   public Context setProfile(Profile profile) {
      this.profile = profile;
      return this;
   }
}

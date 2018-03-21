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
package io.konik.zugferd.entity;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import io.konik.jaxb.adapter.ParameterProfileAdapter;
import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.profile.ConformanceLevel;
import io.konik.zugferd.profile.Profile;
import io.konik.zugferd.unqualified.Indicator;

/**
 * = The Exchanged Document Context
 * 
 * Grouping of the properties of the message.
 */
@XmlType(name = "ExchangedDocumentContextType", propOrder = { "test", "businessProcess", "guideline" })
public class Context implements Serializable {

   @XmlElement(name = "TestIndicator")
   private Indicator test;

   @XmlElement(name = "BusinessProcessSpecifiedDocumentContextParameter")
   private Parameter businessProcess;

   @XmlElement(name = "GuidelineSpecifiedDocumentContextParameter", required = true)
   @XmlJavaTypeAdapter(ParameterProfileAdapter.class)
   private Profile guideline;

   /**
    * Instantiates a new context.
    */
   public Context() {
   }

   /**
    * Instantiates a new context with a latest ZUGFeRD profile version.
    *
    * @param conformanceLevel the profile
    */
   public Context(ConformanceLevel conformanceLevel) {
      this.guideline = new Profile(conformanceLevel);
   }

   /**
    * Checks if that invoice is for test purposes only and should not be processed in the target system.
    * 
    * 
    * Default:: +false+
    * 
    * @return true if this invoice is for testing purpose only
    */
   @Basic
   public boolean isTest() {
      if (test == null) { return false; }
      return test.getIndicator();
   }

   /**
    * Flags the invoice such that it should not be processed in the target system.
    * The sales tax liability does **NOT** arise. 
    * This flag is used in particular in the introductory period of new business relationships.
    * 
    * Default:: +false+
    *
    * @return the context
    */
   public Context setTest() {
      this.test = Indicator.trueIndicator();
      return this;
   }

   /**
    * Flags the invoice such that it should be processed in the target system.
    * 
    * The sales tax liability **does** arise. 
    * This flag is used in particular in the introductory period of new business relationships.
    * 
    * Default:: +false+
    *
    * @return the context
    */
   public Context setNotTest() {
      this.test = Indicator.falseIndicator();
      return this;
   }

   /**
    * Gets the business process.
    *
    * Example:: production Materials, other Materials, freight Invoices
    *
    * @return the business process
    */
   @Extended
   public String getBusinessProcess() {
      return businessProcess == null ? null : businessProcess.getId();
   }

   /**
    * Sets the business process.
    * 
    * Example:: production Materials, other Materials, freight Invoices
    * 
    * @param businessProcess the new business process
    * @return the context
    */
   public Context setBusinessProcess(String businessProcess) {
      this.businessProcess = new Parameter(businessProcess);
      return this;
   }

   /**
    * Gets the guideline or profile of the invoice
    * 
    * Example:: +urn:ferd:CrossIndustryDocument:invoice:1p0:extended+
    * 
    * @return the profile
    */
   @Basic
   @NotNull
   @Valid
   public Profile getGuideline() {
      return this.guideline;
   }

   /**
    * Sets the guideline or profile of the invoice
    * 
    * Example:: +urn:ferd:CrossIndustryDocument:invoice:1p0:extended+
    *
    * @param guideline the new profile
    * @return the context
    */
   public Context setGuideline(Profile guideline) {
      this.guideline = guideline;
      return this;
   }
}

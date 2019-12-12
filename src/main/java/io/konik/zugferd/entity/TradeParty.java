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

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.validator.annotation.NotBlank;
import io.konik.zugferd.unqualified.ID;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * = The Trade Party
 * 
 * Applies to a buyer, seller, order recipient or invoice recipient.
 */
@XmlType(name = "TradePartyType", propOrder = { "id", "globalIds", "name", "contact", "address", "taxRegistrations" })
public class TradeParty implements Serializable {

   @XmlElement(name = "ID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String id;

   @XmlElement(name = "GlobalID")
   private List<ID> globalIds;

   @XmlElement(name = "Name")
   private String name;

   @XmlElement(name = "DefinedTradeContact")
   private Contact contact;

   @XmlElement(name = "PostalTradeAddress")
   private Address address;

   @XmlElement(name = "SpecifiedTaxRegistration")
   private List<TaxRegistration> taxRegistrations;

   /**
    * Gets the vendor, customer or recipient number.
    * 
    * Example:: {@code The supplier number given by the customer/buyer }
    * 
    * @return the id
    */
   @Comfort
   public String getId() {
      return id;
   }

   /**
    * Sets the the vendor, customer or recipient number.
    * 
    * Example:: {@code The supplier number given by the customer/buyer }
    *
    * @param id the new id
    * @return the trade party
    */
   public TradeParty setId(String id) {
      this.id = id;
      return this;
   }

   /**
    * Gets the global vendor number or customer number ids. 
    * 
    * Example:: GLN, DUNS, BIC, ODETTE
    * 
    * Example::
    * - {@link ID#getValue()} {@code  GENODED1SPK, 4000001000005 } 
    * - {@link ID#getSchemeId()} the ISO 6523 code {@code 0021, 0088, 0060, 0177 }
    * 
    * @return the global id
    */
   @Comfort
   public List<ID> getGlobalIds() {
      if (globalIds == null) {
         globalIds = new ArrayList<ID>();
      }
      return this.globalIds;
   }

   /**
    * Adds the global vendor number or customer number ID.
    * 
    * Example:: GLN, DUNS, BIC, ODETTE
    * 
    * Example::
    * - {@link ID#getValue()} {@code  GENODED1SPK, 4000001000005 } 
    * - {@link ID#getSchemeId()} the ISO 6523 code {@code 0021, 0088, 0060, 0177 }
    * 
    * @param additionalGlobalId the additional global id
    * @return the trade party
    */
   public TradeParty addGlobalId(ID additionalGlobalId) {
      getGlobalIds().add(additionalGlobalId);
      return this;
   }

   /**
    * Gets the trade party name. Usually the Company name.
    * 
    * Example:: {@code  ACME Inc.}
    * 
    * @return the trade party or company name
    */
   @Basic
   @NotBlank
   public String getName() {
      return name;
   }

   /**
    * Sets the trade party name. Usually the Company name.
    * 
    * Example:: {@code  ACME Inc.}
    * 
    * @param name the trade party or company name
    * @return the trade party
    */
   public TradeParty setName(String name) {
      this.name = name;
      return this;
   }

   /**
    * Gets the contact individual or department of the trade party
    * 
    * @return the trade party contact individual/department
    */
   @Valid
   @Extended
   public Contact getContact() {
      return contact;
   }

   /**
    * Sets the contact individual or department of the trade party
    * 
    * @param newContact the trade party contact individual/department
    * @return the trade party
    */
   public TradeParty setContact(Contact newContact) {
      this.contact = newContact;
      return this;
   }

   /**
    * Gets the postal trade address.
    * 
    * @return the postal trade address
    */
   @Valid
   public Address getAddress() {
      return address;
   }

   /**
    * Sets the postal trade address.
    * 
    * @param postalAddress the new postal trade address
    * @return the trade party
    */
   public TradeParty setAddress(Address postalAddress) {
      this.address = postalAddress;
      return this;
   }

   /**
    * Gets the specified tax registration.
    * 
    * @return the specified tax registration
    */
   @Valid
   public List<TaxRegistration> getTaxRegistrations() {
      if (taxRegistrations == null) {
         taxRegistrations = new ArrayList<TaxRegistration>();
      }
      return this.taxRegistrations;
   }

   /**
    * Adds the tax registration.
    * 
    * @param additionalTaxRegistration an additional Tax Registration
    * @return the trade party
    */
   public TradeParty addTaxRegistrations(TaxRegistration... additionalTaxRegistration) {
      Collections.addAll(getTaxRegistrations(), additionalTaxRegistration);
      return this;
   }

}

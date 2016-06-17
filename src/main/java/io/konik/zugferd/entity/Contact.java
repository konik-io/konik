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

import io.konik.jaxb.bindable.entity.UniversalCommunicationAdapter;
import io.konik.validator.annotation.Email;
import io.konik.validator.annotation.Extended;
import io.konik.validator.annotation.ValidContact;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * = The Trade Contact
 * 
 * An individual with contact information.
 */
@XmlType(name = "TradeContactType", propOrder = { "name", "department", "telephone", "fax", "email" })
@ValidContact
public class Contact implements Serializable {

   @XmlElement(name = "PersonName")
   private String name;

   @XmlElement(name = "DepartmentName")
   private String department;

   @XmlElement(name = "TelephoneUniversalCommunication")
   @XmlJavaTypeAdapter(value = UniversalCommunicationAdapter.class)
   private String telephone;

   @XmlElement(name = "FaxUniversalCommunication")
   @XmlJavaTypeAdapter(value = UniversalCommunicationAdapter.class)
   private String fax;

   @XmlElement(name = "EmailURIUniversalCommunication")
   @XmlJavaTypeAdapter(value = UniversalCommunicationAdapter.class)
   private String email;

   /**
    * Instantiates a new contact.
    */
   public Contact() {
   }

   /**
    * Instantiates a new trade contact.
    * 
    * @param contactName the person first and last name
    * @param departmentName the department name
    * @param telephone the telephone number
    * @param fax the fax number
    * @param email the email
    */
   public Contact(String contactName, String departmentName, String telephone, String fax, String email) {
      this.name = contactName;
      this.department = departmentName;
      this.telephone = telephone;
      this.fax = fax;
      this.email = email;
   }

   /**
    * Gets the contact person name.
    * 
    * @return the person name
    */
   @Extended
   public String getName() {
      return name;
   }

   /**
    * Sets the contact person name.
    * 
    * @param name the new person name
    * @return the contact
    */
   public Contact setName(String name) {
      this.name = name;
      return this;
   }

   /**
    * Gets the department name.
    * 
    * @return the department name
    */
   @Extended
   public String getDepartment() {
      return department;
   }

   /**
    * Sets the department name.
    * 
    * @param department the new department name
    * @return the contact
    */
   public Contact setDepartment(String department) {
      this.department = department;
      return this;
   }

   /**
    * Gets the telephone number.
    * 
    * Example:: +{plus}49 (123) 456789-999+
    * 
    * @return the telephone universal communication
    */
   @Extended
   public String getTelephone() {
      return telephone;
   }

   /**
    * Sets the telephone number providing the string only.
    * 
    * Example:: +{plus}49 (123) 456789-999+
    *
    * @param telephone the new telephone universal communication
    * @return the contact
    */
   public Contact setTelephone(String telephone) {
      this.telephone = telephone;
      return this;
   }

   /**
    * Gets the Fax number.
    * 
    * Example:: +{plus}49 (123) 456789-999+
    * 
    * @return the Fax number
    */
   @Extended
   public String getFax() {
      return fax;
   }

   /**
    * Sets the telephone number providing the string only.
    * 
    * Example:: +{plus}49 (123) 456789-999+
    *
    * @param faxNumber the new fax number
    * @return the contact
    */
   public Contact setFax(String faxNumber) {
      this.fax = faxNumber;
      return this;
   }

   /**
    * Gets the email contacts E-mail address.
    * 
    * Example:: +example@konik.io+
    * 
    * @return the email address
    */
   @Email
   @Extended
   public String getEmail() {
      return email;
   }

   /**
    * Sets the email contacts E-mail address.
    * 
    * Example:: +example@konik.io+
    *
    * @param email the new email
    * @return the contact
    */
   public Contact setEmail(String email) {
      this.email = email;
      return this;
   }
}

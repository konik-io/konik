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

import io.konik.jaxb.adapter.UniversalCommunicationAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Trade Contact
 * 
 * An individual with contact information.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeContactType", propOrder = { "name", "department", "telephone", "fax", "email" })
public class Contact {

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
	public Contact() {}

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
	 * Profile:: EXTENDED
	 * 
	 * @return the person name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the contact person name.
	 * 
	 * Profile:: EXTENDED
	 * 
	 * @param name the new person name
	 * @return 
	 */
	public Contact setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Gets the department name.
	 * 
	 * Profile:: EXTENDED
	 * 
	 * @return the department name
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department name.
	 * 
	 * Profile:: EXTENDED
	 * 
	 * @param department the new department name
	 * @return 
	 */
	public Contact setDepartment(String department) {
		this.department = department;
		return this;
	}

	/**
	 * Gets the telephone number.
	 * 
    * Profile:: EXTENDED
    * 
    * Example:: +{plus}49 (123) 456789-999+
	 * @return the telephone universal communication
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Sets the telephone number providing the string only.
	 * 
    * Profile:: EXTENDED
    * 
    * Example:: +{plus}49 (123) 456789-999+
	 * @param telephone the new telephone universal communication
	 * @return 
	 */
	public Contact setTelephone(String telephone) {
		this.telephone =telephone;
		return this;
	}

	/**
	 * Gets the Fax number.
	 * 
    * Profile:: EXTENDED
    * 
    * Example:: +{plus}49 (123) 456789-999+
	 * @return the Fax number
	 */
	public String getFax() {
		return fax;
	}

	/**
    * Sets the telephone number providing the string only.
    * 
    * Profile:: EXTENDED
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
    * Profile:: EXTENDED
    * 
    * Example:: +example@konik.io+
    * @return the email address
    */
	public String getEmail() {
		return email;
	}

	/**
    * Sets the email contacts E-mail address.
    * 
    * Profile:: EXTENDED.
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

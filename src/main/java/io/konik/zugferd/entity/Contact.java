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

import static io.konik.zugferd.entity.UriSchemeNames.EMAIL;
import static io.konik.zugferd.entity.UriSchemeNames.TEL;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Trade Contact
 * 
 * Is a individual that can be reached in ways specified by this class.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeContactType", propOrder = { "name", "department", "telephone", "fax", "email" })
public class Contact {

	@XmlElement(name = "PersonName")
	private String name;

	@XmlElement(name = "DepartmentName")
	private String department;

	@Valid
	@XmlElement(name = "TelephoneUniversalCommunication")
	private UniversalCommunication telephone;

	@Valid
	@XmlElement(name = "FaxUniversalCommunication")
	private UniversalCommunication fax;

	@Valid
	@XmlElement(name = "EmailURIUniversalCommunication")
	private UniversalCommunication email;

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
		this.telephone = telephone != null ? new UniversalCommunication(TEL, telephone) : null;
		this.fax = fax != null ? new UniversalCommunication(TEL, fax) : null;
		this.email = email != null ? new UniversalCommunication(EMAIL, email) : null;
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
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the department name.
	 * 
	 * Profile:: EXTENDED
	 * @return the department name
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department name.
	 * 
	 * Profile:: EXTENDED
	 * @param department the new department name
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Gets the telephone number.
	 * 
    * Profile:: EXTENDED
    * Example:: +{plus}49 (123) 456789-999+
	 * @return the telephone universal communication
	 */
	public String getTelephone() {
		return telephone.getCompleteNumber();
	}

	/**
	 * Sets the telephone number providing the string only.
	 * 
    * Profile:: EXTENDED
    * Example:: +{plus}49 (123) 456789-999+
	 * @param telephone the new telephone universal communication
	 */
	public void setTelephone(String telephone) {
		this.telephone = new UniversalCommunication(TEL, telephone);
	}

	/**
	 * Gets the Fax number.
	 * 
    * Profile:: EXTENDED
    * Example:: +{plus}49 (123) 456789-999+
	 * @return the Fax number
	 */
	public UniversalCommunication getFax() {
		return fax;
	}

	/**
    * Sets the telephone number providing the string only.
    * 
    * Profile:: EXTENDED
    * Example:: +{plus}49 (123) 456789-999+
    *
    * @param faxNumber the new fax number
    */
	public void setFax(String faxNumber) {
		this.fax = new UniversalCommunication(TEL, faxNumber);
	}

	/**
    * Gets the email contacts E-mail address.
    * 
    * Profile:: EXTENDED
    * Example:: +example@konik.io+
    * @return the email address
    */
	public String getEmail() {
		return email.getCompleteNumber();
	}

	/**
    * Sets the email contacts E-mail address.
    * Profile: EXTENDED.
    * Example: +example@konik.io+
    *
    * @param email the new email
    */
	public void setEmail(String email) {
		this.email = new UniversalCommunication(EMAIL, email);
	}
}

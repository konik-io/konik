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
 * The Class TradeContact.<br/>
 * Is a individual that can be contacted in ways specified by this class.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeContactType", propOrder = { "name", "department", "telephone", "fax", "email" })
public class Contact {

	/** The contact person name. */
	@XmlElement(name = "PersonName")
	private String name;

	/** The department name. */
	@XmlElement(name = "DepartmentName")
	private String department;

	/** The telephone number */
	@Valid
	@XmlElement(name = "TelephoneUniversalCommunication")
	private UniversalCommunication telephone;

	/** The fax number */
	@Valid
	@XmlElement(name = "FaxUniversalCommunication")
	private UniversalCommunication fax;

	/** The email address. */
	@Valid
	@XmlElement(name = "EmailURIUniversalCommunication")
	private UniversalCommunication email;

	/** Instantiates a new trade contact. */
	public Contact() {
	}

	/**
	 * Instantiates a new trade contact.
	 * 
	 * @param personName the person name
	 * @param departmentName the department name
	 * @param telephone the telephone
	 * @param fax the fax
	 * @param email the email
	 */
	public Contact(String personName, String departmentName, String telephone, String fax, String email) {
		this.name = personName;
		this.department = departmentName;
		this.telephone = telephone != null ? new UniversalCommunication(TEL, telephone) : null;
		this.fax = fax != null ? new UniversalCommunication(TEL, fax) : null;
		this.email = email != null ? new UniversalCommunication(EMAIL, email) : null;
	}

	/**
	 * Gets the contact person name.<br/>
	 * Profile: EXTENDED.<br/>
	 * 
	 * @return the person name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the contact person name.<br/>
	 * Profile: EXTENDED.<br/>
	 * 
	 * @param name the new person name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the department name.<br/>
	 * Profile: EXTENDED.<br/>
	 * 
	 * @return the department name
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department name.<br/>
	 * Profile: EXTENDED.<br/>
	 * 
	 * @param department the new department name
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Gets the telephone number.<br/>
	 * Profile: EXTENDED.<br/>
	 * 
	 * @return the telephone universal communication
	 */
	public UniversalCommunication getTelephone() {
		return telephone;
	}

	/**
	 * Sets the telephone number.<br/>
	 * Profile: EXTENDED.<br/>
	 * 
	 * @param telephone the new telephone number
	 */
	public void setTelephone(UniversalCommunication telephone) {
		this.telephone = telephone;
	}

	/**
	 * Sets the telephone number providing the string only.<br/>
	 * Profile: EXTENDED.<br/>
	 * Example: {@code +49 (123) 456789-999}
	 * 
	 * @param telephone the new telephone universal communication
	 */
	public void setTelephone(String telephone) {
		this.telephone = new UniversalCommunication(TEL, telephone);
	}

	/**
	 * Gets the fax number.<br/>
	 * Profile: EXTENDED.<br/>
	 * Example: {@code +49 (123) 456789-999}
	 * 
	 * @return the fax number
	 */
	public UniversalCommunication getFax() {
		return fax;
	}

	/**
	 * Sets the fax number.<br/>
	 * Profile: EXTENDED.<br/>
	 * Example: {@code +49 (123) 456789-999}
	 * 
	 * @param fax the new fax universal communication
	 */
	public void setFax(UniversalCommunication fax) {
		this.fax = fax;
	}

	/**
	 * Sets the telephone number providing the string only.<br/>
	 * Profile: EXTENDED.<br/>
	 * Example: {@code +49 (123) 456789-999}
	 * 
	 * @param fax the new fax number
	 */
	public void setFax(String fax) {
		this.fax = new UniversalCommunication(TEL, fax);
	}

	/**
	 * Gets the email contacts E-mail address.<br/>
	 * Profile: EXTENDED.<br/>
	 * Example: {@code Vadim.Bauer@example.com}
	 * 
	 * @return the email uri universal communication
	 */
	public UniversalCommunication getEmail() {
		return email;
	}

	/**
	 * Sets the email contacts E-mail address.<br/>
	 * Profile: EXTENDED.<br/>
	 * Example: {@code Vadim.Bauer@example.com}
	 * 
	 * @param email the new email uri universal communication
	 */
	public void setEmail(UniversalCommunication email) {
		this.email = email;
	}

	/**
	 * Sets the email contacts E-mail address.<br/>
	 * Profile: EXTENDED.<br/>
	 * Example: {@code Vadim.Bauer@example.com}
	 * 
	 * @param email the new email uri universal communication
	 */
	public void setEmail(String email) {
		this.email = new UniversalCommunication(EMAIL, email);
	}
}

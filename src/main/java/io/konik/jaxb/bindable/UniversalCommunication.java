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
package io.konik.jaxb.bindable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Universal Communication
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UniversalCommunicationType", propOrder = { "email", "number" })
public class UniversalCommunication {

	@XmlElement(name = "URIID")
	private String email;

	@XmlElement(name = "CompleteNumber")
	private String number;

	/**
	 * Instantiates a new universal communication.
	 * 
	 * @param scheme the scheme
	 * @param email the uri
	 */
	public UniversalCommunication(String email) {
		this.email = email;
	}
	
	/** Instantiates a new universal communication. */
	public UniversalCommunication() {
	}

	/**
    * Gets the mail.
    *
    * @return the mail
    */
	public String getMail() {
		return email;
	}

	/**
    * Sets the mail.
    *
    * @param uriid the new mail
    */
	public void setMail(String uriid) {
		this.email = uriid;
	}

	/**
	 * Gets the complete number.
	 * 
	 * @return the complete number
	 */
	public String getCompleteNumber() {
		return number;
	}

	/**
	 * Sets the complete number.
	 * 
	 * @param uri the new complete number
	 */
	public void setCompleteNumber(String uri) {
		this.number = uri;
	}

}

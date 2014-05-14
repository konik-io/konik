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

import io.konik.zugferd.unqualified.ID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Universal Communication.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UniversalCommunicationType", propOrder = { "uriid", "uri" })
public class UniversalCommunication {

	/** The communication uri name aka URI scheme eg. "tel:" "mailto:" */
	@XmlElement(name = "URIID")
	private ID uriid;

	/** The complete number. */
	@XmlElement(name = "CompleteNumber")
	private String uri;

	/**
	 * Instantiates a new universal communication.
	 * 
	 * @param scheme the scheme
	 * @param uri the uri
	 */
	public UniversalCommunication(UriSchemeNames scheme, String uri) {
		this.uriid = new ID(scheme.scheme);
		this.uri = uri;
	}

	/** Instantiates a new universal communication. */
	public UniversalCommunication() {
	}

	/**
	 * Gets the uriid.
	 * 
	 * @return the uriid
	 */
	public ID getUriId() {
		return uriid;
	}

	/**
	 * Sets the uriid.
	 * 
	 * @param uriid the new uriid
	 */
	public void setUriId(ID uriid) {
		this.uriid = uriid;
	}

	/**
	 * Gets the complete number.
	 * 
	 * @return the complete number
	 */
	public String getCompleteNumber() {
		return uri;
	}

	/**
	 * Sets the complete number.
	 * 
	 * @param uri the new complete number
	 */
	public void setCompleteNumber(String uri) {
		this.uri = uri;
	}

}

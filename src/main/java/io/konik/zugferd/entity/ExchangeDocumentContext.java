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

import io.konik.invoice.profiles.InvoiceProfiles;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class ExchangedDocumentContext. <br/>
 * Groups the properties of the message. <br/>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangedDocumentContextType", propOrder = { "test", "profile" })
public class ExchangeDocumentContext {

	/** Indicates if this invoice is for testing purpose only. */
	@XmlElement(name = "TestIndicator")
	private boolean test;

	/** The guideline specified document context parameters. */
	@Valid
	@XmlElement(name = "GuidelineSpecifiedDocumentContextParameter")
	private List<DocumentContextParameter> profile;

	/** Instantiates a new exchanged document context. */
	public ExchangeDocumentContext() {}

	/**
	 * Instantiates a new exchanged document context with a profile
	 * 
	 * @param profile the profile
	 */
	public ExchangeDocumentContext(InvoiceProfiles profile) {
	   addProfile(new DocumentContextParameter(profile.name));
	}

	/**
	 * Checks if test indicator is set.<br/>
	 * Profile: BASIC + COMFORT<br/>
	 * 
	 * @return true if this invoice is for testing purpose only
	 */
	public boolean isTest() {
		return test;
	}

	/**
	 * Sets the test indicator.<br/>
	 * Profile: BASIC + COMFORT<br/>
	 * 
	 * @param test the new indicates if this invoice is for testing purpose only
	 */
	public void setTest(boolean test) {
		this.test = test;
	}

	/**
	 * Gets the guideline specified document context parameter. <br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code urn:ferd:invoice:1.0:comfort}
	 * 
	 * @return the guideline specified document context parameter
	 */
	public List<DocumentContextParameter> getProfile() {
		if (profile == null) {
			profile = new ArrayList<DocumentContextParameter>();
		}
		return this.profile;
	}

	/**
	 * Adds the guideline specified document context parameter. <br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code urn:ferd:invoice:1.0:comfort}
	 * 
	 * @param documentContextParameter the document context parameter
	 * @return the exchanged document context if add was successful
	 */
	public ExchangeDocumentContext addProfile(DocumentContextParameter documentContextParameter) {
		getProfile().add(documentContextParameter);
		return this;
	}

}

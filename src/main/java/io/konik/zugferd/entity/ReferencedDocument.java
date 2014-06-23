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

import io.konik.zugferd.qualified.DateTime;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * = The Referenced Document
 * 
 * References a external Document.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferencedDocumentType", propOrder = { "issued", "id" })
public class ReferencedDocument {

   @Valid
	@XmlElement(name = "IssueDateTime")
	private DateTime issued;

	@XmlElement(name = "ID")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	private String id;

	/**
	 * Gets the issue date time.
	 * 
	 * Profile:: COMFORT 
	 * 
	 * @return the issue date time
	 */
	public DateTime getIssued() {
		return issued;
	}

	/**
    * Sets the issue date time.
    * 
    * Profile:: COMFORT
    *
    * @param issued the new issue date time
    * @return the referenced document
    */
	public ReferencedDocument setIssued(DateTime issued) {
		this.issued = issued;
		return this;
	}
	
	/**
    * Sets the reference document id.
    *
    * @param referenceDocumentId the value
    * @return the referenced document
    */
	public ReferencedDocument setId(String referenceDocumentId){
	   id = referenceDocumentId;
	   return this;
	}

   /**
    * Gets the id.
    *
    * @return the id
    */
   public String getId() {
      return id;
   }
}

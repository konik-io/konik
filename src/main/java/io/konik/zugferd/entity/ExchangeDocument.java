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

import io.konik.zugferd.datatype.qualified.DateTime;
import io.konik.zugferd.datatype.unqualified.ID;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Class ExchangedDocument.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangedDocumentType", propOrder = { "id", "name", "typeCode", "issued", "notes" })
public class ExchangeDocument {

	/** The invoice id. */
	@XmlElement(name = "ID")
	@Valid
	private ID id;

	/** The invoice name. */
	@XmlElement(name = "Name")
	private List<String> name;

	/** The UNCL 1001 Document Name Code type code. */
	@XmlElement(name = "TypeCode")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	private String typeCode;

	/** The invoice issue date. */
	@XmlElement(name = "IssueDateTime")
	@Valid
	private DateTime issued;

	/** The invoice header notes. */
	@XmlElement(name = "IncludedNote")
	private List<Note> notes;

	/**
	 * Gets the invoice id.<br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code 2012-12345}
	 * 
	 * @return the invoice id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * Sets the invoice id.<br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code 2012-12345}
	 * 
	 * @param id the new id
	 * @return the exchanged document
	 */
	public ExchangeDocument setId(ID id) {
		this.id = id;
		return this;
	}

	/**
	 * Sets the invoice id skipping the scheme id. <br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code 2012-12345}
	 * 
	 * @param invoiceNumber the new id
	 * @return the exchanged document
	 */
	public ExchangeDocument setId(String invoiceNumber) {
		this.id = new ID(invoiceNumber);
		return this;
	}

	/**
	 * Gets the free text invoice name.<br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code invoice, credit advice, debit note, pro forma invoice}
	 * 
	 * @return the invoice name
	 */
	public List<String> getName() {
		if (name == null) {
			name = new ArrayList<String>();
		}
		return this.name;
	}

	/**
	 * Adds a free text invoice name.<br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code invoice, credit advice, debit note, pro forma invoice}
	 * 
	 * @param name the invoice name
	 * @return the exchanged document
	 * @see #getName()
	 */
	public ExchangeDocument addName(String name) {
		getName().add(name);
		return this;
	}

	/**
	 * Gets the UNCL 1001 Document Name Code document type code.<br/>
	 * In BASIC and COMFORT profile only code 380 is allowed.<br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code 380, 381, 383, 389, 261}
	 * 
	 * @return the type code
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * Sets the UNCL 1001 Document Name Code document type code.<br/>
	 * In BASIC and COMFORT profile only code 380 is allowed.<br/>
	 * Profile: BASIC + COMFORT<br/>
	 * Example: {@code 380, 381, 383, 389, 261}
	 * 
	 * @param typeCode the type code
	 * @return the exchanged document
	 */
	public ExchangeDocument setTypeCode(String typeCode) {
		this.typeCode = typeCode;// new DocumentCode(typeCode);
		return this;
	}

	/**
	 * Gets the invoice issue date time. <br/>
	 * Profile: BASIC + COMFORT<br/>
	 * 
	 * @return the issue date time
	 */
	public DateTime getIssued() {
		return issued;
	}

	/**
	 * Sets the invoice issue date time. <br/>
	 * Profile: BASIC + COMFORT<br/>
	 * 
	 * @param issued the new issue date time
	 * @return the exchanged document
	 */
	public ExchangeDocument setIssued(DateTime issued) {
		this.issued = issued;
		return this;
	}

	/**
	 * Gets the invoice header notes.<br/>
	 * Profile {@link Note#getContent()}: BASIC + COMFORT<br/>
	 * Profile {@link Note#getSubjectCode()}: COMFORT <br/>
	 * Example: {@code note content: }{@link Note#getContent() Invoice like agreed on the telephone with Mr.
	 * X.}<br/>
	 * Example: {@code note subject code as UNCL 4451: }{@link Note#getSubjectCode() AAK} <br/>
	 * 
	 * @return the included note
	 */
	public List<Note> getNotes() {
		if (notes == null) {
			notes = new ArrayList<Note>();
		}
		return this.notes;
	}

	/**
	 * Adds a invoice header note.<br/>
	 * Profile {@link Note#getContent()}: BASIC + COMFORT<br/>
	 * Profile {@link Note#getSubjectCode()}: COMFORT <br/>
	 * Example: {@code note content: }{@link Note#getContent() Invoice like agreed on the telephone with Mr.
	 * X.}<br/>
	 * Example: {@code note subject code as UNCL 4451: }{@link Note#getSubjectCode() AAK} <br/>
	 * 
	 * @param note the note
	 * @return the exchanged document
	 */
	public ExchangeDocument addNote(Note note) {
		getNotes().add(note);
		return this;
	}

}

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

import io.konik.zugferd.datatype.unqualified.ID;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class Item Line Document.
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentLineDocumentType", propOrder = { "itemNumber", "notes" })
public class DocumentLine {

	/** The line id. */
	@XmlElement(name = "LineID")
	private ID itemNumber;

	/** The included note. */
	@XmlElement(name = "IncludedNote")
	private List<Note> notes;

	/**
	 * Gets the line item number.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @return the line id
	 */
	public ID getItemNumber() {
		return itemNumber;
	}

	/**
	 * Sets the line item number.<br/>
	 * Profile: COMFORT<br/>
	 *
	 * @param lineItemNumber the new line id
	 */
	public void setItemNumber(ID lineItemNumber) {
		this.itemNumber = lineItemNumber;
	}

	/**
	 * Gets the included note.<br/>
	 * Profile: Note.content COMFORT<br/>
	 * Profile: Note.subjectCode EXTENDED<br/>
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
	 * Adds the note.<br/>
	 * Profile: Note.content COMFORT<br/>
	 * Profile: Note.subjectCode EXTENDED<br/>
	 *
	 * @param note the note
	 * @return the document line document
	 */
	public DocumentLine addNote(Note note) {
		getNotes().add(note);
		return this;
	}

}

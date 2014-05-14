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
@XmlType(name = "DocumentLineDocumentType", propOrder = { "positionNumber", "notes" })
public class DocumentLine {

	@XmlElement(name = "LineID")
	private ID positionNumber;

	@XmlElement(name = "IncludedNote")
	private List<Note> notes;

	/**
    * Instantiates a new document line.
    */
	public DocumentLine() {
	}

	/**
    * Instantiates a new document line.
    *
    * @param positionNumber the position number
    */
	public DocumentLine(String positionNumber) {
      super();
      this.positionNumber = new ID(positionNumber);
   }

	/**
    * Instantiates a new document line.
    *
    * @param positionNumber the position number
    * @param notes the notes
    */
	public DocumentLine(String  positionNumber, List<Note> notes) {
      this(positionNumber);
      this.notes = notes;
   }

   /**
    * Gets the line position number.
    * Profile: COMFORT
    *
    * @return the position number
    */
	public String getPositionNumber() {
		return positionNumber.getValue();
	}

	/**
    * Sets the line position number
    * Profile: COMFORT
    *
    * @param positionNumber the new position number
    */
	public void setPositionNumber(String positionNumber) {
		this.positionNumber = new ID(positionNumber);
	}

	/**
	 * Gets the included note.

	 * Profile: Note.content COMFORT

	 * Profile: Note.subjectCode EXTENDED

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
	 * Adds the note.

	 * Profile: Note.content COMFORT

	 * Profile: Note.subjectCode EXTENDED

	 *
	 * @param note the note
	 * @return the document line document
	 */
	public DocumentLine addNote(Note note) {
		getNotes().add(note);
		return this;
	}

}

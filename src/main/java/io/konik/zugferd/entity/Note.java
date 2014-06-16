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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Note.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoteType", propOrder = { "content", "subjectCode" })
public class Note {

	@XmlElement(name = "Content")
	private String content;

	@XmlElement(name = "SubjectCode")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	private String subjectCode;

	/** Instantiates a new note. */
	public Note() {
	}

	/**
	 * Instantiates a new note without a content only.
	 *
	 * @param content the content
	 */
	public Note(String content) {
		super();
		this.content = content;
	}

	/**
	 * Instantiates a new note.
	 *
	 * @param content the content
	 * @param subjectCode the subject code
	 */
	public Note(String content, String subjectCode) {
		super();
		this.content = content;
		this.subjectCode = subjectCode;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
    * Sets the content.
    *
    * @param content the new content
    * @return the note
    */
	public Note setContent(String content) {
		this.content = content;
		return this;
	}

	/**
	 * Gets the subject code.
	 *
	 * @return the subject code
	 */
	public String getSubjectCode() {
		return subjectCode;
	}

	/**
    * Sets the subject code.
    *
    * @param subjectCode the new subject code
    * @return the note
    */
	public Note setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
		return this;
	}

}

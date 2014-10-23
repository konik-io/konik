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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Item Line Document
 * 
 * For Item position and notes
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentLineDocumentType", propOrder = { "position", "notes" })
public class Document {

    @XmlElement(name = "LineID")
    private String position;

    @XmlElement(name = "IncludedNote")
    private List<Note> notes;

    /**
     * Instantiates a new document line.
     */
    public Document() {
    }

    /**
     * Instantiates a new document line.
     *
     * @param position the position number
     */
    public Document(String position) {
        super();
        this.position = position;
    }

    /**
     * Instantiates a new document line.
     *
     * @param position the position
     * @param notes the notes
     */
    public Document(String position, List<Note> notes) {
        this(position);
        this.notes = notes;
    }

    public Document(int position) {
        super();
        this.position = Integer.toString(position);
    }

    /**
     * Instantiates a new document line.
     *
     * @param position the position
     * @param notes the notes
     */
    public Document(int position, List<Note> notes) {
        this(position);
        this.notes = notes;
    }

    /**
     * Gets the line position.
     * 
     * Profile:: COMFORT
     *
     * @return the position number
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the line position
     * 
     * Profile:: COMFORT.
     *
     * @param position the position
     */
    public void setPosition(String position) {
        this.position = position;

    }

    /**
     * Gets the included note.
     * 
     * Profile:: - Note.content COMFORT - Note.subjectCode EXTENDED
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
     * 
     * Profile:: - Note.content COMFORT - Note.subjectCode EXTENDED
     *
     * @param note the note
     */
    public void addNote(Note note) {
        getNotes().add(note);

    }

}

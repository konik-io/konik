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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import io.konik.validator.annotation.Comfort;

/**
 * = The item position Document
 */
@XmlType(name = "DocumentLineDocumentType", propOrder = { "position", "notes" })
public class PositionDocument implements Serializable {

   @XmlElement(name = "LineID")
   private String position;

   @XmlElement(name = "IncludedNote")
   private List<Note> notes;

   PositionDocument() {
   }

   /**
    * Instantiates a new item position document.
    *
    * @param position the position number
    */
   public PositionDocument(String position) {
      super();
      this.position = position;
   }

   /**
    * Instantiates a new item position document.
    *
    * @param position the position
    * @param notes the notes
    */
   public PositionDocument(String position, List<Note> notes) {
      this(position);
      this.notes = notes;
   }

   /**
    * Instantiates a new item position document.
    *
    * @param position the position number
    */
   public PositionDocument(int position) {
      super();
      this.position = Integer.toString(position);
   }

   /**
    * Instantiates a new item position document.
    *
    * @param position the position
    * @param notes the notes
    */
   public PositionDocument(int position, List<Note> notes) {
      this(position);
      this.notes = notes;
   }

   /**
    * Gets the line position.
    * 
    * @return the position number
    */
   @Comfort
   public String getPosition() {
      return position;
   }

   /**
    * Sets the line position
    * 
    * @param position the position
    */
   public void setPosition(String position) {
      this.position = position;

   }

   /**
    * Gets the included note.
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
    * @param note the note
    */
   public void addNote(Note note) {
      getNotes().add(note);

   }

}

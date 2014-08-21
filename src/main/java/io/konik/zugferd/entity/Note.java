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

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.validator.annotation.NotEmpty;
import io.konik.validator.annotation.NullableNotBlank;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Note
 */
@XmlType(name = "NoteType", propOrder = { "contentCode", "contents", "subjectCode" })
public class Note {

   @Extended
   @NullableNotBlank
   @XmlElement(name = "ContentCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String contentCode;

   @Basic
   @NotEmpty
   @XmlElement(name = "Content")
   private List<String> contents;

   @Comfort
   @XmlElement(name = "SubjectCode")
   @NullableNotBlank
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
      addContent(content);
   }

   /**
    * Instantiates a new note.
    *
    * @param content the content
    * @param subjectCode the subject code
    */
   public Note(String content, String subjectCode) {
      super();
      this.addContent(content);
      this.subjectCode = subjectCode;
   }

   /**
    * Gets the content.
    *
    * @return the content
    */
   public List<String> getContents() {
      if (contents == null) {
         this.contents = new ArrayList<String>();
      }
      return this.contents;
   }

   /**
    * Adds content
    *
    * @param content the additional content
    * @return the note
    */
   public Note addContent(String content) {
      getContents().add(content);
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

   /**
    * Gets the content code.
    * 
    *
    * @return the content code
    */
   public String getContentCode() {
      return contentCode;
   }

   /**
    * Sets the content code.
    * 
    * @param contentCode the content code
    * @return the note
    */
   public Note setContentCode(String contentCode) {
      this.contentCode = contentCode;
      return this;
   }

}

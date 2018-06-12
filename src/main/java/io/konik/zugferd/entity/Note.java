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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.konik.validator.annotation.Basic;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.validator.annotation.NotEmpty;
import io.konik.validator.annotation.NullableNotBlank;

/**
 * = The Note
 */
@XmlType(name = "NoteType", propOrder = { "contentCode", "contents", "subjectCode" })
public class Note implements Serializable {

   @XmlElement(name = "ContentCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String contentCode;

   @XmlElement(name = "Content")
   private List<String> contents;

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
    * Gets the code related to the contend text
    *
    * @return the content code related to content free text
    */
   @Extended
   @NullableNotBlank
   public String getContentCode() {
      return contentCode;
   }

   /**
    * Sets the code related to the contend text
    * 
    * @param contentCode the content code related to content free text
    * @return the note
    */
   public Note setContentCode(String contentCode) {
      this.contentCode = contentCode;
      return this;
   }

   /**
    * Gets the human readable note content.
    *
    * @return the content
    */
   @Basic(ifParent = Header.class)
   @Comfort(ifParent = PositionDocument.class)
   @NotEmpty
   public List<String> getContents() {
      if (contents == null) {
         this.contents = new ArrayList<String>();
      }
      return this.contents;
   }

   /**
    * Adds the free text content.
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
   @Comfort(ifParent = Header.class)
   @Extended(ifParent = PositionDocument.class)
   @NullableNotBlank
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

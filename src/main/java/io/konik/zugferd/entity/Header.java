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
import io.konik.zugferd.unece.codes.DocumentNameCode;

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
 * = The Invoice Document Header
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangedDocumentType", propOrder = { "invoiceNumber", "name", "code", "issued", "notes" })
public class Header {
   
   @XmlElement(name = "ID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String invoiceNumber;

   @XmlElement(name = "Name")
   private List<String> name;

   @XmlElement(name = "TypeCode")
   private DocumentNameCode code;

   @XmlElement(name = "IssueDateTime")
   @Valid
   private DateTime issued;

   @XmlElement(name = "IncludedNote")
   private List<Note> notes;

   /**
    * Gets the invoice number.
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code 2012-12345}
    *
    * @return the invoice number
    */
   public String getInvoiceNumber() {
      return invoiceNumber;
   }

   /**
    * Sets the invoice number.
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code 2012-12345}
    *
    * @param invoiceNumber the invoice number
    * @return the header document
    */
   public Header setInvoiceNumber(String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
      return this;
   }

   /**
    * Gets the free text invoice name.
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code invoice, credit advice, debit note, pro forma invoice}
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
    * Adds a free text invoice name.
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code invoice, credit advice, debit note, pro forma invoice}
    * 
    * @param additionalName the additional invoice name
    * @return the exchanged document
    * @see #getName()
    */
   public Header addName(String additionalName) {
      getName().add(additionalName);
      return this;
   }


   /**
    * Gets +UNCL 1001+ Document Name Code.
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code 380, 381, 383, 389, 261}
    * 
    * @return the document name code
    * @see http://www.unece.org/trade/untdid/d13b/tred/tred1001.htm[UN/EDIFACT 1001 Document name coe^]
    */
   public DocumentNameCode getCode() {
      return code;
   }
   
   /**
    * Sets the +UNCL 1001+ Document Name Code.
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code 380, 381, 383, 389, 261}
    *
    * @param code the new document name code
    * @return the header document
    * @see http://www.unece.org/trade/untdid/d13b/tred/tred1001.htm[UN/EDIFACT 1001 Document name coe^]
    */

   public Header setCode(DocumentNameCode code) {
      this.code = code;
      return this;
   }
   

   /**
    * Gets the invoice issue date time.
    * 
    * Profile:: BASIC
    * 
    * 
    * @return the issue date time
    */
   public DateTime getIssued() {
      return issued;
   }

   /**
    * Sets the invoice issue date time.
    * 
    * Profile:: BASIC
    * 
    * 
    * @param issued the new issue date time
    * @return the exchanged document
    */
   public Header setIssued(DateTime issued) {
      this.issued = issued;
      return this;
   }

   /**
    * Gets the invoice header notes.
    * 
    * Profile:: 
    * - {@link Note#getContent()}: BASIC
    * - {@link Note#getSubjectCode()}: COMFORT
    * 
    * Example:: 
    * {@code note content: }{@link Note#getContent() Invoice like agreed on the telephone with Mr.X.}
    * 
    * Example:: 
    * - {@code note content: }{@link Note#getContent() Invoice like agreed on the telephone with Mr.X.}
    * - {@code note subject code as UNCL 4451: }{@link Note#getSubjectCode() AAK}
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
    * Adds a invoice header note.
    * 
    * Profile:: 
    * - {@link Note#getContent()}: BASIC
    * - {@link Note#getSubjectCode()}: COMFORT
    * 
    * Example:: 
    * - {@code note content: }{@link Note#getContent() Invoice like agreed on the telephone with Mr.X.}
    * - {@code note subject code as UNCL 4451: }{@link Note#getSubjectCode() AAK}
    * 
    * 
    * @param note the note
    * @return the exchanged document
    */
   public Header addNote(Note note) {
      getNotes().add(note);
      return this;
   }

}

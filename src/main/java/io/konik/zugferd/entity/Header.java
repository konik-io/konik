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

import static java.util.Collections.addAll;
import io.konik.builder.GenerateBuilder;
import io.konik.jaxb.adapter.PeriodCompleteToDateTimeAdapter;
import io.konik.validator.annotation.Extended;
import io.konik.validator.annotation.NotEmpty;
import io.konik.validator.annotation.NullableNotBlank;
import io.konik.zugferd.unece.codes.DocumentCode;
import io.konik.zugferd.unqualified.Indicator;
import io.konik.zugferd.unqualified.ZfDate;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.neovisionaries.i18n.LanguageCode;

/**
 * = The Invoice Document Header
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderExchangedDocument", propOrder = { "invoiceNumber", "name", "code", "issued", "copy", "languages",
      "notes", "contractualDueDate" })
@GenerateBuilder
public class Header {

   @NotNull
   @NullableNotBlank
   @XmlElement(name = "ID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String invoiceNumber;

   @NotNull
   @NullableNotBlank
   @XmlElement(name = "Name")
   private String name;

   @NotNull
   @XmlElement(name = "TypeCode")
   private DocumentCode code;

   @XmlElement(name = "IssueDateTime")
   @NotNull
   @Valid
   private ZfDate issued;

   @XmlElement(name = "CopyIndicator")
   private Indicator copy;

   @XmlElement(name = "LanguageID")
   private List<LanguageCode> languages;

   @Valid
   @NotEmpty
   @XmlElement(name = "IncludedNote")
   private List<Note> notes;

   @Valid
   @Extended
   @XmlElement(name = "EffectiveSpecifiedPeriod")
   @XmlJavaTypeAdapter(value = PeriodCompleteToDateTimeAdapter.class)
   private ZfDate contractualDueDate;

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
    */
   public void setInvoiceNumber(String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
      
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
   public String getName() {
      return this.name;
   }

   /**
    * Adds a free text invoice name.
    * 
    * Profile:: BASIC
    * 
    * Example:: {@code invoice, credit advice, debit note, pro forma invoice}
    *
    * @param name the new name
    * @see #getName()
    */
   public void setName(String name) {
      this.name = name;
      
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
   public DocumentCode getCode() {
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
    * @see http://www.unece.org/trade/untdid/d13b/tred/tred1001.htm[UN/EDIFACT 1001 Document name coe^]
    */

   public void setCode(DocumentCode code) {
      this.code = code;
      
   }

   /**
    * Gets the invoice issue date time.
    * 
    * Profile:: BASIC
    * 
    * 
    * @return the issue date time
    */
   public ZfDate getIssued() {
      return issued;
   }

   /**
    * Sets the invoice issue date time.
    * 
    * Profile:: BASIC
    * 
    * 
    * @param issued the new issue date time
    */
   public void setIssued(ZfDate issued) {
      this.issued = issued;
      
   }

   /**
    * Checks if is copy.
    *
    * @return the indicator
    */
   public boolean isCopy() {
      return copy.getIndicator();
   }

   /**
    * Sets the copy.
    *
    * @param copy the new copy
    */
   public void setCopy(boolean copy) {
      this.copy = new Indicator(copy);
   }

   /**
    * Gets the languages.
    *
    * @return the languages
    */
   public List<LanguageCode> getLanguages() {
      if (languages == null) {
         languages = new ArrayList<LanguageCode>();
      }
      return languages;
   }

   /**
    * Adds the language.
    *
    * @param language the language
    */
   public void addLanguage(LanguageCode language) {
      getLanguages().add(language);
   }

   /**
    * Gets the invoice header notes.
    * 
    * Profile::
    * - {@link Note#getContent()}: BASIC
    * - {@link Note#getSubjectCode()}: COMFORT
    * 
    * Example:: {@code note content: }{@link Note#getContent() Invoice like agreed on the telephone with Mr.X.}
    * 
    * Example::
    * - {@code note content: }{@link Note#getContent() Invoice like agreed on the telephone with Mr.X.} -
    * {@code note subject code as UNCL 4451: }{@link Note#getSubjectCode() AAK}
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
    * - {@code note content: }{@link Note#getContent() Invoice like agreed on the telephone with Mr.X.} -
    * {@code note subject code as UNCL 4451: }{@link Note#getSubjectCode() AAK}
    *
    * @param additionalNote the additional note
    */
   public void addNote(Note... additionalNote) {
      addAll(getNotes(), additionalNote);
      
   }

   /**
    * Gets the contractual due date.
    *
    * @return the contractual due date
    */
   public ZfDate getContractualDueDate() {
      return contractualDueDate;
   }

   /**
    * Sets the contractual due date.
    *
    * @param contractualDueDate the contractual due date
    */
   public void setContractualDueDate(ZfDate contractualDueDate) {
      this.contractualDueDate = contractualDueDate;
      
   }

}

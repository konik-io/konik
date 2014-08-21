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

import io.konik.jaxb.adapter.IssueDateTimeAdapter;
import io.konik.validator.annotation.Comfort;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Referenced Document
 * 
 * References a external Document.
 */
@XmlType(name = "ReferencedDocumentType", propOrder = { "issued", "linePos", "typeCode", "id", "referenceType" })
public class ReferencedDocument {

   @XmlElement(name = "IssueDateTime")
   @XmlJavaTypeAdapter(value = IssueDateTimeAdapter.class)
   private Date issued;

   @XmlElement(name = "LineID")
   protected String linePos;

   @XmlElement(name = "TypeCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   protected String typeCode;

   @XmlElement(name = "ID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String id;

   @XmlElement(name = "ReferenceTypeCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   protected String referenceType;

   protected ReferencedDocument() {
   }

   /**
    * The Constructor.
    *
    * @param identifier the id value of the referenced document
    */
   public ReferencedDocument(String identifier) {
      super();
      this.id = identifier;
   }

   /**
    * Gets the issue date time.
    * 
    * @return the issue date time
    */
   public Date getIssued() {
      return new Date(issued.getTime());
   }

   /**
    * Sets the issue date time.
    * 
    * @param issued the new issue date time
    * @return the referenced document
    */
   public ReferencedDocument setIssued(Date issued) {
      this.issued = new Date(issued.getTime());
      return this;
   }

   /**
    * Sets the reference document identifier.
    * 
    * Examples:: Order number, document number, number of customer order, delivery note numbers
    *
    * @param referenceDocumentIdentifier the id of the document
    * @return the referenced document
    */
   public ReferencedDocument setId(String referenceDocumentIdentifier) {
      id = referenceDocumentIdentifier;
      return this;
   }

   /**
    * Gets the identifier.
    * 
    * Examples:: Order number, document number, number of customer order, delivery note numbers
    * 
    * @return the id the identifier of the referenced document
    */
   @NotNull(groups = Comfort.class)
   public String getId() {
      return id;
   }
}

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

package io.konik.zugferd.unqualified;

import io.konik.validator.annotation.NotBlank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The classification code
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodeType", propOrder = { "value" })
public class Code {

   @NotBlank
   @XmlValue
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   @XmlSchemaType(name = "token")
   protected String value;

   @NotBlank
   @XmlAttribute(name = "listID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   @XmlSchemaType(name = "token")
   protected String listId;

   @XmlAttribute(name = "listVersionID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   @XmlSchemaType(name = "token")
   protected String listVersionId;

   /**
    * Gets the value.
    *
    * @return the value
    */
   public String getValue() {
      return value;
   }

   /**
    * Sets the value.
    *
    * @param value the value
    */
   public void setValue(String value) {
      this.value = value;
   }

   /**
    * Gets the list id.
    *
    * @return the list id
    */
   public String getListID() {
      return listId;
   }

   /**
    * Sets the list id.
    *
    * @param value the list id
    */
   public void setListID(String value) {
      this.listId = value;
   }

   /**
    * Gets the list version id.
    *
    * @return the list version id
    */
   public String getListVersionID() {
      return listVersionId;
   }

   /**
    * Sets the list version id.
    *
    * @param value the list version id
    */
   public void setListVersionID(String value) {
      this.listVersionId = value;
   }

}

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

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import io.konik.validator.annotation.NotBlank;

/**
 * = The Identifier.
 */
@XmlType(name = "IDType", propOrder = { "value" })
public class ID implements Serializable {

   @XmlValue
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   @XmlSchemaType(name = "token")
   private String value;

   @XmlAttribute(name = "schemeID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   @XmlSchemaType(name = "token")
   private String schemeId;

   /** Instantiates a new id. */
   public ID() {
   }

   /**
    * Instantiates a new id with value and a null scheme.
    *
    * @param value the value
    */
   public ID(String value) {
      this.value = value;
   }

   /**
    * Instantiates a new id with value and scheme id.
    * 
    * @param value the value
    * @param schemeId the scheme id
    */
   public ID(String value, String schemeId) {
      this.value = value;
      this.schemeId = schemeId;
   }

   /**
    * Gets the value.
    * 
    * @return the value
    */
   @NotBlank
   public String getValue() {
      return value;
   }

   /**
    * Sets the value.
    * 
    * @param value the new value
    */
   public void setValue(String value) {
      this.value = value;
   }

   /**
    * Gets the scheme id.
    * 
    * @return the scheme id
    */
   public String getSchemeId() {
      return schemeId;
   }

   /**
    * Sets the scheme id.
    * 
    * @param schemeId the new scheme id
    */
   public void setSchemeId(String schemeId) {
      this.schemeId = schemeId;
   }
}

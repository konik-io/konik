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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * The scheme agency aware identifier.
 */
public class ExtendedID extends ID {

   @NotBlank
   @XmlAttribute(name = "schemeAgencyID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String schemeAgencyId;

   /**
    * Instantiates a new extended id.
    *
    * @param idValue the id value
    * @param schemeAgencyId the scheme agency id
    */
   public ExtendedID(String idValue, String schemeAgencyId) {
      super(idValue);
      this.schemeAgencyId = schemeAgencyId;
   }

   ExtendedID() {
      super();
   }

   /**
    * Gets the scheme agency id.
    *
    * @return the scheme agency id
    */
   public String getSchemeAgencyId() {
      return schemeAgencyId;
   }

   /**
    * Sets the scheme agency id.
    *
    * @param schemeAgencyId the new scheme agency id
    * @return
    */
   public ExtendedID setSchemeAgencyId(String schemeAgencyId) {
      this.schemeAgencyId = schemeAgencyId;
      return this;
   }

}

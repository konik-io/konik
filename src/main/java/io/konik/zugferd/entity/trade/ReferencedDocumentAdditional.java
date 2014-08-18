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
package io.konik.zugferd.entity.trade;

import javax.validation.constraints.NotNull;

import io.konik.validator.annotation.Extended;
import io.konik.zugferd.entity.ReferencedDocument;


/**
 * 
 * The Additional Referenced Document
 */
public class ReferencedDocumentAdditional extends ReferencedDocument {

   /**
    * Gets the type code.
    *
    * @return the type code
    */
   @NotNull(groups=Extended.class)
   public String getTypeCode() {
      return typeCode;
   }

   /**
    * Sets the type code.
    *
    * @param typeCode the new type code
    */
   public void setTypeCode(String typeCode) {
      this.typeCode = typeCode;
   }
   
   
}

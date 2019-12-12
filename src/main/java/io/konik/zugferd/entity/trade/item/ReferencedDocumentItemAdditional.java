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
package io.konik.zugferd.entity.trade.item;

import io.konik.validator.annotation.Extended;

import javax.validation.constraints.NotNull;

/**
 * 
 * The Referenced Document document with Additional reference type.
 */
public class ReferencedDocumentItemAdditional extends ReferencedDocumentItem {

   /**
    * Gets the reference type code.
    *
    * @return the reference type code
    */
   @NotNull(groups = Extended.class)
   public String getReferenceType() {
      return referenceType;
   }

   /**
    * Sets the reference type code.
    *
    * @param referenceTypeCode the new reference type code
    */
   public void setReferenceType(String referenceTypeCode) {
      this.referenceType = referenceTypeCode;
   }

}

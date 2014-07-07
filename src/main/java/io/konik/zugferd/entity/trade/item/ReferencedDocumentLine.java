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

import io.konik.zugferd.entity.ReferencedDocument;

/**
 * =The Referenced Document with line position information.
 * 
 * References a external Document.
 */
public class ReferencedDocumentLine extends ReferencedDocument{

   /**
    * The JAXB Constructor.
    */
   public ReferencedDocumentLine() {
   }
   
   /**
    * The Constructor.
    *
    * @param linePosition the line position number
    * @param identifier the identifier value this document refers to
    */
   public ReferencedDocumentLine(int linePosition, String identifier) {
      super(identifier);
      setLinePos(String.valueOf(linePosition));
   }
   
   /**
    * Gets the line pos.
    *
    * @return the line id
    */
   public String getLinePos() {
      return linePos;
   }

   /**
    * Sets the line pos.
    *
    * @param linePos the line id
    * @return 
    */
   public ReferencedDocumentLine setLinePos(String linePos) {
      this.linePos = linePos;
      return this;
   }
	
}

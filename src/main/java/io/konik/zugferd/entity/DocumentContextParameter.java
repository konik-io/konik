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

import io.konik.zugferd.datatype.unqualified.ID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The Class DocumentContextParameter.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentContextParameterType", propOrder = { "id" })
public class DocumentContextParameter {

   @XmlElement(name = "ID")
   private ID id;

   public DocumentContextParameter() {
   }

   public DocumentContextParameter(String idValue) {
      this.id = new ID(idValue);
   }

   public DocumentContextParameter(String idValue, String schemeId) {
      this(idValue);
      id.setSchemeId(schemeId);
   }

   public ID getId() {
      return id;
   }

   public void setId(ID id) {
      this.id = id;
   }
}

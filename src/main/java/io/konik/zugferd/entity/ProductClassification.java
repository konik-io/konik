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

import io.konik.validator.annotation.NotEmpty;
import io.konik.zugferd.unqualified.Code;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The product classification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductClassificationType", propOrder = { "classCode", "classNames" })
public class ProductClassification {

   @Valid
   @XmlElement(name = "ClassCode")
   protected Code classCode;

   @NotEmpty
   @XmlElement(name = "ClassName")
   protected List<String> classNames;

   /**
    * Gets the class code.
    *
    * @return the class code
    */
   public Code getClassCode() {
      return classCode;
   }

   /**
    * Sets the class code.
    *
    * @param value the class code
    */
   public void setClassCode(Code value) {
      this.classCode = value;
   }

   /**
    * Gets the class names.
    *
    * @return the class names
    */
   public List<String> getClassNames() {
      if (classNames == null) {
         classNames = new ArrayList<String>();
      }
      return this.classNames;
   }

   /**
    * Adds the class names.
    *
    * @param className the class name
    * @return the product classification
    */
   public ProductClassification addClassNames(String className) {
      getClassNames().add(className);
      return this;
   }

}

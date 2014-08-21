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

import io.konik.validator.annotation.Extended;
import io.konik.validator.annotation.NotBlank;
import io.konik.validator.annotation.NotEmpty;
import io.konik.validator.annotation.NullableNotBlank;
import io.konik.zugferd.unqualified.Measure;

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The Class ProductCharacteristic.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductCharacteristicType", propOrder = { "typeCode", "description", "measurand", "value" })
public class ProductCharacteristic {

   @NotBlank
   @XmlElement(name = "TypeCode")
   private String typeCode;

   @NotEmpty
   @XmlElement(name = "Description")
   private List<String> description;

   @Valid
   @XmlElement(name = "ValueMeasure")
   private Measure measurand;

   @Extended
   @NullableNotBlank
   @XmlElement(name = "Value")
   private String value;

   /**
    * Gets the type code.
    *
    * @return the type code
    */
   public String getTypeCode() {
      return typeCode;
   }

   /**
    * Sets the type code.
    *
    * @param typeCode the type code
    */
   public void setTypeCode(String typeCode) {
      this.typeCode = typeCode;
   }

   /**
    * Gets the description.
    *
    * @return the description
    */
   public List<String> getDescription() {
      return description;
   }

   /**
    * Sets the description.
    *
    * @param description the description
    */
   public void setDescription(List<String> description) {
      this.description = description;
   }

   /**
    * Gets the measurand.
    *
    * @return the measurand
    */
   public Measure getMeasurand() {
      return measurand;
   }

   /**
    * Sets the measurand.
    *
    * @param measurand the measurand
    */
   public void setMeasurand(Measure measurand) {
      this.measurand = measurand;
   }

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

}

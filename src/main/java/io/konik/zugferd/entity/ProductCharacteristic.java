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

import io.konik.validator.annotation.NotBlank;
import io.konik.validator.annotation.NotEmpty;
import io.konik.zugferd.unqualified.Measure;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class ProductCharacteristic.
 */
@XmlType(name = "ProductCharacteristicType", propOrder = { "typeCode", "description", "measurand", "value" })
public class ProductCharacteristic implements Serializable {

   @XmlElement(name = "TypeCode")
   private String typeCode;

   @XmlElement(name = "Description")
   private List<String> description;

   @XmlElement(name = "ValueMeasure")
   private Measure measurand;

   @XmlElement(name = "Value")
   private String value;

   /**
    * Gets the type code.
    *
    * @return the type code
    */
   @NotBlank
   public String getTypeCode() {
      return typeCode;
   }

   /**
    * Sets the type code.
    *
    * @param typeCode the type code
    * @return the product characteristic
    */
   public ProductCharacteristic setTypeCode(String typeCode) {
      this.typeCode = typeCode;
      return this;
   }

   /**
    * Gets the description.
    *
    * @return the description
    */
   @NotEmpty
   public List<String> getDescription() {
      if (description == null) {
         description = new ArrayList<String>();
      }
      return description;
   }

   /**
    * Sets the description.
    *
    * @param additionalDescription the description
    * @return the product characteristic
    */
   public ProductCharacteristic addDescription(String additionalDescription) {
      this.getDescription().add(additionalDescription);
      return this;
   }

   /**
    * Gets the measurand.
    *
    * @return the measurand
    */
   @Valid
   public Measure getMeasurand() {
      return measurand;
   }

   /**
    * Sets the measurand.
    *
    * @param measurand the measurand
    * @return the product characteristic
    */
   public ProductCharacteristic setMeasurand(Measure measurand) {
      this.measurand = measurand;
      return this;
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
    * @return the product characteristic
    */
   public ProductCharacteristic setValue(String value) {
      this.value = value;
      return this;
   }

}

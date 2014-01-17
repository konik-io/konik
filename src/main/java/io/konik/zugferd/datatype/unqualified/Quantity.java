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

package io.konik.zugferd.datatype.unqualified;

import java.math.BigDecimal;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The Class Quantity.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuantityType", propOrder = { "value" })
public class Quantity {

   /** The quantity value. */
   @XmlValue
   private BigDecimal value;

   /** The international quantity unit code. */
   @XmlAttribute(name = "unitCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   @Size(min = 1, max = 3)
   private String unitCode;

   /** Instantiates a new quantity. */
   public Quantity() {
   }

   /**
    * Instantiates a new quantity.
    * 
    * @param value the value
    * @param unitCode the unit code
    */
   public Quantity(BigDecimal value, String unitCode) {
      super();
      this.value = value;
      this.unitCode = unitCode;
   }

   /**
    * Gets the value.
    * 
    * @return the value
    */
   public BigDecimal getValue() {
      return value;
   }

   /**
    * Sets the value.
    * 
    * @param value the new value
    */
   public void setValue(BigDecimal value) {
      this.value = value;
   }

   /**
    * Gets the unit code.
    * 
    * @return the unit code
    */
   public String getUnitCode() {
      return unitCode;
   }

   /**
    * Sets the unit code.
    * 
    * @param newUnitCode the new unit code
    */
   public void setUnitCode(String newUnitCode) {
      this.unitCode = newUnitCode;
   }

}

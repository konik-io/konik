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

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The quantifying metric measure value and type
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasureType", propOrder = { "value" })
public class Measure {

   @XmlValue
   @NotNull @Min(0)
   private BigDecimal value;

   /** The unit code. */
   @XmlAttribute(name = "unitCode")
   @Size(min = 1, max = 3)
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String unitCode;

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
    * @param value the value
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
    * @param value the unit code
    */
   public void setUnitCode(String value) {
      this.unitCode = value;
   }

}

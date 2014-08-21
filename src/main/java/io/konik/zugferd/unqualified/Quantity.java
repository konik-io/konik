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

import io.konik.jaxb.adapter.QuantityRoundingAdapter;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;

import java.math.BigDecimal;

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
 * = The Quantity
 * 
 * Defined by the amount and Unit
 * 
 * Units are based on Recommendation N°. 20 - Codes for Units of Measure Used in International Trade
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuantityType", propOrder = { "value" })
public class Quantity {

   @XmlValue
   @NotNull
   @XmlJavaTypeAdapter(QuantityRoundingAdapter.class)
   private BigDecimal value;

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
   public Quantity(int value, String unitCode) {
      super();
      this.value = BigDecimal.valueOf(value);
      this.unitCode = unitCode;
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
    * Instantiates a new quantity.
    *
    * @param value the value
    * @param unit the unit
    */
   public Quantity(BigDecimal value, UnitOfMeasurement unit) {
      super();
      this.value = value;
      this.unitCode = unit.getCode();
   }

   /**
    * Instantiates a new quantity.
    *
    * @param value the integer value
    * @param unit the unit
    */
   public Quantity(int value, UnitOfMeasurement unit) {
      super();
      this.value = BigDecimal.valueOf(value);
      this.unitCode = unit.getCode();
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
    * @return the quantity
    */
   public Quantity setValue(BigDecimal value) {
      this.value = value;
      return this;
   }

   /**
    * Gets the unit.
    *
    * @return the unit or null if unit is not known.
    */
   public UnitOfMeasurement getUnit() {
      return UnitOfMeasurement.getByCode(unitCode);
   }

   /**
    * Sets the unit.
    *
    * @param unit the new unit
    */
   public void setUnit(UnitOfMeasurement unit) {
      unitCode = unit.getCode();
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

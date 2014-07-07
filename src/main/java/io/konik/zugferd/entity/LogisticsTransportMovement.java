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

import io.konik.validator.annotation.NullableNotBlank;
import io.konik.validator.annotation.ValidId;
import io.konik.zugferd.unqualified.ID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Logistics Transport Movement.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogisticsTransportMovementType", propOrder = { "modeCode", "shippingId" })
public class LogisticsTransportMovement {

   @NullableNotBlank
   @XmlElement(name = "ModeCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String modeCode;

   @ValidId
   @XmlElement(name = "ID")
   private ID shippingId;

   /**
    * Gets the shpping mode code.
    *
    * @return the mode code
    */
   public String getModeCode() {
      return modeCode;
   }

   /**
    * Sets the shpping mode code.
    *
    * @param modeCode the mode code
    * @return the logistics transport movement
    */
   public LogisticsTransportMovement setModeCode(String modeCode) {
      this.modeCode = modeCode;
      return this;
   }

   /**
    * Gets the shpping id.
    *
    * @return the id
    */
   public ID getShppingId() {
      return shippingId;
   }

   /**
    * Sets the shpping id.
    *
    * @param shippingId the id
    * @return the logistics transport movement
    */
   public LogisticsTransportMovement setShppingId(ID shippingId) {
      this.shippingId = shippingId;
      return this;
   }

}

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

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Consignment.
 * 
 * Profile:: EXTENDED
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainConsignmentType", propOrder = { "shippingMethod" })
public class Consignment {

   /** The specified logistics transport movement. */
   @Valid@XmlElement(name = "SpecifiedLogisticsTransportMovement")
   private LogisticsTransportMovement shippingMethod;

   
   /**
    * The Constructor.
    */
   public Consignment() {
      super();
   }

   /**
    * Gets the shipping method.
    *
    * @return the shipping method
    */
   public LogisticsTransportMovement getShippingMethod() {
      return shippingMethod;
   }


   /**
    * Sets the shipping method.
    *
    * @param shippingMethod the shipping method
    */
   public void setShippingMethod(LogisticsTransportMovement shippingMethod) {
      this.shippingMethod = shippingMethod;
   }





}

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

import static java.util.Collections.addAll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Consignment.
 * 
 */
@XmlType(name = "SupplyChainConsignmentType", propOrder = { "shippingMethods" })
public class Consignment implements Serializable {

   @Valid
   @XmlElement(name = "SpecifiedLogisticsTransportMovement")
   private List<LogisticsTransportMovement> shippingMethods;

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
   public List<LogisticsTransportMovement> getShippingMethods() {
      if (shippingMethods == null) {
         shippingMethods = new ArrayList<LogisticsTransportMovement>();
      }
      return shippingMethods;
   }

   /**
    * adds shipping methods.
    *
    * @param additionalShippingMethod the additional shipping method
    * @return the consignment
    */
   public Consignment addShippingMethod(LogisticsTransportMovement... additionalShippingMethod) {
      addAll(getShippingMethods(), additionalShippingMethod);
      return this;
   }

}

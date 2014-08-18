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

import io.konik.zugferd.unqualified.Amount;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * The Class Common Monetary Summation.
 */
@XmlTransient
@XmlType(name = "TradeSettlementMonetarySummationType",propOrder = { "lineTotal"} )
public class CommonMonetarySummation {
   
   @Valid
   @XmlElement(name = "LineTotalAmount")
   protected Amount lineTotal;

   /**
    * Gets the line total.
    *
    * @return the line total
    */
   public Amount getLineTotal() {
      return lineTotal;
   }

   /**
    * Sets the line total.
    *
    * @param lineTotal the line total
    * @return the common monetary summation
    */
   public CommonMonetarySummation setLineTotal(Amount lineTotal) {
      this.lineTotal = lineTotal;
      return this;
   }
   
   
   
}

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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * = The Indicator.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndicatorType", propOrder = { "indicator" })
public class Indicator {

   @XmlElement(name = "Indicator", required = true)
   private boolean indicator;

   /**
    * Creates True indicator.
    *
    * @return the indicator
    */
   public static Indicator trueIndicator() {
      return new Indicator(true);
   }

   /**
    * Creates False indicator.
    *
    * @return the indicator
    */
   public static Indicator falseIndicator() {
      return new Indicator(false);
   }

   Indicator() {
   }

   /**
    * The Constructor.
    *
    * @param indicator the indicator
    */
   public Indicator(boolean indicator) {
      super();
      this.indicator = indicator;
   }

   /**
    * Gets the indicator.
    *
    * @return the indicator
    */
   public boolean getIndicator() {
      return indicator;
   }

}

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
package io.konik.zugferd.datatype.qualified;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The Class PaymentMeansCode represents the UNCL 4461 payment code
 * 
 * @see {@link http://www.unece.org/trade/untdid/d98a/uncl/uncl4461.htm}
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMeansCodeType", propOrder = { "value" })
public class PaymentMeansCode {

   /** The value. */
   @XmlValue
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String value;

   /** Instantiates a new payment means code. */
   public PaymentMeansCode() {
   }

   /**
    * Instantiates a new payment means code.
    * 
    * @param paymentMeansCode the payment means code
    */
   public PaymentMeansCode(String paymentMeansCode) {
      this.value = paymentMeansCode;
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
    * @param date the new value
    */
   public void setValue(String paymentMeansCode) {
      this.value = paymentMeansCode;
   }

}

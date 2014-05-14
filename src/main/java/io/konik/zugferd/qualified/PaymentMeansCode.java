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
package io.konik.zugferd.qualified;

import io.konik.unece.codes.PaymentMeansType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Payment Means Code 
 * 
 * Represents payment code according to +UNCL 4461+.
 * 
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred4461.htm[UN/EDIFACT 4461 Payment means code^]
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMeansCodeType")
@Deprecated
public class PaymentMeansCode {

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
    * Instantiates a new payment means code by a type.
    * 
    * @param type the Payment Means Type 
    */
   public PaymentMeansCode(PaymentMeansType type) {
      this.value = type.getCode();
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
    * @param paymentMeansCode the new payment Means Code 
    */
   public void setValue(String paymentMeansCode) {
      this.value = paymentMeansCode;
   }

}

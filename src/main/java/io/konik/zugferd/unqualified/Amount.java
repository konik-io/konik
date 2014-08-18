/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.unqualified;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import com.neovisionaries.i18n.CurrencyCode;

/**
 * = The Monetary Amount.
 * 
 * A number of monetary units specified by a currency where the currency is explicit or implied.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType", propOrder = { "value" })
public class Amount {

   @NotNull
   @XmlValue
   private BigDecimal value;

   @NotNull 
   @XmlAttribute(name = "currencyID")
   private CurrencyCode currency;

   Amount() {
   }

   /**
    * Instantiates a new amount.
    *
    * @param value the monetary value as a long
    * @param currency the currency code
    * 
    */
   public Amount(long value, CurrencyCode currency) {
      super();
      this.value = BigDecimal.valueOf(value);
      this.currency = currency;
   }

   /**
    * Instantiates a new amount.
    *
    * @param value the monetary value as a string
    * @param currency the currency code
    * @throws NumberFormatException if +value+ is not a valid representation of a +BigDecimal+.
    */
   public Amount(String value, CurrencyCode currency) {
      super();
      this.value = new BigDecimal(value);
      this.currency = currency;
   }

   /**
    * Instantiates a new amount.
    *
    * @param value the value
    * @param currency the currency code
    */
   public Amount(BigDecimal value, CurrencyCode currency) {
      super();
      this.value = value;
      this.currency = currency;
   }

   /**
    * Gets the amount value.
    * 
    * @return the value
    */
   public BigDecimal getValue() {
      return value;
   }

   /**
    * Sets the amount value.
    *
    * @param value the new value
    * @return the amount
    */
   public Amount setValue(BigDecimal value) {
      this.value = value;
      return this;
   }

   /**
    * Gets the currency code.
    *
    * @return the +ISO 4217 3A+ currency code
    */
   public CurrencyCode getCurrency() {
      return currency;
   }
   
   /**
    * Sets the currency code.
    *
    * @param currency the new +ISO 4217 3A+ currency code
    * @return the amount
    */
   public Amount setCurrency(CurrencyCode currency) {
      this.currency = currency;
      return this;
   }

}

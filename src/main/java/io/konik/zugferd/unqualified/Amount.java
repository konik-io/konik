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

import com.neovisionaries.i18n.CurrencyCode;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Monetary Amount.
 * 
 * A number of monetary units specified in a currency where the unit of the currency is explicit or implied.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType", propOrder = { "value" })
public class Amount {

   @XmlValue
   private BigDecimal value;

   @XmlAttribute(name = "currencyID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String currencyCode;

   /** Instantiates a new amount. */
   public Amount() {
   }

   /**
    * Instantiates a new amount.
    *
    * @param value the value
    * @param currencyCode the currency code
    */
   public Amount(long value, CurrencyCode currencyCode) {
      super();
      this.value = BigDecimal.valueOf(value);
      this.currencyCode = currencyCode.name();
   }

   /**
    * Instantiates a new amount.
    *
    * @param value the value
    * @param currencyCode the currency code
    */
   public Amount(String value, CurrencyCode currencyCode) {
      super();
      this.value = new BigDecimal(value);
      this.currencyCode = currencyCode.name();
   }

   /**
    * Instantiates a new amount.
    *
    * @param value the value
    * @param currencyCode the currency code
    */
   public Amount(BigDecimal value, CurrencyCode currencyCode) {
      super();
      this.value = value;
      this.currencyCode = currencyCode.name();
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
   public String getCurrencyCode() {
      return currencyCode;
   }

   /**
    * Gets the currency code type.
    *
    * @return the currency code type
    */
   public CurrencyCode getCurrency() {
      return CurrencyCode.getByCode(currencyCode);
   }
   
   /**
    * Sets the currency code.
    *
    * @param currencyCode the new +ISO 4217 3A+ currency code
    * @return the amount
    */
   public Amount setCurrencyCode(String currencyCode) {
      this.currencyCode = currencyCode;
      return this;
   }
   
   /**
    * Sets the currency.
    *
    * @param currencyCode the new currency code
    * @return the amount
    */
   public Amount setCurrency(CurrencyCode currencyCode) {
      this.currencyCode = currencyCode.name();
      return this;
   }

}

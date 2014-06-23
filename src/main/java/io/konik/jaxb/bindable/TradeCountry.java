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
package io.konik.jaxb.bindable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Trade Country.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeCountryType", propOrder = { "code" })
public class TradeCountry {

   /** The id. */
   @XmlElement(name = "ID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String code;

   TradeCountry() {
   }

   /**
    * Instantiates a new trade country.
    *
    * @param code the code
    */
   public TradeCountry(String code) {
      super();
      this.code = code;
   }

   /**
    * Gets the ISO 3166-2 codes of the country.
    * 
    * @return the ISO 3166-2 codes of the country
    */
   public String getCode() {
      return code;
   }

   /**
    * Sets the ISO 3166-2 codes of the country.
    *
    * @param code the new code
    */
   public void setCode(String code) {
      this.code = code;
   }

}

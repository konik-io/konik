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
package io.konik.zugferd.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Address
 * 
 * The postal address of an entity.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeAddressType", propOrder = { "postcode", "lineOne", "lineTwo", "city", "countryCode" })
public class Address {

   @XmlElement(name = "PostcodeCode")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String postcode;

   @XmlElement(name = "LineOne")
   private String lineOne;

   @XmlElement(name = "LineTwo")
   private String lineTwo;

   @XmlElement(name = "CityName")
   private String city;

   @XmlElement(name = "CountryID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String countryCode;

   /** Instantiates a new trade address. */
   public Address() {
   }

   /**
    * Instantiates a new trade address.
    *
    * @param postcode the postcode
    * @param lineOne the line one
    * @param lineTwo the line two
    * @param cityName the city name
    * @param countryCode the ISO 3166-2A country code
    */
   public Address(String postcode, String lineOne, String lineTwo, String cityName, String countryCode) {
      super();
      this.postcode = postcode;
      this.lineOne = lineOne;
      this.lineTwo = lineTwo;
      this.city = cityName;
      this.countryCode = countryCode;
   }

   /**
    * Instantiates a new trade address.
    *
    * @param postcode the postal code
    * @param lineOne the line one
    * @param cityName the city name
    * @param countryCode the ISO 3166-2A country code
    */
   public Address(String postcode, String lineOne, String cityName, String countryCode) {
      super();
      this.postcode = postcode;
      this.lineOne = lineOne;
      this.city = cityName;
      this.countryCode = countryCode;
   }

   /**
    * Gets the postcode.
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code DE-123456}
    *
    * @return the postcode
    */
   public String getPostcode() {
      return postcode;
   }

   /**
    * Sets the postcode code.
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code DE-123456}
    * 
    * @param postcode the postcode
    * @return the trade address
    */
   public Address setPostcode(String postcode) {
      this.postcode = postcode;
      return this;
   }

   /**
    * Gets the line one. Usually the Street name.
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code Elm Street 13}
    *
    * @return the line one
    */
   public String getLineOne() {
      return lineOne;
   }

   /**
    * Sets the line one. Usually the Street name.
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code Elm Street 13}
    *
    * @param lineOne the new line one
    * @return the trade address
    */
   public Address setLineOne(String lineOne) {
      this.lineOne = lineOne;
      return this;
   }

   /**
    * Gets the line two. Location like Building name or department.
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code Department of broken dreams}
    *
    * @return the line two
    */
   public String getLineTwo() {
      return lineTwo;
   }

   /**
    * Sets the line two.. Location like Building name or department.
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code Department of broken dreams}
    *
    * @param lineTwo the new line two
    * @return the trade address
    */
   public Address setLineTwo(String lineTwo) {
      this.lineTwo = lineTwo;
      return this;
   }

   /**
    * Gets the city name.
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code Zürich}
    *
    * @return the city name
    */
   public String getCity() {
      return city;
   }

   /**
    * Sets the city name.
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code Zürich}
    *
    * @param cityName the new city name
    * @return the trade address
    */
   public Address setCity(String cityName) {
      this.city = cityName;
      return this;
   }

   /**
    * Gets the country id.
    * 
    * Two-letter country codes defined in ISO 3166-1,
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code CH}
    *
    * @return the ISO 3166-2A country code
    * @see <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-2A Country Codes</a>
    */
   public String getCountryId() {
      return countryCode;
   }

   /**
    * Sets the country code.
    * 
    * Two-letter country codes defined in ISO 3166-1,
    * 
    * Profile:: BASIC when part of Trade.agreements.seller.
    * 
    * Example:: {@code CH}
    *
    * @param countryCode the country code
    * @return the trade address
    * @see <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-2A Country Codes</a>
    */
   public Address setCountryId(String countryCode) {
      this.countryCode = countryCode;
      return this;
   }
}

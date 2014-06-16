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

import io.konik.zugferd.unqualified.ID;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.neovisionaries.i18n.CountryCode;

/**
 * = The Trade Product.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeProductType", propOrder = { "globalId", "sellerAssignedId", "buyerAssignedId", "name",
      "description", "origins" })
public class Product {

   @XmlElement(name = "GlobalID")
   private ID globalId;

   @XmlElement(name = "SellerAssignedID")
   private ID sellerAssignedId;

   @XmlElement(name = "BuyerAssignedID")
   private ID buyerAssignedId;

   @XmlElement(name = "Name")
   private String name;

   @XmlElement(name = "Description")
   private String description;

   @Valid
   @XmlElement(name = "OriginTradeCountry")
   private List<CountryCode> origins;

   /**
    * Gets the global id.
    *
    * @return the global id
    */
   public ID getGlobalId() {
      return globalId;
   }

   /**
    * Sets the global id.
    *
    * @param productGlobalId the product global id
    * @return the trade product
    */
   public Product setGlobalId(ID productGlobalId) {
      this.globalId = productGlobalId;
      return this;
   }

   /**
    * Gets the seller assigned id.
    *
    * @return the seller assigned id
    */
   public ID getSellerAssignedId() {
      return sellerAssignedId;
   }

   /**
    * Sets the seller assigned id.
    *
    * @param sellerAssignedId the new seller assigned id
    * @return the trade product
    */
   public Product setSellerAssignedId(ID sellerAssignedId) {
      this.sellerAssignedId = sellerAssignedId;
      return this;
   }

   /**
    * Gets the buyer assigned id.
    *
    * @return the buyer assigned id
    */
   public ID getBuyerAssignedId() {
      return buyerAssignedId;
   }

   /**
    * Sets the buyer assigned id.
    *
    * @param buyerAssignedId the new buyer assigned id
    * @return the trade product
    */
   public Product setBuyerAssignedId(ID buyerAssignedId) {
      this.buyerAssignedId = buyerAssignedId;
      return this;
   }

   /**
    * Gets the name.
    *
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * Sets the name.
    *
    * @param name the new name
    * @return the trade product
    */
   public Product setName(String name) {
      this.name = name;
      return this;
   }

   /**
    * Gets the description.
    *
    * @return the description
    */
   public String getDescription() {
      return description;
   }

   /**
    * Sets the description.
    *
    * @param description the new description
    * @return the product
    */
   public Product setDescription(String description) {
      this.description = description;
      return this;
   }

   /**
    * Gets the origin trade country.
    *
    * @return the origin trade country
    */
   public List<CountryCode> getOrigins() {
      if (origins == null) {
         origins = new ArrayList<CountryCode>();
      }
      return origins;
   }

   /**
    * Adds a origin trade country.
    *
    * @param originCountry the additional origin country
    * @return the trade product
    */
   public Product addOrigins(CountryCode originCountry) {
      getOrigins().add(originCountry);
      return this;
   }

}

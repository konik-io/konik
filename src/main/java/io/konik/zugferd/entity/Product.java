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

import io.konik.jaxb.adapter.CountryAdapter;
import io.konik.jaxb.bindable.entity.TradeCountry;
import io.konik.zugferd.unqualified.ID;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.neovisionaries.i18n.CountryCode;

/**
 * = The Trade Product
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeProductType", propOrder = { "globalId", "sellerAssignedId", "buyerAssignedId", "name",
      "description", "characteristics", "classifications", "origins", "containedProducts" })
public class Product {

   @XmlElement(name = "GlobalID")
   private ID globalId;

   @XmlElement(name = "SellerAssignedID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String sellerAssignedId;

   @XmlElement(name = "BuyerAssignedID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   private String buyerAssignedId;

   @XmlElement(name = "Name")
   private String name;

   @XmlElement(name = "Description")
   private String description;
   
   @Valid
   @XmlElement(name = "ApplicableProductCharacteristic")
   private List<ProductCharacteristic> characteristics;

   @XmlElement(name = "DesignatedProductClassification")
   @Valid
   private List<ProductClassification> classifications;

   @Valid
   @XmlElement(name = "OriginTradeCountry")
   @XmlJavaTypeAdapter(value = CountryAdapter.class)
   private List<CountryCode> origins;

   @XmlElement(name = "IncludedReferencedProduct")
   @Valid
   private List<ReferencedProduct> containedProducts;

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
   public String getSellerAssignedId() {
      return sellerAssignedId;
   }

   /**
    * Sets the seller assigned id.
    *
    * @param sellerAssignedId the new seller assigned id
    * @return the trade product
    */
   public Product setSellerAssignedId(String sellerAssignedId) {
      this.sellerAssignedId = sellerAssignedId;
      return this;
   }

   /**
    * Gets the buyer assigned id.
    *
    * @return the buyer assigned id
    */
   public String getBuyerAssignedId() {
      return buyerAssignedId;
   }

   /**
    * Sets the buyer assigned id.
    *
    * @param buyerAssignedId the new buyer assigned id
    * @return the trade product
    */
   public Product setBuyerAssignedId(String buyerAssignedId) {
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
    * Gets the characteristics.
    *
    * @return the characteristics
    */
   public List<ProductCharacteristic> getCharacteristics() {
      if (characteristics == null) {
         characteristics = new ArrayList<ProductCharacteristic>();
      }
      return characteristics;
   }

   /**
    * Sets the characteristics.
    *
    * @param characteristic the characteristics
    * @return the product
    */
   public Product setCharacteristics(ProductCharacteristic characteristic) {
      getCharacteristics().add(characteristic);
      return this;
   }

   /**
    * Gets the classifications.
    *
    * @return the classifications
    */
   public List<ProductClassification> getClassifications() {
      if (classifications == null) {
         classifications = new ArrayList<ProductClassification>();
      }
      return classifications;
   }

   /**
    * Sets the classifications.
    *
    * @param classification the classifications
    * @return the product
    */
   public Product setClassifications(ProductClassification classification) {
      getClassifications().add(classification);
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

   /**
    * Gets the contained products.
    *
    * @return the contained products
    */
   public List<ReferencedProduct> getContainedProducts() {
      if (containedProducts == null) {
         containedProducts = new ArrayList<ReferencedProduct>();
      }
      return containedProducts;
   }

   /**
    * Additional contained products.
    *
    * @param containedProduct the contained product
    * @return the product
    */
   public Product addContainedProducts(ReferencedProduct containedProduct) {
      getContainedProducts().add(containedProduct);
      return this;
   }

}

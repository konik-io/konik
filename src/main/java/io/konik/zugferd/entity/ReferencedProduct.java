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

import io.konik.validator.annotation.Extended;
import io.konik.validator.annotation.NotEmpty;
import io.konik.zugferd.unqualified.ID;
import io.konik.zugferd.unqualified.Quantity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Referenced Product which is a included part of another product. 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferencedProductType", propOrder = { "globalIds", "sellerAssignedId", "buyerAssignedId", "names","descriptions", "units" })
@Extended
public class ReferencedProduct {

   @Valid
   @XmlElement(name = "GlobalID")
   protected List<ID> globalIds;
   
   
   @XmlElement(name = "SellerAssignedID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   protected String sellerAssignedId;

   
   @XmlElement(name = "BuyerAssignedID")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   protected String buyerAssignedId;

   @NotEmpty
   @XmlElement(name = "Name")
   protected List<String> names;

   
   @XmlElement(name = "Description")
   protected List<String> descriptions;

   @Valid
   @XmlElement(name = "UnitQuantity")
   protected List<Quantity> units;

   /**
    * Gets the global ids.
    *
    * @return the global ids
    */
   public List<ID> getGlobalIds() {
      if (globalIds == null) {
         globalIds = new ArrayList<ID>();
      }
      return this.globalIds;
   }
   
   /**
    * Adds the global ids.
    *
    * @param globarId the globar id
    * @return the referenced product
    */
   public ReferencedProduct addGlobalIds(ID globarId) {
      getGlobalIds().add(globarId);
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
    * @param sellerAsignedId the seller assigned id
    */
   public void setSellerAssignedId(String sellerAsignedId) {
      this.sellerAssignedId = sellerAsignedId;
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
    * @param buyerAssignedId the buyer assigned id
    */
   public void setBuyerAssignedId(String buyerAssignedId) {
      this.buyerAssignedId = buyerAssignedId;
   }

   /**
    * Gets the names.
    *
    * @return the names
    */
   public List<String> getNames() {
      if (names == null) {
         names = new ArrayList<String>();
      }
      return this.names;
   }
   
   /**
    * Adds the names.
    *
    * @param name the name
    * @return the referenced product
    */
   public ReferencedProduct addNames(String name){
      getNames().add(name);
      return this;
   }

   /**
    * Gets the descriptions.
    *
    * @return the descriptions
    */
   public List<String> getDescriptions() {
      if (descriptions == null) {
         descriptions = new ArrayList<String>();
      }
      return this.descriptions;
   }
   
   /**
    * Adds the description.
    *
    * @param description the description
    * @return the referenced product
    */
   public ReferencedProduct addDescription(String description){
      getDescriptions().add(description);
      return this;
   }

   /**
    * Gets the units.
    *
    * @return the units
    */
   public List<Quantity> getUnits() {
      if (units == null) {
         units = new ArrayList<Quantity>();
      }
      return this.units;
   }
   
   /**
    * Adds the units.
    *
    * @param unit the unit
    * @return the referenced product
    */
   public ReferencedProduct addUnits(Quantity unit){
      getUnits().add(unit);
      return this;
   }

}

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

import io.konik.zugferd.entity.trade.item.SpecifiedTax;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Trade Settlement
 * 
 * Contains payment related information.
 * 
 * @param <T> Tax
 * @param <M> MonetarySummation
 */
@XmlTransient
@XmlType(name = "SupplyChainTradeSettlementType")
public interface Settlement<T extends SpecifiedTax, M extends CommonMonetarySummation> {

   /**
    * Gets the billing specified period.
    * 
    * Profile:: COMFORT
    *
    * @return the billing specified period
    */
   public Period getBillingPeriod();

   /**
    * Sets the billing specified period.
    * 
    * Profile:: COMFORT
    * 
    *
    * @param billingPeriod the new billing specified period
    * @return the supply chain trade settlement
    */
   public Settlement<T, M> setBillingPeriod(Period billingPeriod);

   /**
    * Gets the applicable trade tax.
    *
    * @return the applicable trade tax
    */
   public List<T> getTradeTax();

   /**
    * Adds a trade tax.
    * 
    * @param additionalTradeTax
    * @return the trade settlement
    */
   public Settlement<T, M> addTradeTax(T additionalTradeTax);

   /**
    * Gets the trade settlement monetary summation.
    * 
    * Profile:: BASIC
    *
    * @return the specified trade settlement monetary summation
    */
   public M getMonetarySummation();

   /**
    * Sets the trade settlement monetary summation.
    * 
    * Profile:: BASIC
    *
    * @param monetarySummation the new monetary summation
    * @return the supply chain trade settlement
    */
   public Settlement<T, M> setMonetarySummation(M monetarySummation);

}

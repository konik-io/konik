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

import java.io.Serializable;
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
public interface CommonSettlement<T extends Tax, M extends CommonMonetarySummation> extends Serializable {

   /**
    * Gets the billing specified period.
    * 
    * @return the billing specified period
    */
   Period getBillingPeriod();

   /**
    * Sets the billing specified period.
    * 
    *
    * @param billingPeriod the new billing specified period
    * @return the supply chain trade settlement
    */
   CommonSettlement<T, M> setBillingPeriod(Period billingPeriod);

   /**
    * Gets the applicable trade tax.
    *
    * @return the applicable trade tax
    */
   List<T> getTradeTax();

   /**
    * Adds a trade tax.
    * 
    * @param additionalTradeTax
    * @return the trade settlement
    */
   CommonSettlement<T, M> addTradeTax(T additionalTradeTax);

   /**
    * Gets the trade settlement monetary summation.
    * 
    * @return the specified trade settlement monetary summation
    */
   M getMonetarySummation();

   /**
    * Sets the trade settlement monetary summation.
    * 
    * @param monetarySummation the new monetary summation
    * @return the supply chain trade settlement
    */
   CommonSettlement<T, M> setMonetarySummation(M monetarySummation);

}

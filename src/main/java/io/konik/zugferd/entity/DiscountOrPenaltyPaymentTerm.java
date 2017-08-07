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

import io.konik.jaxb.bindable.unqualified.PercentRoundingAdapter;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Measure;
import io.konik.zugferd.unqualified.ZfDate;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * = The payment penalty or discount terms and conditions of a trade
 */
@Extended
@XmlTransient
@XmlType(name = "TradePaymentDiscountTermsType", propOrder = { "reference", "maturityPeriod", "basis",
      "calculationPercent", "actualDiscount" })
interface DiscountOrPenaltyTerm extends Serializable {


   /**
    * Gets the reference date of maturity.
    *
    * @return the reference date
    */
   ZfDate getReference();

   /**
    * Sets the reference date of maturity.
    *
    * @param reference the new reference date
    * @return the discount penalty or discount payment term
    */
   DiscountOrPenaltyTerm setReference(ZfDate reference);

   /**
    * Gets the maturity period measure unit.
    *
    * @return the maturity period
    */
   @Valid
   Measure getMaturityPeriod();

   /**
    * Sets the maturity period measure unit.
    *
    * @param maturityPeriod the new maturity period measure unit.
    * @return the discount penalty or discount payment term
    */
   DiscountOrPenaltyTerm setMaturityPeriod(Measure maturityPeriod);

   /**
    * Gets basis amount of the payment surcharge.
    *
    * @return the basis amount
    */
   @Valid
   Amount getBasis();      

   /**
    * Sets the basis amount of the payment surcharge.
    *
    * @param basis the new basis amount
    * @return the discount penalty or discount payment term
    */
   DiscountOrPenaltyTerm setBasis(Amount basis);

   /**
    * Gets the calculation percentage of payment surcharge.
    *
    * @return the calculation percent
    */

   BigDecimal getCalculationPercent();

   /**
    * Sets the calculation percentage of payment surcharge.
    *
    * @param calculationPercent the new calculation percent of payment surcharge.
    * @return the discount penalty or discount payment term
    */
   DiscountOrPenaltyTerm setCalculationPercent(BigDecimal calculationPercent);

   /**
    * Gets the actual penalty or discount amount.
    *
    * @return the actual penalty or discount amount
    */
   @Valid
   Amount getAmount();

   /**
    * Sets the actual penalty or discount amount.
    *
    * @param penaltyOrDiscountAmount the new penalty or discount amount
    * @return the discount penalty or discount payment term
    */
   DiscountOrPenaltyTerm setAmount(Amount penaltyOrDiscountAmount);

}

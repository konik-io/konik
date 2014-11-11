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

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The payment penalty or discount terms and conditions of a trade
 */
@Extended
@XmlTransient
abstract class DiscountOrPenaltyTerm {

   @XmlElement(name = "BasisDateTime")
   private ZfDate reference;

   @XmlElement(name = "BasisPeriodMeasure")
   private Measure maturityPeriod;

   @XmlElement(name = "BasisAmount")
   private Amount basis;

   @XmlElement(name = "CalculationPercent")
   @XmlJavaTypeAdapter(PercentRoundingAdapter.class)
   private BigDecimal calculationPercent;

   /**
    * Gets the reference date of maturity.
    *
    * @return the reference date
    */
   public ZfDate getReference() {
      return reference;
   }

   /**
    * Sets the reference date of maturity.
    *
    * @param reference the new reference date
    * @return the discount penalty or discount payment term
    */
   public DiscountOrPenaltyTerm setReference(ZfDate reference) {
      this.reference = reference;
      return this;
   }

   /**
    * Gets the maturity period measure unit.
    *
    * @return the maturity period
    */
   @Valid
   public Measure getMaturityPeriod() {
      return maturityPeriod;
   }

   /**
    * Sets the maturity period measure unit.
    *
    * @param maturityPeriod the new maturity period measure unit.
    * @return the discount penalty or discount payment term
    */

   public DiscountOrPenaltyTerm setMaturityPeriod(Measure maturityPeriod) {
      this.maturityPeriod = maturityPeriod;
      return this;
   }

   /**
    * Gets basis amount of the payment surcharge.
    *
    * @return the basis amount
    */
   @Valid
   public Amount getBasis() {
      return basis;
   }

   /**
    * Sets the basis amount of the payment surcharge.
    *
    * @param basis the new basis amount
    * @return the discount penalty or discount payment term
    */
   public DiscountOrPenaltyTerm setBasis(Amount basis) {
      this.basis = basis;
      return this;
   }

   /**
    * Gets the calculation percentage of payment surcharge.
    *
    * @return the calculation percent
    */

   public BigDecimal getCalculationPercent() {
      return calculationPercent;
   }

   /**
    * Sets the calculation percentage of payment surcharge.
    *
    * @param calculationPercent the new calculation percent of payment surcharge.
    * @return the discount penalty or discount payment term
    */

   public DiscountOrPenaltyTerm setCalculationPercent(BigDecimal calculationPercent) {
      this.calculationPercent = calculationPercent;
      return this;
   }

   /**
    * Gets the actual penalty or discount amount.
    *
    * @return the actual penalty or discount amount
    */
   @Valid
   public abstract Amount getAmount();

   /**
    * Sets the actual penalty or discount amount.
    *
    * @param penaltyOrDiscountAmount the new penalty or discount amount
    * @return the discount penalty or discount payment term
    */
   public abstract DiscountOrPenaltyTerm setAmount(Amount penaltyOrDiscountAmount);

}

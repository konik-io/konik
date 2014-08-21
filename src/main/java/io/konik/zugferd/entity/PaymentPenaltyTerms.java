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
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Measure;
import io.konik.zugferd.unqualified.ZfDate;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * = The trades payment penalty terms and conditions
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePaymentPenaltyTermsType", propOrder = { "reference", "maturityPeriod", "basis",
      "calculationPercent", "actualPenalty" })
public class PaymentPenaltyTerms {

   @XmlElement(name = "BasisDateTime")
   private ZfDate reference;

   @Valid
   @XmlElement(name = "BasisPeriodMeasure")
   private Measure maturityPeriod;

   @Valid
   @XmlElement(name = "BasisAmount")
   private Amount basis;

   @XmlElement(name = "CalculationPercent")
   @XmlJavaTypeAdapter(PercentRoundingAdapter.class)
   private BigDecimal calculationPercent;

   @Valid
   @XmlElement(name = "ActualPenaltyAmount")
   private Amount actualPenalty;

   /**
    * Gets the reference.
    *
    * @return the reference
    */
   public ZfDate getReference() {
      return reference;
   }

   /**
    * Sets the reference.
    *
    * @param reference the new reference
    */
   public void setReference(ZfDate reference) {
      this.reference = reference;
   }

   /**
    * Gets the maturity period.
    *
    * @return the maturity period
    */
   public Measure getMaturityPeriod() {
      return maturityPeriod;
   }

   /**
    * Sets the maturity period.
    *
    * @param maturityPeriod the new maturity period
    */
   public void setMaturityPeriod(Measure maturityPeriod) {
      this.maturityPeriod = maturityPeriod;
   }

   /**
    * Gets the basis.
    *
    * @return the basis
    */
   public Amount getBasis() {
      return basis;
   }

   /**
    * Sets the basis.
    *
    * @param basis the new basis
    */
   public void setBasis(Amount basis) {
      this.basis = basis;
   }

   /**
    * Gets the calculation percent.
    *
    * @return the calculation percent
    */
   public BigDecimal getCalculationPercent() {
      return calculationPercent;
   }

   /**
    * Sets the calculation percent.
    *
    * @param calculationPercent the new calculation percent
    */
   public void setCalculationPercent(BigDecimal calculationPercent) {
      this.calculationPercent = calculationPercent;
   }

   /**
    * Gets the actual penalty.
    *
    * @return the actual penalty
    */
   public Amount getActualPenalty() {
      return actualPenalty;
   }

   /**
    * Sets the actual penalty.
    *
    * @param actualPenalty the new actual penalty
    */
   public void setActualPenalty(Amount actualPenalty) {
      this.actualPenalty = actualPenalty;
   }

}

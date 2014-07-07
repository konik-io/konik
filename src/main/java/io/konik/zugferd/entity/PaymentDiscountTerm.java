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

import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.DateTime;
import io.konik.zugferd.unqualified.Measure;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * The Class PaymentDiscountTerm.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePaymentDiscountTermsType", propOrder = { "reference", "maturityPeriod", "basisDiscount",
      "calculationPercent", "actualDiscount" })
public class PaymentDiscountTerm {

   @XmlElement(name = "BasisDateTime")
   private DateTime reference;

   @Valid
   @XmlElement(name = "BasisPeriodMeasure")
   private Measure maturityPeriod;

   @Valid
   @XmlElement(name = "BasisAmount")
   private Amount basisDiscount;

   @XmlElement(name = "CalculationPercent")
   private BigDecimal calculationPercent;

   @Valid
   @XmlElement(name = "ActualDiscountAmount")
   private Amount actualDiscount;

   /**
    * Gets the reference.
    *
    * @return the reference
    */
   public DateTime getReference() {
      return reference;
   }

   /**
    * Sets the reference.
    *
    * @param reference the reference
    * @return the payment discount term
    */
   public PaymentDiscountTerm setReference(DateTime reference) {
      this.reference = reference;
      return this;
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
    * @param maturityPeriod the maturity period
    * @return the payment discount term
    */
   public PaymentDiscountTerm setMaturityPeriod(Measure maturityPeriod) {
      this.maturityPeriod = maturityPeriod;
      return this;
   }

   /**
    * Gets the basis discount.
    *
    * @return the basis discount
    */
   public Amount getBasisDiscount() {
      return basisDiscount;
   }

   /**
    * Sets the basis discount.
    *
    * @param basisDiscount the basis discount
    * @return the payment discount term
    */
   public PaymentDiscountTerm setBasisDiscount(Amount basisDiscount) {
      this.basisDiscount = basisDiscount;
      return this;
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
    * @param calculationPercent the calculation percent
    * @return the payment discount term
    */
   public PaymentDiscountTerm setCalculationPercent(BigDecimal calculationPercent) {
      this.calculationPercent = calculationPercent;
      return this;
   }

   /**
    * Gets the actual discount.
    *
    * @return the actual discount
    */
   public Amount getActualDiscount() {
      return actualDiscount;
   }

   /**
    * Sets the actual discount.
    *
    * @param actualDiscount the actual discount
    * @return the payment discount term
    */
   public PaymentDiscountTerm setActualDiscount(Amount actualDiscount) {
      this.actualDiscount = actualDiscount;
      return this;
   }

}

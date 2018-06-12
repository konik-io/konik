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

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.konik.jaxb.bindable.unqualified.PercentRoundingAdapter;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Measure;
import io.konik.zugferd.unqualified.ZfDate;

/**
 * 
 * = The payment discount terms and conditions of a trade.
 */
public class PaymentDiscountTerms implements DiscountOrPenaltyTerm {

   private static final long serialVersionUID = 8402012452394529191L;

   @XmlElement(name = "BasisDateTime")
   private ZfDate reference;

   @XmlElement(name = "BasisPeriodMeasure")
   private Measure maturityPeriod;

   @XmlElement(name = "BasisAmount")
   private Amount basis;

   @XmlElement(name = "CalculationPercent")
   @XmlJavaTypeAdapter(PercentRoundingAdapter.class)
   private BigDecimal calculationPercent;

   @XmlElement(name = "ActualDiscountAmount")
   private Amount actualDiscount;

   @Override
   public Amount getAmount() {
      return actualDiscount;
   }

   @Override
   public PaymentDiscountTerms setAmount(Amount actualDiscountAmount) {
      this.actualDiscount = actualDiscountAmount;
      return this;
   }

   @Override
   public ZfDate getReference() {
      return reference;
   }

   @Override
   public PaymentDiscountTerms setReference(ZfDate reference) {
      this.reference = reference;
      return this;
   }

   @Override
   public Measure getMaturityPeriod() {
      return maturityPeriod;
   }

   @Override
   public PaymentDiscountTerms setMaturityPeriod(Measure maturityPeriod) {
      this.maturityPeriod = maturityPeriod;
      return this;
   }

   @Override
   public Amount getBasis() {
      return basis;
   }

   @Override
   public PaymentDiscountTerms setBasis(Amount basis) {
      this.basis = basis;
      return this;
   }

   @Override
   public BigDecimal getCalculationPercent() {
      return calculationPercent;
   }

   @Override
   public PaymentDiscountTerms setCalculationPercent(BigDecimal calculationPercent) {
      this.calculationPercent = calculationPercent;
      return this;
   }

}

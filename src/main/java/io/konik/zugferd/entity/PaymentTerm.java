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

import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.validator.annotation.NotEmpty;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.ZfDate;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * = The trade settlement terms of payment.
 */
@XmlType(name = "TradePaymentTermsType", propOrder = { "descriptions", "due", "partialPayments", "penalty", "discount" })
public class PaymentTerm implements Serializable {

   @XmlElement(name = "Description")
   protected List<String> descriptions;

   @XmlElement(name = "DueDateDateTime")
   private ZfDate due;

   @XmlElement(name = "PartialPaymentAmount")
   private List<Amount> partialPayments;

   @XmlElement(name = "ApplicableTradePaymentPenaltyTerms")
   private PaymentPenaltyTerms penalty;

   @XmlElement(name = "ApplicableTradePaymentDiscountTerms")
   private PaymentDiscountTerms discount;

   /**
    * Gets the human readable description of the terms of payment.
    * 
    * @return the terms of payment description
    */
   @Comfort
   @NotEmpty
   public List<String> getDescriptions() {
      if (descriptions == null) {
         descriptions = new ArrayList<String>();
      }
      return this.descriptions;
   }

   /**
    * Adds a human readable description of the terms of payment.
    *
    * @param description the new terms of payment description
    * @return the payment term
    */
   public PaymentTerm addDescription(String description) {
      getDescriptions().add(description);
      return this;
   }

   /**
    * Gets the due date of the payment.
    * 
    * @return the due date
    */
   @Comfort
   public ZfDate getDue() {
      return due;
   }

   /**
    * Sets the new due date of the payment.
    *
    * @param due the new due date of the payment
    * @return the payment term
    */
   public PaymentTerm setDue(ZfDate due) {
      this.due = due;
      return this;
   }

   /**
    * Gets the amount of the partial payment.
    *
    * @return the partial payment amounts
    */
   @Extended
   @Valid
   public List<Amount> getPartialPayments() {
      if (partialPayments == null) {
         this.partialPayments = new ArrayList<Amount>();
      }
      return partialPayments;
   }

   /**
    * Adds an amount of the partial payment.
    *
    * @param partialPayment the partial payment amount
    * @return the payment term
    */
   public PaymentTerm addPartialPayments(Amount partialPayment) {
      getPartialPayments().add(partialPayment);
      return this;
   }

   /**
    * Gets the payment penalty terms.
    *
    * @return the penalty
    */
   public PaymentPenaltyTerms getPenalty() {
      return penalty;
   }

   /**
    * Sets the payment penalty terms..
    *
    * @param penalty the new penalty
    * @return the payment term
    */
   public PaymentTerm setPenalty(PaymentPenaltyTerms penalty) {
      this.penalty = penalty;
      return this;
   }

   /**
    * Gets the payment discount terms.
    *
    * @return the discount
    */
   public PaymentDiscountTerms getDiscount() {
      return discount;
   }

   /**
    * Sets the the payment discount terms.
    *
    * @param discount the new payment discount terms.
    * @return the payment term
    */
   public PaymentTerm setDiscount(PaymentDiscountTerms discount) {
      this.discount = discount;
      return this;
   }
}

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
import io.konik.zugferd.unqualified.ZfDate;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * = The payment terms of a trade.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePaymentTermsType", propOrder = { "descriptions", "due", "partialPayments", "penalty", "discount" })
public class PaymentTerm {

   @XmlElement(name = "Description")
   protected List<String> descriptions;

   @Valid
   @XmlElement(name = "DueDateDateTime")
   private ZfDate due;

   @XmlElement(name = "PartialPaymentAmount")
   @Valid
   private List<Amount> partialPayments;

   @Valid
   @XmlElement(name = "ApplicableTradePaymentPenaltyTerms")
   private PaymentPenaltyTerms penalty;

   @Valid
   @XmlElement(name = "ApplicableTradePaymentDiscountTerms")
   private PaymentDiscountTerms discount;

   /**
    * Gets the description.
    * 
    * @return the description
    */
   public List<String> getDescriptions() {
      if (descriptions == null) {
         descriptions = new ArrayList<String>();
      }
      return this.descriptions;
   }

   /**
    * Sets the description.
    *
    * @param description the new description
    * @return the payment term
    */
   public PaymentTerm addDescription(String description) {
      getDescriptions().add(description);
      return this;
   }

   /**
    * Gets the due date time.
    * 
    * @return the due date time
    */
   public ZfDate getDue() {
      return due;
   }

   /**
    * Sets the due date time.
    *
    * @param due the new due date time
    * @return the payment term
    */
   public PaymentTerm setDue(ZfDate due) {
      this.due = due;
      return this;
   }

   /**
    * Gets the partial payments.
    *
    * @return the partial payments
    */
   public List<Amount> getPartialPayments() {
      if (partialPayments == null) {
         this.partialPayments = new ArrayList<Amount>();
      }
      return partialPayments;
   }

   /**
    * Sets the partial payments.
    *
    * @param partialPayment the partial payment
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
    * @return
    */
   public PaymentTerm setPenalty(PaymentPenaltyTerms penalty) {
      this.penalty = penalty;
      return this;
   }

   /**
    * Gets the discount.
    *
    * @return the discount
    */
   public PaymentDiscountTerms getDiscount() {
      return discount;
   }

   /**
    * Sets the discount.
    *
    * @param discount the new discount
    * @return
    */
   public PaymentTerm setDiscount(PaymentDiscountTerms discount) {
      this.discount = discount;
      return this;
   }
}

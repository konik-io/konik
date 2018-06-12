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
package io.konik.calculation;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.validation.constraints.NotNull;

import io.konik.util.Invoices;
import io.konik.zugferd.Invoice;

/**
 * Completes the {@link Invoice} and calculates with specified {@link Correction}s or additions.
 */
public final class InvoiceCalculator {

   private final Invoice invoice;
   private final List<Correction<Invoice>> corrections = new CopyOnWriteArrayList<Correction<Invoice>>();

   /**
    * Instantiates a new invoice calculator.
    *
    * @param invoice the invoice
    */
   public InvoiceCalculator(@NotNull final Invoice invoice) {
      this.invoice = invoice;
      corrections.add(new InvoiceMonetarySummationAndTradeTaxCompleter());
      corrections.add(new ItemSpecifiedMonetarySummationCompleter());
   }

   /**
    * Registers {@link Correction} to apply on the {@link Invoice}.
    *
    * @param correction the correction
    */
   public void applyCorrection(final Correction<Invoice> correction) {
      this.corrections.add(correction);
   }

   /**
    * Resets calculator and removes all applied {@link Correction}s.
    */
   public void reset() {
      this.corrections.clear();
   }

   /**
    * Runs all registered {@link Correction}s on the {@link Invoice}
    * @return
    */
   public Invoice complete() {
      Invoice correctedInvoice = Invoices.clone(invoice);
      for (Correction<Invoice> correction : corrections) {
         correctedInvoice = correction.correct(correctedInvoice);
      }
      return correctedInvoice;
   }
}

/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.harness;

/**
 * The Invoice Append Runtime Exception is thrown whenever something goes wrong during the invoice to PDF appending
 * process.
 * 
 */
public class InvoiceAppendError extends RuntimeException {

   /** The Constant serialVersionUID. */
   private static final long serialVersionUID = -934899512930010703L;

   /**
    * Instantiates a new invoice append error.
    *
    * @param msg the message
    */
   public InvoiceAppendError(String msg) {
      super(msg);
   }

   /**
    * Instantiates a new invoice append error.
    *
    * @param msg the message
    * @param e the e
    */
   public InvoiceAppendError(String msg, Throwable e) {
      super(msg, e);
   }
}

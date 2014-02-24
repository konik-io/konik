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
package io.konik.harness;


/**
 * The Invoice Append Runtime Exception is thrown whenever something goes wrong during the invoice to PDF appending process. 
 * 
 */
public class InvoiceAppendError extends RuntimeException {

   private static final long serialVersionUID = -934899512930010703L;

   public InvoiceAppendError(String msg) {
      super(msg);
   }

   public InvoiceAppendError(String msg, Throwable e) {
    super(msg, e);
   }
}

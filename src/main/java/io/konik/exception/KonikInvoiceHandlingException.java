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
package io.konik.exception;


/**
 * The Konik Invoice Handling Exception is thrown whenever something goes wrong when handling the model.
 * 
 */
public class KonikInvoiceHandlingException extends RuntimeException {

   private static final long serialVersionUID = -249661599608287823L;
   
   
   public KonikInvoiceHandlingException(String message, Throwable throwable) {
     super(message,throwable);
   }



}

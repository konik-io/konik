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

import io.konik.zugferd.Invoice;

import java.io.InputStream;

/**
 * The Invoice Extractor interface. A PDF Carriage implement this interface to extract a Invoice model from a PDF.
 */
public interface InvoiceExtractor {

   /**
    * Extract invoice from a PDF.
    *
    * @param pdf the pdf
    * @return the extracted invoice model.
    */
   public Invoice extract(final byte[] pdf);

   /**
    * Extract invoice from PDF stream.
    *
    * @param pdf the pdf
    * @return the extracted invoice model.
    */
   public Invoice extract(final InputStream pdf);

}

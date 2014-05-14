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

import io.konik.zugferd.Invoice;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Invoice Appender interface. A PDF Carriage implement this interface to append the invoice model to a PDF.
 * 
 * @author Vadim Bauer
 */
public interface InvoiceAppender {

	/**
    * Append invoice to a PDF.
    * 
    * @param invoice the invoice
    * @param inputPdf the input pdf.
    * @return the resulting PDF.
    */
	public byte[] append(Invoice invoice, byte[] inputPdf);

	/**
    * Append invoice to a PDF.
    * 
    * @param invoice the invoice
    * @param inputPdf the input pdf
    * @param resultingPdf the resulting pdf
    */
	public void append(Invoice invoice, InputStream inputPdf, OutputStream resultingPdf);

}

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

// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.

package io.konik.zugferd.datatype.qualified;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * A factory for creating Object objects.
 */
@XmlRegistry
public class ObjectFactory {


	public ObjectFactory() {
	}


	public TaxTypeCode createTaxTypeCode() {
		return new TaxTypeCode();
	}

	public TaxCategoryCode createTaxCategoryCode() {
		return new TaxCategoryCode();
	}


	public PaymentMeansCode createPaymentMeansCode() {
		return new PaymentMeansCode();
	}


	public DateTime createFormattedDateTime() {
		return new DateTime();
	}

}

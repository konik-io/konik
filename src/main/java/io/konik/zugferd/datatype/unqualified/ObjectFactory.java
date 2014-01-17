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

package io.konik.zugferd.datatype.unqualified;

import javax.xml.bind.annotation.XmlRegistry;

/** A factory for creating Object objects. */
@XmlRegistry
public class ObjectFactory {

	/** Instantiates a new object factory. */
	public ObjectFactory() {
	}


	/**
	 * Creates a new Object object.
	 * 
	 * @return the name
	 */
	public ID createID() {
		return new ID();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the quantity
	 */
	public Quantity createQuantity() {
		return new Quantity();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the amount
	 */
	public Amount createAmount() {
		return new Amount();
	}

}

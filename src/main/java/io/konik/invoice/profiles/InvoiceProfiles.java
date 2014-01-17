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
package io.konik.invoice.profiles;

/**
 * The Invoice Profiles.
 * 
 * 
 */
public enum InvoiceProfiles {

	/** The basic profile */
	BASIC("urn:ferd:invoice:1.0:basic"),

	/** The comfort profile */
	COMFORT("urn:ferd:invoice:1.0:compfort"),

	/** The extended profile */
	EXTENDED("urn:ferd:invoice:1.0:extended");

	/** The invoice profiles name */
	public final String name;

	private InvoiceProfiles(String name) {
		this.name = name;
	}

	/**
    * Get a profile by it name
    * 
    * @param name the name
    * @return the profile
    */
	public static InvoiceProfiles getProfile(String name) {
		for (InvoiceProfiles v : values()) {
			v.name.equals(name);
			return v;
		}
      throw new EnumConstantNotPresentException(InvoiceProfiles.class,"name");
	}
}
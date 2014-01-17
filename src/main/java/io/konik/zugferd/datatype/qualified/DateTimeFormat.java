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
package io.konik.zugferd.datatype.qualified;

/**
 * The Enum holds information on how to format a Date Time.
 * 
 */
public enum DateTimeFormat {

	/** The Formatted Date constant 102 and yyyyMMdd. */
	F102("102", "yyyyMMdd");

	/** The format. e.g. 102,103,104 */
	public final String format;

	/** The format pattern. e.g. yyyy.mm.dd */
	public final String pattern;

	/**
    * Instantiates a new date time format.
    * 
    * @param format the format
    * @param pattern the pattern
    */
	private DateTimeFormat(String format, String pattern) {
		this.format = format;
		this.pattern = pattern;
	}
}
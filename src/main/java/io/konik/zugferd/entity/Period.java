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
package io.konik.zugferd.entity;

import io.konik.zugferd.qualified.DateTime;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * = The Period of time
 * 
 * with a start and end date.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecifiedPeriodType", propOrder = { "start", "end" })
public class Period {

   @Valid
	@XmlElement(name = "StartDateTime")
	private DateTime start;

   @Valid
	@XmlElement(name = "EndDateTime")
	private DateTime end;

	/**
	 * Gets the start date time.
	 * 
	 * @return the start date time
	 */
	public DateTime getStart() {
		return start;
	}

	/**
    * Sets the start date time.
    *
    * @param start the new start date time
    * @return the period
    */
	public Period setStart(DateTime start) {
		this.start = start;
		return this;
	}

	/**
	 * Gets the end date time.
	 * 
	 * @return the end date time
	 */
	public DateTime getEnd() {
		return end;
	}

	/**
    * Sets the end date time.
    *
    * @param end the new end date time
    * @return the period
    */
	public Period setEnd(DateTime end) {
		this.end = end;
		return this;
	}

}

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

package io.konik.zugferd.entity;

import io.konik.zugferd.datatype.qualified.DateTime;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class SpecifiedPeriod.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecifiedPeriodType", propOrder = { "startDateTime", "endDateTime" })
public class BillingPeriod {

	/** The start date time. */
   @Valid
	@XmlElement(name = "StartDateTime")
	private DateTime startDateTime;

	/** The end date time. */
   @Valid
	@XmlElement(name = "EndDateTime")
	private DateTime endDateTime;

	/**
	 * Gets the start date time.
	 * 
	 * @return the start date time
	 */
	public DateTime getStartDateTime() {
		return startDateTime;
	}

	/**
	 * Sets the start date time.
	 * 
	 * @param start the new start date time
	 */
	public void setStartDateTime(DateTime start) {
		this.startDateTime = start;
	}

	/**
	 * Gets the end date time.
	 * 
	 * @return the end date time
	 */
	public DateTime getEndDateTime() {
		return endDateTime;
	}

	/**
	 * Sets the end date time.
	 * 
	 * @param end the new end date time
	 */
	public void setEndDateTime(DateTime end) {
		this.endDateTime = end;
	}

}

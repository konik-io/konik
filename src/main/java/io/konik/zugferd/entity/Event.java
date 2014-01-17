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
import io.konik.zugferd.datatype.qualified.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class SupplyChainEvent.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainEventType", propOrder = { "occurrences" })
public class Event {

	/** The occurrences date time. */
   @Valid
	@XmlElement(name = "OccurrenceDateTime")
	private List<DateTime> occurrences;

	/** Instantiates a new supply chain event. */
	public Event() {
	}

	/**
	 * Instantiates a new supply chain event and sets the first event.
	 * 
	 * @param date the date
	 * @param fdc the date representation
	 */
	public Event(Date date, DateTimeFormat fdc) {
		addOccurrence(new DateTime(date, fdc));
	}

	/**
	 * Gets the occurrences date time.
	 * 
	 * @return the occurrences date time
	 */
	public List<DateTime> getOccurrence() {
		if (occurrences == null) {
			occurrences = new ArrayList<DateTime>();
		}
		return this.occurrences;
	}

	/**
    * Adds the occurrences.
    * 
    * @param dateTime the date time
    * @return the supply chain event
    */
	public Event addOccurrence(DateTime dateTime) {
		getOccurrence().add(dateTime);
		return this;
	}

}

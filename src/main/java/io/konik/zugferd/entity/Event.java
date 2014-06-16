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
import io.konik.zugferd.unece.codes.DateTimeType;

import java.util.Date;

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
@XmlType(name = "SupplyChainEventType", propOrder = { "occurrence" })
public class Event {

	/** The occurrences date time. */
   @Valid
	@XmlElement(name = "OccurrenceDateTime")
	private DateTime occurrence;

	/** Instantiates a new supply chain event. */
	public Event() {
	}
   
	/**
    * Instantiates a new event.
    *
    * @param type the type
    * @param date the date
    */
	public Event(DateTimeType type, Date date) {
	   this.occurrence = new DateTime(type, date);
   }
	/**
	 * Instantiates a new supply chain event and sets the first event.
	 * 
	 * @param dateTime the date time
	 */
	public Event(DateTime dateTime) {
		setOccurrence(dateTime);
	}

   /**
    * Gets the occurrence.
    *
    * @return the occurrence
    */
   public DateTime getOccurrence() {
      return occurrence;
   }

   /**
    * Sets the occurrence.
    *
    * @param occurrence the new occurrence
    * @return the event
    */
   public Event setOccurrence(DateTime occurrence) {
      this.occurrence = occurrence;
      return this;
   }

   /**
    * Gets the occurrence.
    *
    * @return the occurrence
    */
   public Date getOccurrenceAsDate() {
      return occurrence.asDate();
   }


}

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

import io.konik.zugferd.datatype.unqualified.Quantity;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class handles the trade delivery.
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeDeliveryType", propOrder = { "billedQuantity", "event", "note" })
public class Delivery {

	/** The billed quantity. */
   @Valid
	@XmlElement(name = "BilledQuantity")
	private Quantity billedQuantity;

	/** The actual delivery supply chain event. */
   @Valid
	@XmlElement(name = "ActualDeliverySupplyChainEvent")
	private Event event;

	/** The delivery note referenced document. */
   @Valid
	@XmlElement(name = "DeliveryNoteReferencedDocument")
	private ReferencedDocument note;

	/** Instantiates a new trade delivery. */
	public Delivery() {
	}

	/**
	 * Instantiates a new supply chain trade delivery.
	 *
	 * @param billedQuantity the billed quantity
	 * @param deliveryEvent the event
	 */
	public Delivery(Quantity billedQuantity, Event deliveryEvent) {
		this.billedQuantity = billedQuantity;
		this.event = deliveryEvent;
	}

	/**
	 * Gets the billed quantity.<br/>
	 * Profile: BASIC <br/>
	 *
	 * @return the billed quantity
	 */
	public Quantity getBilledQuantity() {
		return billedQuantity;
	}

	/**
	 * Sets the billed quantity.<br/>
	 * Profile: BASIC <br/>
	 *
	 * @param billedQuantity the new billed quantity
	 */
	public void setBilledQuantity(Quantity billedQuantity) {
		this.billedQuantity = billedQuantity;
	}

	/**
	 * Gets the actual delivery event.
	 *
	 * @return the actual delivery event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Sets the actual delivery supply chain event.
	 *
	 * @param deliveryEvent the new actual delivery supply chain event
	 * @return the trade delivery
	 */
	public Delivery setEvent(Event deliveryEvent) {
		this.event = deliveryEvent;
		return this;
	}

	/**
	 * Gets the delivery note referenced document.
	 *
	 * @return the delivery note referenced document
	 */
	public ReferencedDocument getNote() {
		return note;
	}

	/**
	 * Sets the note.
	 *
	 * @param note the new delivery note referenced document
	 * @return the delivery
	 */
	public Delivery setNote(ReferencedDocument note) {
		this.note = note;
		return this;
	}

}

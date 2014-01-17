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
import io.konik.zugferd.datatype.unqualified.ID;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This Class References a external Document.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferencedDocumentType", propOrder = { "issued", "id" })
public class ReferencedDocument {

	/** The issue date time. */
   @Valid
	@XmlElement(name = "IssueDateTime")
	private DateTime issued;

	/** The id. */
	@XmlElement(name = "ID")
	private List<ID> id;

	/**
	 * Gets the issue date time.<br/>
	 * Profile: COMFORT <br/>
	 * 
	 * @return the issue date time
	 */
	public DateTime getIssued() {
		return issued;
	}

	/**
	 * Sets the issue date time.<br/>
	 * Profile: COMFORT <br/>
	 * 
	 * @param issued the new issue date time
	 */
	public void setIssued(DateTime issued) {
		this.issued = issued;
	}

	/**
	 * Gets the id.<br/>
	 * Profile: COMFORT <br/>
	 * 
	 * @return the id
	 */
	public List<ID> getId() {
		if (id == null) {
			id = new ArrayList<ID>();
		}
		return this.id;
	}

}

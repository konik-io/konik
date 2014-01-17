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

import static io.konik.zugferd.datatype.qualified.DateTimeFormat.F102;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * The Class DateTime consist of the date represented as string and the format on how the date should be
 * parsed.<br/>
 * Example: <code> &lt;IssueDateTime format="102">20130605&lt;/IssueDateTime> </code>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormattedDateTimeType", propOrder = { "value" })
public class DateTime {

	/** The date string. */
	@XmlValue
	private String value;

	/** The format of the date string. */
	@XmlAttribute(name = "format")
	private String format;

	/** Instantiates a new date time with current date and format code 102.*/
	public DateTime() {
	   this(new Date(),F102);
	}

	/**
	 * Instantiates a new date time with the default date format code 102 (YYYYMMDD) <br/>
	 * 
	 * Example: {@code 20130305 (YYYYMMDD)}
	 * 
	 * @param date the date
	 */
	public DateTime(Date date) {
	   this(date,F102);
	}

	/**
	 * Instantiates a new date time with the given format code.<br/>
	 * 
	 * @param date the date
	 * @param formatCode the {@link DateTimeFormat}
	 */
	public DateTime(Date date, DateTimeFormat formatCode) {
		this.value = new SimpleDateFormat(formatCode.pattern).format(date);
		this.format = formatCode.format;
	}

	/**
	 * Gets the date value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the date value.<br/>
	 * Example: <code>20130305</code>
	 * 
	 * @param value the new value
	 * @return the formatted date time
	 */
	public DateTime setValue(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Gets the date format code.<br/>
	 * Example: <code>102</code>
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Sets the format code.
	 * 
	 * @param formatCode the new format
	 * @return the formatted date time
	 */
	public DateTime setFormat(String formatCode) {
		this.format = formatCode;
		return this;
	}

	/**
	 * Sets the format code.
	 * 
	 * @param formatCode the new format
	 * @return the formatted date time
	 */
	public DateTime setFormat(DateTimeFormat formatCode) {
		this.format = formatCode.format;
		return this;
	}
}

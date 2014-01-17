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

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The Class Amount.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType", propOrder = { "value" })
public class Amount {

	/** The value. */
	@XmlValue
	private BigDecimal value;

	/** The currency id. */
	@XmlAttribute(name = "currencyID")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	private String currencyId;

	/** Instantiates a new amount. */
	public Amount() {
	}

	/**
	 * Instantiates a new amount.
	 * 
	 * @param value the value
	 * @param currencyId the ISO 4217 3A currency id
	 */
	public Amount(Double value, String currencyId) {
		super();
		this.value = BigDecimal.valueOf(value);
		this.currencyId = currencyId;
	}

	/**
	 * Instantiates a new amount.
	 * 
	 * @param value the value
	 * @param currencyId the ISO 4217 3A currency id
	 */
	public Amount(BigDecimal value, String currencyId) {
		super();
		this.value = value;
		this.currencyId = currencyId;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value the new value
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	/**
	 * Gets the ISO 4217 3A currency id.
	 * 
	 * @return the currency id
	 * @see <a href="http://en.wikipedia.org/wiki/ISO_4217">ISO 4217 3A currency code</a>
	 */
	public String getCurrencyId() {
		return currencyId;
	}

	/**
	 * Sets the ISO 4217 3A currency id.
	 * 
	 * @param currencyId the new currency id
	 * @see <a href="http://en.wikipedia.org/wiki/ISO_4217">ISO 4217 3A currency code</a>
	 */
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

}

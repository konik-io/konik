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
/**
 * Package for bindable entity types
 */
@XmlSchema(elementFormDefault = QUALIFIED, 
   namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", 
   xmlns = { 
      @XmlNs(prefix = "ram", namespaceURI = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12") })

@XmlJavaTypeAdapters(
      { @XmlJavaTypeAdapter(value = CountryAdapter.class, type = TradeCountry.class),
        @XmlJavaTypeAdapter(value = DateTimeAdapter.class, type = DateTime.class)
      })
@XmlAccessorType(NONE)
package io.konik.jaxb.bindable.entity;

import static javax.xml.bind.annotation.XmlAccessType.NONE;
import static javax.xml.bind.annotation.XmlNsForm.QUALIFIED;
import io.konik.jaxb.adapter.CountryAdapter;
import io.konik.jaxb.bindable.unqualified.DateTime;
import io.konik.jaxb.bindable.unqualified.DateTimeAdapter;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;


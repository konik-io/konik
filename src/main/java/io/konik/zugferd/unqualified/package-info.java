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
 * ZUGFeRD unqualified data types. 
 */
@XmlSchema(elementFormDefault = QUALIFIED, 
namespace = "urn:un:unece:uncefact:data:standard:UnqualifiedDataType:15", 
xmlns = { 
      @XmlNs(prefix = "udt", namespaceURI = "urn:un:unece:uncefact:data:standard:UnqualifiedDataType:15") 
      }
)

@XmlJavaTypeAdapters({ 
   @XmlJavaTypeAdapter(value = AmountLowRoundingAdapter.class, type = Amount.class) 
})
@XmlAccessorType(NONE)
package io.konik.zugferd.unqualified;

import static javax.xml.bind.annotation.XmlAccessType.NONE;
import static javax.xml.bind.annotation.XmlNsForm.QUALIFIED;
import io.konik.jaxb.adapter.AmountLowRoundingAdapter;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;


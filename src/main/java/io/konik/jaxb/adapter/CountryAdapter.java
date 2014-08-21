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
package io.konik.jaxb.adapter;

import io.konik.jaxb.bindable.entity.TradeCountry;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.neovisionaries.i18n.CountryCode;

/**
 * = The CountryAdapter maps the JaxB trade countries to the Enum CountryCode.
 */
public class CountryAdapter extends XmlAdapter<TradeCountry, CountryCode> {

   @Override
   public TradeCountry marshal(CountryCode country) throws Exception {
      return new TradeCountry(country.getAlpha2());
   }

   @Override
   public CountryCode unmarshal(TradeCountry tradeCountry) throws Exception {
      return CountryCode.getByCode(tradeCountry.getCode());
   }
}

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
package io.konik.jaxb.adapter;

import io.konik.jaxb.bindable.entity.TradeCountry;
import io.konik.util.Strings;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.neovisionaries.i18n.CountryCode;

/**
 * = The CountryAdapter maps the JaxB trade countries to the Enum CountryCode.
 */
public class CountryAdapter extends XmlAdapter<TradeCountry, CountryCode> {

   private static final Logger LOG = Logger.getLogger(CountryAdapter.class.getName());

   @Override
   public TradeCountry marshal(CountryCode country) throws Exception {
      if (country == null) { return null; }
      return new TradeCountry(country.getAlpha2());
   }

   @Override
   public CountryCode unmarshal(TradeCountry tradeCountry) throws Exception {
      if (tradeCountry == null) { return null; }
      if (Strings.isNullOrEmpty(tradeCountry.getCode())) {
         LOG.log(Level.WARNING, "Trade Country is defined in XML but the code is empty or null");
         return null;
      }
      return CountryCode.getByCode(tradeCountry.getCode());
   }
}

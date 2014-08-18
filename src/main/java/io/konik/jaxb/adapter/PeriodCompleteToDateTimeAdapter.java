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

import io.konik.jaxb.bindable.entity.AdapterPeriod;
import io.konik.zugferd.unqualified.ZfDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * = Adapter to map the Period's complete property to a DateTime property .
 */
public class PeriodCompleteToDateTimeAdapter extends XmlAdapter<AdapterPeriod, ZfDate> {

   @Override
   public ZfDate unmarshal(AdapterPeriod period) throws Exception {
      if (period.getContractualDueDate() == null) { return null; }
      return period.getContractualDueDate();
   }

   @Override
   public AdapterPeriod marshal(ZfDate complete) throws Exception {
      if (complete == null) { return null; }
      return new AdapterPeriod().setContractualDueDate(complete);
   }

}

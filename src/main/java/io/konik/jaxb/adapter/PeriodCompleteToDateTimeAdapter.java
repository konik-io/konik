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

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import io.konik.jaxb.bindable.entity.DueDatePeriod;
import io.konik.zugferd.unqualified.ZfDate;

/**
 * = Adapter to map the Period's complete property to a DateTime property .
 */
public class PeriodCompleteToDateTimeAdapter extends XmlAdapter<DueDatePeriod, ZfDate> {

   private static final Logger LOG = Logger.getLogger(PeriodCompleteToDateTimeAdapter.class.getName());

   @Override
   public ZfDate unmarshal(DueDatePeriod period) throws Exception {
      if (period == null) {
         return null;
      }
      if (period.getContractualDueDate() == null) {
         LOG.log(Level.WARNING, "Specified Period exist but no complete Date Time");
         return null;
      }
      return period.getContractualDueDate();
   }

   @Override
   public DueDatePeriod marshal(ZfDate complete) throws Exception {
      if (complete == null) {
         return null;
      }
      return new DueDatePeriod(complete);
   }

}

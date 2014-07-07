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

import io.konik.util.Strings;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * = The Issue Date Time Adapter.
 * 
 * Two types are allowed:
 * 
 */
public class IssueDateTimeAdapter extends XmlAdapter<String, Date>{

   private final ThreadLocal<SimpleDateFormat> dateTimeFormatter = new ThreadLocal<SimpleDateFormat>() {
      @Override
      protected SimpleDateFormat initialValue() {
         return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//2013-08-05T00:00:00
      }
   };
   private final ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {
      @Override
      protected SimpleDateFormat initialValue() {
         return new SimpleDateFormat("");
      }
   };
   
   @Override
   public Date unmarshal(String date) throws Exception {
      if (Strings.isNullOrEmpty(date)) {
         return null;
      }
      return dateTimeFormatter.get().parse(date);
   }

   @Override
   public String marshal(Date date) throws Exception {
      if(date == null) {
         return null;
      }
      return dateTimeFormatter.get().format(date);
   }

}

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

import static io.konik.util.Strings.isNullOrEmpty;
import io.konik.jaxb.bindable.UniversalCommunication;

import java.util.regex.Pattern;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * = The Currency Adapter
 */
public class UniversalCommunicationAdapter extends XmlAdapter<UniversalCommunication, String> {
  
   Pattern emailRegEx = Pattern.compile(".+@.+\\..+");
   
   @Override
   public UniversalCommunication marshal(String mailOrTel) throws Exception {
      UniversalCommunication communication = new UniversalCommunication();
      if (isNullOrEmpty(mailOrTel) || emailRegEx.matcher(mailOrTel).matches()){
         communication.setMail(mailOrTel);
      }else {
         communication.setCompleteNumber(mailOrTel);
      }
      return communication;
   }

   @Override
   public String unmarshal(UniversalCommunication communication) throws Exception {
      if (isNullOrEmpty(communication.getCompleteNumber())) {
         return communication.getMail();
      }
      return communication.getCompleteNumber();
   }

}

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
package io.konik.util;

import static java.lang.Enum.valueOf;

/**
 * 
 * = The Konik Enumeration Helper Class.
 *
 */
public class KonikEnum {

   private KonikEnum(){
   }
   /**
    * Checks if the given code is contained in the Enumeration.
    * @param <E>
    *
    * @param type the type
    * @param code the code
    * @return true, if is known code
    */
   public static <E extends Enum<E>> boolean isKnownCode(Class<E> type, final String code) {
      try {
         valueOf(type,code);
         return true;
      } catch (IllegalArgumentException e) {
         return false;
      }
   }

   
}

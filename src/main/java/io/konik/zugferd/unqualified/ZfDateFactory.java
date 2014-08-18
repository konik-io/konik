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
package io.konik.zugferd.unqualified;


/**
 * A factory for creating ZfDate instanced based on format code.
 */
public class ZfDateFactory {

   /**
    * Creates a new ZfDate object from the given date time format code.
    *
    * @param formatCode the format code
    * @return the zf date
    */
   public static ZfDate create(String formatCode){
      if(ZfDateDay.CODE.equals(formatCode)) {
         return new ZfDateDay();
      }
      if (ZfDateMonth.CODE.equals(formatCode)) {
         return new ZfDateMonth();
      }
      if (ZfDateWeek.CODE.equals(formatCode)) {
         return new ZfDateWeek();
      }
      throw new IllegalArgumentException("Can not create a ZfDate for the given code" + formatCode);
   }
}

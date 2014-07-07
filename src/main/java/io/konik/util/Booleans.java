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
package io.konik.util;

/**
 * 
 * = The Boolean Utils.
 */
public class Booleans {
   /**
    * Converts a Boolean to a boolean handling {@code null} by returning {@code false}
    *
    * +++
    *   BooleanUtils.toBoolean(Boolean.TRUE)  = true
    *   BooleanUtils.toBoolean(Boolean.FALSE) = false
    *   BooleanUtils.toBoolean(null)          = false
    * +++
    *
    * @param value the boolean to convert
    * @return {@code true} or {@code false}, {@code null} returns {@code false}
    */
   public static boolean toBoolean(final Boolean value) {
       return value != null && value.booleanValue();
   }
}

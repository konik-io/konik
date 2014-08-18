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
package io.konik.zugferd.unqualified;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


@SuppressWarnings("javadoc")
public class ZfDateDayTest {

   ZfDateDay date = new ZfDateDay();
   
   @Test
   public void getFormatter() throws Exception {
      assertThat(date.getFormatter()).isNotNull();
   }

   @Test
   public void getFormatCode() throws Exception {
      assertThat(date.getFormatCode()).isEqualTo("102");
   }
   
   @Test
   public void setDate() {
      date.setDate("20131212");
      assertThat(date).isEqualTo("2013-12-12");
   }

   @Test(expected=IllegalArgumentException.class)
   public void setDate_fail() {
      date.setDate("asdf");
   }
   
   @Test
   public void toStringTest() {
      date.setDate("20131212");
      assertThat(date.toString()).isEqualTo("20131212");
   }
   
}

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
package io.konik.zugferd.qualified;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Dates.yearOf;
import io.konik.zugferd.unece.codes.DateTimeType;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
@SuppressWarnings("javadoc")
public class DateTimeTypeTest {

   @Before
   public void setUp() throws Exception {
   }

   @Test
   public final void format() throws Exception {
      Date now = new Date();

      String formated = DateTimeType._102.format(now);

      assertThat(formated).hasSize(8);
      assertThat(formated).startsWith(valueOf(yearOf(now)));
   }

   @Test
   public final void isKnown_101() throws Exception {
      assertThat(DateTimeType.isKnown("101")).isTrue();
   }

   @Test
   public final void isKnown_0042() throws Exception {
      assertThat(DateTimeType.isKnown("0042")).isFalse();
   }

   @Test(expected = IllegalArgumentException.class)
   public final void getTypeByCode_expectException() throws Exception {
      DateTimeType.getByCode("0042");
   }
   
   @Test
   public final void randomTestAll() throws Exception {
      for (DateTimeType type : DateTimeType.values()) {
         try {
            String result = type.format(new Date());
            assertThat(result).isNotEmpty();   
         }catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("trying this type: "+ type.toString(),e);
         }
         
      }
      
   }
   
   
}

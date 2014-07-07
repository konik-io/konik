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

import static io.konik.zugferd.unece.codes.DateTimeType._101;
import static io.konik.zugferd.unece.codes.DateTimeType._203;
import static io.konik.zugferd.unece.codes.DateTimeType._204;
import static org.apache.commons.lang3.time.FastDateFormat.getInstance;
import static org.assertj.core.api.Assertions.assertThat;
import io.konik.zugferd.unece.codes.DateTimeType;

import java.util.Date;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class DateTimeTest {

   @Test
   public final void DateTime() throws Exception {
      //when
      DateTime dateTime = new DateTime();

      //then
      String expected = getInstance("yyyyMMdd").format(new Date());

      assertThat(dateTime.getValue()).isEqualTo(expected);
      assertThat(dateTime.getFormat()).isEqualTo("102");
   }

   @Test
   public final void DateTimeDate_dateTimeType() throws Exception {
      //setup
      Date now = new Date();

      //when
      DateTime result = new DateTime(_101);

      //then
      String expected = getInstance("yyMMdd").format(now);
      assertThat(result.getValue()).isEqualTo(expected);
      assertThat(result.getFormat()).isEqualTo("101");
   }

   @Test
   public final void getValue() throws Exception {
      //setup
      Date now = new Date();
      //when

      DateTime dateTime = new DateTime(_204);

      //then
      assertThat(dateTime.getValue()).isEqualTo(getInstance(_204.getPattern()).format(now));
   }

   @Test
   public final void getFormat() {
      //given
      Date now = new Date();

      //when
      DateTime dateTime = new DateTime(_203);
      assertThat(dateTime.getFormat()).isEqualTo(_203.getCode());
      assertThat(dateTime.getValue()).isEqualTo(getInstance(_203.getPattern()).format(now));
   }

   @Test(expected = IllegalArgumentException.class)
   public final void asDate_fail() throws Exception {
      DateTime dateTime = new DateTime("123", "1234");
      dateTime.asDate();
   }

   @Test
   public void asDate() throws Exception {
      //when 
      Date result = new DateTime(DateTimeType._102).asDate();

      //expect
      assertThat(result).isEqualToIgnoringHours(new Date());
   }

}

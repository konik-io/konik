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
package io.konik.zugferd.profile;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ConformanceLevelTest {

   @Test
   public void hasThreeEntries() throws Exception {
      ConformanceLevel[] enumConstants = ConformanceLevel.class.getEnumConstants();
      assertThat(enumConstants).hasSize(3);
   }

   @Test
   public void extractConformanceLevel() throws Exception {
      ConformanceLevel level = ConformanceLevel
            .extractConformanceLevel("urn:ferd:CrossIndustryDocument:invoice:1p0:basic");
      assertThat(level).isEqualTo(ConformanceLevel.BASIC);
   }

}

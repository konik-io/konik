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

import static io.konik.zugferd.profile.ProfileVersion.extractVersion;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ProfileTest {

   @Test
   public void getProfile_Basic() throws Exception {
      Profile profile = Profile.getProfile("urn:ferd:CrossIndustryDocument:invoice:1p0:basic");
      assertThat(profile.simpleName()).isEqualTo("basic");
      assertThat(extractVersion(profile.fullName()).version()).isEqualTo("1p0");
   }

   @Test
   public void getProfileByName_Basic() throws Exception {
      Profile.getProfileByName("basic");
   }
   
   @Test
   public void hasThreeEntries() throws Exception {
      Profile[] enumConstants = Profile.class.getEnumConstants();
      assertThat(enumConstants).hasSize(3);
   }
   
   

}

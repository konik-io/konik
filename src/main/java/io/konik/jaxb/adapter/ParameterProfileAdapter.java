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

import io.konik.zugferd.entity.Parameter;
import io.konik.zugferd.profile.Profile;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * JaxB Adapter for mapping Parameter to Profile Enum.
 */
public class ParameterProfileAdapter extends XmlAdapter<Parameter, Profile> {

   @Override
   public Profile unmarshal(Parameter p) throws Exception {
      if (p == null) { return null; }
      return Profile.getProfile(p.getId());
   }

   @Override
   public Parameter marshal(Profile profile) throws Exception {
      if (profile == null) { return null; }
      return new Parameter(profile.fullName());
   }
}

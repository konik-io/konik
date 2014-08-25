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

import static java.util.logging.Level.WARNING;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.konik.zugferd.entity.Parameter;
import io.konik.zugferd.profile.ConformanceLevel;
import io.konik.zugferd.profile.Profile;
import io.konik.zugferd.profile.ProfileVersion;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * JaxB Adapter for mapping Parameter to Profile Enum.
 */
public class ParameterProfileAdapter extends XmlAdapter<Parameter, Profile> {
   private final static Logger LOG = Logger.getLogger(ParameterProfileAdapter.class.getName());

   private static final String DELIMITER = ":";

   @Override
   public Profile unmarshal(Parameter p) throws Exception {
      if (p == null) { return null; }
      String fullName = p.getId();
      try {
         ProfileVersion version = ProfileVersion.extractVersion(fullName);
         ConformanceLevel conformanceLevel = ConformanceLevel.extractConformanceLevel(fullName);
         String ns = getNamespace(fullName);
         return new Profile(ns, version, conformanceLevel);
      } catch (RuntimeException e) {
         LOG.log(WARNING, "Could not parse the profile. Fallback to BASIC latest version", e);
         return new Profile(ConformanceLevel.BASIC);
      }
   }

   private static String getNamespace(String fullName) {
      String[] tokens = fullName.split(DELIMITER);
      StringBuilder ns = new StringBuilder();
      for (int i = 0; i < tokens.length - 2; i++) {
         ns.append(tokens[i]).append(DELIMITER);
      }
      return ns.toString();
   }

   @Override
   public Parameter marshal(Profile profile) throws Exception {
      if (profile == null) { return null; }
      return new Parameter(profile.fullName());
   }
}

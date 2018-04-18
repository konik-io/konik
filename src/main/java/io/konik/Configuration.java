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
package io.konik;

import static java.util.logging.Level.CONFIG;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * The Global Konik Configuration.
 * 
 * Try to load Konik Configuration from file `io.konik.configuration.properties`.
 * System properties provided with the +-Dio.konik*+ or ```System.setProperties("io.konik*")`` will override the file
 * content.
 * 
 */
public enum Configuration {

   /** The singleton configuration instance. */
   INSTANCE;

   private static final Logger LOG = Logger.getLogger(Configuration.class.getName());
   private final Properties properties;

   Configuration() {
      properties = new Properties();
      loadPropertiesFromFile();
      overwriteWithSystemProperties();
   }

   void reload() {
      loadPropertiesFromFile();
      overwriteWithSystemProperties();
   }

   private void loadPropertiesFromFile() {
      String fileName = Configuration.class.getName().toLowerCase();
      InputStream propertiesStream = this.getClass().getResourceAsStream("/" + fileName + ".properties");
      if (propertiesStream != null) {
         try {
            properties.load(propertiesStream);
         } catch (IOException e) {
            LOG.log(CONFIG, "could not load properties file" + fileName + " from classpath", e);
         }
      }
   }

   private void overwriteWithSystemProperties() {
      for (Entry<Object, Object> sysProperty : System.getProperties().entrySet()) {
         if (sysProperty.getKey() instanceof String && ((String) sysProperty.getKey()).startsWith("io.konik")) {
            properties.put(sysProperty.getKey(), sysProperty.getValue());
         }
      }
   }

   /**
    * Searches for the property with the specified key in this property list.
    * If the key is not found in this property list, the default property list,
    * and its defaults, recursively, are then checked. The method returns
    * <code>null</code> if the property is not found.
    *
    * @param key the property key.
    * @return the value in this property list with the specified key value.
    * @see Configuration#getProperty(String, String)
    */
   public String getProperty(String key) {
      return properties.getProperty(key);
   }

   /**
    * Searches for the property with the specified key in this property list.
    * If the key is not found in this property list, the default property list,
    * and its defaults, recursively, are then checked. The method returns the
    * default value argument if the property is not found.
    *
    * @param key the hashtable key.
    * @param defaultValue a default value.
    *
    * @return the value in this property list with the specified key value.
    * @see Configuration#getProperty(String)
    */
   public String getProperty(String key, String defaultValue) {
      return properties.getProperty(key, defaultValue);
   }

   /**
    * Indicate of Konik should strip the trailing zeros in all amounts.
    * 
    * 
    * @return true if strip trailing zeros is active (default is false)
    */
   public boolean stripTrailingZeros() {
      return Boolean.parseBoolean(getProperty("io.konik.stripTrailingZeros", "false"));
   }

   @Override
   public String toString() {
      return "Konik Configuration dump\n" + properties.toString();
   }
}

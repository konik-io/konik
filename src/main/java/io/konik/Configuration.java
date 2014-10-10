package io.konik;

import static java.util.logging.Level.CONFIG;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * The Global Configuration.
 * 
 * Load Konik Configuration from file `io.konik.configuration.properties` 
 * 
 */
public class Configuration {
   private static final Logger LOG = Logger.getLogger(Configuration.class.getName());
   public final static Configuration INSTANCE = new Configuration();
   
   private final Properties properties;
   
   Configuration(){
      properties = new Properties();
      loadPropertiesFromFile();
   }
   
   private void loadPropertiesFromFile() {
	  String fileName = Configuration.class.getName().toLowerCase();
      InputStream propertiesStream = this.getClass().getResourceAsStream("/"+fileName+".properties");
      if (propertiesStream != null) {
         try {
            properties.load(propertiesStream);
         } catch (IOException e) {
            LOG.log(CONFIG, "could not load properties file" + fileName +" from classpath", e);
         }
      }
   }
   

   /**
    * Searches for the property with the specified key in this property list.
    * If the key is not found in this property list, the default property list,
    * and its defaults, recursively, are then checked. The method returns
    * <code>null</code> if the property is not found.
    *
    * @param   key   the property key.
    * @return  the value in this property list with the specified key value.
    * @see     Configuration#getProperty(String, String)
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
    * @param   key            the hashtable key.
    * @param   defaultValue   a default value.
    *
    * @return  the value in this property list with the specified key value.
    * @see     Configuration#getProperty(String)
    */
   public String getProperty(String key, String defaultValue) {
      return properties.getProperty(key, defaultValue);
   }
   
   
   /**
    * Indicate of Konik should strip the trailing zeros in all amounts. 
    * 
    * 
    * @return true if strip trailing zeros is active (default)
 	*/
   public boolean stripTrailingZeros(){
	   return Boolean.getBoolean(getProperty("io.konik.stripTrailingZeros", "true"));   
   }
   
   
   @Override
   public String toString() {
      return "Konik Configuration dump\n" + properties.toString();
   }
}

package io.konik.sdk;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.konik.Configuration;
import io.konik.zugferd.unqualified.ZfDate;
import io.konik.zugferd.unqualified.ZfDateDay;

/**
 * Main SDK configuration class.
 */
public class ZinvoiceApiConfig {

   /**
    * Zinvoice user API KEY
    */
   private final String apiKey;

   /**
    * Absolute URL to Zinvoice remote service.
    *
    * e.g. https://app.z-rechnung.com
    */
   private final String destinationUrl;

   public ZinvoiceApiConfig() {
      this(Configuration.INSTANCE.getProperty("io.konik.zinvoice.api-key"),
            Configuration.INSTANCE.getProperty("io.konik.zinvoice.url"));
   }

   public ZinvoiceApiConfig(String apiKey, String destinationUrl) {
      this.apiKey = apiKey;
      this.destinationUrl = destinationUrl;
   }

   public String getApiKey() {
      return apiKey;
   }

   public String getDestinationUrl() {
      return destinationUrl;
   }

   public ObjectMapper getDefaulObjectMapper() {
      SimpleModule module = new SimpleModule();
      module.addDeserializer(ZfDate.class, new JsonDeserializer<ZfDate>() {
         @Override
         public ZfDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            Long timestamp = jp.readValueAs(Long.class);
            return new ZfDateDay(timestamp);
         }
      });

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      objectMapper.registerModule(module);
      return objectMapper;
   }
}

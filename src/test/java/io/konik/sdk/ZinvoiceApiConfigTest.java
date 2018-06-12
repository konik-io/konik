package io.konik.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;

public class ZinvoiceApiConfigTest {

   @Test
   public void shouldConfigureZinvoiceApiConfigClassCorrectly() {
      //given:
      String apiKey = UUID.randomUUID().toString();
      String destinationUrl = "http://app.te.z-rechnung.com";

      //when:
      ZinvoiceApiConfig config = new ZinvoiceApiConfig(apiKey, destinationUrl);

      //then:
      assertThat(config.getApiKey()).isEqualTo(apiKey);
      assertThat(config.getDestinationUrl()).isEqualTo(destinationUrl);
   }

   @Test
   @Ignore
   public void shouldUsePropertiesFileToGetDefaultValues() {
      //when:
      ZinvoiceApiConfig apiConfig = new ZinvoiceApiConfig();

      //then:
      assertThat(apiConfig.getApiKey()).isEqualTo("1234-1234-1234-1234");
      assertThat(apiConfig.getDestinationUrl()).isEqualTo("https://localhost:8080");
   }
}
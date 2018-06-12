package io.konik.sdk.http;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;

import io.konik.sdk.ZinvoiceApiConfig;

public class ZinvoiceHttpClientTest {

   private static final String API_KEY = UUID.randomUUID().toString();
   private static final String DESTINATION_URL = "http://localhost";

   private ZinvoiceApiConfig apiConfig = new ZinvoiceApiConfig(API_KEY, DESTINATION_URL);

   private HttpTransport httpTransport = new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
         return new MockLowLevelHttpRequest() {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
               String apiKey = this.getFirstHeaderValue("API-KEY");

               MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
               response.setStatusCode(200);
               response.setContentType("application/json");
               response.setContent("{\"apiKey\": \"" + apiKey + "\"}");
               return response;
            }
         };
      }
   };

   private HttpRequestFactory httpRequestFactory = httpTransport.createRequestFactory(new HttpRequestInitializer() {
      @Override
      public void initialize(HttpRequest request) throws IOException {
         request.setParser(new JsonObjectParser(new JacksonFactory()));
      }
   });

   private ObjectMapper objectMapper = new ObjectMapper();

   private ZinvoiceHttpClient zinvoiceHttpClient = new ZinvoiceHttpClient(apiConfig, httpRequestFactory, objectMapper);

   @Test
   @SuppressWarnings("unchecked")
   public void shouldUseApiKeyAsARequestHeader() throws IOException {
      //when:
      Map<String, String> response = zinvoiceHttpClient.get("/lorem/ipsum", Map.class);

      //then:
      assertThat(response.get("apiKey")).isEqualTo(apiConfig.getApiKey());
   }
}
package io.konik.sdk.invoices;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.unitils.thirdparty.org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;

import io.konik.sdk.ZinvoiceApiConfig;
import io.konik.sdk.http.ZinvoiceHttpClient;

public class RestInvoicesApiTest {

   private final ZinvoiceApiConfig apiConfig = new ZinvoiceApiConfig(UUID.randomUUID().toString(), "http://localhost");

   private final ObjectMapper objectMapper = new ObjectMapper();

   private final ZinvoiceHttpClient outboxMockHttpClient = new ZinvoiceHttpClient(apiConfig,
         mockHttpRequestFactory(new MockLowLevelHttpRequest() {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
               StringWriter writer = new StringWriter();
               IOUtils.copy(getClass().getResourceAsStream("/json/RestInvoicesApiTest_outbox.json"), writer, "UTF-8");
               String json = writer.toString();

               MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
               response.setStatusCode(200);
               response.setContentType("application/json");
               response.setContent(json);
               return response;
            }
         }), objectMapper);

   private final ZinvoiceHttpClient inboxMockHttpClient = new ZinvoiceHttpClient(apiConfig,
         mockHttpRequestFactory(new MockLowLevelHttpRequest() {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
               StringWriter writer = new StringWriter();
               IOUtils.copy(getClass().getResourceAsStream("/json/RestInvoicesApiTest_inbox.json"), writer, "UTF-8");
               String json = writer.toString();

               MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
               response.setStatusCode(200);
               response.setContentType("application/json");
               response.setContent(json);
               return response;
            }
         }), objectMapper);

   private HttpRequestFactory mockHttpRequestFactory(final MockLowLevelHttpRequest request) {
      return new MockHttpTransport() {
         @Override
         public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return request;
         }
      }.createRequestFactory();
   }

   @Test
   public void shouldReturn4ItemsInOutbox() {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(outboxMockHttpClient);

      //when:
      List<InvoicesListElement> response = invoicesApi.outbox();

      //then:
      assertThat(response).hasSize(4);
   }

   @Test
   public void shouldReturnCorrectFirstInboxElement() {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(outboxMockHttpClient);

      //when:
      List<InvoicesListElement> response = invoicesApi.outbox();

      //then:
      assertThat(response.get(0).getId()).isEqualTo("e7508df79bc24ceb9f8ac8f98e718e67");
   }

   @Test
   public void shouldParseStatusEnumCorrectly() {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(outboxMockHttpClient);

      //when:
      List<InvoicesListElement> response = invoicesApi.outbox();

      //then:
      assertThat(response.get(0).getStatus()).isEqualTo("PRINTED");
   }

   @Test
   public void shouldParseCreatedDateCorrectly() throws ParseException {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(outboxMockHttpClient);
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      Date expectedCreatedDate = dateFormat.parse("2015-07-31 09:12");

      //when:
      List<InvoicesListElement> response = invoicesApi.outbox();

      //then:
      assertThat(response.get(0).getCreatedDate()).isEqualTo(expectedCreatedDate);
   }

   @Test
   public void shouldParsePerformanceDateCorrectly() throws ParseException {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(outboxMockHttpClient);
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date expectedPerformanceDate = dateFormat.parse("2015-07-31");

      //when:
      List<InvoicesListElement> response = invoicesApi.outbox();

      //then:
      assertThat(response.get(0).getPerformanceDate()).isEqualTo(expectedPerformanceDate);
   }

   @Test
   public void shouldReturn4ItemsInInbox() {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(inboxMockHttpClient);

      //when:
      List<InvoicesListElement> response = invoicesApi.inbox();

      //then:
      assertThat(response).hasSize(3);
   }

   @Test
   public void shouldParseREJECTEDStatusForTheFirstInvoiceInInbox() {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(inboxMockHttpClient);

      //when:
      List<InvoicesListElement> response = invoicesApi.inbox();

      //then:
      assertThat(response.get(0).getStatus()).isEqualTo("REJECTED");
   }

   @Test
   public void shouldParseAmountCorrectly() {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(inboxMockHttpClient);

      //when:
      List<InvoicesListElement> response = invoicesApi.inbox();

      //then:
      assertThat(response.get(0).getAmount()).isEqualTo(BigDecimal.valueOf(235.62));
   }

   @Test
   public void shouldParseCurrencyCorrectly() {
      //given:
      InvoicesApi invoicesApi = new RestInvoicesApi(inboxMockHttpClient);

      //when:
      List<InvoicesListElement> response = invoicesApi.inbox();

      //then:
      assertThat(response.get(0).getCurrency()).isEqualTo("EUR");
   }
}
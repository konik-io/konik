package io.konik.sdk.invoice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.StringWriter;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.unitils.thirdparty.org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.common.io.ByteStreams;

import io.konik.InvoiceTransformer;
import io.konik.sdk.ZinvoiceApiConfig;
import io.konik.sdk.http.BadRequestException;
import io.konik.sdk.http.ZinvoiceHttpClient;
import io.konik.zugferd.Invoice;

public class RestInvoiceApiTest {

   private static final String INVOICE_ID = "4fd7563db62c4234a500b09be34e07dd";

   private final ZinvoiceApiConfig apiConfig = new ZinvoiceApiConfig(UUID.randomUUID().toString(), "http://localhost");

   private final ZinvoiceHttpClient getInvoiceMockHttpClient = new ZinvoiceHttpClient(apiConfig,
         mockHttpRequestFactory(new MockLowLevelHttpRequest() {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
               StringWriter writer = new StringWriter();
               IOUtils.copy(getClass().getResourceAsStream("/json/RestInvoiceApiTest_getInvoice.json"), writer,
                     "UTF-8");
               String json = writer.toString();

               MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
               response.setStatusCode(200);
               response.setContentType("application/json");
               response.setContent(json);
               return response;
            }
         }), apiConfig.getDefaulObjectMapper());

   private final ZinvoiceHttpClient createInvoiceFailHttpClient = new ZinvoiceHttpClient(apiConfig,
         mockHttpRequestFactory(new MockLowLevelHttpRequest() {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
               String json = "{\"path\": \"/invoice\", \"message\": \"Your request contains errors\", \"errors\": {\"trade.settlement.monetarySummation.chargeTotal\": \"may not be null\"}}";
               MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
               response.setStatusCode(400);
               response.setContentType("application/json");
               response.setContent(json);
               return response;
            }
         }), apiConfig.getDefaulObjectMapper());

   private HttpRequestFactory mockHttpRequestFactory(final MockLowLevelHttpRequest request) {
      return new MockHttpTransport() {
         @Override
         public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return request;
         }
      }.createRequestFactory();
   }

   @Test
   public void shouldLoadDocumentAndReturnsItsId() {
      //given:
      InvoiceApi invoiceApi = new RestInvoiceApi(getInvoiceMockHttpClient);

      //when:
      InvoiceDocument invoiceDocument = invoiceApi.getInvoice(INVOICE_ID);

      //then:
      assertThat(invoiceDocument.getId()).isEqualTo(INVOICE_ID);
   }

   @Test
   public void shouldLoadDocumentAndReturnGuidelineNamespace() {
      //given:
      InvoiceApi invoiceApi = new RestInvoiceApi(getInvoiceMockHttpClient);

      //when:
      InvoiceDocument invoiceDocument = invoiceApi.getInvoice(INVOICE_ID);

      //then:
      assertThat(invoiceDocument.getInvoice().getContext().getGuideline().getNamespace())
            .isEqualTo("urn:ferd:CrossIndustryDocument:invoice:");
   }

   @Test
   public void shouldLoadDocumentAndReturnItsInvoiceNumber() {
      //given:
      InvoiceApi invoiceApi = new RestInvoiceApi(getInvoiceMockHttpClient);

      //when:
      InvoiceDocument invoiceDocument = invoiceApi.getInvoice(INVOICE_ID);

      //then:
      assertThat(invoiceDocument.getInvoice().getHeader().getInvoiceNumber()).isEqualTo("20150201");
   }

   @Test
   public void shouldLoadDocumentAndReturnSellerTaxNumber() {
      //given:
      InvoiceApi invoiceApi = new RestInvoiceApi(getInvoiceMockHttpClient);

      //when:
      InvoiceDocument invoiceDocument = invoiceApi.getInvoice(INVOICE_ID);

      //then:
      assertThat(invoiceDocument.getInvoice().getTrade().getAgreement().getSeller().getTaxRegistrations().get(0)
            .getTaxNumber()).isEqualTo("7732393669");
   }

   @Test
   public void shouldWrapBadRequestIntoException() {
      //given:
      InvoiceApi invoiceApi = new RestInvoiceApi(createInvoiceFailHttpClient);

      //when:
      try {
         invoiceApi.createInvoice(mock(Invoice.class));
         failBecauseExceptionWasNotThrown(BadRequestException.class);
      } catch (BadRequestException e) {
         //then:
         assertThat(e.getErrorResponse().getMessage()).isEqualTo("Your request contains errors");
         assertThat(e.getErrorResponse().getErrors()).containsEntry("trade.settlement.monetarySummation.chargeTotal",
               "may not be null");
      }
   }

   @Test
   @Ignore("Ticket created")
   public void shouldUseInvoiceTransformerToGenerateZugferdXmlInvoiceRepresentationDuringCreateRequest()
         throws IOException {
      //given:
      ZinvoiceHttpClient zinvoiceHttpClient = mock(ZinvoiceHttpClient.class);
      InvoiceTransformer invoiceTransformer = mock(InvoiceTransformer.class);
      Invoice invoice = mock(Invoice.class);
      InvoiceApi invoiceApi = new RestInvoiceApi(zinvoiceHttpClient, invoiceTransformer);
      byte[] mockXml = ByteStreams.toByteArray(getClass().getResourceAsStream("/ZUGFeRD-invoice.sample.xml"));

      when(invoiceTransformer.fromModel(invoice)).thenReturn(mockXml);
      when(zinvoiceHttpClient.post("/invoice", mockXml, "application/xml", InvoiceResponse.class))
            .thenReturn(mock(InvoiceResponse.class));

      //when:
      invoiceApi.createInvoice(invoice);

      //then:
      verify(invoiceTransformer, times(1)).fromModel(invoice);
      verify(zinvoiceHttpClient, times(1)).post(Mockito.eq("/invoice"), Mockito.<byte[]> anyObject(),
            Mockito.eq("application/xml"), Mockito.eq(InvoiceResponse.class));
   }

   @Test
   @Ignore("Ticket created")
   public void shouldCallRemoteZInvoiceServiceToUpdateInvoiceStatus() {
      //given:
      ZinvoiceApiConfig apiConfig = new ZinvoiceApiConfig(UUID.randomUUID().toString(), "http://localhost:8080");
      ObjectMapper objectMapper = new ObjectMapper();
      MockHttpTransport httpTransport = new MockHttpTransport.Builder()
            .setLowLevelHttpRequest(new MockLowLevelHttpRequest("/invoice/123/status").setResponse(
                  new MockLowLevelHttpResponse().setContent("{\"invoiceId\": \"123\", \"status\": \"BOOKED\"}")))
            .build();
      HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
      ZinvoiceHttpClient httpClient = new ZinvoiceHttpClient(apiConfig, requestFactory, objectMapper);
      InvoiceApi invoiceApi = new RestInvoiceApi(httpClient, new InvoiceTransformer());

      //when:
      StatusResponse statusResponse = invoiceApi.updateStatus("123", Status.BOOKED);

      //then:
      assertThat(statusResponse.getInvoiceId()).isEqualTo("123");
      assertThat(statusResponse.getStatus()).isEqualTo(Status.BOOKED);

   }
}
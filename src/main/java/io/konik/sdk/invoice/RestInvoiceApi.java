package io.konik.sdk.invoice;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.Maps;

import io.konik.InvoiceTransformer;
import io.konik.sdk.http.InsufficientCreditsAmountException;
import io.konik.sdk.http.ZinvoiceHttpClient;
import io.konik.zugferd.Invoice;

public class RestInvoiceApi implements InvoiceApi {

   private static final Logger log = LoggerFactory.getLogger(RestInvoiceApi.class);

   private final ZinvoiceHttpClient httpClient;

   private final InvoiceTransformer invoiceTransformer;

   public RestInvoiceApi(ZinvoiceHttpClient zinvoiceHttpClient) {
      this.httpClient = zinvoiceHttpClient;
      this.invoiceTransformer = new InvoiceTransformer();
   }

   public RestInvoiceApi(ZinvoiceHttpClient zinvoiceHttpClient, InvoiceTransformer invoiceTransformer) {
      this.httpClient = zinvoiceHttpClient;
      this.invoiceTransformer = invoiceTransformer;
   }

   @Override
   public InvoiceDocument getInvoice(String id) {
      InvoiceDocument.Response response = httpClient.get("/invoice/" + id, InvoiceDocument.Response.class);
      if (response != null) {
         return response.getDocument();
      }
      return null;
   }

   @Override
   public InvoiceResponse createInvoice(Invoice invoice) {
      byte[] invoiceXml = invoiceTransformer.fromModel(invoice);
      return httpClient.post("/invoice", invoiceXml, "application/xml", InvoiceResponse.class);
   }

   @Override
   public InvoiceResponse createDraftInvoice(Invoice invoice) {
      byte[] invoiceXml = invoiceTransformer.fromModel(invoice);
      return httpClient.post("/invoice/draft", invoiceXml, "application/xml", InvoiceResponse.class);
   }

   @Override
   public InvoiceResponse updateInvoice(String invoiceId, Invoice invoice) {
      byte[] invoiceXml = invoiceTransformer.fromModel(invoice);
      return httpClient.put("/invoice/" + invoiceId, invoiceXml, "application/xml", InvoiceResponse.class);
   }

   @Override
   public InvoiceResponse updateDraftInvoice(String invoiceId, Invoice invoice) {
      byte[] invoiceXml = invoiceTransformer.fromModel(invoice);
      return httpClient.put("/invoice/draft/" + invoiceId, invoiceXml, "application/xml", InvoiceResponse.class);
   }

   @Override
   public InputStream downloadInvoiceAsPDF(String invoiceId) {
      try {
         return httpClient.download("/invoice/" + invoiceId + "/pdf");
      } catch (RuntimeException e) {
         if (e.getCause() instanceof HttpResponseException) {
            HttpResponseException responseException = (HttpResponseException) e.getCause();
            if (responseException.getStatusCode() == 409) {
               throw new InsufficientCreditsAmountException();
            }
         }
         throw e;
      }
   }

   @Override
   public void deleteInvoice(String invoiceId) {
      httpClient.delete("/invoice/" + invoiceId);
   }

   @Override
   public boolean sendInvoice(String invoiceId, String email, String message) {
      try {
         String encodedMessage = URLEncoder.encode(message, "UTF-8");
         String json = "{\"recipient\":\"" + email + "\", \"message\":\"" + encodedMessage + "\"}";

         InvoiceResponse createdInvoice = httpClient.post("/invoice/" + invoiceId + "/pdf/send",
               json.getBytes(Charset.forName("UTF-8")), "application/json", InvoiceResponse.class);

         return createdInvoice != null && createdInvoice.getInvoiceId() != null;
      } catch (RuntimeException e) {
         if (e.getCause() instanceof HttpResponseException) {
            HttpResponseException responseException = (HttpResponseException) e.getCause();
            if (responseException.getStatusCode() == 409) {
               throw new InsufficientCreditsAmountException();
            }
         }
         throw e;
      } catch (UnsupportedEncodingException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public boolean sendInvoice(String invoiceId, String email) {
      return sendInvoice(invoiceId, email, "");
   }

   @Override
   public InvoiceResponse uploadInvoice(InputStream pdf, InvoiceDocument.Type type) {
      Map<String, InputStream> files = Maps.newHashMap();
      files.put("pdf", pdf);
      return httpClient.upload(String.format("/invoice/pdf?type=%s", type.toString()), files, InvoiceResponse.class);
   }

   @Override
   public StatusResponse updateStatus(String invoiceId, Status status) {
      try {
         String json = String.format("{\"status\": \"%s\"}", status.toString());
         String url = String.format("/invoice/%s/status", invoiceId);

         log.debug("Updating status of the invoice with id {}: {}", invoiceId, json);

         StatusResponse response = httpClient.post(url, json.getBytes("UTF-8"), "application/json",
               StatusResponse.class);

         log.debug("Change status response = {}", response);

         return response;
      } catch (Exception e) {
         log.warn("Caught exception {}: {}", e.getClass().getSimpleName(), e.getMessage());
         throw new RuntimeException(e);
      }
   }
}

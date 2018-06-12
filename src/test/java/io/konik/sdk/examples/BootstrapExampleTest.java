package io.konik.sdk.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.konik.sdk.ZinvoiceApiConfig;
import io.konik.sdk.http.ZinvoiceHttpClient;
import io.konik.sdk.invoice.InvoiceApi;
import io.konik.sdk.invoice.RestInvoiceApi;
import io.konik.sdk.invoices.InvoicesApi;
import io.konik.sdk.invoices.RestInvoicesApi;

public class BootstrapExampleTest {

   // tag::zinvoiceApiConfig[]
   public ZinvoiceApiConfig zinvoiceApiConfig() {
      return new ZinvoiceApiConfig(
            "f4eb6f7b-e3c3-43b2-a456-c116315102b6", // <1>
            "https://app.z-rechnung.com" // <2>
      );
   }
   // end::zinvoiceApiConfig[]

   // tag::zinvoiceHttpClient[]
   public ZinvoiceHttpClient zinvoiceHttpClient() {
      return new ZinvoiceHttpClient(
            zinvoiceApiConfig() // <3>
      );
   }
   // end::zinvoiceHttpClient[]

   // tag::anotherZinvoiceHttpClient[]
   public ZinvoiceHttpClient anotherZinvoiceHttpClient() {
      return new ZinvoiceHttpClient(
            zinvoiceApiConfig(),
            ZinvoiceHttpClient.DEFAULT_HTTP_REQUEST_FACTORY, // <4>
            new ObjectMapper() // <5>
      );
   }
   // end::anotherZinvoiceHttpClient[]

   // tag::invoicesApi[]
   public InvoicesApi invoicesApi() {
      return new RestInvoicesApi(zinvoiceHttpClient()); // <6>
   }
   // end::invoicesApi[]

   // tag::invoiceApi[]
   public InvoiceApi invoiceApi() {
      return new RestInvoiceApi(zinvoiceHttpClient()); // <7>

   }
   // end::invoiceApi[]
}

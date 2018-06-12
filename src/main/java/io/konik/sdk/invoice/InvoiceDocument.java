package io.konik.sdk.invoice;

import io.konik.zugferd.Invoice;

public class InvoiceDocument {

   public enum Type {
      INCOMING,
      OUTGOING;
   }

   private String id;

   private Invoice invoice;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public Invoice getInvoice() {
      return invoice;
   }

   public void setInvoice(Invoice invoice) {
      this.invoice = invoice;
   }

   public static class Response {
      InvoiceDocument document;

      public InvoiceDocument getDocument() {
         return document;
      }

      public void setDocument(InvoiceDocument document) {
         this.document = document;
      }
   }
}

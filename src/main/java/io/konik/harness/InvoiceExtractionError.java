package io.konik.harness;


public class InvoiceExtractionError extends RuntimeException {

   public InvoiceExtractionError(String msg) {
      super(msg);
   }

   public InvoiceExtractionError(String msg, Throwable e) {
    super(msg, e);
   }
}

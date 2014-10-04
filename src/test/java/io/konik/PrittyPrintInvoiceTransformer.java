package io.konik;

public class PrittyPrintInvoiceTransformer extends InvoiceTransformer {

   @Override
   protected Boolean formatXmlOutput() {
      return Boolean.TRUE;
   }
}

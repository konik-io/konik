package io.konik;

@SuppressWarnings("javadoc")
public class PrittyPrintInvoiceTransformer extends InvoiceTransformer {

   @Override
   protected Boolean formatXmlOutput() {
      return Boolean.TRUE;
   }
}

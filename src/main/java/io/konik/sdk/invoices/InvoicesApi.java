package io.konik.sdk.invoices;

import java.util.List;

public interface InvoicesApi {
   List<InvoicesListElement> inbox();

   List<InvoicesListElement> outbox();
}

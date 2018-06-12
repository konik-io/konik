package io.konik.sdk.invoice;

public class StatusResponse {

   private String invoiceId;
   private Status status;
   private boolean changed;

   public String getInvoiceId() {
      return invoiceId;
   }

   public void setInvoiceId(String invoiceId) {
      this.invoiceId = invoiceId;
   }

   public Status getStatus() {
      return status;
   }

   public void setStatus(Status status) {
      this.status = status;
   }

   public boolean isChanged() {
      return changed;
   }

   public void setChanged(boolean changed) {
      this.changed = changed;
   }

   @Override
   public String toString() {
      return "StatusResponse{" +
            "invoiceId='" + invoiceId + '\'' +
            ", status=" + status +
            ", changed=" + changed +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof StatusResponse)) return false;

      StatusResponse that = (StatusResponse) o;

      if (changed != that.changed) return false;
      if (invoiceId != null ? !invoiceId.equals(that.invoiceId) : that.invoiceId != null) return false;
      return status == that.status;

   }

   @Override
   public int hashCode() {
      int result = invoiceId != null ? invoiceId.hashCode() : 0;
      result = 31 * result + (status != null ? status.hashCode() : 0);
      result = 31 * result + (changed ? 1 : 0);
      return result;
   }
}

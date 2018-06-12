package io.konik.sdk.http;

public class InsufficientCreditsAmountException extends RuntimeException {

   public InsufficientCreditsAmountException() {
      super("Request cannot be continued due to insufficient credits amount. Add some credits to your account before you try again.");
   }
}

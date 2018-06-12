package io.konik.sdk.http;

public class BadRequestException extends RuntimeException {

   private final ErrorResponse errorResponse;

   public BadRequestException(ErrorResponse errorResponse) {
      this.errorResponse = errorResponse;
   }

   public ErrorResponse getErrorResponse() {
      return errorResponse;
   }

   @Override
   public String toString() {
      StringBuilder stringBuilder = new StringBuilder("BadRequestException: " + errorResponse.getMessage());

      System.out.println(errorResponse);

      if (errorResponse.getErrors() != null && !errorResponse.getErrors().isEmpty()) {
         stringBuilder.append("\nReason:\n|");
         for (String key : errorResponse.getErrors().keySet()) {
            String message = errorResponse.getErrors().get(key);
            stringBuilder.append("\n");
            stringBuilder.append("|-- " + key + ": " + message);
         }
         stringBuilder.append("\n|_");
      }
      return stringBuilder.toString();
   }
}

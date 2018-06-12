package io.konik.sdk.http;

import java.util.Map;

public class ErrorResponse {

   private String path;

   private String message;

   private Map<String, String> errors;

   public String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public Map<String, String> getErrors() {
      return errors;
   }

   public void setErrors(Map<String, String> errors) {
      this.errors = errors;
   }

   @Override
   public String toString() {
      return "ErrorResponse{" +
            "path='" + path + '\'' +
            ", message='" + message + '\'' +
            ", errors=" + errors +
            '}';
   }
}

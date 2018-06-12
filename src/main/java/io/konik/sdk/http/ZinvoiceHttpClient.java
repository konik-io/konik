package io.konik.sdk.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.common.io.ByteStreams;

import io.konik.sdk.ZinvoiceApiConfig;

/**
 * HTTP client for Zinvoice services.
 *
 * It allows to call Zinvoice endpoints with no worries about internal connection details.
 */
public class ZinvoiceHttpClient {

   public static final HttpRequestFactory DEFAULT_HTTP_REQUEST_FACTORY = new NetHttpTransport()
         .createRequestFactory(new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest httpRequest) throws IOException {
               httpRequest.setParser(new JsonObjectParser(new JacksonFactory()));
            }
         });

   private final ZinvoiceApiConfig apiConfig;

   private final HttpRequestFactory httpRequestFactory;

   private final ObjectMapper objectMapper;

   public ZinvoiceHttpClient(ZinvoiceApiConfig apiConfig, HttpRequestFactory httpRequestFactory,
         ObjectMapper objectMapper) {
      this.apiConfig = apiConfig;
      this.httpRequestFactory = httpRequestFactory;
      this.objectMapper = objectMapper;
   }

   public ZinvoiceHttpClient(ZinvoiceApiConfig apiConfig, ObjectMapper objectMapper) {
      this.apiConfig = apiConfig;
      this.objectMapper = objectMapper;
      this.httpRequestFactory = DEFAULT_HTTP_REQUEST_FACTORY;
   }

   public ZinvoiceHttpClient(ZinvoiceApiConfig apiConfig) {
      this.apiConfig = apiConfig;
      this.objectMapper = apiConfig.getDefaulObjectMapper();
      this.httpRequestFactory = DEFAULT_HTTP_REQUEST_FACTORY;
   }

   /**
    * Runs GET request.
    *
    * @param endpoint
    * @param responseTypeClass
    * @return
    */
   public <T> T get(String endpoint, Class<T> responseTypeClass) {
      T result;

      try {
         HttpRequest request = httpRequestFactory.buildGetRequest(createEndpoint(endpoint));
         request.setHeaders(new HttpHeaders().set("API-KEY", apiConfig.getApiKey()));

         HttpResponse response = request.execute();
         result = objectMapper.readValue(response.parseAsString(), responseTypeClass);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

      return result;
   }

   /**
    * Downloads content as {@see InputStream}.
    *
    * @param endpoint
    * @return
    */
   public InputStream download(String endpoint) {
      try {
         HttpRequest request = httpRequestFactory.buildGetRequest(createEndpoint(endpoint));
         request.setHeaders(new HttpHeaders().set("API-KEY", apiConfig.getApiKey()).setAccept("application/json"));
         return request.execute().getContent();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   /**
    * Uploads {@see InputStream} to given endpoint.
    *
    * @param endpoint
    * @param files map where key is field name and value is a content of uploading file
    * @param responseTypeClass 
    * @return 
    */
   public <T> T upload(String endpoint, Map<String, InputStream> files, Class<T> responseTypeClass) {
      try {
         MultipartContent content = new MultipartContent();
         content.setMediaType(new HttpMediaType("multipart/form-data").setParameter("boundary", "__END_OF_PART__"));

         Detector detector = new DefaultDetector();

         for (String key : files.keySet()) {
            InputStream file = new ByteArrayInputStream(ByteStreams.toByteArray(files.get(key)));
            MediaType mediaType = detector.detect(file, new Metadata());
            MultipartContent.Part part = new MultipartContent.Part(new InputStreamContent(mediaType.toString(), file));
            part.setHeaders(new HttpHeaders().set("Content-Disposition",
                  String.format("form-data; name=\"%s\"; filename=\"%s\"", key, key)));
            content.addPart(part);
         }

         HttpRequest request = httpRequestFactory.buildPostRequest(createEndpoint(endpoint), content);
         request.setHeaders(new HttpHeaders().set("API-KEY", apiConfig.getApiKey()).setAccept("application/json"));
         HttpResponse response = request.execute();

         return objectMapper.readValue(response.parseAsString(), responseTypeClass);

      } catch (HttpResponseException e) {
         if (e.getStatusCode() == 400) {
            throw new BadRequestException(getErrorResponse(e));
         }
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   /**
    * Runs POST request.
    *
    * @param endpoint
    * @param body 
    * @param contentType 
    * @param responseTypeClass
    * @return
    */
   public <T> T post(String endpoint, byte[] body, String contentType, Class<T> responseTypeClass) {
      T result;

      try {
         HttpContent content = new InputStreamContent(contentType, new ByteArrayInputStream(body));
         HttpRequest request = httpRequestFactory.buildPostRequest(createEndpoint(endpoint), content);
         request.setHeaders(new HttpHeaders().set("API-KEY", apiConfig.getApiKey()));

         HttpResponse response = request.execute();
         result = objectMapper.readValue(response.parseAsString(), responseTypeClass);
      } catch (HttpResponseException e) {
         if (e.getStatusCode() == 400) {
            throw new BadRequestException(getErrorResponse(e));
         }
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

      return result;
   }

   /**
    * Runs PUT request.
    *
    * @param endpoint
    * @param body 
    * @param contentType 
    * @param responseTypeClass
    * @return
    */
   public <T> T put(String endpoint, byte[] body, String contentType, Class<T> responseTypeClass) {
      T result;

      try {
         HttpContent content = new InputStreamContent(contentType, new ByteArrayInputStream(body));
         HttpRequest request = httpRequestFactory.buildPutRequest(createEndpoint(endpoint), content);
         request.setHeaders(new HttpHeaders().set("API-KEY", apiConfig.getApiKey()));

         HttpResponse response = request.execute();
         result = objectMapper.readValue(response.parseAsString(), responseTypeClass);
      } catch (HttpResponseException e) {
         if (e.getStatusCode() == 400) {
            throw new BadRequestException(getErrorResponse(e));
         }
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

      return result;
   }

   /**
    * Runs DELETE request.
    *
    * @param endpoint
    * @return
    */
   public void delete(String endpoint) {
      try {
         HttpRequest request = httpRequestFactory.buildDeleteRequest(createEndpoint(endpoint));
         request.setHeaders(new HttpHeaders().set("API-KEY", apiConfig.getApiKey()));
         request.execute();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   private ErrorResponse getErrorResponse(HttpResponseException e) {
      ErrorResponse errorResponse;
      try {
         errorResponse = objectMapper.readValue(e.getContent(), ErrorResponse.class);
      } catch (IOException e1) {
         throw new RuntimeException(e1);
      }
      return errorResponse;
   }

   private GenericUrl createEndpoint(String endpoint) {
      return new GenericUrl(apiConfig.getDestinationUrl() + endpoint);
   }
}

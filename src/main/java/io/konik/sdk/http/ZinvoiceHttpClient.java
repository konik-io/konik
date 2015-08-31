package io.konik.sdk.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import io.konik.sdk.ZinvoiceApiConfig;

import java.io.IOException;

/**
 * HTTP client for Zinvoice services.
 *
 * It allows to call Zinvoice endpoints with no worries about internal connection details.
 */
public class ZinvoiceHttpClient {

	public static final HttpRequestFactory DEFAULT_HTTP_REQUEST_FACTORY = new NetHttpTransport().createRequestFactory(new HttpRequestInitializer() {
		@Override
		public void initialize(HttpRequest httpRequest) throws IOException {
			httpRequest.setParser(new JsonObjectParser(new JacksonFactory()));
		}
	});

	private final ZinvoiceApiConfig apiConfig;

	private final HttpRequestFactory httpRequestFactory;

	private final ObjectMapper objectMapper;

	public ZinvoiceHttpClient(ZinvoiceApiConfig apiConfig, HttpRequestFactory httpRequestFactory, ObjectMapper objectMapper) {
		this.apiConfig = apiConfig;
		this.httpRequestFactory = httpRequestFactory;
		this.objectMapper = objectMapper;
	}

	public ZinvoiceHttpClient(ZinvoiceApiConfig apiConfig, ObjectMapper objectMapper) {
		this.apiConfig = apiConfig;
		this.objectMapper = objectMapper;
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

	private GenericUrl createEndpoint(String endpoint) {
		return new GenericUrl(apiConfig.getDestinationUrl() + endpoint);
	}
}

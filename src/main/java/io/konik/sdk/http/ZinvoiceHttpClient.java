package io.konik.sdk.http;

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

	public ZinvoiceHttpClient(ZinvoiceApiConfig apiConfig, HttpRequestFactory httpRequestFactory) {
		this.apiConfig = apiConfig;
		this.httpRequestFactory = httpRequestFactory;
	}

	/**
	 * Runs GET request.
	 *
	 * @param endpoint
	 * @param responseTypeClass
	 * @return
	 * @throws IOException
	 */
	public <T> T get(String endpoint, Class<T> responseTypeClass) throws IOException {
		HttpRequest request = httpRequestFactory.buildGetRequest(createEndpoint(endpoint));
		request.setHeaders(new HttpHeaders().set("API-KEY", apiConfig.getApiKey()));
		return request.execute().parseAs(responseTypeClass);
	}

	private GenericUrl createEndpoint(String endpoint) {
		return new GenericUrl(apiConfig.getDestinationUrl() + endpoint);
	}
}

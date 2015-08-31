package io.konik.sdk;

/**
 * Main SDK configuration class.
 */
public class ZinvoiceApiConfig {

	/**
	 * Zinvoice user API KEY
	 */
	private final String apiKey;

	/**
	 * Absolute URL to Zinvoice remote service.
	 *
	 * e.g. https://app.z-rechnung.com
	 */
	private final String destinationUrl;

	public ZinvoiceApiConfig(String apiKey, String destinationUrl) {
		this.apiKey = apiKey;
		this.destinationUrl = destinationUrl;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getDestinationUrl() {
		return destinationUrl;
	}
}

package io.konik.sdk;

import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class ZinvoiceApiConfigTest {

	@Test
	public void shouldConfigureZinvoiceApiConfigClassCorrectly() {
		//given:
		String apiKey = UUID.randomUUID().toString();
		String destinationUrl = "http://app.te.z-rechnung.com";

		//when:
		ZinvoiceApiConfig config = new ZinvoiceApiConfig(apiKey, destinationUrl);

		//then:
		assertThat(config.getApiKey()).isEqualTo(apiKey);
		assertThat(config.getDestinationUrl()).isEqualTo(destinationUrl);
	}
}
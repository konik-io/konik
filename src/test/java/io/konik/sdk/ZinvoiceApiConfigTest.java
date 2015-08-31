package io.konik.sdk;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ZinvoiceApiConfigTest {

	@Test
	public void shouldConfigureZinvoiceApiConfigClassCorrectly() {
		//given:
		String apiKey = UUID.randomUUID().toString();
		String destinationUrl = "http://app.te.z-rechnung.com";

		//when:
		ZinvoiceApiConfig config = new ZinvoiceApiConfig(apiKey, destinationUrl);

		//then:
		assertThat(config.getApiKey(), is(equalTo(apiKey)));
		assertThat(config.getDestinationUrl(), is(equalTo(destinationUrl)));
	}
}
package io.konik.csv.pdf;

import org.junit.Test;

import java.io.File;

public class CsvToZUGFeRDConverterTest {

	private CsvToZUGFeRDConverter converter = new CsvToZUGFeRDConverter();

	@Test
	public void shouldMapFileInput() {
		//given:
		File csvFile = new File("src/test/resources/csv/example_with_file.csv");

		//when:
		converter.convert(csvFile);
	}
}
package io.konik.csv.mapper;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvInvoicesReaderUTF8Test {

	private CsvInvoicesReader reader = new CsvInvoicesReader();

	@Test
	public void shouldReadAllInvoicesFromCsvFile() {
		//given:
		File csvFile = new File("src/test/resources/csv/example_utf8.csv");

		//when:
		CsvInvoicesReader.Result result = reader.read(csvFile);

		//then:
		assertThat(result.getConvertedRows().get(1).getRow().getItems().get(0).getName()).isEqualTo("Monatliche Beträge");

		assertThat(result.getConvertedRows().get(1).getInvoice().getTrade().getItems().get(0).getProduct().getName()).isEqualTo("Monatliche Beträge");
	}
}
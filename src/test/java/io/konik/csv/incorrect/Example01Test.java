package io.konik.csv.incorrect;

import io.konik.csv.mapper.CsvInvoicesReader;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class Example01Test {


	private CsvInvoicesReader reader = new CsvInvoicesReader();

	@Test
	public void shouldReadAllInvoicesFromCsvFile() {
		//given:
		File csvFile = new File("src/test/resources/csv/incorrect/example01.csv");

		//when:
		CsvInvoicesReader.Result result = reader.read(csvFile);

		//then:
		assertThat(result.getConvertedRows()).hasSize(2);

		//then:
		assertThat(result.getRowErrors()).hasSize(2);

		//and:
		assertThat(result.getRowErrors().get(0).getRowNumber()).isEqualTo(3);

		//and:
		assertThat(result.getRowErrors().get(0).getErrorMessage()).isEqualTo(result.getRowErrors().get(0).getException().getMessage());

		//and:
		assertThat(result.getRowErrors().get(1).getRowNumber()).isEqualTo(4);

		//and:
		assertThat(result.getRowErrors().get(1).getErrorMessage()).isEqualTo(result.getRowErrors().get(1).getException().getMessage());
	}
}

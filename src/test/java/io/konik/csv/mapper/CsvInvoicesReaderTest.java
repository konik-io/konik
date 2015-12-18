package io.konik.csv.mapper;

import io.konik.csv.Rows;
import io.konik.csv.converter.InvoiceToRowConverter;
import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvInvoicesReaderTest {

	private CsvInvoicesReader reader = new CsvInvoicesReader();

	@Test
	public void shouldReadAllInvoicesFromCsvFile() {
		//given:
		File csvFile = new File("src/test/resources/csv/example.csv");

		//when:
		List<Invoice> invoices = reader.read(csvFile);

		//then:
		assertThat(invoices).hasSize(2);

		assertThat(invoices.get(0)).is(createdFrom(Rows.row1));

		assertThat(invoices.get(1)).is(createdFrom(Rows.row2));
	}

	private static Condition<Invoice> createdFrom(final Row row) {
		return new Condition<Invoice>() {
			@Override
			public boolean matches(Invoice invoice) {
				return row.equals(InvoiceToRowConverter.convert(invoice));
			}
		};
	}

}
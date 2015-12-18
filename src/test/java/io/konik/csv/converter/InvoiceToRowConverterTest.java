package io.konik.csv.converter;

import io.konik.csv.Rows;
import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceToRowConverterTest {

	@Test
	public void shouldConvertRowToInvoiceAndConvertItBack() {
		//given:
		Row row = Rows.row1;

		//when:
		Invoice invoice = RowToInvoiceConverter.convert(Rows.row1);
		Row convertedRow = InvoiceToRowConverter.convert(invoice);

		//then:
		assertThat(row).isEqualTo(convertedRow);
	}
}
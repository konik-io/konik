package io.konik.csv.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import io.konik.csv.Rows;
import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;

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
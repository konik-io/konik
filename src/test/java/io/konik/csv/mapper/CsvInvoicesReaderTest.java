package io.konik.csv.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.assertj.core.api.Condition;
import org.junit.Test;

import io.konik.csv.Rows;
import io.konik.csv.converter.InvoiceToRowConverter;
import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;

public class CsvInvoicesReaderTest {

   private CsvInvoicesReader reader = new CsvInvoicesReader();

   @Test
   public void shouldReadAllInvoicesFromCsvFile() {
      //given:
      File csvFile = new File("src/test/resources/csv/example.csv");

      //when:
      CsvInvoicesReader.Result result = reader.read(csvFile);

      //then:
      assertThat(result.getConvertedRows()).hasSize(2);

      assertThat(result.getConvertedRows().get(0).getInvoice()).is(createdFrom(Rows.row1));

      assertThat(result.getConvertedRows().get(1).getInvoice()).is(createdFrom(Rows.row2));
   }

   @Test
   public void shouldMapFileInput() {
      //given:
      File csvFile = new File("src/test/resources/csv/example_with_file.csv");

      //when:
      CsvInvoicesReader.Result result = reader.read(csvFile);

      //then:
      assertThat(result.getConvertedRows().get(0).getRow().getFile().getInput())
            .isEqualTo("src/test/resources/csv/pdf/invoice.pdf");

      assertThat(result.getConvertedRows().get(0).getRow().getFile().getOutput()).isEqualTo("/tmp/inoive_new.pdf");

      //and:
      assertThat(result.getConvertedRows().get(1).getRow().getFile().getInput())
            .isEqualTo("src/test/resources/csv/pdf/invoice2.pdf");

      assertThat(result.getConvertedRows().get(1).getRow().getFile().getOutput()).isEqualTo("/tmp/invoice2_new.pdf");
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
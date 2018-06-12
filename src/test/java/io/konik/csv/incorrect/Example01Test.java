package io.konik.csv.incorrect;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.junit.Test;

import io.konik.csv.mapper.CsvInvoicesReader;

public class Example01Test {

   private CsvInvoicesReader reader = new CsvInvoicesReader();

   @Test
   public void shouldReadAllInvoicesFromCsvFile() {
      //given:
      File csvFile = new File("src/test/resources/csv/incorrect/example01.csv");

      //when:
      CsvInvoicesReader.Result result = reader.read(csvFile);

      //then:
      assertThat(result.getConvertedRows()).hasSize(1);

      //then:
      assertThat(result.getRowErrors()).hasSize(3);

      //and:
      assertThat(result.getRowErrors().get(0).getRowNumber()).isEqualTo(2);

      //and:
      assertThat(result.getRowErrors().get(0).getErrorMessage())
            .isEqualTo(result.getRowErrors().get(0).getException().getMessage());

      //and:
      assertThat(result.getRowErrors().get(1).getRowNumber()).isEqualTo(3);

      //and:
      assertThat(result.getRowErrors().get(1).getErrorMessage())
            .isEqualTo(result.getRowErrors().get(1).getException().getMessage());

      //and:
      assertThat(result.getRowErrors().get(2).getRowNumber()).isEqualTo(4);

      //and:
      assertThat(result.getRowErrors().get(2).getErrorMessage())
            .isEqualTo(result.getRowErrors().get(2).getException().getMessage());
   }
}

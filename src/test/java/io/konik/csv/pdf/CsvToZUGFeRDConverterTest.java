package io.konik.csv.pdf;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("Move this test case to pdfconverter")
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
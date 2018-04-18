package io.konik.csv;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.text.ParseException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.supercsv.prefs.CsvPreference;

import io.konik.csv.mapper.CsvMapperBuilder;

@RunWith(Parameterized.class)
public class CsvMapperBuilderCsvPreferenceRecognitionFailTest {

   @Parameter
   public String fileName;

   @Parameter(1)
   public CsvPreference expectedPreference;

   @Parameters(name = "{0}")
   public static Iterable<Object[]> getParams() throws ParseException {
      return Arrays.asList(new Object[] { "standard_preference_01.csv", CsvPreference.STANDARD_PREFERENCE },
            new Object[] { "standard_preference_02.csv", CsvPreference.STANDARD_PREFERENCE },
            new Object[] { "standard_preference_03.csv", CsvPreference.STANDARD_PREFERENCE },
            new Object[] { "excel_north_eu_01.csv", CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE },
            new Object[] { "excel_north_eu_02.csv", CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE },
            new Object[] { "excel_north_eu_03.csv", CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE }

      );
   }

   @Test
   public void confirmThatColumnDefinitionForGivenHeaderExists() {
      //when:
      CsvPreference csvPreference = CsvMapperBuilder
            .recognizeCsvPreference(new File("src/test/resources/csv/recognition/" + fileName));

      //then:
      assertThat(csvPreference).isEqualTo(expectedPreference);
   }
}
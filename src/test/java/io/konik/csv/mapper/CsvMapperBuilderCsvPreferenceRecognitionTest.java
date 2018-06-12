package io.konik.csv.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.text.ParseException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CsvMapperBuilderCsvPreferenceRecognitionTest {

   @Parameter
   public String fileName;

   @Parameters(name = "{0}")
   public static Iterable<Object[]> getParams() throws ParseException {
      return Arrays.asList(new Object[] { "fail01.csv" }, new Object[] { "fail02.csv" }, new Object[] { "fail03.csv" },
            new Object[] { "fail04.csv" });
   }

   @Test
   public void confirmThatColumnDefinitionForGivenHeaderExists() {
      //setup:
      Exception exception = null;

      //when:
      try {
         CsvMapperBuilder.recognizeCsvPreference(new File("src/test/resources/csv/recognition/failures/" + fileName));
      } catch (Exception e) {
         exception = e;
      }

      //then:
      assertThat(exception).isNotNull();
   }
}
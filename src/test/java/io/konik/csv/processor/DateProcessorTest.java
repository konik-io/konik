package io.konik.csv.processor;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateProcessorTest {

   private final DateProcessor processor = new DateProcessor();

   @Parameter
   public String dateStr;

   @Parameter(1)
   public Date expectedDate;

   @Parameters(name = "{1}")
   public static Iterable<Object[]> getParams() throws ParseException {
      DateFormat dateFormat = new DateProcessor().getDateFormat();

      return Arrays.asList(new Object[] { "20150101", dateFormat.parse("20150101") },
            new Object[] { "19960130", dateFormat.parse("19960130") },
            new Object[] { "20000101", dateFormat.parse("20000101") },
            new Object[] { "19991231", dateFormat.parse("19991231") },
            new Object[] { "20120229", dateFormat.parse("20120229") },
            new Object[] { "33333333", dateFormat.parse("33351003") });
   }

   @Test
   public void convertDateStrToZfDate() {
      //when:
      Date date = (Date) processor.execute(dateStr, null);

      //then:
      assertThat(date).isEqualTo(expectedDate);
   }
}
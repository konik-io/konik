package io.konik.zugferd.qualified;

import static io.konik.unece.codes.DateTimeType._101;
import static io.konik.unece.codes.DateTimeType._203;
import static io.konik.unece.codes.DateTimeType._204;
import static org.apache.commons.lang3.time.FastDateFormat.getInstance;
import static org.assertj.core.api.Assertions.assertThat;
import io.konik.zugferd.qualified.DateTime;

import java.util.Date;

import org.junit.Test;
@SuppressWarnings("javadoc")
public class DateTimeTest {

   @Test
   public final void DateTime() throws Exception {
      //when
      DateTime dateTime = new DateTime();

      //then
      String expected = getInstance("yyyyMMdd").format(new Date());

      assertThat(dateTime.getValue()).isEqualTo(expected);
      assertThat(dateTime.getCode()).isEqualTo("102");
   }

   @Test
   public final void DateTimeDate_dateTimeType() throws Exception {
      //setup
      Date now = new Date();
      
      //when
      DateTime dateTime = new DateTime(_101);
     
      //then
      String expected = getInstance("yyMMdd").format(now);
      assertThat(dateTime.getValue()).isEqualTo(expected);
      assertThat(dateTime.getCode()).isEqualTo("101");
   }

   @Test
   public final void getValue() throws Exception {
      //setup
      Date now = new Date();
      //when

      DateTime dateTime = new DateTime(_204);

      //then
      assertThat(dateTime.getValue()).isEqualTo(getInstance(_204.pattern).format(now));
   }

   @Test
   public final void getCode() {
      //given
      Date now = new Date();

      //when
      DateTime dateTime = new DateTime(_203);
      assertThat(dateTime.getCode()).isEqualTo(_203.code);
      assertThat(dateTime.getValue()).isEqualTo(getInstance(_203.pattern).format(now));
   }

   @Test(expected = IllegalArgumentException.class)
   public final void asDate_fail() throws Exception {
      DateTime dateTime = new DateTime("123", "1234");
      dateTime.asDate();
   }

}

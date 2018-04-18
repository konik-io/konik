package io.konik.csv.pdf;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.konik.csv.pdf.FileAppenderPriorityComparator.Order;
import io.konik.harness.FileAppender;

@RunWith(MockitoJUnitRunner.class)
public class FileAppenderPriorityComparatorTest {

   private FileAppender firstFileAppender = mock(FileAppender.class);

   private FileAppender secondFileAppender = mock(FileAppender.class);

   private FileAppender thirdFileAppender = mock(FileAppender.class);

   @Before
   public void setup() {
      when(firstFileAppender.getPriority()).thenReturn(100);
      when(secondFileAppender.getPriority()).thenReturn(50);
      when(thirdFileAppender.getPriority()).thenReturn(40);
   }

   @Test
   public void shouldSortFileAppendersByPriorityDesc() {
      //given:
      FileAppenderPriorityComparator comparator = new FileAppenderPriorityComparator(Order.DESC);
      List<FileAppender> appenders = Arrays.asList(thirdFileAppender, firstFileAppender, secondFileAppender);

      //when:
      Collections.sort(appenders, comparator);

      //then:
      assertThat(appenders.get(0)).isEqualTo(firstFileAppender);

      //and:
      assertThat(appenders.get(1)).isEqualTo(secondFileAppender);

      //and:
      assertThat(appenders.get(2)).isEqualTo(thirdFileAppender);
   }

   @Test
   public void shouldSortFileAppendersByPriorityAsc() {
      //given:
      FileAppenderPriorityComparator comparator = new FileAppenderPriorityComparator(Order.ASC);
      List<FileAppender> appenders = Arrays.asList(secondFileAppender, firstFileAppender, thirdFileAppender);

      //when:
      Collections.sort(appenders, comparator);

      //then:
      assertThat(appenders.get(0)).isEqualTo(thirdFileAppender);

      //and:
      assertThat(appenders.get(1)).isEqualTo(secondFileAppender);

      //and:
      assertThat(appenders.get(2)).isEqualTo(firstFileAppender);
   }
}
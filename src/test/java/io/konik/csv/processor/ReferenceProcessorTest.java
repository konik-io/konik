package io.konik.csv.processor;

import java.text.ParseException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import io.konik.zugferd.unece.codes.Reference;

@RunWith(Parameterized.class)
public class ReferenceProcessorTest {

   private final ReferenceProcessor processor = new ReferenceProcessor();

   @Parameter
   public Reference reference;

   @Parameter(1)
   public String referenceConvertedToString;

   @Parameters(name = "{1}")
   public static Iterable<Object[]> getParams() throws ParseException {
      return Lists.transform(Arrays.asList(Reference.values()), new Function<Reference, Object[]>() {
         public Object[] apply(Reference reference) {
            return new Object[] { reference, reference.getCode() };
         }
      });
   }

   @Test
   public void asdasasdasd() {
      //given:
      String value = processor.execute(reference, null);
      //when:

      //then:

   }
}
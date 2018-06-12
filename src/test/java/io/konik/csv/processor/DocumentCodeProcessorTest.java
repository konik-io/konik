package io.konik.csv.processor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import io.konik.zugferd.unece.codes.DocumentCode;

public class DocumentCodeProcessorTest {

   @Test
   public void shouldConvertAllStringValuesToDocumentCode() {
      //given:
      DocumentCodeProcessor processor = new DocumentCodeProcessor();
      //when:
      DocumentCode[] codes = DocumentCode.values();
      //then:
      for (DocumentCode documentCode : codes) {
         assertThat(documentCode).isEqualTo(processor.execute(documentCode.getCode(), null));
      }
   }

   @Test
   public void shouldConvertAllDocumentCodesToStringRepresentations() {
      //given:
      DocumentCodeProcessor processor = new DocumentCodeProcessor();
      //when:
      DocumentCode[] codes = DocumentCode.values();
      //then:
      for (DocumentCode documentCode : codes) {
         assertThat(documentCode.getCode()).isEqualTo(processor.execute(documentCode, null));
      }
   }

   @Test
   public void shouldReturnNullIfDocumentCodeForGivenStringDoesNotExist() {
      //given:
      DocumentCodeProcessor processor = new DocumentCodeProcessor();
      String nonExistingCode = "999";
      //when:
      DocumentCode documentCode = (DocumentCode) processor.execute(nonExistingCode, null);
      //then:
      assertThat(documentCode).isNull();
   }
}
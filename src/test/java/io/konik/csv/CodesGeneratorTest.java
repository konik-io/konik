package io.konik.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import io.konik.zugferd.unece.codes.Reference;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;

public class CodesGeneratorTest {

   private static final String REFERENCE_CODES = "src/main/resources/csv/reference_codes.csv";
   private static final String UNIT_CODES = "src/main/resources/csv/unit_codes.csv";

   @Test
   public void generateCurrentReferenceCodesDescription() throws IOException {
      FileWriter writer = new FileWriter(new File(REFERENCE_CODES));
      writer.write("reference.code;reference.description\n");

      for (Reference reference : Reference.values()) {
         writer.write(String.format("%s;\"%s\"\n", reference.name(), reference.getDescription()));
      }

      writer.close();
   }

   @Test
   public void generateUnitCodes() throws IOException {
      FileWriter writer = new FileWriter(new File(UNIT_CODES));
      writer.write("unit.code;unit.description\n");

      for (UnitOfMeasurement unitOfMeasurement : UnitOfMeasurement.values()) {
         writer.write(String.format("%s;\"%s\"\n", unitOfMeasurement.name(), unitOfMeasurement.getDescription()));
      }

      writer.close();
   }
}

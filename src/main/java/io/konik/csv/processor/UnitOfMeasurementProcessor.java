package io.konik.csv.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

import io.konik.zugferd.unece.codes.UnitOfMeasurement;

/**
 * Custom {@link CellProcessor} for {@link UnitOfMeasurement}.
 */
public final class UnitOfMeasurementProcessor implements CellProcessor {

   private static final Logger log = LoggerFactory.getLogger(UnitOfMeasurementProcessor.class);

   @Override
   public Object execute(Object value, CsvContext context) {

      if (value instanceof String) {
         String code = (String) value;
         try {
            return UnitOfMeasurement.valueOf(code);
         } catch (IllegalArgumentException e) {
            log.warn("UnitOfMeasurement for value {} does not exist", value);
         }
      }

      if (value instanceof UnitOfMeasurement) {
         UnitOfMeasurement unitOfMeasurement = (UnitOfMeasurement) value;
         return unitOfMeasurement.name();
      }

      return null;
   }
}

package io.konik.csv.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

import io.konik.zugferd.unece.codes.DocumentCode;

/**
 * Custom {@link CellProcessor} for {@link io.konik.zugferd.unece.codes.DocumentCode}.
 */
public final class DocumentCodeProcessor implements CellProcessor {

   private static final Logger log = LoggerFactory.getLogger(DocumentCodeProcessor.class);

   @Override
   public Object execute(Object value, CsvContext context) {

      if (value instanceof String) {
         String code = (String) value;
         try {
            return DocumentCode.getByCode(code);
         } catch (IllegalArgumentException e) {
            log.warn("DocumentCode for value {} does not exist", value);
         }
      }

      if (value instanceof DocumentCode) {
         DocumentCode code = (DocumentCode) value;
         return code.getCode();
      }

      return null;
   }
}

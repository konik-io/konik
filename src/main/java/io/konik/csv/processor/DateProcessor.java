package io.konik.csv.processor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

/**
 * Custom {@link CellProcessor} for {@link Date} class.
 *
 * It uses proper {@link java.text.DateFormat} to convert object from and to a String value.
 */
public final class DateProcessor implements CellProcessor {

   private static final Logger log = LoggerFactory.getLogger(DateProcessor.class);

   private static final ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {
      @Override
      protected DateFormat initialValue() {
         return new SimpleDateFormat("yyyyMMdd");
      }
   };

   public DateFormat getDateFormat() {
      return dateFormat.get();
   }

   @Override
   public Object execute(Object value, CsvContext context) {

      if (value instanceof String) {
         String dateStr = (String) value;
         Date date = null;

         try {
            return dateFormat.get().parse(dateStr);
         } catch (ParseException e) {
            log.error("Parsing {} throws an exception: {}", value, e.getMessage());
            throw new RuntimeException(String.format("Value %s does not match valid date format (yyyyMMdd)", value));
         }
      }

      if (value instanceof Date) {
         return dateFormat.get().format(value);
      }

      return null;
   }
}

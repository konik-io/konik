package io.konik.csv.mapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;

import io.konik.csv.converter.RowToInvoiceConverter;
import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;

/**
 * Reader class used for reading CSV files and returning a {@link List} of {@see Invoice}s.
 *
 * This is high-level component that should be used to import invoices from CSV files.
 */
public class CsvInvoicesReader {

   private static final Logger log = LoggerFactory.getLogger(CsvInvoicesReader.class);

   private final ColumnsConfigurer columnsConfigurer;

   public CsvInvoicesReader() {
      this(new CsvMapperHeaderColumnsConfigurer());
   }

   public CsvInvoicesReader(ColumnsConfigurer columnsConfigurer) {
      this.columnsConfigurer = columnsConfigurer;
   }

   /**
    * Loads invoices from given CSV file.
    * @param csvFile
    * @return
    */
   public Result read(File csvFile) {
      CsvMapperBuilder mapperBuilder = CsvMapperBuilder.withHeadersFromCsvFile(csvFile, columnsConfigurer);
      CellProcessor[] processors = mapperBuilder.getCellProcessors();
      CsvDozerBeanReader reader = mapperBuilder.getBeanReader(csvFile, Row.class);

      List<ConvertedRow> convertedRows = new LinkedList<ConvertedRow>();
      List<RowError> rowErrors = new LinkedList<RowError>();
      Row currentRow = null;
      final AtomicInteger rowNumber = new AtomicInteger(1);

      try {
         do {
            try {
               currentRow = reader.read(Row.class, processors);
               if (currentRow != null) {
                  Invoice invoice = RowToInvoiceConverter.convert(currentRow);
                  convertedRows.add(new ConvertedRow(rowNumber.getAndIncrement(), currentRow, invoice));
               }
            } catch (Exception e) {
               log.warn("Exception caught during reading a row");
               rowErrors.add(new RowError(rowNumber.getAndIncrement(), currentRow, e.getMessage(), e));
            }
         } while (currentRow != null);

         return new Result(convertedRows, rowErrors);

      } catch (Exception e) {
         throw new RuntimeException(e);

      } finally {
         if (reader != null) {
            try {
               reader.close();
            } catch (IOException e) {
               log.error(e.getMessage(), e);
            }
         }
      }
   }

   static public class ConvertedRow {
      private final int rowNumber;
      private final Row row;
      private final Invoice invoice;

      public ConvertedRow(int rowNumber, Row row, Invoice invoice) {
         this.rowNumber = rowNumber;
         this.row = row;
         this.invoice = invoice;
      }

      public int getRowNumber() {
         return rowNumber;
      }

      public Row getRow() {
         return row;
      }

      public Invoice getInvoice() {
         return invoice;
      }
   }

   static public class RowError {
      private final int rowNumber;
      private final Row row;
      private final String errorMessage;
      private final Exception exception;

      public RowError(int rowNumber, Row row, String errorMessage, Exception exception) {
         this.rowNumber = rowNumber;
         this.row = row;
         this.errorMessage = errorMessage;
         this.exception = exception;
      }

      public int getRowNumber() {
         return rowNumber;
      }

      public Row getRow() {
         return row;
      }

      public String getErrorMessage() {
         return errorMessage;
      }

      public Exception getException() {
         return exception;
      }
   }

   static public class Result {
      private final List<ConvertedRow> convertedRows;
      private final List<RowError> rowErrors;

      public Result(List<ConvertedRow> convertedRows, List<RowError> rowErrors) {
         this.convertedRows = convertedRows;
         this.rowErrors = rowErrors;
      }

      public List<ConvertedRow> getConvertedRows() {
         return convertedRows;
      }

      public List<RowError> getRowErrors() {
         return rowErrors;
      }
   }
}

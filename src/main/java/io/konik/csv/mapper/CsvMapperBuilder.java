package io.konik.csv.mapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Nullable;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldDefinition;
import org.dozer.loader.api.FieldsMappingOption;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanData;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class CsvMapperBuilder {

   private final CopyOnWriteArrayList<Column> columns = new CopyOnWriteArrayList<Column>();

   private final CsvPreference csvPreference;

   public CsvMapperBuilder(CsvPreference csvPreference) {
      this.csvPreference = csvPreference;
   }

   public CsvMapperBuilder add(Column.Builder builder) {
      columns.add(builder.build());
      return this;
   }

   public CsvMapperBuilder addColumns(List<Column> columns) {
      this.columns.addAll(columns);
      return this;
   }

   public CellProcessor[] getCellProcessors() {
      return Lists.transform(columns, new Function<Column, CellProcessor>() {
         public CellProcessor apply(Column column) {
            return column.processor;
         }
      }).toArray(new CellProcessor[columns.size()]);
   }

   public String[] getColumnNames() {
      return Lists.transform(columns, new Function<Column, String>() {
         public String apply(Column column) {
            return column.name;
         }
      }).toArray(new String[columns.size()]);
   }

   public DozerBeanMapper buildBeanMapper(final Class<?> destinationObjectClass) {
      DozerBeanMapper beanMapper = new DozerBeanMapper();
      beanMapper.addMapping(new BeanMappingBuilder() {
         @Override
         protected void configure() {
            TypeMappingBuilder readerBuilder = mapping(CsvDozerBeanData.class, destinationObjectClass,
                  TypeMappingOptions.oneWay(), TypeMappingOptions.wildcard(false), TypeMappingOptions.mapNull(false));

            TypeMappingBuilder writerBuilder = mapping(destinationObjectClass,
                  type(CsvDozerBeanData.class).mapNull(true), TypeMappingOptions.oneWay(),
                  TypeMappingOptions.wildcard(false));

            for (int i = 0; i < columns.size(); i++) {
               Column column = columns.get(i);

               if (column == null) {
                  throw new NullPointerException(String.format("fieldMapping at index %d should not be null", i));
               }

               String srcField = "columns[" + i + "]";

               if (column.fieldDefinition != null) {
                  readerBuilder.fields(srcField, column.fieldDefinition, column.mappingOptions);
               } else {
                  readerBuilder.fields(srcField, column.name, column.mappingOptions);
               }

               writerBuilder.fields(column.name, srcField, FieldsMappingOptions.copyByReference());
            }
         }
      });

      return beanMapper;
   }

   public static Column.Builder column(String header) {
      return Column.builder().name(header);
   }

   public static CsvMapperBuilder withHeadersFromCsvFile(final File csvFile,
         final ColumnsConfigurer columnsConfigurer) {
      if (!csvFile.exists()) {
         throw new IllegalArgumentException("File does not exist!");
      }

      CsvPreference csvPreference = recognizeCsvPreference(csvFile);

      try {
         final CsvDozerBeanReader reader = new CsvDozerBeanReader(
               new InputStreamReader(new FileInputStream(csvFile), "UTF-8"), csvPreference);
         final String[] headers = reader.getHeader(true);
         reader.close();

         List<Column> columns = Lists.transform(Arrays.asList(headers), new Function<String, Column>() {
            @Nullable
            @Override
            public Column apply(String input) {
               return columnsConfigurer.getColumnDefinitionForHeader(input);
            }
         });

         return new CsvMapperBuilder(csvPreference).addColumns(columns);

      } catch (Exception e) {
         throw new RuntimeException("CsvMapperBuilder initialization failed", e);
      }
   }

   public static CsvPreference recognizeCsvPreference(File file) {
      String[] lines = new String[2];
      try {
         BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
         int lineNum = 0;
         String line;

         while ((line = bufferedReader.readLine()) != null && lineNum < 2) {
            lines[lineNum++] = line.replaceAll("\"([^\"]+)\"", "_");
         }

         if (isEmptyLine(lines[0]) || isEmptyLine(lines[1])) {
            throw new IllegalArgumentException("CSV file has to contain a header and at least one row");
         }

      } catch (IOException e) {
         throw new IllegalStateException("Delimiter recognition failed", e);
      }

      if (isDelimiter(",", lines[0], lines[1])) {
         return CsvPreference.STANDARD_PREFERENCE;
      }

      if (isDelimiter(";", lines[0], lines[1])) {
         return CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE;
      }

      throw new IllegalStateException("Delimiter for the CSV file could not be found");
   }

   private static boolean isEmptyLine(String line) {
      return line == null || line.isEmpty();
   }

   private static boolean isDelimiter(String delimiter, String lineOne, String lineTwo) {
      return lineOne.split(delimiter).length == lineTwo.split(delimiter).length && lineOne.contains(delimiter);
   }

   public CsvDozerBeanReader getBeanReader(File csvFile, Class<?> beanType) {
      try {
         CsvDozerBeanReader reader = new CsvDozerBeanReader(
               new InputStreamReader(new FileInputStream(csvFile), "UTF-8"), csvPreference, buildBeanMapper(beanType));
         reader.getHeader(true);
         return reader;

      } catch (IOException e) {
         throw new RuntimeException("Bean reader initialization failed", e);
      }
   }

   static class Column {
      final String name;
      final Class<?> type;
      final CellProcessor processor;
      final FieldsMappingOption[] mappingOptions;
      final FieldDefinition fieldDefinition;

      public Column(Builder builder) {
         this.name = builder.name;
         this.type = builder.type;
         this.processor = builder.processor;
         this.mappingOptions = builder.mappingOptions.toArray(new FieldsMappingOption[builder.mappingOptions.size()]);
         this.fieldDefinition = builder.fieldDefinition;
      }

      public static Builder builder() {
         return new Builder();
      }

      @Override
      public String toString() {
         return "Column{" + "name='" + name + '\'' + ", type=" + type + ", processor=" + processor + ", mappingOptions="
               + Arrays.toString(mappingOptions) + ", fieldDefinition=" + fieldDefinition + '}';
      }

      public static class Builder {
         private String name;
         private Class<?> type = String.class;
         private CellProcessor processor = new Optional();
         private List<FieldsMappingOption> mappingOptions = new LinkedList<FieldsMappingOption>();
         private FieldDefinition fieldDefinition;

         public Builder name(String name) {
            this.name = name;
            this.fieldDefinition = new FieldDefinition(name)
                  .setMethod(String.format("set%s", capitalize(extractChildsField(name))));
            return this;
         }

         public Builder type(Class<?> type) {
            this.type = type;
            return this;
         }

         public Builder processor(CellProcessor processor) {
            this.processor = processor;
            return this;
         }

         public Builder mappingOptions(FieldsMappingOption... mappingOptions) {
            this.mappingOptions.addAll(Arrays.asList(mappingOptions));
            return this;
         }

         public Builder fieldDefinition(FieldDefinition fieldDefinition) {
            this.fieldDefinition = fieldDefinition;
            return this;
         }

         public Column build() {
            if (mappingOptions.isEmpty()) {
               mappingOptions.add(FieldsMappingOptions.hintB(type));
            }
            return new Column(this);
         }

         private static String capitalize(String str) {
            if (str != null && str.length() > 0) {
               return str.substring(0, 1).toUpperCase() + str.substring(1);
            }
            return str;
         }

         private static String extractChildsField(String path) {
            if (path.lastIndexOf(".") >= 0) {
               return path.substring(path.lastIndexOf(".") + 1);
            }
            return path;
         }
      }
   }
}

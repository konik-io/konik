package io.konik.csv.mapper;

import static io.konik.csv.mapper.CsvMapperBuilder.column;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ift.CellProcessor;

import com.google.common.base.Function;
import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;

import io.konik.csv.mapper.CsvMapperBuilder.Column;
import io.konik.csv.processor.DateProcessor;
import io.konik.csv.processor.ReferenceProcessor;
import io.konik.csv.processor.UnitOfMeasurementProcessor;
import io.konik.zugferd.unece.codes.Reference;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;

final class CsvMapperHeaderColumnsConfigurer implements ColumnsConfigurer {

   private static final Logger log = LoggerFactory.getLogger(CsvMapperHeaderColumnsConfigurer.class);

   private static final ConcurrentMap<Pattern, Function<String, Column.Builder>> config = new ConcurrentHashMap<Pattern, Function<String, Column.Builder>>();

   static {
      config.put(Pattern.compile("^file\\.input"), defaultColumn());
      config.put(Pattern.compile("^file\\.output"), defaultColumn());

      config.put(Pattern.compile("^header\\.invoiceNumber$"), defaultColumn());
      config.put(Pattern.compile("^header\\.type$"), defaultColumn());
      config.put(Pattern.compile("^header\\.issued$"), typeColumn(Date.class, new DateProcessor()));
      config.put(Pattern.compile("^header\\.dueDate$"), typeColumn(Date.class, new DateProcessor()));
      config.put(Pattern.compile("^header\\.reference$"), defaultColumn());
      config.put(Pattern.compile("^header\\.customerNumber$"), defaultColumn());
      config.put(Pattern.compile("^header\\.currency$"), typeColumn(CurrencyCode.class));
      config.put(Pattern.compile("^header\\.note$"), defaultColumn());

      config.put(Pattern.compile("^recipient\\.name$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.contactName$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.addressLine1$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.addressLine2$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.city$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.postcode$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.countryCode$"), typeColumn(CountryCode.class));
      config.put(Pattern.compile("^recipient\\.postcode$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.email$"), defaultColumn());

      config.put(Pattern.compile("^recipient\\.taxes\\[\\d\\].number$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.taxes\\[\\d\\].type$"),
            typeColumn(Reference.class, new ReferenceProcessor()));

      config.put(Pattern.compile("^recipient\\.bankInfo.bankName$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.bankInfo.bic$"), defaultColumn());
      config.put(Pattern.compile("^recipient\\.bankInfo.iban$"), defaultColumn());

      config.put(Pattern.compile("^issuer\\.name$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.contactName$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.addressLine1$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.addressLine2$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.city$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.postcode$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.countryCode$"), typeColumn(CountryCode.class));
      config.put(Pattern.compile("^issuer\\.postcode$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.email$"), defaultColumn());

      config.put(Pattern.compile("^issuer\\.taxes\\[\\d\\].number$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.taxes\\[\\d\\].type$"),
            typeColumn(Reference.class, new ReferenceProcessor()));

      config.put(Pattern.compile("^issuer\\.bankInfo.bankName$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.bankInfo.bic$"), defaultColumn());
      config.put(Pattern.compile("^issuer\\.bankInfo.iban$"), defaultColumn());

      config.put(Pattern.compile("^items\\[\\d\\]\\.name$"), defaultColumn());
      config.put(Pattern.compile("^items\\[\\d\\]\\.quantity$"), typeColumn(BigDecimal.class));
      config.put(Pattern.compile("^items\\[\\d\\]\\.unit$"),
            typeColumn(UnitOfMeasurement.class, new UnitOfMeasurementProcessor()));
      config.put(Pattern.compile("^items\\[\\d\\]\\.unitPrice$"), typeColumn(BigDecimal.class));
      config.put(Pattern.compile("^items\\[\\d\\]\\.taxPercent$"), typeColumn(BigDecimal.class));

   }

   private static Function<String, Column.Builder> defaultColumn() {
      return new Function<String, Column.Builder>() {
         @Nullable
         @Override
         public Column.Builder apply(String input) {
            log.debug("Creating default column for {}", input);
            return column(input);
         }
      };
   }

   private static Function<String, Column.Builder> typeColumn(final Class<?> type, final CellProcessor processor) {
      return new Function<String, Column.Builder>() {
         @Nullable
         @Override
         public Column.Builder apply(@Nullable String input) {
            Column.Builder builder = column(input).type(type);
            if (processor != null) {
               builder.processor(processor);
            }
            return builder;
         }
      };
   }

   private static Function<String, Column.Builder> typeColumn(final Class<?> type) {
      return typeColumn(type, null);
   }

   @Override
   public Column getColumnDefinitionForHeader(String header) {
      for (Pattern pattern : config.keySet()) {
         Matcher matcher = pattern.matcher(header);

         while (matcher.find()) {
            String value = matcher.group();

            Column.Builder builder = config.get(pattern).apply(value);

            if (builder != null) {
               return builder.build();
            }
         }
      }
      return null;
   }
}

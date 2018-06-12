package io.konik.csv.mapper;

import static io.konik.csv.mapper.CsvMapperBuilder.column;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.CsvDozerBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;

import io.konik.csv.Rows;
import io.konik.csv.model.Row;
import io.konik.csv.processor.DateProcessor;
import io.konik.csv.processor.ReferenceProcessor;
import io.konik.csv.processor.UnitOfMeasurementProcessor;
import io.konik.zugferd.unece.codes.Reference;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;

public class CsvMapperBuilderTest {

   @Test
   public void shouldWriteAndReadRowEntryUsingCsvMapper() throws IOException {
      //given:
      File file = File.createTempFile(UUID.randomUUID().toString(), ".csv");
      DozerBeanMapper mapper = getBuilder().buildBeanMapper(Row.class);
      CellProcessor[] processors = getBuilder().getCellProcessors();
      String[] headers = getBuilder().getColumnNames();

      //when:
      CsvDozerBeanWriter writer = new CsvDozerBeanWriter(new FileWriter(file), CsvPreference.STANDARD_PREFERENCE,
            mapper);
      writer.writeHeader(headers);
      writer.write(Rows.row1, processors);
      writer.write(Rows.row2, processors);
      writer.flush();
      writer.close();

      //then:
      assertThat(file.length()).isGreaterThan(0l);

      //when:
      CsvDozerBeanReader reader = new CsvDozerBeanReader(new FileReader(file), CsvPreference.STANDARD_PREFERENCE,
            mapper);
      System.out.println(Arrays.toString(reader.getHeader(true)));
      Row row1 = reader.read(Row.class, processors);
      Row row2 = reader.read(Row.class, processors);
      reader.close();

      //then:
      assertThat(row1).isEqualTo(Rows.row1);
      assertThat(row2).isEqualTo(Rows.row2);
   }

   @Test
   public void shouldReadRowsFromExistingCsvFileUsingCsvMpperHeaderColumnConfigurer() throws IOException {
      //given:
      File csvFile = new File("src/test/resources/csv/example.csv");
      CsvMapperBuilder mapperBuilder = CsvMapperBuilder.withHeadersFromCsvFile(csvFile,
            new CsvMapperHeaderColumnsConfigurer());
      CellProcessor[] processors = mapperBuilder.getCellProcessors();
      CsvDozerBeanReader reader = mapperBuilder.getBeanReader(csvFile, Row.class);

      //when:
      Row row1 = reader.read(Row.class, processors);
      Row row2 = reader.read(Row.class, processors);
      reader.close();

      //then:
      assertThat(row1).isEqualTo(Rows.row1);
      assertThat(row2).isEqualTo(Rows.row2);
   }

   private CsvMapperBuilder getBuilder() {
      return new CsvMapperBuilder(CsvPreference.STANDARD_PREFERENCE).add(column("header.invoiceNumber"))
            .add(column("header.type")).add(column("header.issued").type(Date.class).processor(new DateProcessor()))
            .add(column("header.dueDate").type(Date.class).processor(new DateProcessor()))
            .add(column("header.reference")).add(column("header.customerNumber"))
            .add(column("header.currency").type(CurrencyCode.class)).add(column("header.note"))
            .add(column("recipient.name")).add(column("recipient.contactName")).add(column("recipient.addressLine1"))
            .add(column("recipient.addressLine2")).add(column("recipient.city")).add(column("recipient.postcode"))
            .add(column("recipient.countryCode").type(CountryCode.class)).add(column("recipient.email"))
            .add(column("recipient.taxes[0].number"))
            .add(column("recipient.taxes[0].type").type(Reference.class).processor(new ReferenceProcessor()))
            .add(column("recipient.taxes[1].number"))
            .add(column("recipient.taxes[1].type").type(Reference.class).processor(new ReferenceProcessor()))
            .add(column("recipient.bankInfo.bankName")).add(column("recipient.bankInfo.bic"))
            .add(column("recipient.bankInfo.iban")).add(column("issuer.name")).add(column("issuer.contactName"))
            .add(column("issuer.addressLine1")).add(column("issuer.addressLine2")).add(column("issuer.city"))
            .add(column("issuer.postcode")).add(column("issuer.countryCode").type(CountryCode.class))
            .add(column("issuer.email")).add(column("issuer.taxes[0].number"))
            .add(column("issuer.taxes[0].type").type(Reference.class).processor(new ReferenceProcessor()))
            .add(column("issuer.bankInfo.bankName")).add(column("issuer.bankInfo.bic"))
            .add(column("issuer.bankInfo.iban")).add(column("items[0].name"))
            .add(column("items[0].quantity").type(BigDecimal.class))
            .add(column("items[0].unit").type(UnitOfMeasurement.class).processor(new UnitOfMeasurementProcessor()))
            .add(column("items[0].unitPrice").type(BigDecimal.class))
            .add(column("items[0].taxPercent").type(BigDecimal.class))

            .add(column("items[1].name")).add(column("items[1].quantity").type(BigDecimal.class))
            .add(column("items[1].unit").type(UnitOfMeasurement.class).processor(new UnitOfMeasurementProcessor()))
            .add(column("items[1].unitPrice").type(BigDecimal.class))
            .add(column("items[1].taxPercent").type(BigDecimal.class));
   }
}
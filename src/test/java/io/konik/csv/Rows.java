package io.konik.csv;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;

import io.konik.csv.model.Row;
import io.konik.zugferd.unece.codes.Reference;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;

public class Rows {

   public static Row row1;
   public static Row row2;

   static {

      Row.TradeParty recipient = new Row.TradeParty().setName("Lorem Ipsum LTD").setContactName("Joe Doe")
            .setAddressLine1("Baker Street 21").setCity("London").setPostcode("8231233")
            .setEmail("joedoe@loremipsumltd.com").setCountryCode(CountryCode.DE)
            .addTax(new Row.Tax("UK2123432123", Reference.FC)).addTax(new Row.Tax("UK1231232322", Reference.VA));

      row1 = new Row();
      row1.setHeader(
            new Row.Header().setInvoiceNumber("INVOICE/2015/11/22").setType("Rechnung").setDueDate(parse("2015-12-31"))
                  .setIssued(parse("2015-12-14")).setNote("This is simple note in two separate lines")
                  .setCurrency(CurrencyCode.EUR).setReference("lorem@ipsum.com").setCustomerNumber("123123123123"));
      row1.setRecipient(recipient);
      row1.setIssuer(new Row.TradeParty().setName("Microsoft").setContactName("Bill Gates")
            .setAddressLine1("Silicon Valley 21").setCity("Los Angeles, California").setPostcode("8323443")
            .setEmail("contact@billgatesmicrosoft.com").setCountryCode(CountryCode.US)
            .addTax(new Row.Tax("US123123345345", Reference.FC)).setBankInfo(new Row.BankInformation()
                  .setBankName("Test Bank Account").setBic("TESTBNK").setIban("PL123123123123132")));
      row1.setItems(Arrays.asList(
            new Row.Item().setName("Computer mouse").setQuantity(BigDecimal.ONE).setTaxPercent(BigDecimal.valueOf(19))
                  .setUnit(UnitOfMeasurement.UNIT).setUnitPrice(BigDecimal.valueOf(79)),
            new Row.Item().setName("Transport service").setQuantity(BigDecimal.ONE)
                  .setTaxPercent(BigDecimal.valueOf(19)).setUnit(UnitOfMeasurement.UNIT)
                  .setUnitPrice(BigDecimal.valueOf(9.99))));

      row2 = new Row();
      row2.setHeader(new Row.Header().setInvoiceNumber("INVOICE/2015/11/23").setType("Rechnung")
            .setDueDate(parse("2015-12-29")).setIssued(parse("2015-12-15")).setNote("email: qweqwe@test.com")
            .setCurrency(CurrencyCode.EUR).setReference("lorem@ipsum.com").setCustomerNumber("123123123123"));
      row2.setRecipient(recipient);
      row2.setIssuer(new Row.TradeParty().setName("Test Company LTD").setAddressLine1("Test Street 2").setCity("Berlin")
            .setPostcode("34234").setCountryCode(CountryCode.DE).addTax(new Row.Tax("DE123123123", Reference.FC))
            .setBankInfo(new Row.BankInformation().setBankName("Test Bank Account").setBic("TESTBNK")
                  .setIban("PL123123123123132")));
      row2.setItems(Arrays.asList(
            new Row.Item().setName("Beer").setQuantity(BigDecimal.valueOf(8)).setTaxPercent(BigDecimal.valueOf(8))
                  .setUnit(UnitOfMeasurement.LITRE).setUnitPrice(BigDecimal.valueOf(17))));
   }

   static Date parse(String str) {
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

      try {
         return dateFormat.parse(str);
      } catch (ParseException e) {
      }

      return null;
   }
}

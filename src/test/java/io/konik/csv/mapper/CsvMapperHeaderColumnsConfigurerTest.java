package io.konik.csv.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CsvMapperHeaderColumnsConfigurerTest {

   private CsvMapperHeaderColumnsConfigurer configurer = new CsvMapperHeaderColumnsConfigurer();

   @Parameter
   public String header;

   @Parameters(name = "{0}")
   public static Iterable<Object[]> getParams() throws ParseException {
      return Arrays.asList(new Object[] { "header.invoiceNumber" }, new Object[] { "header.type" },
            new Object[] { "header.issued" }, new Object[] { "header.dueDate" }, new Object[] { "header.reference" },
            new Object[] { "header.customerNumber" }, new Object[] { "header.currency" },
            new Object[] { "header.note" },

            new Object[] { "recipient.name" }, new Object[] { "recipient.contactName" },
            new Object[] { "recipient.addressLine1" }, new Object[] { "recipient.addressLine2" },
            new Object[] { "recipient.city" }, new Object[] { "recipient.postcode" },
            new Object[] { "recipient.countryCode" }, new Object[] { "recipient.email" },
            new Object[] { "recipient.taxes[0].number" }, new Object[] { "recipient.taxes[0].type" },
            new Object[] { "recipient.taxes[1].number" }, new Object[] { "recipient.taxes[1].type" },
            new Object[] { "recipient.taxes[2].number" }, new Object[] { "recipient.taxes[2].type" },
            new Object[] { "recipient.bankInfo.bankName" }, new Object[] { "recipient.bankInfo.bic" },
            new Object[] { "recipient.bankInfo.iban" },

            new Object[] { "issuer.name" }, new Object[] { "issuer.contactName" },
            new Object[] { "issuer.addressLine1" }, new Object[] { "issuer.addressLine2" },
            new Object[] { "issuer.city" }, new Object[] { "issuer.postcode" }, new Object[] { "issuer.countryCode" },
            new Object[] { "issuer.email" }, new Object[] { "issuer.taxes[0].number" },
            new Object[] { "issuer.taxes[0].type" }, new Object[] { "issuer.bankInfo.bankName" },
            new Object[] { "issuer.bankInfo.bic" }, new Object[] { "issuer.bankInfo.iban" },

            new Object[] { "items[0].name" }, new Object[] { "items[0].quantity" }, new Object[] { "items[0].unit" },
            new Object[] { "items[0].unitPrice" }, new Object[] { "items[0].taxPercent" },
            new Object[] { "items[1].name" }, new Object[] { "items[1].quantity" }, new Object[] { "items[1].unit" },
            new Object[] { "items[1].unitPrice" }, new Object[] { "items[1].taxPercent" },
            new Object[] { "items[2].name" }, new Object[] { "items[2].quantity" }, new Object[] { "items[2].unit" },
            new Object[] { "items[2].unitPrice" }, new Object[] { "items[2].taxPercent" });
   }

   @Test
   public void confirmThatColumnDefinitionForGivenHeaderExists() {
      assertThat(configurer.getColumnDefinitionForHeader(header)).isNotNull();
   }

}
package io.konik.csv.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.assertj.core.api.Condition;
import org.assertj.core.data.Index;
import org.junit.Before;
import org.junit.Test;

import com.neovisionaries.i18n.CurrencyCode;

import io.konik.csv.Rows;
import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.TaxRegistration;
import io.konik.zugferd.entity.TradeParty;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.profile.ConformanceLevel;
import io.konik.zugferd.unece.codes.DocumentCode;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;

public class RowToInvoiceConverterTest {

   private Invoice invoice;

   private Row row;

   @Before
   public void setup() {
      row = Rows.row1;
      invoice = RowToInvoiceConverter.convert(row);
   }

   @Test
   public void shouldConvertInvoiceWithConformanceLevelBasic() {
      assertThat(invoice.getContext().getGuideline().getConformanceLevel()).isEqualTo(ConformanceLevel.EXTENDED);
   }

   @Test
   public void shouldConvertInvoiceHeaderNumber() {
      assertThat(invoice.getHeader().getInvoiceNumber()).isEqualTo(row.getHeader().getInvoiceNumber());
   }

   @Test
   public void shouldConvertInvoiceHeaderName() {
      assertThat(invoice.getHeader().getName()).isEqualTo(row.getHeader().getType());
   }

   @Test
   public void shouldConvertDocumentCode() {
      assertThat(invoice.getHeader().getCode()).isEqualTo(DocumentCode._380);
   }

   @Test
   public void shouldConvertNote() {
      assertThat(invoice.getHeader().getNotes()).hasSize(1);

      assertThat(invoice.getHeader().getNotes().get(0).getContents()).hasSize(1)
            .contains("This is simple note in two separate lines", Index.atIndex(0));
   }

   @Test
   public void shouldConvertIssueDate() {
      assertThat(invoice.getHeader().getIssued()).isEqualToIgnoringHours(row.getHeader().getIssued());
   }

   @Test
   public void shouldConvertDueDate() {
      assertThat(invoice.getHeader().getContractualDueDate()).isEqualToIgnoringHours(row.getHeader().getDueDate());
   }

   @Test
   public void shouldConvertBuyer() {
      assertThat(invoice.getTrade().getAgreement().getBuyer()).is(equalToRowTradeParty(row.getRecipient()));
   }

   @Test
   public void shouldConvertBuyerTaxInformation() {
      assertThat(invoice.getTrade().getAgreement().getBuyer().getTaxRegistrations()).hasSize(2);

      assertThat(invoice.getTrade().getAgreement().getBuyer().getTaxRegistrations().get(0))
            .is(equalToRowTradePartyTaxInfo(row.getRecipient().getTaxes().get(0)));

      assertThat(invoice.getTrade().getAgreement().getBuyer().getTaxRegistrations().get(1))
            .is(equalToRowTradePartyTaxInfo(row.getRecipient().getTaxes().get(1)));
   }

   @Test
   public void shouldConvertSeller() {
      assertThat(invoice.getTrade().getAgreement().getSeller()).is(equalToRowTradeParty(row.getIssuer()));
   }

   @Test
   public void shouldConvertSellerTaxInformation() {
      assertThat(invoice.getTrade().getAgreement().getSeller().getTaxRegistrations()).hasSize(1);

      assertThat(invoice.getTrade().getAgreement().getSeller().getTaxRegistrations().get(0))
            .is(equalToRowTradePartyTaxInfo(row.getIssuer().getTaxes().get(0)));
   }

   @Test
   public void shouldConvertCustomerNumber() {
      assertThat(invoice.getTrade().getAgreement().getBuyer().getId()).isEqualTo(row.getHeader().getCustomerNumber());
   }

   @Test
   public void shouldConvertItems() {
      assertThat(invoice.getTrade().getItems()).hasSize(2);

      for (int i = 0; i < row.getItems().size(); i++) {
         assertThat(invoice.getTrade().getItems().get(i))
               .is(equalToRowItem(row.getItems().get(i), row.getHeader().getCurrency()));
      }
   }

   @Test
   public void shouldConvertMonetarySummation() {
      BigDecimal lineTotal = BigDecimal.valueOf(79).add(BigDecimal.valueOf(9.99));
      BigDecimal percent = BigDecimal.valueOf(19);
      BigDecimal taxAmount = lineTotal.multiply(percent.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
      CurrencyCode currency = row.getHeader().getCurrency();

      MonetarySummation summation = invoice.getTrade().getSettlement().getMonetarySummation();

      assertThat(summation.getLineTotal().getCurrency()).isEqualTo(currency);
      assertThat(summation.getLineTotal().getValue()).isEqualTo(lineTotal);

      assertThat(summation.getGrandTotal().getCurrency()).isEqualTo(currency);
      assertThat(summation.getGrandTotal().getValue()).isEqualTo(lineTotal.add(taxAmount));

      assertThat(summation.getTaxBasisTotal().getCurrency()).isEqualTo(currency);
      assertThat(summation.getTaxBasisTotal().getValue()).isEqualTo(lineTotal);

      assertThat(summation.getTaxTotal().getCurrency()).isEqualTo(currency);
      assertThat(summation.getTaxTotal().getValue()).isEqualTo(taxAmount);
   }

   private Condition<TradeParty> equalToRowTradeParty(final Row.TradeParty rowTradeParty) {
      return new Condition<TradeParty>() {
         @Override
         public boolean matches(TradeParty tradeParty) {
            return tradeParty.getName().equals(rowTradeParty.getName())
                  && tradeParty.getContact().getName().equals(rowTradeParty.getContactName())
                  && tradeParty.getContact().getEmail().equals(rowTradeParty.getEmail())
                  && tradeParty.getAddress().getLineOne().equals(rowTradeParty.getAddressLine1())
                  && tradeParty.getAddress().getLineTwo().equals(rowTradeParty.getAddressLine2())
                  && tradeParty.getAddress().getCity().equals(rowTradeParty.getCity())
                  && tradeParty.getAddress().getPostcode().equals(rowTradeParty.getPostcode())
                  && tradeParty.getAddress().getCountry().equals(rowTradeParty.getCountryCode());
         }
      };
   }

   private Condition<TaxRegistration> equalToRowTradePartyTaxInfo(final Row.Tax tax) {
      return new Condition<TaxRegistration>() {
         @Override
         public boolean matches(TaxRegistration taxRegistration) {
            return taxRegistration.getTaxNumber().equals(tax.getNumber())
                  && taxRegistration.getType().equals(tax.getType());
         }
      };
   }

   private Condition<Item> equalToRowItem(final Row.Item rowItem, final CurrencyCode currencyCode) {
      return new Condition<Item>() {
         @Override
         public boolean matches(Item item) {
            BigDecimal lineTotal = rowItem.getQuantity().multiply(rowItem.getUnitPrice());

            return item.getProduct().getName().equals(rowItem.getName())
                  && item.getDelivery().getBilled().getUnit().equals(rowItem.getUnit())
                  && item.getDelivery().getBilled().getValue().equals(rowItem.getQuantity())
                  && item.getDelivery().getBilled().getUnitCode().equals(rowItem.getUnit().getCode())
                  && item.getAgreement().getNetPrice().getChargeAmount().getValue().equals(rowItem.getUnitPrice())
                  && item.getAgreement().getNetPrice().getChargeAmount().getCurrency().equals(currencyCode)
                  && item.getAgreement().getGrossPrice().getChargeAmount().getValue().equals(rowItem.getUnitPrice())
                  && item.getAgreement().getGrossPrice().getChargeAmount().getCurrency().equals(currencyCode)
                  && item.getSettlement().getTradeTax().size() == 1
                  && item.getSettlement().getTradeTax().get(0).getPercentage().equals(rowItem.getTaxPercent())
                  && item.getSettlement().getTradeTax().get(0).getCategory().equals(TaxCategory.S)
                  && item.getSettlement().getTradeTax().get(0).getType().equals(TaxCode.VAT)
                  && item.getSettlement().getMonetarySummation().getLineTotal().getCurrency().equals(currencyCode)
                  && item.getSettlement().getMonetarySummation().getLineTotal().getValue().equals(lineTotal);
         }
      };
   }
}
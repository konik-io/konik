package io.konik.calculation;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Test;

import io.konik.InvoiceTransformer;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;

public class InvoiceCalculatorTest {

   @Test
   public void shouldCorrectInvoiceMonetarySummationAndItemsSpecifiedMonetarySummations() {
      //given:
      InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges.xml");
      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(xml);
      InvoiceCalculator calculator = new InvoiceCalculator(invoice);

      //when:
      Invoice calculatedInvoice = calculator.complete();

      //then:
      assertThat(invoice.getTrade().getSettlement().getMonetarySummation())
            .isNotEqualTo(calculatedInvoice.getTrade().getSettlement().getMonetarySummation());

      for (int i = 0; i < invoice.getTrade().getItems().size(); i++) {
         SpecifiedMonetarySummation monetarySummation = invoice.getTrade().getItems().get(i).getSettlement()
               .getMonetarySummation();

         if (monetarySummation != null) {
            assertThat(monetarySummation)
                  .isNotEqualTo(calculatedInvoice.getTrade().getItems().get(i).getSettlement().getMonetarySummation());
         }
      }
   }

   @Test
   public void shouldCorrectInvoiceTradeTaxList() {
      //given:
      InputStream xml = getClass().getResourceAsStream("/ZUGFeRD-without-trade-tax.xml");
      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(xml);
      InvoiceCalculator corrector = new InvoiceCalculator(invoice);

      //when:
      Invoice corrected = corrector.complete();

      //then:
      assertThat(invoice.getTrade().getSettlement().getTradeTax()).isEmpty();

      assertThat(corrected.getTrade().getSettlement().getTradeTax()).hasSize(1);

      assertThat(corrected.getTrade().getSettlement().getTradeTax().get(0).getCalculated().getValue())
            .isEqualByComparingTo(BigDecimal.valueOf(2.40));

      assertThat(corrected.getTrade().getSettlement().getTradeTax().get(0).getBasis().getValue())
            .isEqualByComparingTo(BigDecimal.valueOf(30.0));

      assertThat(corrected.getTrade().getSettlement().getTradeTax().get(0).getPercentage())
            .isEqualByComparingTo(BigDecimal.valueOf(8.0));
   }
}
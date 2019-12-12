package io.konik.validation;

import io.konik.validation.AmountCalculator.TaxAggregator;
import io.konik.zugferd.entity.Tax;
import io.konik.zugferd.entity.trade.TradeTax;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxAggregatorTest {

   private Tax vat19 = new TradeTax().setPercentage(BigDecimal.valueOf(19)).setType(TaxCode.VAT)
         .setCategory(TaxCategory.C);

   private Tax vat23 = new TradeTax().setPercentage(BigDecimal.valueOf(23)).setType(TaxCode.VAT)
         .setCategory(TaxCategory.C);

   @Test
   public void taxBasisForEmptyTaxAggregatorIsEqualToZero() {
      //given:
      TaxAggregator aggregator = new TaxAggregator();
      //when:
      BigDecimal value = aggregator.calculateTaxBasis();
      //then:
      assertThat(value).isEqualByComparingTo(BigDecimal.ZERO);
   }

   @Test
   public void taxTotalForEmptyTaxAggregatorIsEqualToZero() {
      //given:
      TaxAggregator aggregator = new TaxAggregator();
      //when:
      BigDecimal value = aggregator.calculateTaxTotal();
      //then:
      assertThat(value).isEqualByComparingTo(BigDecimal.ZERO);
   }

   @Test
   public void shouldCalculateTaxBasisFromAddedTaxAmounts() {
      //given:
      TaxAggregator aggregator = new TaxAggregator();
      aggregator.add(vat19, BigDecimal.valueOf(100));
      aggregator.add(vat19, BigDecimal.valueOf(54));
      aggregator.add(vat19, BigDecimal.valueOf(2.34));
      aggregator.add(vat23, BigDecimal.valueOf(50));
      aggregator.add(vat23, BigDecimal.valueOf(99.99));
      //when:
      BigDecimal taxBasis = aggregator.calculateTaxBasis();
      //then:
      assertThat(taxBasis).isEqualByComparingTo(BigDecimal.valueOf(306.33));
   }

   @Test
   public void shouldCalculateTaxTotalFromAddedTaxAmounts() {
      //given:
      TaxAggregator aggregator = new TaxAggregator();
      aggregator.add(vat19, BigDecimal.valueOf(100));
      aggregator.add(vat19, BigDecimal.valueOf(54));
      aggregator.add(vat19, BigDecimal.valueOf(2.34));
      aggregator.add(vat23, BigDecimal.valueOf(50));
      aggregator.add(vat23, BigDecimal.valueOf(99.99));
      //when:
      BigDecimal taxBasis = aggregator.calculateTaxTotal();
      //then:
      assertThat(taxBasis).isEqualByComparingTo(BigDecimal.valueOf(64.20));
   }
}
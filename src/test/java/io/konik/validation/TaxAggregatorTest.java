package io.konik.validation;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import io.konik.zugferd.entity.Tax;
import io.konik.zugferd.entity.trade.TradeTax;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;

public class TaxAggregatorTest {

  private static List<Tax> vat19 = new ArrayList<Tax>();

  private static List<Tax> vat23 = new ArrayList<Tax>();

  @BeforeClass
  public static void setUp() {
    vat19.add(new TradeTax().setPercentage(BigDecimal.valueOf(19)).setType(TaxCode.VAT)
        .setCategory(TaxCategory.C));
    vat23.add(new TradeTax().setPercentage(BigDecimal.valueOf(23)).setType(TaxCode.VAT)
        .setCategory(TaxCategory.C));
  }

  @Test
  public void taxBasisForEmptyTaxAggregatorIsEqualToZero() {
    // given:
    TaxAggregator aggregator = new TaxAggregator();
    // when:
    BigDecimal value = aggregator.calculateTaxBasis();
    // then:
    assertThat(value).isEqualByComparingTo(BigDecimal.ZERO);
  }

  @Test
  public void taxTotalForEmptyTaxAggregatorIsEqualToZero() {
    // given:
    TaxAggregator aggregator = new TaxAggregator();
    // when:
    BigDecimal value = aggregator.calculateTaxTotal();
    // then:
    assertThat(value).isEqualByComparingTo(BigDecimal.ZERO);
  }

  @Test
  public void shouldCalculateTaxBasisFromAddedTaxAmounts() {
    // given:
    List<Item> items = new ArrayList<Item>();
    TaxAggregator aggregator = new TaxAggregator();
    aggregator.add(vat19, BigDecimal.valueOf(100));
    aggregator.add(vat19, BigDecimal.valueOf(54));
    aggregator.add(vat19, BigDecimal.valueOf(2.34));
    aggregator.add(vat19, BigDecimal.valueOf(50));
    aggregator.add(vat19, BigDecimal.valueOf(99.99));

    // when:
    BigDecimal taxBasis = aggregator.calculateTaxBasis();
    // then:
    assertThat(taxBasis).isEqualByComparingTo(BigDecimal.valueOf(306.33));
  }

  @Test
  public void shouldCalculateTaxTotalFromAddedTaxAmounts() {
    // given:
    TaxAggregator aggregator = new TaxAggregator();
    aggregator.add(vat19, BigDecimal.valueOf(100));
    aggregator.add(vat19, BigDecimal.valueOf(54));
    aggregator.add(vat19, BigDecimal.valueOf(2.34));
    aggregator.add(vat23, BigDecimal.valueOf(50));
    aggregator.add(vat23, BigDecimal.valueOf(99.99));
    // when:
    BigDecimal taxBasis = aggregator.calculateTaxTotal();
    // then:
    assertThat(taxBasis).isEqualByComparingTo(BigDecimal.valueOf(64.20));
  }
}

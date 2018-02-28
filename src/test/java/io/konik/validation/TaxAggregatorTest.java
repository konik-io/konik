package io.konik.validation;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.zugferd.entity.Price;
import io.konik.zugferd.entity.Tax;
import io.konik.zugferd.entity.trade.TradeTax;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.SpecifiedAgreement;
import io.konik.zugferd.entity.trade.item.SpecifiedDelivery;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Quantity;

public class TaxAggregatorTest {

  private Tax vat19 = new TradeTax().setPercentage(BigDecimal.valueOf(19)).setType(TaxCode.VAT)
      .setCategory(TaxCategory.C);

  private Tax vat23 = new TradeTax().setPercentage(BigDecimal.valueOf(23)).setType(TaxCode.VAT)
      .setCategory(TaxCategory.C);

  @Test
  public void taxBasisForEmptyTaxAggregatorIsEqualToZero() {
    // given:
    TaxAggregator aggregator = new TaxAggregator();
    List<Item> items = new ArrayList<Item>();
    // when:
    BigDecimal value = aggregator.calculateTaxBasis(items);
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
    items
        .add(new Item().setDelivery(new SpecifiedDelivery(new Quantity(10, UnitOfMeasurement.UNIT)))
            .setAgreement(new SpecifiedAgreement()
                .setNetPrice(new Price(new Amount(BigDecimal.valueOf(10), CurrencyCode.EUR)))));
    items.add(new Item().setDelivery(new SpecifiedDelivery(new Quantity(2, UnitOfMeasurement.UNIT)))
        .setAgreement(new SpecifiedAgreement()
            .setNetPrice(new Price(new Amount(BigDecimal.valueOf(27), CurrencyCode.EUR)))));
    items.add(new Item().setDelivery(new SpecifiedDelivery(new Quantity(1, UnitOfMeasurement.UNIT)))
        .setAgreement(new SpecifiedAgreement()
            .setNetPrice(new Price(new Amount(BigDecimal.valueOf(2.34), CurrencyCode.EUR)))));
    items.add(new Item().setDelivery(new SpecifiedDelivery(new Quantity(1, UnitOfMeasurement.UNIT)))
        .setAgreement(new SpecifiedAgreement()
            .setNetPrice(new Price(new Amount(BigDecimal.valueOf(50), CurrencyCode.EUR)))));
    items.add(new Item().setDelivery(new SpecifiedDelivery(new Quantity(1, UnitOfMeasurement.UNIT)))
        .setAgreement(new SpecifiedAgreement()
            .setNetPrice(new Price(new Amount(BigDecimal.valueOf(99.99), CurrencyCode.EUR)))));
    // when:
    BigDecimal taxBasis = aggregator.calculateTaxBasis(items);
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

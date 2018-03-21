/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import java.math.BigDecimal;
import io.konik.zugferd.entity.Tax;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;

/**
 * Helper key for {@link TaxAggregator}
 */
final class TaxKey {
  private final BigDecimal percentage;
  private final TaxCode code;
  private final TaxCategory category;

  private TaxKey(final Tax tax) {
    this.percentage = tax.getPercentage();
    this.category = tax.getCategory();
    this.code = tax.getType();
  }

  public static TaxKey create(final Tax tax) {
    return new TaxKey(tax);
  }

  public BigDecimal getPercentage() {
    return percentage;
  }

  public TaxCode getCode() {
    return code;
  }

  public TaxCategory getCategory() {
    return category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof TaxKey))
      return false;

    TaxKey key = (TaxKey) o;

    if (!percentage.equals(key.percentage))
      return false;
    if (code != key.code)
      return false;
    return category == key.category;

  }

  @Override
  public int hashCode() {
    int result = percentage.hashCode();
    result = 31 * result + (code != null ? code.hashCode() : 0);
    result = 31 * result + (category != null ? category.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Key{" + "percentage=" + percentage + ", code=" + code + ", category=" + category + '}';
  }
}

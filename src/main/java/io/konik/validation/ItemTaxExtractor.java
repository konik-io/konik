/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import javax.annotation.Nullable;
import com.google.common.base.Function;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.ItemTax;

final class ItemTaxExtractor implements Function<Item, ItemTax> {
  @Nullable
  @Override
  public ItemTax apply(@Nullable Item item) {
    if (item == null || item.getSettlement() == null) {
      return null;
    }

    if (item.getSettlement().getTradeTax().isEmpty()) {
      return null;
    }

    return item.getSettlement().getTradeTax().size() > 1 ? item.getSettlement().getTradeTax().get(1)
        : item.getSettlement().getTradeTax().get(0);
  }
}

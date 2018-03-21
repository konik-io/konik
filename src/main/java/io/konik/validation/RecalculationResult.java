/* Copyright 2018 objective partner AG, all rights reserved */
package io.konik.validation;

import io.konik.zugferd.entity.trade.MonetarySummation;

public class RecalculationResult {

  private final MonetarySummation monetarySummation;
  private final TaxAggregator taxAggregator;

  public RecalculationResult(MonetarySummation monetarySummation, TaxAggregator taxAggregator) {
    this.monetarySummation = monetarySummation;
    this.taxAggregator = taxAggregator;
  }

  public MonetarySummation getMonetarySummation() {
    return monetarySummation;
  }

  public TaxAggregator getTaxAggregator() {
    return taxAggregator;
  }
}

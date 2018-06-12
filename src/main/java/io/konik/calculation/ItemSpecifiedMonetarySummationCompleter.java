package io.konik.calculation;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.konik.util.Items;
import io.konik.validation.AmountCalculator;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;

/**
 * Recalculates {@link SpecifiedMonetarySummation} for every {@link Item} and replaces old object with the new one.
 */
public final class ItemSpecifiedMonetarySummationCompleter implements Correction<Invoice> {

   protected static Logger log = LoggerFactory.getLogger(ItemSpecifiedMonetarySummationCompleter.class);

   @Override
   public Invoice correct(@NotNull final Invoice invoice) {

      log.debug("Running ItemSpecifiedMonetarySummationCompleter...");

      if (invoice.getTrade() != null && invoice.getTrade().getItems() != null) {
         List<Item> items = Items.purchasableItemsOnly(invoice.getTrade().getItems());
         for (Item item : items) {
            if (item.getSettlement() != null) {
               SpecifiedMonetarySummation monetarySummation = AmountCalculator
                     .calculateSpecifiedMonetarySummation(item);
               item.getSettlement().setMonetarySummation(monetarySummation);
            }
         }
      }
      return invoice;
   }
}

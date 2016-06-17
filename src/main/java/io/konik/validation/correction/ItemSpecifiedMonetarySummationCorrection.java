package io.konik.validation.correction;

import io.konik.util.Items;
import io.konik.validation.AmountCalculator;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Recalculates {@link SpecifiedMonetarySummation} for every {@link Item} and replaces old object with the new one.
 */
public final class ItemSpecifiedMonetarySummationCorrection implements Correction<Invoice> {

	@Override
	public Invoice correct(@NotNull final Invoice invoice) {
		if (invoice.getTrade() != null && invoice.getTrade().getItems() != null) {
			List<Item> items = Items.purchasableItemsOnly(invoice.getTrade().getItems());
			for (Item item : items) {
				if (item.getSettlement() != null) {
					SpecifiedMonetarySummation monetarySummation = AmountCalculator.calculateSpecifiedMonetarySummation(item);
					item.getSettlement().setMonetarySummation(monetarySummation);
				}
			}
		}
		return invoice;
	}
}

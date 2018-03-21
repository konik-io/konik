package io.konik.util;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import io.konik.zugferd.entity.trade.item.Item;

/**
 * Helper functions for {@link Item} class.
 */
public final class Items {

	/**
	 * Filters list of {@link Item} using given {@link Predicate}
	 * @param items
	 * @param predicate
	 * @return
	 */
	public static List<Item> filter(List<Item> items, Predicate<Item> predicate) {
		return new LinkedList<Item>(Collections2.filter(items, predicate));
	}

	/**
	 * Removes all non-purchasable items (e.g. text information only item etc.)
	 * @param items
	 * @return
	 */
	public static List<Item> purchasableItemsOnly(List<Item> items) {
		return filter(items, new Predicate<Item>() {
			@Override
			public boolean apply(@Nullable Item item) {
				return item != null &&
						item.getDelivery() != null &&
						item.getAgreement() != null &&
						item.getSettlement() != null;
			}
		});
	}
}

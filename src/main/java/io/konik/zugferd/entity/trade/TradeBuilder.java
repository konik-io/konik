package io.konik.zugferd.entity.trade;

import static java.util.Arrays.asList;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.ItemBuilder;

import javax.annotation.Generated;

/**
 * The {@link TradeBuilder} is a Builder for {@link Trade} objects.
 * <p>
 * ATTENTION: This class has been generated. If you want to ADD HANDWRITTEN CODE, please MOVE THIS FILE out of
 * the generated-sources folder in order to prevent it from being overwritten by the PojoBuilder generator!
 * </p>
 */
@Generated("PojoBuilder")
public class TradeBuilder extends AbstractTradeBuilder {
	public TradeBuilder() {}

	public TradeBuilder addItem(ItemBuilder additionalItem) {
		return addItem(additionalItem.build());
	}
	
	public TradeBuilder addItem(Item additionalItem) {
		return self.items(asList(additionalItem));
	}
}

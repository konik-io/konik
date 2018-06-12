package io.konik.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.validation.constraints.NotNull;

import io.konik.util.Amounts;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.Trade;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.ItemTax;
import io.konik.zugferd.entity.trade.item.SpecifiedSettlement;
import io.konik.zugferd.unqualified.Amount;

public class InvoiceTaxCompleter implements Correction<Invoice> {

   @Override
   public Invoice correct(@NotNull Invoice invoice) {

      if (invoice != null && invoice.getTrade() != null && invoice.getTrade().getItems() != null) {
         Trade trade = invoice.getTrade();

         for (Item item : trade.getItems()) {
            SpecifiedSettlement settlement = item.getSettlement();

            if (settlement.getMonetarySummation() != null) {
               Amount lineTotal = settlement.getMonetarySummation().getLineTotal();

               if (lineTotal != null) {
                  if (settlement.getTradeTax() != null) {
                     for (ItemTax tax : settlement.getTradeTax()) {
                        if (tax.getPercentage() != null) {
                           BigDecimal value = lineTotal.getValue();
                           BigDecimal calculated = value.multiply(tax.getPercentage().divide(BigDecimal.valueOf(100)))
                                 .setScale(2, RoundingMode.HALF_UP);

                           tax.setCalculated(new Amount(calculated, lineTotal.getCurrency()));
                        } else {
                           tax.setCalculated(Amounts.zero(lineTotal.getCurrency()));
                        }
                     }
                  }
               } else {
                  if (settlement.getTradeTax() != null) {
                     settlement.getTradeTax().clear();
                  }
               }
            }
         }
      }
      return invoice;
   }
}

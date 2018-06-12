package io.konik.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import io.konik.InvoiceTransformer;
import io.konik.util.Items;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;

@RunWith(Parameterized.class)
public class AmountCalculatorCalculateSpecifiedMonetarySummationTest {

   @Parameterized.Parameters(name = "Calculating specified monetary summation for object with index = {index}")
   public static Collection<Object[]> data() throws IOException {
      InputStream xml = AmountCalculatorCalculateSpecifiedMonetarySummationTest.class
            .getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges.xml");

      InvoiceTransformer transformer = new InvoiceTransformer();
      Invoice invoice = transformer.toModel(xml);
      List<Item> items = Items.purchasableItemsOnly(invoice.getTrade().getItems());

      Object[][] objects = new Object[items.size()][1];
      for (int i = 0; i < items.size(); i++) {
         objects[i][0] = items.get(i);
      }
      return Arrays.asList(objects);
   }

   @Parameterized.Parameter
   public Item item;

   @Test
   public void test() {
      //when:
      SpecifiedMonetarySummation monetarySummation = AmountCalculator.calculateSpecifiedMonetarySummation(item);

      //then:
      assertThat(item.getSettlement().getMonetarySummation().getLineTotal())
            .isEqualToComparingFieldByField(monetarySummation.getLineTotal());

      assertThat(item.getSettlement().getMonetarySummation().getTotalAllowanceCharge().getValue())
            .isEqualByComparingTo(monetarySummation.getTotalAllowanceCharge().getValue());
   }
}
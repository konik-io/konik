package io.konik.csv.converter;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.*;
import io.konik.zugferd.entity.trade.Agreement;
import io.konik.zugferd.entity.trade.Settlement;
import io.konik.zugferd.entity.trade.Trade;
import io.konik.zugferd.entity.trade.item.*;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

final public class InvoiceToRowConverter {

   public static Row convert(Invoice invoice) {
      if (invoice == null) {
         throw new IllegalArgumentException("Invoice cannot be null");
      }

      return new Process().run(invoice);
   }

   private static class Process {
      public Row run(Invoice invoice) {
         Row row = new Row();
         row.setHeader(mapHeader(invoice));

         Trade trade = invoice.getTrade();
         if (trade != null) {

            Agreement agreement = trade.getAgreement();
            if (agreement != null) {

               if (agreement.getBuyer() != null) {
                  row.setRecipient(mapTradeParty(agreement.getBuyer()));
               } else {
                  row.setRecipient(new Row.TradeParty());
               }

               if (agreement.getSeller() != null) {
                  row.setIssuer(mapTradeParty(agreement.getSeller()));
               } else {
                  row.setIssuer(new Row.TradeParty());
               }
            }

            Settlement settlement = trade.getSettlement();
            if (settlement != null) {

               if (settlement.getPaymentMeans() != null && !settlement.getPaymentMeans().isEmpty()) {
                  PaymentMeans paymentMeans = settlement.getPaymentMeans().get(0);

                  if (paymentMeans.getInformations() != null && !paymentMeans.getInformations().isEmpty()) {
                     row.setComments(paymentMeans.getInformations().get(0));
                  }

                  Row.BankInformation bankInformation = new Row.BankInformation();
                  if (paymentMeans.getPayeeAccount() != null) {
                     bankInformation.setIban(paymentMeans.getPayeeAccount().getIban());
                  }

                  if (paymentMeans.getPayeeInstitution() != null) {
                     bankInformation.setBankName(paymentMeans.getPayeeInstitution().getName())
                           .setBic(paymentMeans.getPayeeInstitution().getBic());
                  }

                  row.getIssuer().setBankInfo(bankInformation);
               }
            }

            List<Row.Item> items = Lists.transform(trade.getItems(), new Function<Item, Row.Item>() {
               @Nullable
               @Override
               public Row.Item apply(@Nullable Item item) {
                  Row.Item rowItem = new Row.Item();
                  if (item != null) {
                     rowItem.setName(item.getProduct() != null ? item.getProduct().getName() : "");

                     SpecifiedDelivery delivery = item.getDelivery();
                     if (delivery != null && delivery.getBilled() != null) {
                        rowItem.setQuantity(delivery.getBilled().getValue())
                              .setUnit(delivery.getBilled().getUnit());
                     }

                     SpecifiedAgreement agreement = item.getAgreement();
                     if (agreement != null && agreement.getNetPrice() != null) {
                        rowItem.setUnitPrice(agreement.getNetPrice().getChargeAmount().getValue());
                     }

                     SpecifiedSettlement settlement = item.getSettlement();
                     if (settlement != null && settlement.getTradeTax() != null
                           && !settlement.getTradeTax().isEmpty()) {
                        SpecifiedTax tradeTax = settlement.getTradeTax().get(0);

                        rowItem.setTaxPercent(tradeTax.getPercentage());
                     }
                  }
                  return rowItem;
               }
            });

            row.setItems(items);
         }

         return row;
      }

      private static Row.TradeParty mapTradeParty(TradeParty tradeParty) {
         Row.TradeParty rowTradeParty = new Row.TradeParty();

         rowTradeParty.setName(tradeParty.getName());

         Address address = tradeParty.getAddress();
         if (Objects.nonNull(address)) {
            rowTradeParty.setAddressLine1(address.getLineOne())
                  .setAddressLine2(address.getLineTwo())
                  .setCity(address.getCity())
                  .setCountryCode(address.getCountry())
                  .setPostcode(address.getPostcode());
         }

         Contact contact = tradeParty.getContact();
         if (Objects.nonNull(contact)) {
            rowTradeParty.setContactName(contact.getName())
                  .setEmail(contact.getEmail());
         }

         List<TaxRegistration> taxRegistrations = tradeParty.getTaxRegistrations();
         if (Objects.nonNull(taxRegistrations) && !taxRegistrations.isEmpty()) {
            rowTradeParty.setTaxes(Lists.transform(taxRegistrations, new Function<TaxRegistration, Row.Tax>() {
               @Nullable
               @Override
               public Row.Tax apply(TaxRegistration taxRegistration) {
                  Row.Tax tax = new Row.Tax();
                  if (Objects.nonNull(taxRegistration)) {
                     tax.setNumber(taxRegistration.getTaxNumber())
                           .setType(taxRegistration.getType());
                  }
                  return tax;
               }
            }));
         }

         return rowTradeParty;
      }

      private static Row.Header mapHeader(Invoice invoice) {
         Header header = invoice.getHeader();

         if (Objects.nonNull(header)) {
            CurrencyCode currencyCode = null;
            String paymentReference = null;
            String customerNumber = null;
            String noteText = null;

            Trade trade = invoice.getTrade();
            if (trade != null) {
               Settlement settlement = trade.getSettlement();
               Agreement agreement = trade.getAgreement();

               if (settlement != null) {
                  currencyCode = settlement.getCurrency();
                  paymentReference = settlement.getPaymentReference();
               }

               if (agreement != null) {
                  TradeParty buyer = agreement.getBuyer();

                  if (buyer != null) {
                     customerNumber = buyer.getId();
                  }
               }
            }

            if (header.getNotes() != null && !header.getNotes().isEmpty()) {
               Note note = header.getNotes().get(0);

               if (note != null && note.getContents() != null && !note.getContents().isEmpty()) {
                  noteText = note.getContents().get(0);
               }
            }

            Date issued = header.getIssued() != null ? new Date(header.getIssued().getTime()) : null;
            Date dueDate = header.getContractualDueDate() != null ? new Date(header.getContractualDueDate().getTime())
                  : null;

            return new Row.Header().setInvoiceNumber(header.getInvoiceNumber())
                  .setType(header.getName())
                  .setCurrency(currencyCode)
                  .setReference(paymentReference)
                  .setCustomerNumber(customerNumber)
                  .setIssued(issued)
                  .setDueDate(dueDate)
                  .setNote(noteText);
         }

         return new Row.Header();
      }
   }
}

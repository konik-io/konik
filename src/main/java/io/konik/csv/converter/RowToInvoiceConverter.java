package io.konik.csv.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.neovisionaries.i18n.CurrencyCode;

import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.Address;
import io.konik.zugferd.entity.Contact;
import io.konik.zugferd.entity.CreditorFinancialAccount;
import io.konik.zugferd.entity.FinancialInstitution;
import io.konik.zugferd.entity.GrossPrice;
import io.konik.zugferd.entity.Header;
import io.konik.zugferd.entity.Note;
import io.konik.zugferd.entity.PaymentMeans;
import io.konik.zugferd.entity.PositionDocument;
import io.konik.zugferd.entity.Price;
import io.konik.zugferd.entity.Product;
import io.konik.zugferd.entity.TaxRegistration;
import io.konik.zugferd.entity.TradeParty;
import io.konik.zugferd.entity.trade.Agreement;
import io.konik.zugferd.entity.trade.Delivery;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.Settlement;
import io.konik.zugferd.entity.trade.Trade;
import io.konik.zugferd.entity.trade.TradeTax;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.ItemTax;
import io.konik.zugferd.entity.trade.item.SpecifiedAgreement;
import io.konik.zugferd.entity.trade.item.SpecifiedDelivery;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import io.konik.zugferd.entity.trade.item.SpecifiedSettlement;
import io.konik.zugferd.profile.ConformanceLevel;
import io.konik.zugferd.unece.codes.DocumentCode;
import io.konik.zugferd.unece.codes.TaxCategory;
import io.konik.zugferd.unece.codes.TaxCode;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Quantity;
import io.konik.zugferd.unqualified.ZfDateDay;

/**
 * Converter from {@link Row} to {@link Invoice}
 */
public class RowToInvoiceConverter {

	private static final ConcurrentMap<String, DocumentCode> codes = new ConcurrentHashMap<String, DocumentCode>();

	static {
		codes.put("rechnung", DocumentCode._380);
		codes.put("gutschriftsanzeige", DocumentCode._380);
		codes.put("angebot", DocumentCode._310);
		codes.put("bestellung", DocumentCode._220);
		codes.put("proformarechnung", DocumentCode._325);
		codes.put("teilrechnung", DocumentCode._326);
		codes.put("korrigierte rechnung", DocumentCode._384);
		codes.put("konsolidierte rechnung", DocumentCode._385);
		codes.put("vorauszahlungsrechnung", DocumentCode._386);
		codes.put("invoice", DocumentCode._380);
		codes.put("credit note", DocumentCode._381);
		codes.put("offer", DocumentCode._310);
		codes.put("order", DocumentCode._220);
		codes.put("proforma invoice", DocumentCode._325);
		codes.put("partial invoice", DocumentCode._326);
		codes.put("corrected invoice", DocumentCode._384);
		codes.put("consolidated invoice", DocumentCode._385);
		codes.put("prepayment invoice", DocumentCode._386);
	}

	public static Invoice convert(Row row) {
		Objects.requireNonNull(row);

		return new Process().run(row);
	}

	protected static DocumentCode getCode(String code) {
		if (code != null) {
			String key = code.trim().toLowerCase();

			if (codes.containsKey(key)) {
				return codes.get(key);
			}
		}

		return DocumentCode._380;
	}

	/**
	 * Internal class to manage conversion state in a thread safe manner.
	 */
	private static class Process {

		private CurrencyCode currencyCode;
		private String customerNumber;
		private ConcurrentMap<BigDecimal, TaxAccumulator> calculatedTax = new ConcurrentHashMap<BigDecimal, TaxAccumulator>();

		protected Invoice run(Row row) {
			Header header = mapHeader(row.getHeader());

			TradeParty buyer = mapTradeParty(row.getRecipient());
			TradeParty seller = mapTradeParty(row.getIssuer());

			Agreement agreement = new Agreement()
					.setBuyer(buyer)
					.setSeller(seller);

			Delivery delivery = new Delivery(header.getIssued());

			Settlement settlement = mapSettlement(row);

			Trade trade = createTrade(row, agreement, delivery, settlement);

			Invoice invoice = new Invoice(ConformanceLevel.EXTENDED);
			invoice.setHeader(header);
			invoice.setTrade(trade);

			return invoice;
		}

		private Trade createTrade(Row row, Agreement agreement, Delivery delivery, Settlement settlement) {
			Trade trade = new Trade()
					.setAgreement(agreement)
					.setDelivery(delivery)
					.setSettlement(settlement);

			for (Item item : transformToItems(row.getItems())) {
				trade.addItem(item);
			}
			return trade;
		}

		private Settlement mapSettlement(Row row) {
			Row.BankInformation bankInformation = row.getIssuer().getBankInfo();
			PaymentMeans paymentMeans = new PaymentMeans()
					.addInformation(row.getComments())
					.setPayeeAccount(new CreditorFinancialAccount(bankInformation.getIban()))
					.setPayeeInstitution(new FinancialInstitution(bankInformation.getBic()).setName(bankInformation.getBankName()));

			computeCalculatedTax(row);

			Settlement settlement = new Settlement()
					.setCurrency(currencyCode)
					.addPaymentMeans(paymentMeans)
					.setPaymentReference(row.getHeader().getReference())
					.setMonetarySummation(calculateMonetarySummation());

			addTradeTaxesFromCalculatedTax(settlement);
			return settlement;
		}

		private MonetarySummation calculateMonetarySummation() {
			MonetarySummation monetarySummation = new MonetarySummation()
					.setLineTotal(new Amount(BigDecimal.ZERO, currencyCode))
					.setChargeTotal(new Amount(BigDecimal.ZERO, currencyCode))
					.setAllowanceTotal(new Amount(BigDecimal.ZERO, currencyCode))
					.setTaxBasisTotal(new Amount(BigDecimal.ZERO, currencyCode))
					.setTaxTotal(new Amount(BigDecimal.ZERO, currencyCode))
					.setGrandTotal(new Amount(BigDecimal.ZERO, currencyCode));

			for (Map.Entry<BigDecimal, TaxAccumulator> entry : calculatedTax.entrySet()) {
				BigDecimal lineTotal = monetarySummation.getLineTotal().getValue();
				BigDecimal taxBasisTotal = monetarySummation.getTaxBasisTotal().getValue();
				BigDecimal taxTotal = monetarySummation.getTaxTotal().getValue();
				BigDecimal grandTotal = monetarySummation.getGrandTotal().getValue();

				BigDecimal curLineTotal = entry.getValue().lineTotal;
				BigDecimal curTaxAmount = entry.getValue().taxAmount;

				monetarySummation.setLineTotal(new Amount(lineTotal.add(curLineTotal), currencyCode));
				monetarySummation.setTaxBasisTotal(new Amount(taxBasisTotal.add(curLineTotal), currencyCode));
				monetarySummation.setTaxTotal(new Amount(taxTotal.add(curTaxAmount), currencyCode));
				monetarySummation.setGrandTotal(new Amount(grandTotal.add(curTaxAmount).add(curLineTotal), currencyCode));
			}
			return monetarySummation;
		}

		private void addTradeTaxesFromCalculatedTax(Settlement settlement) {
			for (Map.Entry<BigDecimal, TaxAccumulator> entry : calculatedTax.entrySet()) {
				BigDecimal lineTotal = entry.getValue().lineTotal;
				BigDecimal taxAmount = entry.getValue().taxAmount;

				TradeTax tradeTax = new TradeTax()
						.setType(TaxCode.VAT)
						.setPercentage(entry.getKey())
						.setCategory(TaxCategory.S)
						.setBasis(new Amount(lineTotal, currencyCode))
						.setCalculated(new Amount(taxAmount, currencyCode));
				tradeTax.setLineTotal(new Amount(lineTotal, currencyCode));

				settlement.addTradeTax(tradeTax);
			}
		}

		private void computeCalculatedTax(Row row) {
			for (Row.Item item : row.getItems()) {
				if (item != null) {
					BigDecimal percent = item.getTaxPercent();
					BigDecimal unitPrice = item.getUnitPrice();
					BigDecimal quantity = item.getQuantity();

					if (unitPrice != null && percent != null && quantity != null) {
						BigDecimal lineTotal = unitPrice.multiply(quantity);
						BigDecimal taxAmount = lineTotal.multiply(
								percent.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)
						);

						TaxAccumulator taxAccumulator = new TaxAccumulator(taxAmount, lineTotal);
						if (calculatedTax.containsKey(percent)) {
							taxAccumulator = calculatedTax.get(percent).accumulate(taxAccumulator);
						}

						calculatedTax.put(percent, taxAccumulator);
					}
				}
			}
		}

		private Header mapHeader(Row.Header rowHeader) {
			Header header = new Header();

			if (rowHeader != null) {
				if (rowHeader.getIssued() != null) {
					header.setIssued(new ZfDateDay(rowHeader.getIssued()));
				}

				if (rowHeader.getDueDate() != null) {
					header.setContractualDueDate(new ZfDateDay(rowHeader.getDueDate()));
				}

				header.setCode(getCode(rowHeader.getType()))
						.setInvoiceNumber(rowHeader.getInvoiceNumber())
						.setName(rowHeader.getType());

				if (!Strings.isNullOrEmpty(rowHeader.getNote())) {
					header.addNote(new Note(rowHeader.getNote()));
				}

				currencyCode = rowHeader.getCurrency();

				customerNumber = rowHeader.getCustomerNumber();
			}

			return header;
		}

		private TradeParty mapTradeParty(Row.TradeParty tradeParty) {
			TradeParty recipient = new TradeParty();

			if (tradeParty != null) {
				recipient.setName(tradeParty.getName())
						.setId(customerNumber)
						.setContact(mapContact(tradeParty))
						.setAddress(mapAddress(tradeParty));

				if (tradeParty.getTaxes() != null) {
					List<TaxRegistration> taxRegistrations = mapTaxRegistrations(tradeParty.getTaxes());
					TaxRegistration[] array = new TaxRegistration[tradeParty.getTaxes().size()];

					recipient.addTaxRegistrations(
							taxRegistrations.toArray(array)
					);
				}
			}

			return recipient;
		}

		private List<TaxRegistration> mapTaxRegistrations(List<Row.Tax> taxes) {
			return Lists.transform(taxes, new Function<Row.Tax, TaxRegistration>() {
				@Nullable
				@Override
				public TaxRegistration apply(Row.Tax tax) {
					return new TaxRegistration(tax.getNumber(), tax.getType());
				}
			});
		}

		private Contact mapContact(Row.TradeParty tradeParty) {
			return new Contact(tradeParty.getContactName(), null, null, null, tradeParty.getEmail());
		}

		private Address mapAddress(Row.TradeParty tradeParty) {
			return new Address(tradeParty.getPostcode(), tradeParty.getAddressLine1(), tradeParty.getAddressLine2(), tradeParty.getCity(), tradeParty.getCountryCode());
		}

		/**
		 * Transforms list of {@link io.konik.csv.model.Row.Item} to {@link Item}
		 * @param items
		 * @return
		 */
		private List<Item> transformToItems(List<Row.Item> items) {
			final AtomicInteger index = new AtomicInteger(0);

			return Lists.transform(items, new Function<Row.Item, Item>() {
				public Item apply(Row.Item rowItem) {
					Item item = new Item();
					if (rowItem != null) {
						String assignedId = String.format("%d", index.incrementAndGet());

						Product product = mapProduct(assignedId, rowItem);

						SpecifiedDelivery delivery = mapDelivery(rowItem);

						SpecifiedSettlement settlement = mapSettlement(rowItem);

						SpecifiedAgreement agreement = mapAgreement(rowItem);

						item.setPosition(new PositionDocument(assignedId));
						item.setProduct(product);
						item.setDelivery(delivery);
						item.setSettlement(settlement);
						item.setAgreement(agreement);
					}
					return item;
				}

				private SpecifiedAgreement mapAgreement(Row.Item rowItem) {
					SpecifiedAgreement agreement = new SpecifiedAgreement();
					agreement.setNetPrice(new Price(new Amount(rowItem.getUnitPrice(), currencyCode)));
					agreement.setGrossPrice(new GrossPrice(new Amount(rowItem.getUnitPrice(), currencyCode)));
					return agreement;
				}

				private SpecifiedSettlement mapSettlement(Row.Item rowItem) {
					ItemTax itemTax = mapItemTax(rowItem);

					SpecifiedMonetarySummation monetarySummation = mapMonetarySummation(rowItem);

					SpecifiedSettlement settlement = new SpecifiedSettlement();
					settlement.addTradeTax(itemTax);
					settlement.setMonetarySummation(monetarySummation);
					return settlement;
				}

				private SpecifiedMonetarySummation mapMonetarySummation(Row.Item rowItem) {
					BigDecimal lineTotal = BigDecimal.ZERO;
					if (rowItem.getUnitPrice() != null && rowItem.getQuantity() != null) {
						lineTotal = rowItem.getUnitPrice().multiply(rowItem.getQuantity());
					}
					SpecifiedMonetarySummation monetarySummation = new SpecifiedMonetarySummation();
					monetarySummation.setLineTotal(new Amount(lineTotal, currencyCode));
					return monetarySummation;
				}

				private ItemTax mapItemTax(Row.Item rowItem) {
					ItemTax itemTax = new ItemTax().setType(TaxCode.VAT);
					BigDecimal percent = rowItem.getTaxPercent() != null ? rowItem.getTaxPercent() : BigDecimal.ZERO;
					itemTax.setPercentage(percent);
					itemTax.setCategory(TaxCategory.S);
					return itemTax;
				}

				private SpecifiedDelivery mapDelivery(Row.Item rowItem) {
					SpecifiedDelivery delivery = new SpecifiedDelivery();

					BigDecimal quantity = rowItem.getQuantity() != null ? rowItem.getQuantity() : BigDecimal.ZERO;
					UnitOfMeasurement unit = rowItem.getUnit() != null ? rowItem.getUnit() : UnitOfMeasurement.UNIT;

					delivery.setBilled(new Quantity(quantity, unit));

					return delivery;
				}

				private Product mapProduct(String assignedId, Row.Item rowItem) {
					return new Product().setName(rowItem.getName())
							.setBuyerAssignedId(assignedId)
							.setSellerAssignedId(assignedId);
				}
			});
		}

		private static class TaxAccumulator {
			final public BigDecimal taxAmount;
			final public BigDecimal lineTotal;

			public TaxAccumulator(BigDecimal taxAmount, BigDecimal lineTotal) {
				this.taxAmount = taxAmount;
				this.lineTotal = lineTotal;
			}

			public TaxAccumulator accumulate(TaxAccumulator taxAccumulator) {
				return new TaxAccumulator(
						taxAccumulator.taxAmount.add(taxAmount),
						taxAccumulator.lineTotal.add(lineTotal)
				);
			}
		}
	}
}

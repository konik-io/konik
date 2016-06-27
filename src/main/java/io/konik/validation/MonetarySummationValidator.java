package io.konik.validation;

import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.Settlement;
import io.konik.zugferd.entity.trade.Trade;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import io.konik.zugferd.entity.trade.item.SpecifiedSettlement;
import io.konik.zugferd.unqualified.Amount;
import org.apache.bval.jsr303.util.PathImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * Validates {@link Invoice}'s {@link MonetarySummation} by comparing values after recalculating MonetarySummation
 * for the invoice and all line position items.
 */
public class MonetarySummationValidator {

	public Set<ConstraintViolation<Invoice>> validate(final Invoice invoice) {
		if (invoice == null) {
			throw new IllegalArgumentException("Invoice cannot be null");
		}

		Set<ConstraintViolation<Invoice>> violations = new HashSet<ConstraintViolation<Invoice>>();
		Trade trade = invoice.getTrade();

		if (trade != null) {
			Settlement settlement = trade.getSettlement();

			if (settlement.getMonetarySummation() != null) {
				MonetarySummation monetarySummation = settlement.getMonetarySummation();
				MonetarySummation calculatedMonetarySummation = AmountCalculator.calculateMonetarySummation(invoice);

				if (!areEqual(monetarySummation.getGrandTotal(), calculatedMonetarySummation.getGrandTotal())) {
					String message = message(monetarySummation.getGrandTotal(), calculatedMonetarySummation.getGrandTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.grandTotal.error", "trade.settlement.monetarySummation.grandTotal", monetarySummation.getGrandTotal().getValue()));
				}

				if (!areEqual(monetarySummation.getTaxBasisTotal(), calculatedMonetarySummation.getTaxBasisTotal())) {
					String message = message(monetarySummation.getTaxBasisTotal(), calculatedMonetarySummation.getTaxBasisTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.taxBasisTotal.error", "trade.settlement.monetarySummation.taxBasisTotal", monetarySummation.getTaxBasisTotal().getValue()));
				}

				if (!areEqual(monetarySummation.getChargeTotal(), calculatedMonetarySummation.getChargeTotal())) {
					String message = message(monetarySummation.getChargeTotal(), calculatedMonetarySummation.getChargeTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.chargeTotal.error", "trade.settlement.monetarySummation.chargeTotal", monetarySummation.getChargeTotal().getValue()));
				}

				if (!areEqual(monetarySummation.getAllowanceTotal(), calculatedMonetarySummation.getAllowanceTotal())) {
					String message = message(monetarySummation.getAllowanceTotal(), calculatedMonetarySummation.getAllowanceTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.allowanceTotal.error", "trade.settlement.monetarySummation.allowanceTotal", monetarySummation.getAllowanceTotal().getValue()));
				}

				if (!areEqual(monetarySummation.getDuePayable(), calculatedMonetarySummation.getDuePayable())) {
					String message = message(monetarySummation.getDuePayable(), calculatedMonetarySummation.getDuePayable());
					violations.add(new Violation(invoice, message, "monetarySummation.duePayable.error", "trade.settlement.monetarySummation.duePayable", monetarySummation.getDuePayable().getValue()));
				}

				if (!areEqual(monetarySummation.getLineTotal(), calculatedMonetarySummation.getLineTotal())) {
					String message = message(monetarySummation.getLineTotal(), calculatedMonetarySummation.getLineTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.lineTotal.error", "trade.settlement.monetarySummation.lineTotal", monetarySummation.getLineTotal().getValue()));
				}

				if (!areEqual(monetarySummation.getTaxTotal(), calculatedMonetarySummation.getTaxTotal())) {
					String message = message(monetarySummation.getTaxTotal(), calculatedMonetarySummation.getTaxTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.taxTotal.error", "trade.settlement.monetarySummation.taxTotal", monetarySummation.getTaxTotal().getValue()));
				}

				if (!areEqual(monetarySummation.getTotalPrepaid(), calculatedMonetarySummation.getTotalPrepaid())) {
					String message = message(monetarySummation.getTotalPrepaid(), calculatedMonetarySummation.getTotalPrepaid());
					violations.add(new Violation(invoice, message, "monetarySummation.totalPrepaid.error", "trade.settlement.monetarySummation.totalPrepaid", monetarySummation.getTotalPrepaid().getValue()));
				}
			}

			if (trade.getItems() != null) {
				for (int i = 0; i < trade.getItems().size(); i++) {
					Item item = trade.getItems().get(i);

					if (item.getSettlement() != null) {
						SpecifiedSettlement specifiedSettlement = item.getSettlement();

						if (specifiedSettlement.getMonetarySummation() != null) {
							SpecifiedMonetarySummation monetarySummation = specifiedSettlement.getMonetarySummation();
							SpecifiedMonetarySummation calculatedMonetarySummation = AmountCalculator.calculateSpecifiedMonetarySummation(item);

							if (!areEqual(monetarySummation.getLineTotal(), calculatedMonetarySummation.getLineTotal())) {
								String message = message(monetarySummation.getLineTotal(), calculatedMonetarySummation.getLineTotal());
								violations.add(new Violation(invoice, message, "item.monetarySummation.lineTotal.error", "trade.items["+i+"].settlement.monetarySummation.lineTotal", monetarySummation.getLineTotal().getValue()));
							}
							if (!areEqual(monetarySummation.getTotalAllowanceCharge(), calculatedMonetarySummation.getTotalAllowanceCharge())) {
								String message = message(monetarySummation.getTotalAllowanceCharge(), calculatedMonetarySummation.getTotalAllowanceCharge());
								violations.add(new Violation(invoice, message, "item.monetarySummation.totalAllowanceCharge.error", "trade.items["+i+"].settlement.monetarySummation.totalAllowanceCharge", monetarySummation.getTotalAllowanceCharge().getValue()));
							}
						}
					}
				}
			}
		}

		return violations;
	}

	private static String message(final Amount first, final Amount second) {
		return String.format("%s != %s", first.getValue().toString(), second.getValue().toString());
	}

	private static boolean areEqual(final Amount first, final Amount second) {
		if (first == null && second == null) {
			return true;
		}
		if (first == null || second == null) {
			return false;
		}

		if (first.getCurrency() != null && second.getCurrency() != null) {
			if (!first.getCurrency().getCurrency().equals(second.getCurrency().getCurrency())) {
				return false;
			}
		}

		if (first.getValue() != null && second.getValue() != null) {
			return first.getValue().equals(second.getValue());
		}

		return false;
	}

	private static class Violation implements ConstraintViolation<Invoice> {

		private final Invoice invoice;
		private final String message;
		private final String messageTemplate;
		private final String propertyPath;
		private final Object invalidValue;

		public Violation(Invoice invoice, String message, String messageTemplate, String propertyPath, Object invalidValue) {
			this.invoice = invoice;
			this.message = message;
			this.messageTemplate = messageTemplate;
			this.propertyPath = propertyPath;
			this.invalidValue = invalidValue;
		}

		@Override
		public String getMessage() {
			return message;
		}

		@Override
		public String getMessageTemplate() {
			return messageTemplate;
		}

		@Override
		public Invoice getRootBean() {
			return invoice;
		}

		@Override
		public Class<Invoice> getRootBeanClass() {
			return Invoice.class;
		}

		@Override
		public Object getLeafBean() {
			return null;
		}

		@Override
		public Object[] getExecutableParameters() {
			return new Object[0];
		}

		@Override
		public Object getExecutableReturnValue() {
			return null;
		}

		@Override
		public Path getPropertyPath() {
			return PathImpl.createPathFromString(propertyPath);
		}

		@Override
		public Object getInvalidValue() {
			return invalidValue;
		}

		@Override
		public ConstraintDescriptor<?> getConstraintDescriptor() {
			return null;
		}

		@Override
		public <U> U unwrap(Class<U> type) {
			return null;
		}
	}
}

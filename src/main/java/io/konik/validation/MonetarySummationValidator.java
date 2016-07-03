package io.konik.validation;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import io.konik.validator.annotation.Basic;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.Settlement;
import io.konik.zugferd.entity.trade.Trade;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import io.konik.zugferd.entity.trade.item.SpecifiedSettlement;
import io.konik.zugferd.profile.ConformanceLevel;
import io.konik.zugferd.unqualified.Amount;
import org.apache.bval.jsr303.util.PathImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;
import java.lang.annotation.Annotation;
import java.math.RoundingMode;
import java.util.*;

/**
 * Validates {@link Invoice}'s {@link MonetarySummation} by comparing values after recalculating MonetarySummation
 * for the invoice and all line position items.
 */
public class MonetarySummationValidator {

	private static Logger log = LoggerFactory.getLogger(MonetarySummationValidator.class);

	/**
	 * Checks if given method belongs to the validation groups profile.
	 *
	 * @param clazz
	 * @param methodName
	 * @param validationGroups
	 * @return
	 */
	public static boolean belongsToProfile(final Class<?> clazz, final String methodName, final List<Class<?>> validationGroups) {
		try {
			Annotation[] annotations  = clazz.getMethod(methodName).getAnnotations();
			List<Annotation> profileAnnotationsOnly = new LinkedList<Annotation>(Collections2.filter(Arrays.asList(annotations), new Predicate<Annotation>() {
				@Override
				public boolean apply(Annotation annotation) {
					return ConformanceLevel.getAnnotations().contains(annotation.annotationType());
				}
			}));

			if (profileAnnotationsOnly.isEmpty()) {
				return true;
			}

			if (profileAnnotationsOnly.size() == 1 && profileAnnotationsOnly.get(0).annotationType().equals(Basic.class)) {
				return true;
			}

			return Iterables.any(profileAnnotationsOnly, new Predicate<Annotation>() {
				@Override
				public boolean apply(@Nullable Annotation annotation) {
					return validationGroups.contains(annotation.annotationType());
				}
			});

		} catch (Exception e) {
			log.warn("{} caught while checking if method {} from class {} belongs to validation groups: {}", e.getClass().getSimpleName(), methodName, clazz, e.getMessage());
		}

		return false;
	}

	public Set<ConstraintViolation<Invoice>> validate(final Invoice invoice, final Class<?>[] validationGroups) {
		if (invoice == null) {
			throw new IllegalArgumentException("Invoice cannot be null");
		}

		Set<ConstraintViolation<Invoice>> violations = new HashSet<ConstraintViolation<Invoice>>();
		Trade trade = invoice.getTrade();

		if (trade != null) {
			Settlement settlement = trade.getSettlement();

			List<Class<?>> validationGroupsList = Arrays.asList(validationGroups);

			if (settlement.getMonetarySummation() != null) {
				MonetarySummation monetarySummation = settlement.getMonetarySummation();
				MonetarySummation calculatedMonetarySummation = AmountCalculator.calculateMonetarySummation(invoice);

				Class<?> clazz = MonetarySummation.class;

				if (belongsToProfile(clazz, "getGrandTotal", validationGroupsList) &&
						!areEqual(monetarySummation.getGrandTotal(), calculatedMonetarySummation.getGrandTotal())) {
					String message = message(monetarySummation.getGrandTotal(), calculatedMonetarySummation.getGrandTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.grandTotal.error", "trade.settlement.monetarySummation.grandTotal", monetarySummation.getGrandTotal() != null ? monetarySummation.getGrandTotal().getValue() : null));
				}

				if (belongsToProfile(clazz, "getTaxBasisTotal", validationGroupsList) &&
						!areEqual(monetarySummation.getTaxBasisTotal(), calculatedMonetarySummation.getTaxBasisTotal())) {
					String message = message(monetarySummation.getTaxBasisTotal(), calculatedMonetarySummation.getTaxBasisTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.taxBasisTotal.error", "trade.settlement.monetarySummation.taxBasisTotal", monetarySummation.getTaxBasisTotal() != null ? monetarySummation.getTaxBasisTotal().getValue() : null));
				}

				if (belongsToProfile(clazz, "getChargeTotal", validationGroupsList) &&
						!areEqual(monetarySummation.getChargeTotal(), calculatedMonetarySummation.getChargeTotal())) {
					String message = message(monetarySummation.getChargeTotal(), calculatedMonetarySummation.getChargeTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.chargeTotal.error", "trade.settlement.monetarySummation.chargeTotal", monetarySummation.getChargeTotal() != null ? monetarySummation.getChargeTotal().getValue() : null));
				}

				if (belongsToProfile(clazz, "getAllowanceTotal", validationGroupsList) &&
						!areEqual(monetarySummation.getAllowanceTotal(), calculatedMonetarySummation.getAllowanceTotal())) {
					String message = message(monetarySummation.getAllowanceTotal(), calculatedMonetarySummation.getAllowanceTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.allowanceTotal.error", "trade.settlement.monetarySummation.allowanceTotal", monetarySummation.getAllowanceTotal() != null ? monetarySummation.getAllowanceTotal().getValue() : null));
				}

				if (belongsToProfile(clazz, "getDuePayable", validationGroupsList) &&
						!areEqual(monetarySummation.getDuePayable(), calculatedMonetarySummation.getDuePayable())) {
					String message = message(monetarySummation.getDuePayable(), calculatedMonetarySummation.getDuePayable());
					violations.add(new Violation(invoice, message, "monetarySummation.duePayable.error", "trade.settlement.monetarySummation.duePayable", monetarySummation.getDuePayable() != null ? monetarySummation.getDuePayable().getValue() : null));
				}

				if (belongsToProfile(clazz, "getLineTotal", validationGroupsList) &&
						!areEqual(monetarySummation.getLineTotal(), calculatedMonetarySummation.getLineTotal())) {
					String message = message(monetarySummation.getLineTotal(), calculatedMonetarySummation.getLineTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.lineTotal.error", "trade.settlement.monetarySummation.lineTotal", monetarySummation.getLineTotal() != null ? monetarySummation.getLineTotal().getValue() : null));
				}

				if (belongsToProfile(clazz, "getTaxTotal", validationGroupsList) &&
						!areEqual(monetarySummation.getTaxTotal(), calculatedMonetarySummation.getTaxTotal())) {
					String message = message(monetarySummation.getTaxTotal(), calculatedMonetarySummation.getTaxTotal());
					violations.add(new Violation(invoice, message, "monetarySummation.taxTotal.error", "trade.settlement.monetarySummation.taxTotal", monetarySummation.getTaxTotal() != null ? monetarySummation.getTaxTotal().getValue() : null));
				}

				if (belongsToProfile(clazz, "getTotalPrepaid", validationGroupsList) &&
						!areEqual(monetarySummation.getTotalPrepaid(), calculatedMonetarySummation.getTotalPrepaid())) {
					String message = message(monetarySummation.getTotalPrepaid(), calculatedMonetarySummation.getTotalPrepaid());
					violations.add(new Violation(invoice, message, "monetarySummation.totalPrepaid.error", "trade.settlement.monetarySummation.totalPrepaid", monetarySummation.getTotalPrepaid() != null ? monetarySummation.getTotalPrepaid().getValue() : null));
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

							if (belongsToProfile(SpecifiedMonetarySummation.class, "getLineTotal", validationGroupsList) &&
									!areEqual(monetarySummation.getLineTotal(), calculatedMonetarySummation.getLineTotal())) {
								String message = message(monetarySummation.getLineTotal(), calculatedMonetarySummation.getLineTotal());
								violations.add(new Violation(invoice, message, "item.monetarySummation.lineTotal.error", "trade.items["+i+"].settlement.monetarySummation.lineTotal", monetarySummation.getLineTotal() != null ? monetarySummation.getLineTotal().getValue() : null));
							}
							if (belongsToProfile(SpecifiedMonetarySummation.class, "getTotalAllowanceCharge", validationGroupsList) &&
									!areEqual(monetarySummation.getTotalAllowanceCharge(), calculatedMonetarySummation.getTotalAllowanceCharge())) {
								String message = message(monetarySummation.getTotalAllowanceCharge(), calculatedMonetarySummation.getTotalAllowanceCharge());
								violations.add(new Violation(invoice, message, "item.monetarySummation.totalAllowanceCharge.error", "trade.items["+i+"].settlement.monetarySummation.totalAllowanceCharge", monetarySummation.getTotalAllowanceCharge() != null ? monetarySummation.getTotalAllowanceCharge().getValue() : null));
							}
						}
					}
				}
			}
		}

		return violations;
	}

	private static String message(final Amount original, final Amount recalculated) {
		return String.format("Original amount value for given field is [%s] while expected value after recalculation is equal [%s]",
				original != null ? original.getValue().toString() : "null",
				recalculated != null ? recalculated.getValue().toString() : "null"
		);
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
			return first.getValue()
					.setScale(2, RoundingMode.HALF_UP)
					.equals(second.getValue()
							.setScale(2, RoundingMode.HALF_UP)
					);
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

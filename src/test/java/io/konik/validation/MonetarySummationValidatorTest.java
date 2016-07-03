package io.konik.validation;

import io.konik.InvoiceTransformer;
import io.konik.validator.annotation.Comfort;
import io.konik.validator.annotation.Extended;
import io.konik.zugferd.Invoice;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.groups.Default;
import java.io.InputStream;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MonetarySummationValidatorTest {

	@Test
	public void shouldNotComplaintAboutCorrectInvoiceMonetarySummation() {
		//given:
		InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges.xml");
		InvoiceTransformer transformer = new InvoiceTransformer();
		Invoice invoice = transformer.toModel(xml);
		MonetarySummationValidator validator = new MonetarySummationValidator();

		//when:
		Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice, new Class[] {Default.class, Comfort.class, Extended.class});

		//then:
		assertThat(violations).isEmpty();
	}

	@Test
	public void shouldComplainAboutIncorrectMonetarySummation() {
		//given:
		InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges_with_errors.xml");
		InvoiceTransformer transformer = new InvoiceTransformer();
		Invoice invoice = transformer.toModel(xml);
		MonetarySummationValidator validator = new MonetarySummationValidator();

		//when:
		Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice, new Class[] {Default.class, Comfort.class, Extended.class});

		//then:
		assertThat(violations).hasSize(1);

		assertThat(violations.iterator().next().getMessage()).isEqualTo("Original amount value for given field is [202.71] while expected value after recalculation is equal [202.70]");

		assertThat(violations.iterator().next().getPropertyPath().toString()).isEqualTo("trade.settlement.monetarySummation.lineTotal");
	}

	@Test
	public void shouldValidateInvoiceExample3() {
		//given:
		InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_monetary_summation_recalculation_failed_input.xml");
		InvoiceTransformer transformer = new InvoiceTransformer();
		Invoice invoice = transformer.toModel(xml);
		MonetarySummationValidator validator = new MonetarySummationValidator();

		//when:
		Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice, new Class[] {Default.class, Comfort.class, Extended.class});

		//then:
		for (ConstraintViolation<Invoice> violation : violations) {
			System.out.printf("%-70s: %s%n", violation.getPropertyPath().toString(), violation.getMessage());
		}
		assertThat(violations).hasSize(2);

	}

}
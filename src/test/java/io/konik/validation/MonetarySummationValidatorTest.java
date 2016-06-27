package io.konik.validation;

import io.konik.InvoiceTransformer;
import io.konik.zugferd.Invoice;
import org.junit.Test;

import javax.validation.ConstraintViolation;
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
		Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice);

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
		Set<ConstraintViolation<Invoice>> violations = validator.validate(invoice);

		//then:
		assertThat(violations).hasSize(1);

		assertThat(violations.iterator().next().getMessage()).isEqualTo("202.71 != 202.70");

		assertThat(violations.iterator().next().getPropertyPath().toString()).isEqualTo("trade.settlement.monetarySummation.lineTotal");
	}

}
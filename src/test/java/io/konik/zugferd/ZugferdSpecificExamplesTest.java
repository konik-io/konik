package io.konik.zugferd;

import io.konik.InvoiceTransformer;
import io.konik.validation.InvoiceValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.ConstraintViolation;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ZugferdSpecificExamplesTest {

	private static final String ROOT = "src/test/resources/zugferd_examples/";

	@Parameterized.Parameters(name = "Invoice {0} has {1} error(s)")
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][]{
				{ "ZUGFeRD_1p0_COMFORT_Einfach_Original.xml", 0 },
				{ "ZUGFeRD_1p0_EXTENDED_Warenrechnung.xml", 2 },
				{ "large_zugferd_invoice.xml", 6 },
		});
	}

	@Parameterized.Parameter
	public String file;

	@Parameterized.Parameter(1)
	public int expectedNumberOfErrors;

	private static File stringFileNameToFile(String name) {
		return new File(ROOT + name);
	}

	@Test
	public void validateInvoiceAndCompareWithExpectedNumberOfErrors() {
		//setup:
		InvoiceTransformer transformer = new InvoiceTransformer();
		Invoice invoice = transformer.toModel(stringFileNameToFile(file));
		InvoiceValidator invoiceValidator = new InvoiceValidator();

		//when:
		Set<ConstraintViolation<Invoice>> validationResult = invoiceValidator.validate(invoice);

		//then:
		printErrorsIfPresent(validationResult);
		assertThat(validationResult).hasSize(expectedNumberOfErrors);
	}

	private static void printErrorsIfPresent(final Set<ConstraintViolation<Invoice>> constraintViolations) {
		if (constraintViolations != null) {
			for (ConstraintViolation<Invoice> constraintViolation : constraintViolations) {
				System.out.printf("%-60s: %s | Invalid value: %s%n",
						constraintViolation.getPropertyPath(),
						constraintViolation.getMessage(),
						constraintViolation.getInvalidValue());
			}
		}
	}
}

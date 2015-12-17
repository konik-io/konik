package io.konik.csv.processor;

import io.konik.zugferd.unece.codes.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

/**
 * Custom {@link CellProcessor} for {@link Reference}.
 */
public final class ReferenceProcessor implements CellProcessor {

	private static final Logger log = LoggerFactory.getLogger(ReferenceProcessor.class);

	@Override
	public <T> T execute(Object value, CsvContext context) {

		if (value instanceof String) {
			String code = (String) value;
			try {
				return (T) Reference.getByCode(code);
			} catch (IllegalArgumentException e) {
				log.warn("Reference for value {} does not exist", value);
			}
		}

		if (value instanceof Reference) {
			Reference reference = (Reference) value;
			return (T) reference.getCode();
		}

		return null;
	}
}

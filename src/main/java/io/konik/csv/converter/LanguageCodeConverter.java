package io.konik.csv.converter;

import com.neovisionaries.i18n.LanguageCode;
import org.dozer.DozerConverter;

/**
 * Intermediate converter used to convert {@link String} to {@link LanguageCode}
 * while mapping a single value to a collection using custom add..() method.
 */
public class LanguageCodeConverter extends DozerConverter<String, LanguageCode> {

	public LanguageCodeConverter() {
		this(String.class, LanguageCode.class);
	}

	public LanguageCodeConverter(Class<String> prototypeA, Class<LanguageCode> prototypeB) {
		super(prototypeA, prototypeB);
	}

	@Override
	public LanguageCode convertTo(String source, LanguageCode destination) {
		return LanguageCode.getByCode(source, false);
	}

	@Override
	public String convertFrom(LanguageCode source, String destination) {
		return source.toString();
	}
}

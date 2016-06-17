package io.konik.validation.correction;

import javax.validation.constraints.NotNull;

public interface Correction<T> {
	public T correct(@NotNull final T object);
}

package io.konik.calculation;

import javax.validation.constraints.NotNull;

public interface Correction<T> {
   public T correct(@NotNull final T object);
}

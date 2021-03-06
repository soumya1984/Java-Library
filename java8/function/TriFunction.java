// Copyright (c) 2014 Daniel S. Dickstein

package library.java8.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
  public R apply(T t, U u, V v);

  public default <W> TriFunction<T, U, V, W> andThen(Function<? super R, ? extends W> after) {
    Objects.requireNonNull(after);
    return (T t, U u, V v) -> after.apply(apply(t, u, v));
  }
}
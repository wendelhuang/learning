package com.sklink.learning.lambda.exception01;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction01<T, R, E extends Throwable> {
    R apply(T t) throws E;
    static <T, R, E extends Throwable>Function<T, R> unchecked(ThrowingFunction01<T, R, E> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (Throwable e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }
}

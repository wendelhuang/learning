package com.sklink.learning.lambda.exception01;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Throwable> {
    void accept(T t) throws E;
    static <T, E extends Throwable>Consumer<T> unchecked(ThrowingConsumer<T, E> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Throwable e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }
}

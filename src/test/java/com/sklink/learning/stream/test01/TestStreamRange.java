package com.sklink.learning.stream.test01;

import org.junit.Test;

import java.util.stream.IntStream;

public class TestStreamRange {

    @Test
    public void test() {
        IntStream.range(0, 10).forEach(System.out::println);
    }
}

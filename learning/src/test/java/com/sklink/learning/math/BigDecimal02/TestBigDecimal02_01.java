package com.sklink.learning.math.BigDecimal02;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TestBigDecimal02_01 {

    @Test
    public void test() {
        List<BigDecimal> bigDecimalList = Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN, BigDecimal.TEN);
        System.out.println(bigDecimalList.stream().reduce(BigDecimal::add).get());


        bigDecimalList = Arrays.asList();
        /**
         * Exception
         */
        System.out.println(bigDecimalList.stream().reduce(BigDecimal::add).get());
        System.out.println(bigDecimalList.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
    }
}

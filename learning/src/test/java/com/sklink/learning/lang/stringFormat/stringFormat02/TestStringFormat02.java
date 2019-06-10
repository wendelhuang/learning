package com.sklink.learning.lang.stringFormat.stringFormat02;

import org.junit.Test;

import java.math.BigDecimal;

public class TestStringFormat02 {
    @Test
    public void test() {
        System.out.println(String.format("%.2f", BigDecimal.ZERO));
        System.out.println(String.format("%b", false));
        System.out.println(String.format("%B", false));
    }
}

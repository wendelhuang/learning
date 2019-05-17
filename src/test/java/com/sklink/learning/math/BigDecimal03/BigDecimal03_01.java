package com.sklink.learning.math.BigDecimal03;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimal03_01 {
    public static BigDecimal sqrt(BigDecimal num, int precision, RoundingMode roundingMode) {
        MathContext mathContext = new MathContext(precision, roundingMode);
        BigDecimal root = num;
        BigDecimal diff = BigDecimal.ZERO;
        do {
            root = root.add(num.divide(root, precision, roundingMode)).divide(new BigDecimal(2), precision, roundingMode);
            System.out.println(String.format("root = %.15f, num = %.15f", root, num));
            diff = root.multiply(root).subtract(num);
            System.out.println(String.format("diff = %.15f", diff));
        }while(diff.abs().compareTo(new BigDecimal(0.00000000000001)) >= 0);
        return root;
    }

    @Test
    public void test() {
        System.out.println(BigDecimal03_01.sqrt(new BigDecimal(2), 15, RoundingMode.HALF_UP));
    }

    @Test
    public void test2() {
        System.out.println(new BigDecimal(1.414213562400000).multiply(new BigDecimal(1.414213562400000)));
    }
}

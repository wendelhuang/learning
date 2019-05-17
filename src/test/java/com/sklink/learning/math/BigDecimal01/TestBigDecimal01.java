package com.sklink.learning.math.BigDecimal01;

import org.junit.Test;

import java.math.BigDecimal;

public class TestBigDecimal01 {
    @Test
    public void test() {
        BigDecimal b1 = new BigDecimal(160000);
        BigDecimal b2 = new BigDecimal(4.65);

        BigDecimal c1 = b1.divide(b2, 0, BigDecimal.ROUND_DOWN);
        System.out.println(c1);

        BigDecimal c2 = b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP);
        System.out.println(c2);

        // 四舍五入
        System.out.println(b1.divide(b2, 0, BigDecimal.ROUND_HALF_UP));
        // 五舍六入
        System.out.println(b1.divide(b2, 0, BigDecimal.ROUND_HALF_DOWN));

        System.out.println(String.format("%.4f", new BigDecimal(27.09).divide(new BigDecimal(27.11), 6, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.ONE)));

    }
}

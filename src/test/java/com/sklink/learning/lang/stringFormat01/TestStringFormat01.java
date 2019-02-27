package com.sklink.learning.lang.stringFormat01;

import org.junit.Test;

import java.util.Calendar;

public class TestStringFormat01 {

    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);

        System.out.println(String.format("%d-%02d-%02d", year, month, day));
    }
}

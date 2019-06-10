package com.sklink.learning.lang.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate01 {

    @Test
    public void test() {
        System.out.println(new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime()));
        System.out.println(new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime()).compareTo("240000"));
        Calendar calendar = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        calendar.set(Calendar.MONTH, 1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        /**
         * calendar.set(Calendar.DATE, 31);
         */
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));


        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));

        calendar.add(calendar.MONTH, 1);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
    }

    public Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 3);
        calendar.set(calendar.MONTH, (calendar.get(Calendar.MONTH)/3)*3);
        calendar.set(Calendar.DATE, 0);
        return calendar.getTime();
    }

    @Test
    public void testGetLastDayOfQuarter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        for(int i = 0; i < 1000; i++) {
            calendar.add(Calendar.DATE, 1);
            System.out.println(String.format("%s季末最后一天为%s",
                    simpleDateFormat.format(calendar.getTime()),
                    simpleDateFormat.format(getLastDayOfQuarter(calendar.getTime()))));
        }
    }

    /**
     * 获取季度第一天
     */
    public Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.MONTH, (calendar.get(Calendar.MONTH)/3)*3);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    @Test
    public void testGetFirstDayOfQuarter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        for(int i = 0; i < 1000; i++) {
            calendar.add(Calendar.DATE, 1);
            System.out.println(String.format("%s季初第一天为%s",
                    simpleDateFormat.format(calendar.getTime()),
                    simpleDateFormat.format(getFirstDayOfQuarter(calendar.getTime()))));
        }
    }
}

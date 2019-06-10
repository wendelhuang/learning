package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_11;

public class JMTP02_11 {
    public static void main(String[] args) {
        JMTP02_11_Task task = new JMTP02_11_Task();
        JMTP02_11_ThreadA a = new JMTP02_11_ThreadA(task);
        JMTP02_11_ThreadB b = new JMTP02_11_ThreadB(task);

        a.start();
        b.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long begin = Math.min(JMTP02_11_CommonUtils.beginTime1, JMTP02_11_CommonUtils.beginTime2);
        long end = Math.max(JMTP02_11_CommonUtils.endTime1, JMTP02_11_CommonUtils.endTime2);

        System.out.println(String.format("beginTime1: %d, endTime1: %d", JMTP02_11_CommonUtils.beginTime1, JMTP02_11_CommonUtils.endTime1));
        System.out.println(String.format("beginTime2: %d, endTime2: %d", JMTP02_11_CommonUtils.beginTime2, JMTP02_11_CommonUtils.endTime2));
        System.out.println(String.format("begin: %d, end: %d, end-begin = %d", begin, end, end-begin));
    }
}

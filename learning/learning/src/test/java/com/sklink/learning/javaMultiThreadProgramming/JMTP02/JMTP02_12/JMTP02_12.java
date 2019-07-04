package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_12;

public class JMTP02_12 {
    public static void main(String[] args) {
        JMTP02_12_Task task = new JMTP02_12_Task();
        JMTP02_12_ThreadA a = new JMTP02_12_ThreadA(task);
        JMTP02_12_ThreadB b = new JMTP02_12_ThreadB(task);

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long begin = Math.min(JMTP02_12_CommonUtils.beginTime1, JMTP02_12_CommonUtils.beginTime2);
        long end = Math.max(JMTP02_12_CommonUtils.endTime1, JMTP02_12_CommonUtils.endTime2);

        System.out.println(String.format("beginTime1: %d, endTime1: %d", JMTP02_12_CommonUtils.beginTime1, JMTP02_12_CommonUtils.endTime1));
        System.out.println(String.format("beginTime2: %d, endTime2: %d", JMTP02_12_CommonUtils.beginTime2, JMTP02_12_CommonUtils.endTime2));
        System.out.println(String.format("begin: %d, end: %d, end-begin = %d", begin, end, end-begin));
    }
}

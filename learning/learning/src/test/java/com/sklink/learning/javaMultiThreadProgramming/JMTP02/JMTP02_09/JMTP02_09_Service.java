package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_09;

public class JMTP02_09_Service {
    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("A")) {
            System.out.println(String.format("Thread: %s, beginTime: %d", Thread.currentThread().getName(), System.currentTimeMillis()));
            int i = 1;
            while(i == 1) {
                String str = "" + Math.random();
                System.out.println(String.format("str = %s", str));
                if (str.substring(0, 8).equals("0.123456")) {
                    System.out.println(String.format("Thread: %s, exceptionTime = %d", Thread.currentThread().getName(), System.currentTimeMillis()));
                    Integer.parseInt("a");
                }
            }
        }else {
            System.out.println(String.format("Thread B run time = %d", System.currentTimeMillis()));
        }
    }
}

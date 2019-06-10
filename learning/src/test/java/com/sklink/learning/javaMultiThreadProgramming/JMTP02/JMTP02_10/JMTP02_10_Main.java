package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_10;

public class JMTP02_10_Main {
    synchronized public void serviceMethod() {
        System.out.println(String.format("main#serviceMethod: sleep beginTime: %d", System.currentTimeMillis()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("main#serviceMethod: sleep endTime: %d", System.currentTimeMillis()));
    }
}

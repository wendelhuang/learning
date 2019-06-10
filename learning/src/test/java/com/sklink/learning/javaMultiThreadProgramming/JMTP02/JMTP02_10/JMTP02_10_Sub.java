package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_10;

public class JMTP02_10_Sub extends JMTP02_10_Main {
    @Override
    public void serviceMethod() {
        System.out.println(String.format("sub#serviceMethod beginTime: %d", System.currentTimeMillis()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("sub#serviceMethod endTime: %d", System.currentTimeMillis()));
    }
}

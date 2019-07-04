package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_16;

public class JMTP01_16_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i = 0; i < 10000; i++) {
            System.out.println(String.format("Thread: %s, i: %d", Thread.currentThread().getName(), i));
        }
    }
}

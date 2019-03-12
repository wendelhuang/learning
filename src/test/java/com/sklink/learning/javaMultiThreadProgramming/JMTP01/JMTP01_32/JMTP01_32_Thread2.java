package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_32;

public class JMTP01_32_Thread2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(String.format("Thread2: %s, priority: %d", Thread.currentThread().getName(), this.getPriority()));

    }
}

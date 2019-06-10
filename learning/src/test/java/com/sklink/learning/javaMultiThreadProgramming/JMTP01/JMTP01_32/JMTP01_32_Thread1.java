package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_32;

public class JMTP01_32_Thread1 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(String.format("Thread1: %s, priority: %d", Thread.currentThread().getName(), this.getPriority()));
        JMTP01_32_Thread2 thread = new JMTP01_32_Thread2();
        thread.start();
    }
}

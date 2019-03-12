package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_19;

public class JMTP01_19_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100000; i++) {
            if (this.isInterrupted()) {
                System.out.println(String.format("Thread: %s, isInterrupted: %B, break", Thread.currentThread().getName(), this.isInterrupted()));
                break;
            }
            System.out.println(String.format("Thread: %s, i: %d", Thread.currentThread().getName(), i));
        }
        System.out.println(String.format("Thread: %s end", Thread.currentThread().getName()));
    }
}

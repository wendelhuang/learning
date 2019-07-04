package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_21;

public class JMTP01_21_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println(String.format("Thread: %s start", Thread.currentThread().getName()));
            Thread.sleep(30000);
            System.out.println(String.format("Thread: %s end", Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            System.out.println(String.format("Thread: %s interrupted, isInterrupted: %B", Thread.currentThread().getName(), this.isInterrupted()));
            e.printStackTrace();
        }
    }
}

package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_22;

public class JMTP01_22_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for(int i = 0; i < 10000; i++) {
                System.out.println(String.format("Thread: %s, i: %d, isInterrupted: %B", Thread.currentThread().getName(), i, this.isInterrupted()));
            }
            System.out.println(String.format("Thread %s sleep begin, isInterrupted: %B", Thread.currentThread().getName(), this.isInterrupted()));
            Thread.sleep(10000);
            System.out.println(String.format("Thread %s sleep end, isInterrupted: %B", Thread.currentThread().getName(), this.isInterrupted()));
        }catch (InterruptedException e) {
            System.out.println(String.format("Thread: %s InterruptedException catched, isInterrupted: %B", Thread.currentThread().getName(), this.isInterrupted()));
        }
    }
}

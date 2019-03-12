package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_15;

public class JMTP01_15 {
    public static void main(String[] args) {
        System.out.println(String.format("Thread: %s end", Thread.currentThread().getName()));
        JMTP01_15_Thread mythread = new JMTP01_15_Thread();
        mythread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread.interrupt();
        System.out.println(String.format("Thread: %s end", Thread.currentThread().getName()));
    }
}

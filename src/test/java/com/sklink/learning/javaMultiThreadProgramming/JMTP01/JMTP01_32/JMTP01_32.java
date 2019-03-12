package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_32;

public class JMTP01_32 {
    public static void main(String[] args) {
        System.out.println(String.format("Thread main: %s, begin priority: %d", Thread.currentThread().getName(), Thread.currentThread().getPriority()));
        JMTP01_32_Thread1 thread1 = new JMTP01_32_Thread1();
        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.currentThread().setPriority(6);
        System.out.println(String.format("Thread main: %s, change priority to: %d", Thread.currentThread().getName(), Thread.currentThread().getPriority()));

        JMTP01_32_Thread1 thread2 = new JMTP01_32_Thread1();
        thread2.start();
    }
}

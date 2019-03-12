package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_18;

public class JMTP01_18 {
    public static void main(String[] args) {
        JMTP01_18_Thread thread = new JMTP01_18_Thread();
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        System.out.println(String.format("Thread: %s, isInterrupted: %B", thread.getName(), thread.isInterrupted()));
        System.out.println(String.format("Thread: %s, isInterrupted: %B", thread.getName(), thread.isInterrupted()));
    }
}

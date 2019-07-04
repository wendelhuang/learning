package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_20;

public class JMTP01_20 {
    public static void main(String[] args) {
        JMTP01_20_Thread thread = new JMTP01_20_Thread();
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        System.out.println("main end");
    }
}

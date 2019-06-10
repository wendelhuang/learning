package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_22;

public class JMTP01_22 {
    public static void main(String[] args) {
        JMTP01_22_Thread thread = new JMTP01_22_Thread();
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

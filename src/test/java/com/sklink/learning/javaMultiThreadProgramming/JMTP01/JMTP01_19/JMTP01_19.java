package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_19;

public class JMTP01_19 {
    public static void main(String[] args) {
        JMTP01_19_Thread thread = new JMTP01_19_Thread();
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

package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_21;


public class JMTP01_21 {
    public static void main(String[] args) {
        JMTP01_21_Thread thread = new JMTP01_21_Thread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("main end");
    }
}

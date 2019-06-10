package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_16;

public class JMTP01_16 {
    public static void main(String[] args) {
        JMTP01_16_Thread thread = new JMTP01_16_Thread();
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        System.out.println(thread.interrupted());
        System.out.println(thread.interrupted());
        System.out.println("main end");
    }
}

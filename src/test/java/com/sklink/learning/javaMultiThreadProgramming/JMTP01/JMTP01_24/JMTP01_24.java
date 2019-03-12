package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_24;

public class JMTP01_24 {
    public static void main(String[] args) {
        JMTP01_24_Thread mythread = new JMTP01_24_Thread();
        mythread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread.stop();
        System.out.println("main end");
    }
}

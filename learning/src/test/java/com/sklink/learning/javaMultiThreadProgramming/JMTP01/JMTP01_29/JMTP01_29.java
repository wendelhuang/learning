package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_29;

public class JMTP01_29 {
    public static void main(String[] args) {
        JMTP01_29_Thread thread = new JMTP01_29_Thread();
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.suspend();
        //System.out.println("main end");
    }
}

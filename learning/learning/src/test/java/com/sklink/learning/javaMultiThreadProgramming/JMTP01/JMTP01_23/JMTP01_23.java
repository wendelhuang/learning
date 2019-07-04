package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_23;

public class JMTP01_23 {
    public static void main(String[] args) {
        JMTP01_23_Thread mythread = new JMTP01_23_Thread();
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

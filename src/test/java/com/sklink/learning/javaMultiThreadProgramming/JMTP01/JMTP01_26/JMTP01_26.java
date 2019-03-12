package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_26;

public class JMTP01_26 {
    public static void main(String[] args) {
        JMTP01_26_Thread mythread = new JMTP01_26_Thread();
        mythread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread.interrupt();
    }
}

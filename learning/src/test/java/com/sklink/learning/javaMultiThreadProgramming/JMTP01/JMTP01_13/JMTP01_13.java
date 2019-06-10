package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_13;

public class JMTP01_13 {
    public static void main(String[] args) {
        JMTP01_13_Thread t1 = new JMTP01_13_Thread();
        t1.setName("t1");
        t1.run();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(t1);
        t2.setName("t2");
        t2.start();
    }
}

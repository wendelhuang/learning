package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_P114;

public class JMTP02_P114_Run1 {
    public static void main(String[] args) {
        JMTP02_P114_MyService myService = new JMTP02_P114_MyService();

        Thread t1 = new Thread(myService, "t1");
        Thread t2 = new Thread(myService, "t2");

        t1.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}

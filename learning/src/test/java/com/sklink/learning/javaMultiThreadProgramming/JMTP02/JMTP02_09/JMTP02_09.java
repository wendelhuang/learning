package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_09;

public class JMTP02_09 {
    public static void main(String[] args) {
        JMTP02_09_Service service = new JMTP02_09_Service();
        JMTP02_09_Thread a = new JMTP02_09_Thread(service);
        a.setName("A");
        JMTP02_09_Thread b = new JMTP02_09_Thread(service);
        b.setName("B");

        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}

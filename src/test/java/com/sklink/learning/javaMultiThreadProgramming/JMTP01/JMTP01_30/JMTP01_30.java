package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_30;

public class JMTP01_30 {
    public static void main(String[] args) {
        final JMTP01_30_MyObject myObject = new JMTP01_30_MyObject();
        Thread thread1 = new Thread(() -> myObject.setValue("a", "aa"));
        thread1.setName("a");
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(() -> myObject.printUsernamePassword());
        thread2.start();
    }
}

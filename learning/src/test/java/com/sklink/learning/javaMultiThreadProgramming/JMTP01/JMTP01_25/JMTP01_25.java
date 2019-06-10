package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_25;

public class JMTP01_25 {
    public static void main(String[] args) {
        JMTP01_25_SynchronizedObject synchronizedObject = new JMTP01_25_SynchronizedObject();
        JMTP01_25_Thread mythread = new JMTP01_25_Thread(synchronizedObject);
        mythread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread.stop();
        System.out.println(String.format("username: %s, password: %s", synchronizedObject.getUsername(), synchronizedObject.getPassword()));
        System.out.println("main end");
    }
}

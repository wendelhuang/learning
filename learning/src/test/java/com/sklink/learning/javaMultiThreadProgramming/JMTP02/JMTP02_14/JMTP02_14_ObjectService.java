package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_14;

public class JMTP02_14_ObjectService {
    public void serviceMethodA() {
        synchronized (this) {
            System.out.println(String.format("serviceMethodA begin = %d", System.currentTimeMillis()));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("serviceMethodA end = %d", System.currentTimeMillis()));
        }
    }
    public void serviceMethodB() {
        synchronized (this) {
            System.out.println(String.format("serviceMethodB begin = %d", System.currentTimeMillis()));
            System.out.println(String.format("serviceMethodB end = %d", System.currentTimeMillis()));
        }
    }
}

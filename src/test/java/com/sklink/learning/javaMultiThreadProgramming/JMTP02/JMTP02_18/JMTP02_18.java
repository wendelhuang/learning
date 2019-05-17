package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_18;

/**
 * 2.2.12 多线程的死锁
 */
public class JMTP02_18 {
    public static void main(String[] args) {
        JMTP02_18_DeadThread t1 = new JMTP02_18_DeadThread();
        t1.setUsername("a");
        Thread thread1 = new Thread(t1);
        thread1.start();

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.setUsername("b");
        Thread thread2 = new Thread(t1);

        thread2.start();

    }
}

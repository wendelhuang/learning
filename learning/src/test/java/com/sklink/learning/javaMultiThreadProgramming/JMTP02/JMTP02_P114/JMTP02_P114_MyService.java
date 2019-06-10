package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_P114;

public class JMTP02_P114_MyService implements Runnable {
    private String lock = "123";
    public void run() {
        synchronized (lock) {
            System.out.println(String.format("%s begin at %d", Thread.currentThread().getName(), System.currentTimeMillis()));

            lock = "456";

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("%s end at %d", Thread.currentThread().getName(), System.currentTimeMillis()));
        }
    }
}

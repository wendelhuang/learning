package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_13;

public class JMTP01_13_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(String.format("run:  Thread.currentThread().getName() = %s begin ", Thread.currentThread().getName()));
        System.out.println(String.format("run:  this.getName() = %s begin ", this.getName()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("run:  Thread.currentThread().getName() = %s end ", Thread.currentThread().getName()));
    }
}

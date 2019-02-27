package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_09;

public class JMTP01_09_Thread extends Thread {
    private int i = 5;

    @Override
    public void run() {
        super.run();
        System.out.println(String.format("threadname: %s, i: %d", Thread.currentThread().getName(), i--));
    }
}

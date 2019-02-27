package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_07;

public class JMTP01_07_Thread extends Thread {
    private int count = 5;
    @Override
    //synchronized public void run() {
    public void run() {
        super.run();
        count -- ;
        System.out.println(String.format("由%s计算, count = %d", Thread.currentThread().getName(), count));
    }
}

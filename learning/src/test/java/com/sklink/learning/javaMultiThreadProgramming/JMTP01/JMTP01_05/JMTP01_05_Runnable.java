package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_05;

public class JMTP01_05_Runnable implements Runnable {
    @Override
    public void run() {
        System.out.println(String.format("%s 运行中!", Thread.currentThread().getName()));
    }
}

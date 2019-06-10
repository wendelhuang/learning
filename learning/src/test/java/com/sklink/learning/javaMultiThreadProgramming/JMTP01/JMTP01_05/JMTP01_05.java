package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_05;

public class JMTP01_05 {
    public static void main(String[] args) {
        Runnable runnable = new JMTP01_05_Runnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(String.format("%s 运行结束!", Thread.currentThread().getName()));
    }
}

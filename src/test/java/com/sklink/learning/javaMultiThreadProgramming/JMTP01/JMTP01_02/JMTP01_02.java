package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_02;

public class JMTP01_02 {
    public static void main(String[] args) {
        JMTP01_02_Thread thread = new JMTP01_02_Thread();
        thread.start();
        System.out.println("运行结束");
    }
}

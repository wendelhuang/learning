package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_12;

public class JMTP01_12 {
    public static void main(String[] args) {
        JMTP01_12_CountOperate mythread = new JMTP01_12_CountOperate();
        Thread t1 = new Thread(mythread);
        t1.setName("t1");
        t1.start();
    }
}

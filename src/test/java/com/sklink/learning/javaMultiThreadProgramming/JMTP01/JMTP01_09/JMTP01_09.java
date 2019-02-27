package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_09;

public class JMTP01_09 {
    public static void main(String[] args) {
        JMTP01_09_Thread mythread = new JMTP01_09_Thread();
        Thread t1 = new Thread(mythread);
        Thread t2 = new Thread(mythread);
        Thread t3 = new Thread(mythread);
        Thread t4 = new Thread(mythread);
        Thread t5 = new Thread(mythread);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

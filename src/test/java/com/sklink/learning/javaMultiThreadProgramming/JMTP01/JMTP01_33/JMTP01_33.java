package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_33;

public class JMTP01_33 {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            JMTP01_33_Thread1 thread1 = new JMTP01_33_Thread1();
            thread1.setPriority(Thread.MAX_PRIORITY);
            thread1.start();

            JMTP01_33_Thread2 thread2 = new JMTP01_33_Thread2();
            thread2.setPriority(Thread.MIN_PRIORITY);
            thread2.start();
        }
    }
}

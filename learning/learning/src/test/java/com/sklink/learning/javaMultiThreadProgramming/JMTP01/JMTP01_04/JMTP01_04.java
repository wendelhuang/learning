package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_04;

public class JMTP01_04 {
    public static void main(String[] args) {
        JMTP01_04_Thread thread1 = new JMTP01_04_Thread(1);
        JMTP01_04_Thread thread2 = new JMTP01_04_Thread(2);
        JMTP01_04_Thread thread3 = new JMTP01_04_Thread(3);
        JMTP01_04_Thread thread4 = new JMTP01_04_Thread(4);
        JMTP01_04_Thread thread5 = new JMTP01_04_Thread(5);
        JMTP01_04_Thread thread6 = new JMTP01_04_Thread(6);
        JMTP01_04_Thread thread7 = new JMTP01_04_Thread(7);
        JMTP01_04_Thread thread8 = new JMTP01_04_Thread(8);
        JMTP01_04_Thread thread9 = new JMTP01_04_Thread(9);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
    }
}

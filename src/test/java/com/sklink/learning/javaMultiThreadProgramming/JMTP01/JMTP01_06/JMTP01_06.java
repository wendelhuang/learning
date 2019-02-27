package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_06;

public class JMTP01_06 {
    public static void main(String[] args) {
        JMTP01_06_Thread threadA = new JMTP01_06_Thread("A");
        JMTP01_06_Thread threadB = new JMTP01_06_Thread("B");
        JMTP01_06_Thread threadC = new JMTP01_06_Thread("C");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

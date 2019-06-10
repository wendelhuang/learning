package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_01;

public class JMTP02_01 {
    public static void main(String[] args) {
        JMTP02_01_HasSelfPrivateNum numRef = new JMTP02_01_HasSelfPrivateNum();
        JMTP02_01_ThreadA threadA = new JMTP02_01_ThreadA(numRef);
        JMTP02_01_ThreadB threadB = new JMTP02_01_ThreadB(numRef);

        threadA.start();
        threadB.start();
    }
}

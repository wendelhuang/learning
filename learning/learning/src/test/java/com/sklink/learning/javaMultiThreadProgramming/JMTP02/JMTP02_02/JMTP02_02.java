package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_02;

public class JMTP02_02 {
    public static void main(String[] args) {
        JMTP02_02_HasSelfPrivateNum numRef = new JMTP02_02_HasSelfPrivateNum();
        JMTP02_02_ThreadA threadA = new JMTP02_02_ThreadA(numRef);
        JMTP02_02_ThreadB threadB = new JMTP02_02_ThreadB(numRef);

        threadA.start();
        threadB.start();
    }
}

package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_03;

public class JMTP02_03 {
    public static void main(String[] args) {
        JMTP02_03_HasSelfPrivateNum numRef1 = new JMTP02_03_HasSelfPrivateNum();
        JMTP02_03_HasSelfPrivateNum numRef2 = new JMTP02_03_HasSelfPrivateNum();
        JMTP02_03_ThreadA threadA = new JMTP02_03_ThreadA(numRef1);
        JMTP02_03_ThreadB threadB = new JMTP02_03_ThreadB(numRef2);

        threadA.start();
        threadB.start();
    }
}

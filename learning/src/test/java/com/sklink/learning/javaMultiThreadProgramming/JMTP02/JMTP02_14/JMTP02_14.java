package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_14;

public class JMTP02_14 {
    public static void main(String[] args) {
        JMTP02_14_ObjectService service = new JMTP02_14_ObjectService();
        JMTP02_14_ThreadA a = new JMTP02_14_ThreadA(service);
        JMTP02_14_ThreadB b = new JMTP02_14_ThreadB(service);

        a.start();
        b.start();
    }
}

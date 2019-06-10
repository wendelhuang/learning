package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_04;

public class JMTP02_04 {
    public static void main(String[] args) {
        JMTP02_04_MyObject object = new JMTP02_04_MyObject();
        JMTP02_04_ThreadA a = new JMTP02_04_ThreadA(object);
        a.setName("A");

        JMTP02_04_ThreadB b = new JMTP02_04_ThreadB(object);
        b.setName("B");

        a.start();
        b.start();
    }
}

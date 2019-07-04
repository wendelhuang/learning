package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_05;

public class JMTP02_05 {
    public static void main(String[] args) {
        JMTP02_05_MyObject object = new JMTP02_05_MyObject();
        JMTP02_05_ThreadA a = new JMTP02_05_ThreadA(object);
        a.setName("A");

        JMTP02_05_ThreadB b = new JMTP02_05_ThreadB(object);
        b.setName("B");

        a.start();
        b.start();
    }
}

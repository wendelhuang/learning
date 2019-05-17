package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_17;

public class JMTP02_17 {
    public static void main(String[] args) {
        JMTP02_17_Service service = new JMTP02_17_Service();
        JMTP02_17_ThreadA a = new JMTP02_17_ThreadA(service);
        a.setName("a");
        JMTP02_17_ThreadB b = new JMTP02_17_ThreadB(service);
        b.setName("b");
        JMTP02_17_ThreadC c = new JMTP02_17_ThreadC(service);
        c.setName("c");

        a.start();
        b.start();
        c.start();
    }
}

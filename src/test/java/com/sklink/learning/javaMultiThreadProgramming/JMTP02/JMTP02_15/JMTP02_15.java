package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_15;

public class JMTP02_15 {
    public static void main(String[] args) {
        JMTP02_15_MyList list = new JMTP02_15_MyList();
        JMTP02_15_Thread a = new JMTP02_15_Thread(list);
        a.setName("a");
        JMTP02_15_Thread b = new JMTP02_15_Thread(list);
        b.setName("b");
        a.start();
        b.start();
    }
}

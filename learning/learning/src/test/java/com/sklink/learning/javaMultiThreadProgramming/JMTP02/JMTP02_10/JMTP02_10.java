package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_10;

public class JMTP02_10 {
    public static void main(String[] args) {
        JMTP02_10_Sub sub = new JMTP02_10_Sub();
        JMTP02_10_Thread a = new JMTP02_10_Thread(sub);
        JMTP02_10_Thread b = new JMTP02_10_Thread(sub);

        a.start();
        b.start();
    }
}

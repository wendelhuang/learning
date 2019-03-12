package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_06;

public class JMTP02_06 {
    public static void main(String[] args) {
        JMTP02_06_PublicVar publicVar = new JMTP02_06_PublicVar();
        JMTP02_06_ThreadA thread = new JMTP02_06_ThreadA(publicVar);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publicVar.getValue();
    }
}

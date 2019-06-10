package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_01;

public class JMTP02_01_ThreadA extends Thread {
    private JMTP02_01_HasSelfPrivateNum numRef;
    public JMTP02_01_ThreadA(JMTP02_01_HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        this.numRef.AddI("a");
    }
}

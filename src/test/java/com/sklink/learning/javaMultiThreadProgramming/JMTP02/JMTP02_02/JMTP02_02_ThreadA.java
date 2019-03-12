package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_02;

public class JMTP02_02_ThreadA extends Thread {
    private JMTP02_02_HasSelfPrivateNum numRef;
    public JMTP02_02_ThreadA(JMTP02_02_HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        this.numRef.AddI("a");
    }
}

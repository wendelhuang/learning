package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_03;

public class JMTP02_03_ThreadB extends Thread {
    private JMTP02_03_HasSelfPrivateNum numRef;
    public JMTP02_03_ThreadB(JMTP02_03_HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        this.numRef.AddI("b");
    }
}

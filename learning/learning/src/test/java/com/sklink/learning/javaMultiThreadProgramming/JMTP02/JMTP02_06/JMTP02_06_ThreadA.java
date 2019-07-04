package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_06;

public class JMTP02_06_ThreadA extends Thread {
    private JMTP02_06_PublicVar publicVar;
    public JMTP02_06_ThreadA(JMTP02_06_PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        this.publicVar.setValue("B", "BB");
    }
}

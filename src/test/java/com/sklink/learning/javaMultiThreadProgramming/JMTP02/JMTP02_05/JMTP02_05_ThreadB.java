package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_05;

public class JMTP02_05_ThreadB extends Thread {
    private JMTP02_05_MyObject object;
    public JMTP02_05_ThreadB(JMTP02_05_MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        this.object.methodB();
    }
}

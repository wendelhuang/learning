package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_04;

public class JMTP02_04_ThreadB extends Thread {
    private JMTP02_04_MyObject object;
    public JMTP02_04_ThreadB(JMTP02_04_MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        this.object.methodA();
    }
}

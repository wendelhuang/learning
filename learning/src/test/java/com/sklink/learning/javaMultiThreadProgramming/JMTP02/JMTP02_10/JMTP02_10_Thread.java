package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_10;

public class JMTP02_10_Thread extends Thread {
    private JMTP02_10_Sub sub;
    public JMTP02_10_Thread(JMTP02_10_Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        super.run();
        this.sub.serviceMethod();
    }
}

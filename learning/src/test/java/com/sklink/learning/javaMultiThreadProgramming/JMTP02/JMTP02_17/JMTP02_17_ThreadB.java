package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_17;

public class JMTP02_17_ThreadB extends Thread {
    private JMTP02_17_Service service;
    public JMTP02_17_ThreadB(JMTP02_17_Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.printB();
    }
}

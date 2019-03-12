package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_14;

public class JMTP02_14_ThreadB extends Thread {
    JMTP02_14_ObjectService service;
    public JMTP02_14_ThreadB(JMTP02_14_ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        this.service.serviceMethodB();
    }
}

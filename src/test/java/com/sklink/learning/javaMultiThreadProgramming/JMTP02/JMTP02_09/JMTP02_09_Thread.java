package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_09;

public class JMTP02_09_Thread extends Thread {
    private JMTP02_09_Service service;
    public JMTP02_09_Thread(JMTP02_09_Service service) {
        this.service = service;
    }
    @Override
    public void run() {
        super.run();
        this.service.testMethod();
    }
}

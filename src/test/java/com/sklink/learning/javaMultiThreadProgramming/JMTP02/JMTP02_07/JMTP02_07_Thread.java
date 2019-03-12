package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_07;

public class JMTP02_07_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        JMTP02_07_Service service = new JMTP02_07_Service();
        service.service1();
    }
}

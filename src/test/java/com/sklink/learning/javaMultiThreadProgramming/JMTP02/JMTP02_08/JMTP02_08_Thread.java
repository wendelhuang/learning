package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_08;

public class JMTP02_08_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        JMTP02_08_Sub sub = new JMTP02_08_Sub();
        sub.operateISubMethod();
    }
}

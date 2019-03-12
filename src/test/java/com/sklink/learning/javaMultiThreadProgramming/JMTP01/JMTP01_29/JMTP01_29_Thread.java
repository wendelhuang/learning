package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_29;

public class JMTP01_29_Thread extends Thread {
    private long i = 0;
    @Override
    public void run() {
        super.run();
        while(true) {
            i++;
            System.out.println(i);
        }
    }
}

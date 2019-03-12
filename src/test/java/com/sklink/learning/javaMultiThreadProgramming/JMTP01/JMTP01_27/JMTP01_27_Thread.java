package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_27;

public class JMTP01_27_Thread extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            i++;
        }
    }
}

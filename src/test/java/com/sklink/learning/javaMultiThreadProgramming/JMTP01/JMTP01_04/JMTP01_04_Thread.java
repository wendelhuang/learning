package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_04;

public class JMTP01_04_Thread extends Thread{
    private int i;
    public JMTP01_04_Thread(int i) {
        super();
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(i);
    }
}

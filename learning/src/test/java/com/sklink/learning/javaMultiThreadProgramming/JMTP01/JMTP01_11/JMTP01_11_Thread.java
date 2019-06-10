package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_11;

public class JMTP01_11_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(String.format("run: isAlive = %B", this.isAlive()));
    }
}

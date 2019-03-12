package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_31;

public class JMTP01_31_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 50000000; i++) {
            //Thread.yield();
            count += (i+1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("用时%d毫秒", endTime - beginTime));
    }
}

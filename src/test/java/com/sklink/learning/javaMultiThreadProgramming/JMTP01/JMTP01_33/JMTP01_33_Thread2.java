package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_33;

public class JMTP01_33_Thread2 extends Thread {
    @Override
    public void run() {
        super.run();
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 50000; j++) {
                addResult += (i+j);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Thread2计算结果: %d, 用时%d毫秒", addResult, endTime - beginTime));
    }
}

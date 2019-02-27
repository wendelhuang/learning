package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_06;

public class JMTP01_06_Thread extends Thread {
    private int count = 5;
    public JMTP01_06_Thread(String name) {
        super();
        this.setName(name);
    }
    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count -- ;
            System.out.println(String.format("由%s计算, count = %d", Thread.currentThread().getName(), count));
        }
    }
}

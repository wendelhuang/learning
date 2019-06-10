package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_10;

public class JMTP01_10_CountOperate extends Thread {
    public static int count = 1;
    public JMTP01_10_CountOperate() {
        super.setName("AAA" + count);
        count++;
        System.out.println("JMTP01_10_CountOperate------begin");
        System.out.println(String.format("Thread.currentThread().getName() = %s", Thread.currentThread().getName()));
        System.out.println(String.format("this.getName() = %s", this.getName()));
        System.out.println("JMTP01_10_CountOperate------end");
    }
    @Override
    public void run() {
        super.run();
        System.out.println("run------begin");
        System.out.println(String.format("Thread.currentThread().getName() = %s", Thread.currentThread().getName()));
        System.out.println(String.format("this.getName() = %s", this.getName()));
        System.out.println("run------end");
    }
}

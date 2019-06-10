package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_12;

public class JMTP01_12_CountOperate extends Thread {
    public JMTP01_12_CountOperate() {
        System.out.println("CountOperate---begin");
        System.out.println(String.format("Thread.currentThread().getName() = %s", Thread.currentThread().getName()));
        System.out.println(String.format("Thread.currentThread().isAlive() = %B", Thread.currentThread().isAlive()));
        System.out.println(String.format("this.getName = %s", this.getName()));
        System.out.println(String.format("this.isAlive() = %B", this.isAlive()));
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run---begin");
        System.out.println(String.format("Thread.currentThread().getName() = %s", Thread.currentThread().getName()));
        System.out.println(String.format("Thread.currentThread().isAlive() = %B", Thread.currentThread().isAlive()));
        System.out.println(String.format("this.getName = %s", this.getName()));
        System.out.println(String.format("this.isAlive() = %B", this.isAlive()));
        System.out.println("run---end");
    }
}

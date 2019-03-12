package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_34;

public class JMTP01_34 {
    public static void main(String[] args) {
        JMTP01_34_Thread thread = new JMTP01_34_Thread();
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我离开thread对象也不再打印了, 也就是停止了");
    }
}

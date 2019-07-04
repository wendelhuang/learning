package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_28;

public class JMTP01_28 {
    public static void main(String[] args) {
        final JMTP01_28_SynchronizedObject synchronizedObject = new JMTP01_28_SynchronizedObject();
        Thread thread1 = new Thread(()->synchronizedObject.printString());
        thread1.setName("a");
        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread thread2 = new Thread(() -> {
            System.out.println("thread2启动了, 但进入不了printString方法, 只打印一个begin, 因为printString方法被a线程锁定并永远suspend暂停了");
            synchronizedObject.printString();
        });
        thread2.start();
    }
}

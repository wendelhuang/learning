package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_17;

public class JMTP02_17_Service {
    synchronized public static void printA() {
        try {
            System.out.println(String.format("Thread %s 在 %d 进入printA", Thread.currentThread().getName(), System.currentTimeMillis()));
            Thread.sleep(5000);
            System.out.println(String.format("Thread %s 在 %d 退出printA", Thread.currentThread().getName(), System.currentTimeMillis()));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public static void printB() {
        System.out.println(String.format("Thread %s 在 %d 进入printB", Thread.currentThread().getName(), System.currentTimeMillis()));
        System.out.println(String.format("Thread %s 在 %d 退出printB", Thread.currentThread().getName(), System.currentTimeMillis()));
    }
    synchronized public void printC() {
        System.out.println(String.format("Thread %s 在 %d 进入printC", Thread.currentThread().getName(), System.currentTimeMillis()));
        System.out.println(String.format("Thread %s 在 %d 退出printC", Thread.currentThread().getName(), System.currentTimeMillis()));
    }
}

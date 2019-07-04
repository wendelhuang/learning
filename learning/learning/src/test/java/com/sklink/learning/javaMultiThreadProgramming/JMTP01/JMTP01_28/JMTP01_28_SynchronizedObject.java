package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_28;

public class JMTP01_28_SynchronizedObject {
    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a 线程永远suspend了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}

package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_27;

public class JMTP01_27 {
    public static void main(String[] args) {
        JMTP01_27_Thread mythread = new JMTP01_27_Thread();
        mythread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread.suspend();
        System.out.println(String.format("A = %d, i = %d", System.currentTimeMillis(), mythread.getI()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread.resume();
        System.out.println(String.format("B = %d, i = %d", System.currentTimeMillis(), mythread.getI()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread.suspend();
        System.out.println(String.format("C = %d, i = %d", System.currentTimeMillis(), mythread.getI()));
    }
}

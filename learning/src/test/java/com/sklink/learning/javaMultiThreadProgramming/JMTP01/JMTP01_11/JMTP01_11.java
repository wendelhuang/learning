package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_11;

public class JMTP01_11 {
    public static void main(String[] args) {
        JMTP01_11_Thread mythread = new JMTP01_11_Thread();
        System.out.println(String.format("begin, isAlive = %B", mythread.isAlive()));
        mythread.start();
        System.out.println(String.format("end, isAlive = %B", mythread.isAlive()));
    }
}

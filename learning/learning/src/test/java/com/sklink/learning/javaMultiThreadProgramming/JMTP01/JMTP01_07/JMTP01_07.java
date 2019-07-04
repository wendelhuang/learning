package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_07;

public class JMTP01_07 {
    public static void main(String[] args) {
        JMTP01_07_Thread mythread = new JMTP01_07_Thread();
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}

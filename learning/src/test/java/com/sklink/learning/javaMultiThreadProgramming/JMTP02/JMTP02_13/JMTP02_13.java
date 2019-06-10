package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_13;

public class JMTP02_13 {
    public static void main(String[] args) {
        JMTP02_13_Task task = new JMTP02_13_Task();
        JMTP02_13_Thread a = new JMTP02_13_Thread(task);
        JMTP02_13_Thread b = new JMTP02_13_Thread(task);

        a.start();
        b.start();
    }
}

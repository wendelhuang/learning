package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_08;

public class JMTP02_08_Main {
    public int i = 10;
    synchronized public void operateIMainMethod() {
        try {
            i--;
            System.out.println(String.format("main, i: %d", i));
            Thread.sleep(500);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

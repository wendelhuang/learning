package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_08;

public class JMTP02_08_Sub extends JMTP02_08_Main {
    synchronized public void operateISubMethod() {
        try {
            while(i > 0) {
                i--;
                System.out.println(String.format("sub, i: %d", i));
                Thread.sleep(500);
                this.operateIMainMethod();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

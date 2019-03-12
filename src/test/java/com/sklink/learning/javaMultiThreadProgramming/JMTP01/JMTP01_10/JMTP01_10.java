package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_10;

public class JMTP01_10 {
    public static void main(String[] args) {
        JMTP01_10_CountOperate countOperate = new JMTP01_10_CountOperate();
        Thread t1 = new Thread(countOperate);
        t1.setName("t1");
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JMTP01_10_CountOperate countOperate2 = new JMTP01_10_CountOperate();
        countOperate2.setName("countOperate2");
        Thread t2 = new Thread(countOperate);
        t2.setName("t2");
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JMTP01_10_CountOperate countOperate3 = new JMTP01_10_CountOperate();
        countOperate3.setName("countOperate3");
        countOperate3.start();
    }
}

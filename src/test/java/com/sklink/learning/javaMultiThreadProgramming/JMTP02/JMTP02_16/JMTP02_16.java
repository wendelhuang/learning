package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_16;

public class JMTP02_16 {
    public static void main(String[] args) {
        JMTP02_16_MyList list = new JMTP02_16_MyList();
        JMTP02_16_Thread1 a = new JMTP02_16_Thread1(list);
        a.setName("a");
        JMTP02_16_Thread2 b = new JMTP02_16_Thread2(list);
        b.setName("b");
        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("size: %d", list.getSize()));
    }
}

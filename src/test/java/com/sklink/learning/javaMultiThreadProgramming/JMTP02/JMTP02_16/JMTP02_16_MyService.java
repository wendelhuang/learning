package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_16;

public class JMTP02_16_MyService {
    public JMTP02_16_MyList addMethod(JMTP02_16_MyList list, String data) {
        System.out.println(String.format("addMethod begin, list.getSize() = %d", list.getSize()));
        if (list.getSize() < 1) {
            System.out.println(String.format("Thread %s getting data, need 2 seconds", Thread.currentThread().getName()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(data);
        }
        System.out.println(String.format("addMethod end, list.getSize() = %d", list.getSize()));
        return list;
    }
}

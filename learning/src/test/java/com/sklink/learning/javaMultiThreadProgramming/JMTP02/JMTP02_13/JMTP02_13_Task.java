package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_13;

public class JMTP02_13_Task {
    public void doLongtimeTask() {
        for(int i = 0; i < 100; i++) {
            System.out.println(String.format("asynchronized Thread: %s, i: %d", Thread.currentThread().getName(), i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        synchronized (this) {
            for(int i = 0; i < 100; i++) {
                System.out.println(String.format("synchronized Thread: %s, i: %d", Thread.currentThread().getName(), i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

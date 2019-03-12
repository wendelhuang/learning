package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_20;

public class JMTP01_20_Thread extends Thread{
    @Override
    public void run() {
        super.run();
        try{
            for (int i = 0; i < 10000; i++) {
                if (this.isInterrupted()) {
                    System.out.println(String.format("Thread: %s, isInterrupted: %B, throw Exception", Thread.currentThread().getName(), this.isInterrupted()));
                    throw new InterruptedException();
                }
                System.out.println(String.format("Thread: %s, i: %d", Thread.currentThread().getName(), i));
            }
            System.out.println(String.format("Thread: %s end", Thread.currentThread().getName()));
        }catch (InterruptedException e) {
            System.out.println(String.format("Thread: %s InterruptedException catched", Thread.currentThread().getName()));
        }
    }
}

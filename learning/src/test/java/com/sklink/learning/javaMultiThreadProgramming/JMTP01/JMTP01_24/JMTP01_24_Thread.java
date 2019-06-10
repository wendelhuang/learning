package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_24;

public class JMTP01_24_Thread extends Thread {
    private int i = 0;
    @Override
    public void run() {
        super.run();
        while(true) {
            try {
                System.out.println(String.format("Thread: %s, i: %d", Thread.currentThread().getName(), i));
                i++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }catch (ThreadDeath error) {
                error.printStackTrace();
                break;
            }
        }
        System.out.println("thread end");
    }
}

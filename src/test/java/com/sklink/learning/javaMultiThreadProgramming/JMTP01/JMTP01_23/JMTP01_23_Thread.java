package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_23;

public class JMTP01_23_Thread extends Thread {
    private int i = 0;
    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                System.out.println(String.format("Thread: %s, i: %d", Thread.currentThread().getName(), i));
                i++;
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

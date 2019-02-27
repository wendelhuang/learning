package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_03;

public class JMTP01_03_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        try{
            for(int i = 0; i < 10; i++) {
                int time  = (int)(Math.random() * 1000);
                Thread.sleep(time);
                System.out.println(String.format("run: %s", Thread.currentThread().getName()));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

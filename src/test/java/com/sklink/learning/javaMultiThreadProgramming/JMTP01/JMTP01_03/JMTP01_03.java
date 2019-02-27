package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_03;

public class JMTP01_03 {
    public static void main(String[] args) {
        try{
            JMTP01_03_Thread thread = new JMTP01_03_Thread();
            thread.setName("myThread");
            thread.start();
            for(int i = 0; i < 10; i++) {
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
                System.out.println(String.format("main: %s", Thread.currentThread().getName()));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

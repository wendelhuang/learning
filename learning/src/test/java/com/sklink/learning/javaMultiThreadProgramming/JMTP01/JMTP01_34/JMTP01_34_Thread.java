package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_34;

public class JMTP01_34_Thread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        super.run();
        while(true) {
            try{
                i++;
                System.out.println(String.format("i: %d", i));
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

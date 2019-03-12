package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_26;

public class JMTP01_26_Thread extends Thread {
    @Override
    public void run() {
        super.run();
        while(true) {
            if (this.isInterrupted()) {
                System.out.println("停止了!");
                return;
            }
            System.out.println("timer = " + System.currentTimeMillis());

            /*
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
        }
    }
}

package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_15;

import org.springframework.util.StopWatch;

public class JMTP01_15_Thread extends Thread{
    @Override
    public void run() {
        super.run();
        StopWatch stopWatch = new StopWatch("thread");
        stopWatch.start("run");
        for(int i = 0; i < 500000; i++) {
            System.out.println(String.format("Thread: %s, i: %d", Thread.currentThread().getName(), i));
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}

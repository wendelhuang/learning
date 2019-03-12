package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_13;

public class JMTP02_13_Thread extends Thread {
    private JMTP02_13_Task task;
    public JMTP02_13_Thread(JMTP02_13_Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        this.task.doLongtimeTask();
    }
}

package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_11;

public class JMTP02_11_ThreadB extends Thread {
    private JMTP02_11_Task task;
    public JMTP02_11_ThreadB(JMTP02_11_Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        JMTP02_11_CommonUtils.beginTime2 = System.currentTimeMillis();
        this.task.doLongTimeTask();
        JMTP02_11_CommonUtils.endTime2 = System.currentTimeMillis();
    }
}

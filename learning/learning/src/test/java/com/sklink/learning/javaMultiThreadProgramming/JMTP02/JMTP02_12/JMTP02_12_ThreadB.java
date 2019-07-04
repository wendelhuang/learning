package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_12;

public class JMTP02_12_ThreadB extends Thread {
    private JMTP02_12_Task task;
    public JMTP02_12_ThreadB(JMTP02_12_Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        JMTP02_12_CommonUtils.beginTime2 = System.currentTimeMillis();
        this.task.doLongTimeTask();
        JMTP02_12_CommonUtils.endTime2 = System.currentTimeMillis();
    }
}

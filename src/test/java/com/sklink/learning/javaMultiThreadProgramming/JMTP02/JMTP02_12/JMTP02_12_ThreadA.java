package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_12;

public class JMTP02_12_ThreadA extends Thread {
    private JMTP02_12_Task task;
    public JMTP02_12_ThreadA(JMTP02_12_Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        JMTP02_12_CommonUtils.beginTime1 = System.currentTimeMillis();
        this.task.doLongTimeTask();
        JMTP02_12_CommonUtils.endTime1 = System.currentTimeMillis();
    }
}

package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_25;

public class JMTP01_25_Thread extends Thread {
    private JMTP01_25_SynchronizedObject synchronizedObject;
    public JMTP01_25_Thread(JMTP01_25_SynchronizedObject synchronizedObject) {
        this.synchronizedObject = synchronizedObject;
    }
    @Override
    public void run() {
        super.run();
        synchronizedObject.printString("b", "bb");
    }
}

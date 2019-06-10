package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_15;

public class JMTP02_15_Thread extends Thread {
    private JMTP02_15_MyList myList;
    public JMTP02_15_Thread(JMTP02_15_MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i < 100; i++) {
            myList.add(String.format("%d", i));
        }
    }
}

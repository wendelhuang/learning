package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_16;

public class JMTP02_16_Thread1 extends Thread {
    private JMTP02_16_MyList myList;
    public JMTP02_16_Thread1(JMTP02_16_MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        super.run();
        JMTP02_16_MyService service = new JMTP02_16_MyService();
        service.addMethod(myList, "A");
    }
}

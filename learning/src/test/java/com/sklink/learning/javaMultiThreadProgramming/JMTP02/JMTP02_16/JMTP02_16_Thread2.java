package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_16;

public class JMTP02_16_Thread2 extends Thread {
    private JMTP02_16_MyList myList;
    public JMTP02_16_Thread2(JMTP02_16_MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JMTP02_16_MyService service = new JMTP02_16_MyService();
        service.addMethod(myList, "B");
    }
}

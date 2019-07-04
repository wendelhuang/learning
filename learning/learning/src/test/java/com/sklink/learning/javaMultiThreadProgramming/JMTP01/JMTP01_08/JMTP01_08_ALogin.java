package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_08;

public class JMTP01_08_ALogin extends Thread {
    @Override
    public void run() {
        super.run();
        JMTP01_08_LoginServlet.doPost("a", "aa");
    }
}

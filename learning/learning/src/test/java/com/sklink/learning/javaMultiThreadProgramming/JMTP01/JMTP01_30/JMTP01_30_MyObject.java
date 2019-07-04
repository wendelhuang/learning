package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_30;

public class JMTP01_30_MyObject {
    private String username = "1";
    private String password = "11";

    public void setValue(String u, String p) {
        this.username = u;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("停止a线程");
            Thread.currentThread().suspend();
        }
        this.password = p;
    }
    public void printUsernamePassword() {
        System.out.println(String.format("%s %s", this.username, this.password));
    }
}

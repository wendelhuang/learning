package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_06;

public class JMTP02_06_PublicVar {
    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;

        System.out.println(String.format("setValue, Thread: %s, username: %s, password: %s",
                Thread.currentThread().getName(), this.username, this.password));
    }

    public void getValue() {
        System.out.println(String.format("getValue, Thread: %s, username: %s, password: %s",
                Thread.currentThread().getName(), this.username, this.password));
    }
}

package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_18;

public class JMTP02_18_DeadThread implements Runnable {
    public String username;
    public Object o1 = new Object();
    public Object o2 = new Object();
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        if (this.username.equals("a")) {
            synchronized (o1) {
                System.out.println(String.format("threadName = %s", this.username));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("lock1 -> lock2");
                }
            }
        }
        if (this.username.equals("b")) {
            synchronized (o2) {
                System.out.println(String.format("threadName = %s", this.username));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("lock2 -> lock1");
                }
            }
        }
    }
}

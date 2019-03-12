package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_04;

public class JMTP02_04_MyObject {
    //public void methodA() {
    synchronized public void methodA() {
        try{
            System.out.println(String.format("begin methodA threadName = %s", Thread.currentThread().getPriority()));
            Thread.sleep(5000);
            System.out.println("end");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

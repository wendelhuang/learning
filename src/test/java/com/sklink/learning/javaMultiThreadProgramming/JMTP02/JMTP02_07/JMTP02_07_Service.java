package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_07;

public class JMTP02_07_Service {
    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }
    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }
    synchronized public void service3() {
        System.out.println("service3");
    }
}

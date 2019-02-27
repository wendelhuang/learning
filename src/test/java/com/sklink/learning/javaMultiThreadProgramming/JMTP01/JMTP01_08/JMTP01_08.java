package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_08;

public class JMTP01_08 {
    public static void main(String[] args) {
        JMTP01_08_ALogin a = new JMTP01_08_ALogin();
        a.start();
        JMTP01_08_BLogin b = new JMTP01_08_BLogin();
        b.start();
    }
}

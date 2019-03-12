package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_17;

public class JMTP01_17 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(String.format("interrupted: %B", Thread.interrupted()));
        System.out.println(String.format("interrupted: %B", Thread.interrupted()));
    }
}

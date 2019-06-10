package com.sklink.learning.lambda.functionReference01;

public class TestFunctionReference01 {
    public static class Inner implements Runnable {

        @Override
        public void run() {
            System.out.println("aaa");
        }
    }
    public static void main(String[] args) {
        Inner inner = new Inner();
        Thread t1 = new Thread(inner::run);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_02;

public class JMTP02_02_HasSelfPrivateNum {
    private int num = 0;
    //synchronized public void AddI(String username) {
    public void AddI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set 100 over");
                Thread.sleep(2000);
            }else{
                num = 200;
                System.out.println("b set 200 over");
            }
            System.out.println(String.format("%s, num = %d", username, num));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

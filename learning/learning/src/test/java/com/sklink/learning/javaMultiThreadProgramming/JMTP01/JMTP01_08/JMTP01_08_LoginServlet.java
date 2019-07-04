package com.sklink.learning.javaMultiThreadProgramming.JMTP01.JMTP01_08;

public class JMTP01_08_LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    //public static void doPost(String username, String password) {
    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println(String.format("username = %s, password = %s", usernameRef, password));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.sklink.learning.oo.oo01;

public interface MyInterface {
    void laugh();
    default void cry() {
        System.out.println("cry");
    }
    static void jump() {
        System.out.println("jump");
    }
}

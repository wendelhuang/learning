package com.sklink.learning.oo.oo01;

public abstract class MyAbstractClass {
    abstract void laugh();
    public void cry() {
        System.out.println("abstract class cry");
    }
    static void jump() {
        System.out.println("abstract class jump");
    }

    // 编译错误, static和abstrct不能连用
    //static abstract void sleep();
    static void sleep() {
        System.out.println("abstract class sleep");
    }
}

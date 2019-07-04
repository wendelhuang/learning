package com.sklink.learning.lang.static01;

class StaticParent {
    public static int staticValue;
    private static int staticVisible;
    static {
        System.out.println(String.format("父类staticValue赋值前=%d", staticValue));
        staticValue = 99;
        System.out.println(String.format("父类staticValue赋值后=%d", staticValue));
    }
    static {
        System.out.println("父类静态代码块执行");
    }
    void show() {
        System.out.println("父类方法被执行");
    }
    private static void staticVisibleFunction() {

    }

}
public class TestStatic01 extends StaticParent{
    static {
        System.out.println("子类静态代码块执行");
    }

    void show() {
        System.out.println("子类方法被执行");
    }

    public static void main(String[] args) {
        System.out.println("main函数执行");
        TestStatic01 testStatic01 = new TestStatic01();
        testStatic01.show();
    }

}

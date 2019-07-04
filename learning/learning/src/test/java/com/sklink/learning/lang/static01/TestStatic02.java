package com.sklink.learning.lang.static01;

class StaticParent02 {
    static {
        System.out.println("父类静态代码块执行");
    }
    {
        System.out.println("父类非静态代码块执行");
    }
    void show() {
        System.out.println("父类方法被执行");
    }
    StaticParent02() {
        System.out.println("父类构造方法执行");
    }
}

public class TestStatic02 extends StaticParent02{
    static {
        System.out.println("子类静态代码块执行");
    }
    {
        System.out.println("子类非静态代码块执行");
    }

    TestStatic02() {
        System.out.println("子类构造方法执行");
    }

    void show() {
        System.out.println("子类方法被执行");
    }

    public static void main(String[] args) {
        System.out.println("main函数执行");
        TestStatic02 testStatic02 = new TestStatic02();
        testStatic02.show();
        System.out.println("-----------------------------");
        TestStatic02 testStatic021 = new TestStatic02();
        testStatic021.show();
    }

}

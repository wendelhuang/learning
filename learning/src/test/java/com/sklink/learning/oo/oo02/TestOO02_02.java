package com.sklink.learning.oo.oo02;

class Base02 {
    public String s1 = "基类实例变量s1";
    private static String s2 = "基类静态变量s2";

    public void f() {
        System.out.println("基类方法");
    }

    private void f2() {
        System.out.println("基类private方法");
    }
}
class Child02 extends Base02 {
    public String s1 = "子类实例变量s1";
    private static String s2 = "子类静态变量s2";

    public void f() {
        System.out.println("子类方法");
    }
    public void f2() {
        System.out.println("基类private方法");
    }
}
public class TestOO02_02 {
    public static void main(String[] args) {
        Child02 child02 = new Child02();
        System.out.println(((Base02)child02).s1);
        ((Base02)child02).f();
        /**
         * 需写在Base02类中
         */
        //((Base02)child02).f2();
    }
}

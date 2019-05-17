package com.sklink.learning.oo.oo02;

class Base {
    private int x3 = initPrint1();
    public String s3 = "基类实例变量s3";

    private static int x4 = initPrint2();
    private static String s4 = "基类静态变量s4";

    private int initPrint1() {
        System.out.println(String.format("基类initPrint1 实例变量s3 = %s", s3));
        System.out.println(String.format("基类initPrint1 静态变量s4 = %s", s4));
        return 11;
    }

    private static int initPrint2() {
        System.out.println(String.format("基类initPrint2 静态变量s4 = %s", s4));
        return 21;
    }
    public Base() {
        System.out.println("基类无参构造器");
    }
    public Base(int i) {
        System.out.println(String.format("基类构造器 i= %d", i));
    }
    public void callName() {
        System.out.println(s3);
    }
    public static void sMethodBase() {
        System.out.println(String.format("基类静态方法sMethodBase 静态变量s4 = %s", s4));
    }
}

class Child extends Base {
    private int x1 = initPrint1();
    public String s1 = "子类实例变量s1";

    private static int x3 = initPrint2();
    public static String s2 = "子类静态变量s2";

    private int initPrint1() {
        System.out.println(String.format("子类initPrint1 实例变量s1 = %s", s1));
        System.out.println(String.format("子类initPrint1 静态变量s2 = %s", s2));
        return 11;
    }

    private static int initPrint2() {
        System.out.println(String.format("子类initPrint2 静态变量s2 = %s", s2));
        return 21;
    }

    public Child(String s) {
        super(1);
        System.out.println("子类构造器");
    }

    public void callName() {
        System.out.println(s1);
    }

    public static void sMethodChild() {
        System.out.println(String.format("子类静态方法sMethodChild 静态变量s2 = %s", s2));
    }
}

public class TestOO02_01 {
    public static void main(String[] args) {
        //Child.sMethodBase();

        //Child.sMethodChild();

        Child child = new Child("s");
    }
}

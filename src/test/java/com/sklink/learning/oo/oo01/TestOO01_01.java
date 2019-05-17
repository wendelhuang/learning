package com.sklink.learning.oo.oo01;

public class TestOO01_01 {
    public static void main(String[] args) {
        MyClass01 myClass01 = new MyClass01();
        myClass01.laugh();
        myClass01.cry();
        // 编译错误, 接口的static方法不会被继承
        //MyClass.jump();
        MyInterface.jump();
    }
}

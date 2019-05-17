package com.sklink.learning.oo.oo02;

/**
 * 牛客网题目
 */
public class TestOO02_03 {
    private String baseName = "base";
    public TestOO02_03() {
        callName();
    }
    public void callName() {
        System.out.println(baseName);
    }
    static class Sub extends TestOO02_03 {
        private String baseName = "sub";
        public Sub() {
            System.out.println(String.format("子类构造函数, baseName = %s", baseName));
        }
        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        TestOO02_03 testOO02_03 = new Sub();
    }
}

package com.sklink.learning.framework.annotation01;

public class EmployeeDAOTest {
    @MyBefore
    public void setup() {
        System.out.println("setup");
    }
    @MyTest
    public void testSave() {
        System.out.println("save...");
    }
    @MyTest
    public void testDelete() {
        System.out.println("delete...");
    }
    @MyAfter
    public void destroy() {
        System.out.println("destroy");
    }
}

package com.sklink.learning.classLoader.classLoader002;

public class ClassLoader002_ClassForName {
	static {
		System.out.println("执行了静态代码块");
	}
	private static String staticField = staticMethod();
			
	public static String staticMethod() {
		System.out.println("执行了静态方法");
		return "给静态字段赋值";
	}
}

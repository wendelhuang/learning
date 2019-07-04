package com.sklink.learning.classLoader.classLoader001;

/**
 * TestClassLoader001_003_Long
 */
public class Long {
	public void testClassLoader() {
		System.out.println(String.format("自定义Long类被%s加载了", Long.class.getClassLoader()));
	}
	
	public static void main(String[] args) {
		System.out.println("Long");
	}
}

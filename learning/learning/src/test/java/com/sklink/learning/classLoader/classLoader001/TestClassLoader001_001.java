package com.sklink.learning.classLoader.classLoader001;


public class TestClassLoader001_001 {
	public static void main(String[] args) {
		System.out.println(TestClassLoader001_001.class.getClassLoader());
		System.out.println(TestClassLoader001_001.class.getClassLoader().getParent());
		System.out.println(TestClassLoader001_001.class.getClassLoader().getParent().getParent());
	}
}

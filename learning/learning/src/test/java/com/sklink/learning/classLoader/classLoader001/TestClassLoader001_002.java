package com.sklink.learning.classLoader.classLoader001;

import java.util.Arrays;

public class TestClassLoader001_002 {
	public static void main(String[] args) {
		
		printClass("sun.boot.class.path");
		printClass("java.ext.dirs");
		printClass("java.class.path");
	}
	
	private static void printClass(String prop) {
		System.out.println(String.format("-------------%s------------", prop));
		String property = System.getProperty(prop);
		Arrays.asList(property.split(";")).forEach(System.out::println);
	}
}

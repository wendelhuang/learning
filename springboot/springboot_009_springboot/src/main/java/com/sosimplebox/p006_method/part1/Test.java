package com.sosimplebox.p006_method.part1;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		test();
		test1();
		test2();
	}
	
	public static void test() throws NoSuchMethodException, SecurityException {
		Method method = MethodTest.class.getDeclaredMethod("test");
		AnnotatedType annotatedType = method.getAnnotatedReturnType();
		System.out.println(annotatedType.getType());
	}
	
	public static void test1() throws NoSuchMethodException, SecurityException {
		Method method = MethodTest.class.getDeclaredMethod("test1");
		AnnotatedType[] annotatedTypes = method.getAnnotatedExceptionTypes();
		for(AnnotatedType t : annotatedTypes) {
			System.out.println(t.getType());
		}
	}
	public static void test2() throws NoSuchMethodException, SecurityException {
		Method method = MethodTest.class.getDeclaredMethod("test");
		AnnotatedType annotatedType = method.getAnnotatedReceiverType();
		System.out.println(annotatedType.getType());
	}
}

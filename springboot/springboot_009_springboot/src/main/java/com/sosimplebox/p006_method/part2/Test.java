package com.sosimplebox.p006_method.part2;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = MethodTest.class.getDeclaredMethod("test");
		MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
		System.out.println(methodAnnotation);
		System.out.println(methodAnnotation.key());
		System.out.println(methodAnnotation.value());
	}
}

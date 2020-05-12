package com.sosimplebox.p005_import.part1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTestDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestDemo.class);
		String[] beanDefinationNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanDefinationNames) {
			System.out.println(name);
		}
 	}
}

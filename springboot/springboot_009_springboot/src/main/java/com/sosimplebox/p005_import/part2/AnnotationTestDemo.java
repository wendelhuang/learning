package com.sosimplebox.p005_import.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTestDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}

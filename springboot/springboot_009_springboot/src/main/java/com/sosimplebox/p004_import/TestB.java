package com.sosimplebox.p004_import;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestB {
	
	public void fun(String str) {
		System.out.println(str);
	}
	
	public void printName() {
		System.out.println("className: " + Thread.currentThread().getStackTrace()[1].getClassName());
	}

}

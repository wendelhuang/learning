package com.sosimplebox.p001_factorybean.demo.print;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrint implements IPrint{

	@Override
	public boolean verify(Integer condition) {
		return condition <= 0;
	}

	@Override
	public void print(String msg) {
		System.out.println("console print: " + msg);
		
	}
	
}

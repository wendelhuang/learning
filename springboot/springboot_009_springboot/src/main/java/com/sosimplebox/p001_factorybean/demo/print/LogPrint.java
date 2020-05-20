package com.sosimplebox.p001_factorybean.demo.print;

import org.springframework.stereotype.Component;

@Component
public class LogPrint implements IPrint{

	@Override
	public boolean verify(Integer condition) {
		return condition > 0;
	}

	@Override
	public void print(String msg) {
		System.out.println("log print "+ msg);
	}
	
}

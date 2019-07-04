package com.sklink.learning.dp.dpInRunoob.$13chainOfResponsibilityPattern;

public class ConsoleLogger extends AbstractLogger {
	
	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println(String.format("Console logger: %s", message));
		
	}

}

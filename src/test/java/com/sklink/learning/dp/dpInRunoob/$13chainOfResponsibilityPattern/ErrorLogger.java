package com.sklink.learning.dp.dpInRunoob.$13chainOfResponsibilityPattern;

public class ErrorLogger extends AbstractLogger{
	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println(String.format("Error logger: %s", message));
	}

}

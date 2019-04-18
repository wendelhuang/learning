package com.sklink.learning.dp.dpInRunoob.$13chainOfResponsibilityPattern;

public class FileLogger extends AbstractLogger {
	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println(String.format("File logger: %s", message));
		
	}

}

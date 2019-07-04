package com.sklink.learning.dp.dpInRunoob.$13chainOfResponsibilityPattern;

public class ChainPatternDemo {
	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		
		fileLogger.setNextLogger(consoleLogger);
		errorLogger.setNextLogger(fileLogger);
		
		return errorLogger;
	}
	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();
		
		loggerChain.logMessage(AbstractLogger.INFO, "This is a info message");
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug message");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is a error message");
	}
}

package com.sosimplebox.p001_factorybean.exception;

public class NoSpiChooseException extends RuntimeException{
	public NoSpiChooseException(String text) {
		super(text);
	}
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}

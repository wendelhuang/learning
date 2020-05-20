package com.sosimplebox.springboot_007_unifyException.exception;

public interface ResultCode {
	boolean success();
	long code();
	String message();
}

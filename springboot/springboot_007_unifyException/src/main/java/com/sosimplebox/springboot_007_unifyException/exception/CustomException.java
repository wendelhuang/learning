package com.sosimplebox.springboot_007_unifyException.exception;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomException extends RuntimeException {
	@Autowired
	ResultCode resultCode;
	public CustomException(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
	public ResultCode getResultCode() {
		return this.resultCode;
	}
}

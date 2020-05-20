package com.sosimplebox.springboot_007_unifyException.exception;

public class ResponseResult implements Response {
	boolean success = SUCCESS;
	long code = SUCCESS_CODE;
	String message;
	
	public ResponseResult(ResultCode resultCode) {
		this.success = resultCode.success();
		this.code = resultCode.code();
		this.message = resultCode.message();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

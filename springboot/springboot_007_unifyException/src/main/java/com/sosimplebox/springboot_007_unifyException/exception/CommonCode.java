package com.sosimplebox.springboot_007_unifyException.exception;

public enum CommonCode implements ResultCode{
	NO_PAGE(false, 404, "没有信息"),
	FAIL(false, 500, "操作失败"),
	SUCCESS(true, 200, "操作成功"),
	;
	
	boolean success;
	long code;
	String message;
	
	private CommonCode(boolean success, long code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}

	public boolean success() {
		return success;
	}

	public long code() {
		return code;
	}

	public String message() {
		return message;
	}
}

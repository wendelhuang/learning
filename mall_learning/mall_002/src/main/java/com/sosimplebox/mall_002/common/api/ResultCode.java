package com.sosimplebox.mall_002.common.api;

import org.springframework.http.HttpStatus;
public enum ResultCode implements IErrorCode {
	SUCCESS(HttpStatus.OK.value(), "操作成功"),
	FAILED(HttpStatus.INTERNAL_SERVER_ERROR.value(), "操作失败"),
	VALIDATE_FAILED(HttpStatus.BAD_REQUEST.value(), "参数校验失败"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "暂未登陆或token已经过期"),
	FORBIDDEN(HttpStatus.FORBIDDEN.value(), "没有相关权限"),
	;
	private long code;
	private String message;
	private ResultCode(long code, String message) {
		this.code = code;
		this.message = message;
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

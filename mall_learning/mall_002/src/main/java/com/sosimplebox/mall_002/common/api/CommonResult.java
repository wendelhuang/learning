package com.sosimplebox.mall_002.common.api;

public class CommonResult<T> {
	private long code;
	private String message;
	private T data;
	
	
	public CommonResult() {
		super();
	}
	public CommonResult(long code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public static<T> CommonResult<T> success(T data) {
		return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
	}
	
	public static<T> CommonResult<T> success(T data, String message) {
		return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
	}
	
	public static<T> CommonResult<T> failed(IErrorCode errorCode) {
		return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
	}
	
	public static<T> CommonResult<T> failed(String message) {
		return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
	}
	
	public static<T> CommonResult<T> failed() {
		return failed(ResultCode.FAILED);
	}
	
	public static<T> CommonResult<T> validateFailed() {
		return failed(ResultCode.VALIDATE_FAILED);
	}
	
	public static <T> CommonResult<T> validateFailed(String message) {
		return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
	}
	
	public static <T> CommonResult<T> unauthorized(T data) {
		return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
	}
	
	public static <T> CommonResult<T> forbidden(T data) {
		return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}

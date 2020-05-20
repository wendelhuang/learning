package com.sosimplebox.springboot_007_unifyException.exception;

public class ExceptionCast {
	public static void cast(ResultCode resultCode) {
		throw new CustomException(resultCode);
	}
}

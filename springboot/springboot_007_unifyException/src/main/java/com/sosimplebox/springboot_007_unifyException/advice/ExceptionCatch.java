package com.sosimplebox.springboot_007_unifyException.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sosimplebox.springboot_007_unifyException.exception.CustomException;
import com.sosimplebox.springboot_007_unifyException.exception.ResponseResult;
import com.sosimplebox.springboot_007_unifyException.exception.ResultCode;

@ControllerAdvice
public class ExceptionCatch {
	@ExceptionHandler(CustomException.class)
	@ResponseBody
	public ResponseResult customException(CustomException customException) {
		System.out.println("customException start");
		ResultCode resultCode = customException.getResultCode();
		
		System.out.println("customException end");
		return new ResponseResult(resultCode);
	}
}

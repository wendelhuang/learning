package com.sosimplebox.springboot_007_unifyException.service;

import org.springframework.stereotype.Service;

import com.sosimplebox.springboot_007_unifyException.exception.CommonCode;
import com.sosimplebox.springboot_007_unifyException.exception.CustomException;

@Service
public class EmployeeService {
	public int add() {
		throw new CustomException(CommonCode.FAIL);
	}
}

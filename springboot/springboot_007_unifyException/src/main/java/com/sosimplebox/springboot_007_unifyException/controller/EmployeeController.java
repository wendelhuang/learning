package com.sosimplebox.springboot_007_unifyException.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sosimplebox.springboot_007_unifyException.exception.CommonCode;
import com.sosimplebox.springboot_007_unifyException.exception.ResponseResult;
import com.sosimplebox.springboot_007_unifyException.service.EmployeeService;

@Controller
@RequestMapping("/e")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/add")
	@ResponseBody
	public ResponseResult add() {
		employeeService.add();
		return new ResponseResult(CommonCode.FAIL);
	}
}

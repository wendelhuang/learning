package com.sosimplebox.springboot_002_actuator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/list")
	public String list() {
		return "list";
	}

	@RequestMapping("get")
	public String get() {
		return "get";
	}
}

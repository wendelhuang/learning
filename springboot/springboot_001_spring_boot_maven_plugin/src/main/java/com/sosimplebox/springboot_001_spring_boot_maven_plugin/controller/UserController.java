package com.sosimplebox.springboot_001_spring_boot_maven_plugin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/list")
	public String list() {
		return "list";
	}

}

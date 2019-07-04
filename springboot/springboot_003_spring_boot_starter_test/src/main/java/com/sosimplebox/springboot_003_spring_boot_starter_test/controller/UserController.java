package com.sosimplebox.springboot_003_spring_boot_starter_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosimplebox.springboot_003_spring_boot_starter.MyProperties;
import com.sosimplebox.springboot_003_spring_boot_starter.MyService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	//@Autowired
	//private MyService myService;
	
	@Autowired
	private MyProperties myProperties;
	
	
	@RequestMapping("/list")
	public String list() {
		//myService.print();
		System.out.println(myProperties.getHost());
		return "list";
	}
}

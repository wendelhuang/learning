package com.sosimplebox.springboot_004_websocket_001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexController {
	@GetMapping("/home")
	public String home() {
		return "index";
	}
}

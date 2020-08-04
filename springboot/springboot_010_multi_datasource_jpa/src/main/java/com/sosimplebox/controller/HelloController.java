package com.sosimplebox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosimplebox.config.DataBase1Properties;
import com.sosimplebox.dao.db1.OrderDaoRepository;
import com.sosimplebox.dao.db2.ServerDaoRepository;
@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	DataBase1Properties dataBase1Properties;
	
	@Autowired
	OrderDaoRepository orderDaoRepository;

	@Autowired
	ServerDaoRepository serverDaoRepository;

	@RequestMapping("/say")
	public String say(String name) {
		System.out.println(dataBase1Properties);
		System.out.println(dataBase1Properties.getDriverClassName());
		System.out.println(orderDaoRepository.count());
		System.out.println(serverDaoRepository.findAll().size());
		return "Hello, " + name;
	}
}

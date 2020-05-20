package com.sosimplebox.p001_helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosimplebox.p001_helloworld.dao.Order;
import com.sosimplebox.p001_helloworld.service.OrderService;
import com.sosimplebox.p001_helloworld.service.OrderServiceImplCacheLevel2;

@RequestMapping("/order")
@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderServiceImplCacheLevel2 orderServiceImplCacheLevel2;
	
	@RequestMapping("/list")
	List<Order> listAllOrders() {
		orderService.test();
		return null;
	}
	
	@RequestMapping("/show")
	void showAllOrders() {
		orderServiceImplCacheLevel2.test();
	}
}

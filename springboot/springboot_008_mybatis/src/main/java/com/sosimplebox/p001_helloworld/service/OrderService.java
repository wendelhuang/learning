package com.sosimplebox.p001_helloworld.service;

import java.util.List;

import com.sosimplebox.p001_helloworld.dao.Order;

public interface OrderService {
	public void test();
	public List<Order> listAllOrders();
	public void showAllOrders();
}

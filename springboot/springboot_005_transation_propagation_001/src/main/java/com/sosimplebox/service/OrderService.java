package com.sosimplebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sosimplebox.dao.OrderDao;
import com.sosimplebox.model.Order;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	public int save(Order order) {
		return orderDao.save(order);
	}
	
	public int update(Order order) {
		return orderDao.update(order);
	}
	
	public int delete(Order order) {
		return orderDao.delete(order);
	}
	
	public List<Order> findAll() {
		return orderDao.findAll();
	}
}

package com.sosimplebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sosimplebox.dao.OrderDao;
import com.sosimplebox.model.Order;

@Service
public class OrderPropagationRequiredService {
	@Autowired
	private OrderDao orderDao;
	@Transactional(propagation = Propagation.REQUIRED)
	public int save(Order order) {
		return orderDao.save(order);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public int update(Order order) {
		return orderDao.update(order);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(Order order) {
		return orderDao.delete(order);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Order> findAll() {
		return orderDao.findAll();
	}
}

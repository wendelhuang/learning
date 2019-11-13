package com.sosimplebox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sosimplebox.dao.OrderDao;
import com.sosimplebox.model.Order;

@Service
public class OrderPropagationRequiresNewService {
	@Autowired
	private OrderDao orderDao;
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int save(Order order) {
		return orderDao.save(order);
	}
}

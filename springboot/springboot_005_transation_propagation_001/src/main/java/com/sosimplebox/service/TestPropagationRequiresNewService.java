package com.sosimplebox.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sosimplebox.model.Account;
import com.sosimplebox.model.Order;


@Service
public class TestPropagationRequiresNewService {
	@Autowired
	AccountPropagationRequiresNewService accountPropagationRequiresNewService;
	@Autowired
	OrderPropagationRequiresNewService orderPropagationRequiresNewService;
	
	@Transactional
	public void test() {
		Account account = new Account();
		account.setName("张三");
		account.setBalance(1000);
		accountPropagationRequiresNewService.save(account);
		
		Order order = new Order();
		order.setName("zhangsan");
		order.setMoney(1000);
		orderPropagationRequiresNewService.save(order);
		
		throw new RuntimeException();
	}
	
	@Transactional
	public void testWithCatch() {
		Account account = new Account();
		account.setName("张三");
		account.setBalance(1000);
		try {
			accountPropagationRequiresNewService.saveWithException(account);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Order order = new Order();
		order.setName("zhangsan");
		order.setMoney(1000);
		orderPropagationRequiresNewService.save(order);
	}
}

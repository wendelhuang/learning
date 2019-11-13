package com.sosimplebox.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sosimplebox.model.Account;
import com.sosimplebox.model.Order;


@Service
public class TestPropagationRequiredService {
	@Autowired
	AccountPropagationRequiredService accountPropagationRequiredService;
	@Autowired
	OrderPropagationRequiredService orderPropagationRequiredService;
	
	@Transactional
	public void test() {
		Account account = new Account();
		account.setName("张三");
		account.setBalance(1000);
		accountPropagationRequiredService.save(account);
		
		Order order = new Order();
		order.setName("zhangsan");
		order.setMoney(1000);
		orderPropagationRequiredService.save(order);
		
		throw new RuntimeException();
	}
	
	@Transactional
	public void testWithCatch() {
		Account account = new Account();
		account.setName("张三");
		account.setBalance(1000);
		try {
			accountPropagationRequiredService.saveWithException(account);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Order order = new Order();
		order.setName("zhangsan");
		order.setMoney(1000);
		orderPropagationRequiredService.save(order);
	}
}

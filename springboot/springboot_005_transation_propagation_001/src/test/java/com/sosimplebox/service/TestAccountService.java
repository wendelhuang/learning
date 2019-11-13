package com.sosimplebox.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sosimplebox.App;
import com.sosimplebox.model.Account;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class})
public class TestAccountService {
	
	@Autowired
	AccountService accountService;
	
	@Test
	public void testSave() {
		Account account = new Account();
		account.setName("赵六");
		account.setBalance(10000);
		System.out.println(accountService.save(account));
	}
}

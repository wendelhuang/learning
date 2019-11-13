package com.sosimplebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sosimplebox.dao.AccountDao;
import com.sosimplebox.model.Account;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;
	
	public int save(Account account) {
		return accountDao.save(account);
	}
	
	public int update(Account account) {
		return accountDao.update(account);
	}
	
	public int delete(Account account) {
		return accountDao.delete(account);
	}
	
	public List<Account> findAll() {
		return accountDao.findAll();
	}
}
